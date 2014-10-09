package com.yinhai.bcs.upg.netService.pay.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.yinhai.bcs.entity.domain.BcsupgServiceInterfaceDomain;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.common.util.ParamUtil;
import com.yinhai.bcs.upg.dbservice.Pay3Service;
import com.yinhai.bcs.upg.dbservice.PayRecordsService;
import com.yinhai.bcs.upg.dbservice.ServiceService;
import com.yinhai.bcs.upg.message.util.MessageUtil;
import com.yinhai.bcs.upg.pay3Interface.Pay3Interface;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;
import com.yinhai.sysframework.util.DateUtil;
import com.yinhai.webframework.BaseAction;


/**
 * 
 * 
 * 功能名称 ：同步消息监听ACTION
 * 实现目标 ： 监听,接受支付成功/失败的同步支付消息,完成支付操作的后续操作（分析业务系统请求的业务类型,Process核心账务处理系统或财务系统）
 * 入口数据 ： 调用支付操作异步回来的支付消息
 * 出口数据 ： 完成支付后续操作的处理结果消息
 * ---------------------------------------------------------------------------------------
 * 数据流程 ：
 * 1 接受异步消息RspMessage
 * 3 记录接受3ways/banks返回的支付通知消息日志
 * 2 解析RspMessage 解析为RspHeader -消息头   Object -消息体
 * 3 对数据签名进行验签signData
 * 4 验签成功后
 * 		   a 使用RspHeader中的服务标识判断此次支付操作所属业务服务类型
 *         b 调用对应业务服务类型的dealProcess处理服务完成支付成功的后续操作
 * 5 返回处理结果页面URL -success.jsp 处理成功  -failure.jsp 处理失败
 * 
 * 
 * 
 * 注： 从支付宝或者其他第三方返回的消息没有做 签名验证
 * 
 * @author BXS
 *
 */
@Namespace("/test")
@Action(value = "payResultReturnListener", 
		results = { @Result(name = "goSuccessReturn", location = "/return/goSuccessReturn.jsp"),
					@Result(name = "failure", location = "/return/failure.jsp"),
					@Result(name = "goFaildReturn", location = "/return/goFaildReturn.jsp")				
})
public class PayResultReturnListenerAction extends BaseAction {
	protected final Log log = LogFactory.getLog(getClass());
	private ServiceService serviceService = (ServiceService) getService("serviceService");
	private PayRecordsService tradeService = (PayRecordsService) getService("payRecordsService");
	private Pay3Service pay3Service = (Pay3Service) getService("pay3Service");

	
	public String execute() {
		try {
			// 取出整个协议包
			Map<String,String> paramMap = ParamUtil.coverRequestMapToMap(request);
			log.debug("得到的同步消息是" + paramMap);
			System.out.println("第三方支付同步返回信息" + paramMap);
			if(paramMap == null || paramMap.size() == 0){
				request.setAttribute(IConstants.FPAY_EEROR_MSG, "获取到的请求信息为空值，检查你的浏览器设置或查看是否正确发送了支付请求信息.");
				return "failure";
			}
			// 取该笔交易操作流水号
			String opt_sn = MessageUtil.findSN(paramMap);
			if(opt_sn == null || opt_sn.length() != IConstants.PAY_OPT_SN_LENGTH ){
				request.setAttribute(IConstants.FPAY_EEROR_MSG, "没有取得交易操作流水号或者是错误的操作流水号.");
				return "failure";
			}
			log.debug("同步处理1");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("opt_sn", opt_sn);
			Map<String, Object> payRecord = tradeService.getPayRecordByOptSN(params);
			if(payRecord == null){
				request.setAttribute(IConstants.FPAY_EEROR_MSG, "没有取得支付记录信息.");
				return "failure";
			}
			log.debug("同步处理2");
			int recordsId = (Integer) payRecord.get("records_id");
			Integer payway_id = (Integer)payRecord.get("payway_id");
			Integer serviceId = (Integer)payRecord.get("service_id");
			// 根据支付通道payway_id，获取支付通道信息payInterface
			BcsupgServiceInterfaceDomain siDomain= serviceService.getServiceInterfaceDomain(serviceId);
			if(siDomain==null){
				request.setAttribute(IConstants.FPAY_EEROR_MSG, "没有对应的服务信息.");
				return "failure";
			}
			log.debug("同步处理3");
			Map<String, Object> params2 = new HashMap<String, Object>();
			params2.put("payway_id", payway_id);
			Map<String, Object>payInterface = pay3Service.getPay3Interface(params2);
			if(payInterface == null){
				request.setAttribute(IConstants.FPAY_EEROR_MSG, "没有对应的支付接口.");
				return "failure";
			}
			log.debug("同步处理4");
			String  payClassName = (String)payInterface.get("pay_process_class");
			Pay3Interface pay3Interface = (Pay3Interface)(Class.forName(payClassName).newInstance());
			OutFPayResultMsg outFPayResultMsg = pay3Interface.getProtocolTrans().createPayResult(paramMap);
			outFPayResultMsg.setOpSn(opt_sn);
			outFPayResultMsg.setOrgData(paramMap);
			if(outFPayResultMsg.getPayResult() == IConstants.PAY_RESULT_SUCCESS){
				log.debug("同步返回消息处理中，更新支付记录表信息 处理成功");
				//更新支付记录表信息 处理成功
				tradeService.updatePayDealStatus(recordsId, IConstants.PAY_DEAL_STATUS_SUCCESS);
				
				Map<String,Object> returnData = new HashMap<String,Object>();
				returnData.put("clientId", payRecord.get("client_id"));
				returnData.put("serviceId", payRecord.get("service_id"));
				returnData.put("signData","");
				returnData.put("opSn", payRecord.get("opt_sn"));
				returnData.put("trade_sn", payRecord.get("trade_sn"));
				returnData.put("pay_deal_status",IConstants.PAY_DEAL_STATUS_SUCCESS);
				//1--未处理，2-处理成功，3-处理失败
				returnData.put("pay_result", outFPayResultMsg.getPayResult());
				returnData.put("biz_back_params", payRecord.get("biz_back_params"));
				request.setAttribute(IConstants.FPAY_RETURN_URL, payRecord.get("return_url"));
				request.setAttribute(IConstants.FPAY_RETURN_DATA,returnData);
				log.debug("将要发送给商户的数据是" + returnData);
				return "goSuccessReturn";
			}else{
				log.debug("更新支付记录表信息 支付失败");
				//更新支付记录表信息 支付失败
				tradeService.updatePayDealStatus(recordsId, IConstants.PAY_DEAL_STATUS_FAILD);
				
				request.setAttribute(IConstants.FPAY_EEROR_MSG, outFPayResultMsg.getPayResultInfo());
				return "goFaildReturn";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(IConstants.FPAY_EEROR_MSG,  "系统超时."+e.getMessage());
			return "failure";
		}
	}
}

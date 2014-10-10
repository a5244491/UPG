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
import com.yinhai.bcs.upg.netService.pay.dealProcess.PayDealProcess;
import com.yinhai.bcs.upg.netService.pay.job.NoticeOnceTaskQueue;
import com.yinhai.bcs.upg.pay3Interface.Pay3Interface;
import com.yinhai.bcs.upg.pay3Interface.Pay3ProtocolTrans;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;
import com.yinhai.bcs.upg.pay3Interface.llpay.LLPayUtil;
import com.yinhai.sysframework.util.DateUtil;
import com.yinhai.webframework.BaseAction;

/**
 * 
 * 功能名称 ： 异步消息监听ACTION 实现目标 ：
 * 监听,接受支付成功/失败的异步支付消息,完成支付操作的后续操作（分析业务系统请求的业务类型,Process核心账务处理系统或财务系统） 入口数据 ：
 * 调用支付操作异步回来的支付消息 出口数据 ： 完成支付后续操作的处理结果消息
 * ----------------------------------------
 * ----------------------------------------------- 数据流程 ： 1 接受异步消息RspMessage 3
 * 记录接受3ways/banks返回的支付通知消息日志 2 解析RspMessage 解析为RspHeader -消息头 Object -消息体 3
 * 对数据签名进行验签signData 4 验签成功后 a 使用RspHeader中的服务标识判断此次支付操作所属业务服务类型 b
 * 调用对应业务服务类型的dealProcess处理服务完成支付成功的后续操作 5 返回处理结果状态码 -success 处理成功 -failure 处理失败
 * 
 * 
 * @author Administrator
 * 
 */

@Namespace("/test")
@Action(value = "payResultNoticeListener", results = { @Result(name = "notice", location = "/return/notice.jsp"),
		@Result(name = "failure", location = "/return/noticeFailure.jsp") })
public class PayResultNoticeListenerAction extends BaseAction {
	protected final static Log log = LogFactory.getLog(PayResultNoticeListenerAction.class);
	private ServiceService serviceService = (ServiceService) getService("serviceService");
	private PayRecordsService payRecordsService = (PayRecordsService) getService("payRecordsService");
	private Pay3Service pay3Service = (Pay3Service) getService("pay3Service");

	public String execute() {
		try {
			// 取出整个协议包
			Map<String, String> paramMap = ParamUtil.coverRequestMapToMap(request);
			System.out.println("[" + DateUtil.getCurrentTime() + "]第三方支付异步请求信息" + paramMap);
			log.debug("异步处理__得到的异步请求消息是"+ paramMap);
			// 取出支付通道
			String opt_sn = MessageUtil.findSN(paramMap);
			if (opt_sn == null || opt_sn.length() != IConstants.PAY_OPT_SN_LENGTH) {
				log.debug("异步处理__没有取得交易流水号或者操作流水号的格式错误");
				request.setAttribute(IConstants.FPAY_NOTICE_MSG, "没有取得交易流水号或者操作流水号的格式错误.");
				return "notice";
			}

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("opt_sn", opt_sn);
			Map<String, Object> payRecord = payRecordsService.getPayRecordByOptSN(params);
			if (payRecord == null) {
				log.debug("异步处理__没有取得支付记录");
				request.setAttribute(IConstants.FPAY_NOTICE_MSG, "没有取得支付记录.");
				return "notice";
			}

			Integer payway_id = (Integer) payRecord.get("payway_id");
			Integer serviceId = (Integer) payRecord.get("service_id");
			// 根据支付通道payway_id，获取支付通道信息payInterface
			BcsupgServiceInterfaceDomain siDomain = serviceService.getServiceInterfaceDomain(serviceId);
			if (siDomain == null) {
				log.debug("异步处理__没有取得服务接口");
				request.setAttribute(IConstants.FPAY_NOTICE_MSG, "没有取得服务接口.");
				return "notice";
			}
			Map<String, Object> params2 = new HashMap<String, Object>();
			params2.put("payway_id", payway_id);
			Map<String, Object> payInterface = pay3Service.getPay3Interface(params2);
			if (payInterface == null) {
				log.debug("异步处理__没有取得支付接口");
				request.setAttribute(IConstants.FPAY_NOTICE_MSG, "没有取得支付接口.");
				return "notice";
			}
			String payClassName = (String) payInterface.get("pay_process_class");
			Pay3Interface pay3Interface = (Pay3Interface) (Class.forName(payClassName).newInstance());

			// add by CQ 应该在这里进行验证
			Pay3ProtocolTrans ppt = pay3Interface.getProtocolTrans();
			if (!ppt.checkSign(request, paramMap, response)) {
				log.debug("异步处理__支付异步通知验签失败");
				request.setAttribute(IConstants.FPAY_EEROR_MSG, "支付异步通知验签失败");
				return "failure";
			}
			OutFPayResultMsg outFPayResultMsg = ppt.createPayResult(paramMap);
			outFPayResultMsg.setOpSn(opt_sn);
			outFPayResultMsg.setOrgData(paramMap);

			int recordsId = (Integer) payRecord.get("records_id");
			payRecordsService.updatePayResult(recordsId, outFPayResultMsg.getPayResult());
			if (outFPayResultMsg.getPayResult() == IConstants.PAY_RESULT_SUCCESS) {
				// 更新支付记录状态
				// 支付成功
				// 获取支付通道对应的接口类、通知地址、收款账号等信息
				BcsupgServiceInterfaceDomain serviceDomain = serviceService.getServiceInterfaceDomain(serviceId);
				if (serviceDomain == null) {
					log.debug("异步处理__");
					request.setAttribute(IConstants.FPAY_EEROR_MSG, "没有对应的结果处理信息");
					return "failure";
				}
				String payDealProcessClass = serviceDomain.getPay_result_process_class();
				// 根据支付通道定义，获取支付接口类
				PayDealProcess payDealProcess = (PayDealProcess) (Class.forName(payDealProcessClass).newInstance());
				// 取得支付状态
				// 1-处理成功，2-处理失败 回调处理（采用虚拟系统还是财务系统进行账务处理）

				int dealStatus = payDealProcess.deal(outFPayResultMsg, payRecord);
				if (dealStatus == IConstants.PAY_DEAL_STATUS_SUCCESS) {
					// 更新支付记录信息
					payRecordsService.updatePayDealStatus(recordsId, IConstants.PAY_DEAL_STATUS_SUCCESS);
				} else {
					payRecordsService.updatePayDealStatus(recordsId, IConstants.PAY_DEAL_STATUS_FAILD);
				}
				request.setAttribute(IConstants.FPAY_NOTICE_MSG, pay3Interface.getProtocolTrans()
						.createFPayNoticeReturnStr(outFPayResultMsg));
				NoticeOnceTaskQueue.putTask(recordsId);
				return "notice";
			} else {
				// 支付失败
				payRecordsService.updatePayDealStatus(recordsId, IConstants.PAY_DEAL_STATUS_FAILD);
				request.setAttribute(IConstants.FPAY_NOTICE_MSG, pay3Interface.getProtocolTrans()
						.createFPayNoticeReturnStr(outFPayResultMsg));
				NoticeOnceTaskQueue.putTask(recordsId);
				return "notice";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(IConstants.FPAY_EEROR_MSG, "the system time out." + e.getMessage());
			return "failure";
		}
	}
}

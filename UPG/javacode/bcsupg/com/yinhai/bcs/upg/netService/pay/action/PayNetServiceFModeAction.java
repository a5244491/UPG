package com.yinhai.bcs.upg.netService.pay.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.yinhai.bcs.entity.domain.BcsClientInfosDomain;
import com.yinhai.bcs.entity.domain.BcsupgServiceInterfaceDomain;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.common.util.ParamUtil;
//import com.yinhai.bcs.upg.dbservice.CacheService;
import com.yinhai.bcs.upg.dbservice.ClientService;
import com.yinhai.bcs.upg.dbservice.Pay3Service;
import com.yinhai.bcs.upg.dbservice.PayRecordsService;
import com.yinhai.bcs.upg.dbservice.ServiceService;
import com.yinhai.bcs.upg.message.common.ReqUPGMsgHeader;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.message.util.MessageUtil;
import com.yinhai.bcs.upg.pay3Interface.Pay3Interface;
import com.yinhai.webframework.BaseAction;


/**
 * 
 * 功能名称 ： 支付Action -前台模式
 * 实现目标 ： 业务系统请求此Action完成后台支付操作
 * 入口数据 ： 业务系统的请求数据包data_package
 * 出口数据 ： 支付结果页面URL（由对应Action处理跳转）-success.jsp 支付成功  -failure.jsp 支付失败
 * ---------------------------------------------------------------------------------------
 * 数据流程 ： 
 * 1 获取业务端/客户端请求数据包（data_package）
 * 2 解析data_package a 获取消息头data_package_header  b 获取消息体data_package_body
 * 3 使用data_package_header中的客户端ID与服务ID验证客户端使用权限
 * 4 权限验证通过 使用data_package_header中的signData验证客户端数据签名
 * 5 签名验证通过   
 *            a 生成支付接口协议报文
 *            b 向支付记录表中新增一条支付记录（状态为 '待支付'）
 *            c 使用服务携带的支付通道ACCEPT_PAY_ID获取支付接口接入信息
 *              1 调用支付接口信息中的协议转化类实现对生成的支付接口协议报文,本身的支付信息进行转化为支付接口的请求数据包
 *            d 使用对应的支付接口完成支付操作（调用支付合作平台的支付接口完成支付操作）
 *            e 使用服务携带的PAY_RESULT_PROCESS_CLASS完成支付结果处理操作
 *            f 在当前事务中,对新增的支付记录信息进行更新操作（状态为 '支付成功'）
 * 6 返回支付URL  
 * 			  'success.jsp'-返回支付成功页面（支付网关前台提供）
 * 			  'failure.jsp'-返回支付失败页面（支付网关前台提供）
 * @author BXS
 *
 */

@Namespace("/test")
@Action(value = "payFService", 
		results = { @Result(name = "success", location = "/pay/goPay.jsp"),
					@Result(name = "failure", location = "/pay/failure.jsp")
})
public class PayNetServiceFModeAction extends BaseAction {

	private ClientService clientService = (ClientService) getService("clientService");
	private PayRecordsService tradeService = (PayRecordsService) getService("payRecordsService");
	private ServiceService   serveService   = (ServiceService) getService("serviceService");
	private Pay3Service pay3Service = (Pay3Service) getService("pay3Service");
	//private CacheService cacheService = (CacheService)getService("cacheService");
	
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String service() throws Exception {
 
		// 取出整个协议包
	    java.util.Map<String, String[]> dataMap = request.getParameterMap();
	    java.util.Map<String,String> paramMap= ParamUtil.coverRequestMapToMap(request);
		try{
			// 构建请求消息
			PayUPGReqMsg reqMsg = MessageUtil.createPayReqMsg(dataMap);
			// 获取请求消息头
			ReqUPGMsgHeader reqHeadMsg = reqMsg.getMsgHeader();
			// 获取客户端信息
			BcsClientInfosDomain clientDomain = clientService.getDetail(reqHeadMsg.getClient_id());
			if(clientDomain == null){
				request.setAttribute(IConstants.FPAY_EEROR_MSG,"未取得接入商户信息或商户信息已失效.");
				return "failure";
			}
			String clientPubKey = clientDomain.getClient_pub_key();
			String optsn = reqHeadMsg.getOpt_sn();
			Integer serviceid = reqHeadMsg.getService_id();
			Integer clientid = reqHeadMsg.getClient_id();
			// 验证操作流水号的有效性
			boolean verifyOPSNResult= MessageUtil.verifyOPSN(serviceid.toString(),clientid.toString(),optsn);
			if(!verifyOPSNResult){
				request.setAttribute(IConstants.FPAY_EEROR_MSG,"操作流水号格式不正确（无效操作流水号）.");
				return "failure";
			}
			
			
			// 验证操作流水号的重复性
//			if(cacheService.repeatVerify(optsn)){
//				request.setAttribute(IConstants.FPAY_EEROR_MSG,"the opt sn can not be used repetly.");
//				return "failure";
//			}
//			cacheService.push(optsn);
			
			
			// 验证客户使用服务权限
			if (clientService.checkClientRight(clientid, serviceid) == 1) {
				if(true) { // add by CQ for test
				//if (MessageUtil.verifyFPaySign(paramMap,reqHeadMsg.getSign_data(),clientPubKey)) {  // modify by CQ for test
					//根据服务标识Service_id,取出对应的支付通道payway_id
					BcsupgServiceInterfaceDomain bcsServiceDomian = serveService.getServiceInterfaceDomain(serviceid);
					if(bcsServiceDomian == null){
						request.setAttribute(IConstants.FPAY_EEROR_MSG, "we have not found any service that you gived.");
						return "failure";
					}
					Integer payway_id = bcsServiceDomian.getPayway_id();
					//根据支付通道payway_id，获取支付通道信息payInterface
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("payway_id", payway_id);
					Map<String, Object> payInterfaceMap = pay3Service.getPay3Interface(params);
					if(payInterfaceMap == null){
						request.setAttribute(IConstants.FPAY_EEROR_MSG, "can not get effective pay way informations.");
						return "failure";
					}
					//获取支付通道对应的接口类、通知地址、收款账号等信息
					String payClassName = (String)payInterfaceMap.get("pay_process_class");
					String receive_account = (String)payInterfaceMap.get("receive_account");
					String return_url = reqMsg.getReturn_url();
					String notify_url = reqMsg.getNotify_url();
					String error_notify_url = "";
					reqMsg.setReturn_url(return_url);
					reqMsg.setNotify_url(notify_url);
					reqMsg.setError_notify_url(error_notify_url);
					reqMsg.setPayWayId(payway_id.toString());
					//持久化待支付的支付记录
					Map<String, Object> payRecordMap = MessageUtil.payReqMsgBody2Map(reqMsg);
					payRecordMap.put("sign_type", IConstants.SIGN_TYPE_MD5RSA);
					payRecordMap.put("pay_notice_count", IConstants.PAY_NOTICE_COUNT_DEFAULT);//默认通知次数
					payRecordMap.put("trade_time", new Timestamp(System.currentTimeMillis()));
					tradeService.insert(payRecordMap);
					//根据支付通道定义,获取支付接口类
					Pay3Interface pay3Interface = (Pay3Interface)(Class.forName(payClassName).newInstance());
					reqMsg.setReceive_account(receive_account);
					//支付接口生成支付URL
					pay3Interface.setPayInterfaceMap(payInterfaceMap);
					Map<String,Object> payMap = pay3Interface.payFMode(reqMsg);
					request.setAttribute(IConstants.FPAY_POST_URL, payMap.get(IConstants.FPAY_POST_URL));
					request.setAttribute(IConstants.FPAY_POST_DATA, payMap.get(IConstants.FPAY_POST_DATA));
					return "success";
				} else {
					// 验证报文签名失败
					request.setAttribute(IConstants.FPAY_EEROR_MSG, "your sign_data is worng.");
					return "failure";
				}
			} else {
				// 验证客户权限失败
				request.setAttribute(IConstants.FPAY_EEROR_MSG, "auth faild,you have no right to use this service.");
				return "failure";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute(IConstants.FPAY_EEROR_MSG,"the system exception now at "+new java.util.Date()+" Exception:"+ex.getMessage()+".");
			return "failure";
		}
	}
}

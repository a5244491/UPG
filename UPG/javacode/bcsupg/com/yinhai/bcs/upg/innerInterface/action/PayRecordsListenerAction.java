package com.yinhai.bcs.upg.innerInterface.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.yinhai.bcs.entity.domain.BcsClientInfosDomain;
import com.yinhai.bcs.entity.domain.BcsupgServiceInterfaceDomain;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.common.util.JsonUtil;
import com.yinhai.bcs.upg.common.util.ParamUtil;
import com.yinhai.bcs.upg.dbservice.ClientService;
import com.yinhai.bcs.upg.dbservice.PayRecordsService;
import com.yinhai.bcs.upg.dbservice.ServiceService;
import com.yinhai.bcs.upg.message.common.ReqUPGMsgHeader;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.message.util.MessageUtil;
import com.yinhai.webframework.BaseAction;


@Namespace("/test")
@Action(value = "payRecordsListener", results = {
		@Result(name = "failure", location = "/return/noticeFailure.jsp") })
public class PayRecordsListenerAction extends BaseAction {
	
	/** 支付记录DB服务*/
	private PayRecordsService payRecordsService = (PayRecordsService) getService("payRecordsService");
	/** 客户端DB服务*/
	private ClientService clientService = (ClientService) getService("clientService");
	/** 服务DB服务*/
	private ServiceService   serverService   = (ServiceService) getService("serviceService");
	/**
	 * 初始化一个待支付记录
	 */
	public void pRecordss() throws Exception {
		// dataMap取出整个协议包
	    java.util.Map<String, String[]> dataMap = request.getParameterMap();
		Map<String,String> paramMap= ParamUtil.coverRequestMapToMap(request);
		// 构建请求消息
		PayUPGReqMsg reqMsg = MessageUtil.createPayReqMsg(dataMap);
		// 解析请求消息头&消息体
		ReqUPGMsgHeader reqHeadMsg = reqMsg.getMsgHeader();
		try{
			BcsClientInfosDomain clientDomain = clientService.getDetail(reqHeadMsg.getClient_id());
			if(clientDomain == null){
				printStrToHttpRsp(response,"failure:can not get client information or your client have invalided.");
			}
			String clientPubKey = clientDomain.getClient_pub_key();
			boolean verifyOPSNResult= MessageUtil.verifyOPSN(reqHeadMsg.getService_id()+"",reqHeadMsg.getClient_id()+"",reqHeadMsg.getOpt_sn());
			if(!verifyOPSNResult){
				printStrToHttpRsp(response,"failure:the format of optsn is wrong.");
			}
			// 验证客户权限
			if (clientService.checkClientRight(reqHeadMsg.getClient_id(),reqHeadMsg.getService_id()) == 1) {
				if (MessageUtil.verifyFPaySign(paramMap,reqHeadMsg.getSign_data(), clientPubKey)) {
					//根据服务标识Service_id,取出对应的支付通道payway_id
					BcsupgServiceInterfaceDomain bcsServiceDomian = serverService.getServiceInterfaceDomain(reqHeadMsg.getService_id());
					if(bcsServiceDomian == null){
						printStrToHttpRsp(response, "failure:we have not found any service that you gived.");
					}
					Integer payway_id = bcsServiceDomian.getPayway_id();
					//持久化待支付的支付记录
					Map<String, Object> payRecordMap = MessageUtil.payReqMsgBody2Map(reqMsg);
					payRecordMap.put("payway_id", payway_id);
					payRecordMap.put("sign_type", "MD5withRSA");
					payRecordMap.put("pay_notice_count", IConstants.PAY_NOTICE_COUNT_DEFAULT);//默认通知次数
					payRecordMap.put("error_no", "");
					payRecordMap.put("trade_time", new Timestamp(System.currentTimeMillis()));
					payRecordsService.insert(payRecordMap);
					printStrToHttpRsp(response, "success:your persistence what is success.");
				} else {
					// 验证报文签名失败
					printStrToHttpRsp(response,"failure:your sign_data is worng.");
				}
			} else {
				// 验证客户权限失败
				printStrToHttpRsp(response,"auth failure:you have no right to use this service.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			printStrToHttpRsp(response,"failure:the system time out.");
		}
	}
	
	
	/**
	 * 向客户端端返回JSON
	 * 
	 * @param result
	 * @throws Exception
	 */
	public static void printStrToHttpRsp(HttpServletResponse response,String str) throws Exception {
		String orgData=JsonUtil.toJson(str);
		response.setContentType("text/plain; chartset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(orgData);
	}
}

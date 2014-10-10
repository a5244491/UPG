package com.yinhai.bcs.upg.pay3Interface;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;

public interface Pay3ProtocolTrans {
	
	
	/**
	 * 协议转化处理
	 * @return
	 */
	public Map reqBPayTrans (PayUPGReqMsg payReqMsgBody);
	public Map reqFPayTrans (PayUPGReqMsg payReqMsgBody,Map<String, Object> payInterfaceMap);
	
	/**
	 * 构造支付结果消息类，用于支付结果监听类进一步做业务处理
	 * @param reqParamMap
	 * @return
	 */
	public OutFPayResultMsg createPayResult(Map<String, String> reqParamMap);
	
	public String createFPayNoticeReturnStr (OutFPayResultMsg rspMsg);
	public boolean checkSign(HttpServletRequest request,
			Map<String, String> paramMap, HttpServletResponse response);
}

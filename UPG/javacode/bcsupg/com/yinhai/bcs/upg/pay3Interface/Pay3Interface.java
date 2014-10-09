package com.yinhai.bcs.upg.pay3Interface;

import java.util.Map;

import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;


public interface Pay3Interface {
	
	
	/**
	 * 后台支付接口
	 * @param protocolMessage 协议报文
	 * @param object 协议转化类
	 * @return 支付接口消息
	 */
	public OutFPayResultMsg payBMode(PayUPGReqMsg payReqMsgbody);
	
	
	/**
	 * 前台支付调用方法
	 * @param payReqMsgbody
	 * @return
	 */
	public Map<String,Object> payFMode(PayUPGReqMsg payReqMsgbody);
	
	
	/**
	 * 取得协议传换类
	 * @return
	 */
	public Pay3ProtocolTrans getProtocolTrans();
	
	
	/**
	 * 证验签名
	 * @param requestParamsMap
	 * @return
	 */
	public boolean verify(Map<String, String[]> requestParamsMap);
	
	
	/**
	 * 设置接口的domain map
	 * @param payInterfaceMap
	 */
	public void setPayInterfaceMap(Map<String, Object> payInterfaceMap);
	
	
	
	
}

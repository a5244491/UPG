package com.yinhai.bcs.upg.pay3Interface.util;

import java.util.HashMap;
import java.util.Map;

import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;

public class ProtocolUtil {
	
	
	
	
	/**
	 * 构造支付响应消息
	 * @param dataStr 响应数据信息
	 * @return ReqMessage 响应消息
	 */
	public static OutFPayResultMsg createOutPayResultMsg(String dataStr){
	
		return null;
		
	}
	
	/**
	 * 解析支付方支付处理消息
	 * @param  returnProcessMsg 支付方支付处理消息
	 * @return Map 将支付方的消息封装成支付结果键值对
	 */
	public static Map<String,Object> decodeReturnProtMsg (String returnProcessMsg){
		
		Map<String,Object> returnProtMsg = new HashMap<String,Object>();
		
		return returnProtMsg;
	}
}

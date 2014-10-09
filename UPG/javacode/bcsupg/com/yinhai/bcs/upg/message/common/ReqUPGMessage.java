package com.yinhai.bcs.upg.message.common;

import java.util.Map;


/**
 * 所有格式的请求消息
 * @author Administrator
 *
 */
public  class ReqUPGMessage {
	
	private ReqUPGMsgHeader msgHeader;//消息头部
	
	
	public  Map<String,Object> toMap(){
		return null;
	}
	
	public ReqUPGMessage() {
		
	}

	public ReqUPGMsgHeader getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(ReqUPGMsgHeader msgHeader) {
		this.msgHeader = msgHeader;
	}



}

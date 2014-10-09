package com.yinhai.bcs.upg.message.common;


/**
 * 所有格式的响应消息
 * @author Administrator
 *
 */
public  class RspUPGMessage {

	
	private RspUPGMsgHeader rspMsgHeader;//消息头部
	
	private Object objBody;//消息体

	
	
	public RspUPGMessage() {
		
	}
	

	public RspUPGMsgHeader getRspMsgHeader() {
		return rspMsgHeader;
	}


	public void setRspMsgHeader(RspUPGMsgHeader rspMsgHeader) {
		this.rspMsgHeader = rspMsgHeader;
	}


	
	

	public Object getObjBody() {
		return objBody;
	}


	public void setObjBody(Object objBody) {
		this.objBody = objBody;
	}

}

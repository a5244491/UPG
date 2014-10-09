package com.yinhai.bcs.upg.message.common;


/**
 * 消息头
 * @author Administrator
 *
 */
public class RspUPGMsgHeader {
	/**
	 * 
	 * MsgHeader
	 * serviceId  操作标识    （标识属于什么类型的操作）
	 * clientId   客户端标识（客户端唯一标识）
	 * opSn       操作流水号（同一个事务的操作，操作流水号相同）
	 * msgType    消息类型    （0 请求消息   1 响应消息）
	 * rspCode    响应码值    （{"success","failure"}）
	 * signData   数据签名    （"Y9ACD92NCIDI82390403943CJDEJCJ"）
	 * 
	 */
	
	private int clientId;
	
	private int serviceId;
	
	private String signData;
	
	private String opSn;
	
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getSignData() {
		return signData;
	}
	public void setSignData(String signData) {
		this.signData = signData;
	}
	public String getOpSn() {
		return opSn;
	}
	public void setOpSn(String opSn) {
		this.opSn = opSn;
	}
	
	
	
}

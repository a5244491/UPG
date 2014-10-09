package com.yinhai.bcs.upg.message.common;


/**
 * 消息头
 * @author Administrator
 *
 */
public class ReqUPGMsgHeader {
	/**
	 * 
	 * MsgHeader
	 * service_id  操作标识    （标识属于什么类型的操作）
	 * client_id   客户端标识（客户端唯一标识）
	 * opt_sn      操作流水号（同一个事务的操作，操作流水号相同）
	 * sign_data   数字签名    （"Y9ACD92NCIDI82390403943CJDEJCJ"）
	 */
	
	/** 服务标识 */
	private Integer service_id;
	
	/** 客户端ID */
	private Integer client_id;
	
	/** 流水号 */
	private String  opt_sn;
	
	
	/** 签名数据 */
	private String  sign_data;
	
	
	public String getOpt_sn() {
		return opt_sn;
	}
	public void setOpt_sn(String opt_sn) {
		this.opt_sn = opt_sn;
	}
	public Integer getService_id() {
		return service_id;
	}
	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}
	public Integer getClient_id() {
		return client_id;
	}
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	
	public String getSign_data() {
		return sign_data;
	}
	public void setSign_data(String sign_data) {
		this.sign_data = sign_data;
	}
	
}

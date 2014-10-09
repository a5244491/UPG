package com.yinhai.bcs.upg.pay3Interface.common.msg;

import java.util.Map;


public class OutFPayResultMsg {
	
	/**
	 * 支付结果
	 * 1-支付成功,2-支付失败
	 */
	private int payResult;
	/**
	 * 操作流水号
	 */
	private String opSn;
	
	private String tradeSN;
	
	private String payResultInfo;
	
	/**
	 * 原始请求包
	 */
	private Map<String,String> orgData;

	public int getPayResult() {
		return payResult;
	}

	public void setPayResult(int payResult) {
		this.payResult = payResult;
	}

	public String getTradeSN() {
		return tradeSN;
	}

	public void setTradeSN(String tradeSN) {
		this.tradeSN = tradeSN;
	}

	public String getPayResultInfo() {
		return payResultInfo;
	}

	public void setPayResultInfo(String payResultInfo) {
		this.payResultInfo = payResultInfo;
	}

	public Map<String, String> getOrgData() {
		return orgData;
	}

	public void setOrgData(Map<String, String> orgData) {
		this.orgData = orgData;
	}

	public String getOpSn() {
		return opSn;
	}

	public void setOpSn(String opSn) {
		this.opSn = opSn;
	}

		
}

package com.yinhai.bcs.upg.message.trade;

import java.util.Map;

import com.yinhai.bcs.upg.message.common.ReqUPGMessage;


public class TransAmountReqUPGMsg extends ReqUPGMessage{
	String transOutAccount;
	String transInAccount;
	int bankCardId;
	
	
	
	public int getBankCardId() {
		return bankCardId;
	}
	public void setBankCardId(int bankCardId) {
		this.bankCardId = bankCardId;
	}
	public String getTransOutAccount() {
		return transOutAccount;
	}
	public void setTransOutAccount(String transOutAccount) {
		this.transOutAccount = transOutAccount;
	}
	public String getTransInAccount() {
		return transInAccount;
	}
	public void setTransInAccount(String transInAccount) {
		this.transInAccount = transInAccount;
	}
	@Override
	public Map<String, Object> toMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

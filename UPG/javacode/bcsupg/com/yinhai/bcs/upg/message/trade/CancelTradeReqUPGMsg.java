package com.yinhai.bcs.upg.message.trade;

import java.util.Map;

import com.yinhai.bcs.upg.message.common.ReqUPGMessage;


public class CancelTradeReqUPGMsg extends ReqUPGMessage{
	
	String TradeSn;
	int bankCardId;

	
	
	public int getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(int bankCardId) {
		this.bankCardId = bankCardId;
	}

	public String getTradeSn() {
		return TradeSn;
	}

	public void setTradeSn(String tradeSn) {
		TradeSn = tradeSn;
	}

	@Override
	public Map<String, Object> toMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

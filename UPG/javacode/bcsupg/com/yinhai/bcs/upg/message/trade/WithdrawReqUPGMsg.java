package com.yinhai.bcs.upg.message.trade;

import java.util.Map;

import com.yinhai.bcs.upg.message.common.ReqUPGMessage;


public class WithdrawReqUPGMsg extends ReqUPGMessage{
	double withdrawAmount;

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	@Override
	public Map<String, Object> toMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

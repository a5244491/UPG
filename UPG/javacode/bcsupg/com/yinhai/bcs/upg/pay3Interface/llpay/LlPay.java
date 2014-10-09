package com.yinhai.bcs.upg.pay3Interface.llpay;

import java.util.Map;

import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.Pay3Interface;
import com.yinhai.bcs.upg.pay3Interface.Pay3ProtocolTrans;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;

public class LlPay implements Pay3Interface {

	Map<String, Object> payInterfaceMap;

	@Override
	public Map payFMode(PayUPGReqMsg payReqMsgbody) {
		Map postMap = getProtocolTrans().reqFPayTrans(payReqMsgbody,
				payInterfaceMap);
		return postMap;
	}

	@Override
	public OutFPayResultMsg payBMode(PayUPGReqMsg payReqMsgbody) {
		return null;
	}

	@Override
	public Pay3ProtocolTrans getProtocolTrans() {
		return new LlProtocolTrans();
	}

	@Override
	public void setPayInterfaceMap(Map<String, Object> payInterfaceMap) {
		this.payInterfaceMap = payInterfaceMap;
	}

	@Override
	public boolean verify(Map<String, String[]> requestParamsMap) {
		return true;
	}
}

package com.yinhai.bcs.upg.pay3Interface.virtual;

import java.util.Map;

import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.Pay3Interface;
import com.yinhai.bcs.upg.pay3Interface.Pay3ProtocolTrans;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;
import com.yinhai.webframework.BaseAction;

@SuppressWarnings({"unchecked","rawtypes"})
public class VirtualPay extends BaseAction implements Pay3Interface{

	//private PayRecordsService tradeService = (PayRecordsService) getService("payRecordsService");

	Map<String, Object> payInterfaceMap;
	
	@Override
	public OutFPayResultMsg payBMode(PayUPGReqMsg payReqMsgbody) {
		return null;
	}

	@Override
	public Map<String, Object> payFMode(PayUPGReqMsg payReqMsgbody) {
		Map postMap = getProtocolTrans().reqFPayTrans(payReqMsgbody,payInterfaceMap);
		return postMap;
	}

	@Override
	public Pay3ProtocolTrans getProtocolTrans() {
		return new VirtualProtocolTrans();
	}

	@Override
	public boolean verify(Map<String, String[]> requestParamsMap) {
		
		return false;
	}

	@Override
	public void setPayInterfaceMap(Map<String, Object> payInterfaceMap) {
		this.payInterfaceMap = payInterfaceMap;
	}

	
}

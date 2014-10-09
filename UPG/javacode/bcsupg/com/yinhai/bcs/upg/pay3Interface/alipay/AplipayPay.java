package com.yinhai.bcs.upg.pay3Interface.alipay;

import java.util.HashMap;
import java.util.Map;

import com.yinhai.bcs.upg.dbservice.PayRecordsService;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.Pay3Interface;
import com.yinhai.bcs.upg.pay3Interface.Pay3ProtocolTrans;
import com.yinhai.bcs.upg.pay3Interface.alipay.config.AlipayConfig;
import com.yinhai.bcs.upg.pay3Interface.alipay.util.AlipayNotify;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;
import com.yinhai.webframework.BaseAction;


public class AplipayPay extends BaseAction implements Pay3Interface{
	
	private PayRecordsService tradeService = (PayRecordsService) getService("payRecordsService");

	Map<String, Object> payInterfaceMap;
	
	@Override
	public boolean verify(Map<String, String[]> requestParamsMap) {
		
		// 取流水号opt_sn
		String opt_sn = requestParamsMap.get("extra_common_param")[0];
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("opt_sn", opt_sn);
		Map<String, Object> payRecord = tradeService.getPayRecordByOptSN(params);
		Integer payway_id = (Integer)payRecord.get("payway_id");
		
		// 初始化支付宝接口参数
		AlipayConfig alipayconfig = AlipayConfig.getInstance();
		alipayconfig.init(payway_id.toString());
		
		// 验证支付宝通知消息的签名
		Map<String, String> map = new HashMap<String, String>();
		for (String key : requestParamsMap.keySet()) {
        	String value = requestParamsMap.get(key)[0];
        	map.put(key, value);
        }
		boolean result = AlipayNotify.verify(map);
		
		return result;
	}

	@Override
	public OutFPayResultMsg payBMode(PayUPGReqMsg payReqMsgbody ) {
		
		return null;
	}
	
	@Override
	public Map payFMode(PayUPGReqMsg payReqMsgbody ) {
		
		Map postMap = getProtocolTrans().reqFPayTrans(payReqMsgbody,payInterfaceMap);
		
		return postMap;
	}

	@Override
	public Pay3ProtocolTrans getProtocolTrans() {
		return new AplipayProtocolTrans();
	}

	
	


	@Override
	public void setPayInterfaceMap(Map<String, Object> payInterfaceMap) {
		this.payInterfaceMap=payInterfaceMap;
	}
}

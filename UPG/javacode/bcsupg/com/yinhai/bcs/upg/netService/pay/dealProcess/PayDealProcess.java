package com.yinhai.bcs.upg.netService.pay.dealProcess;

import java.util.Map;

import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;

public interface PayDealProcess {
	
	/**
	 * 支付结果处理类接口
	 */
	public int deal(OutFPayResultMsg outPayResultMsg,Map<String,Object> payRecord);
	 
}


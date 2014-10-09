package com.yinhai.bcs.upg.message.pay;

import com.yinhai.bcs.upg.message.common.RspUPGMessage;

public class PayUPGRspMsg extends RspUPGMessage{
	
	
	/** 交易流水号 */
	private String  trade_sn;
	
	/** 处理状态 */
	private Integer pay_deal_status;
	
	/** 处理结果 */
	private Integer pay_result;
	
	/** 业务扩展参数 */
	private String biz_extends_params;
}

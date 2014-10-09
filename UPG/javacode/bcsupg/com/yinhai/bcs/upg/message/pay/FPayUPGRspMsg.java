package com.yinhai.bcs.upg.message.pay;

import com.yinhai.bcs.upg.message.common.RspUPGMessage;

public class FPayUPGRspMsg extends RspUPGMessage{
	
	/** 交易流水号 */
	private String  trade_sn;
	
	/** 处理状态 */
	private Integer pay_deal_status;
	
	/** 处理结果 */
	private Integer pay_result;
	
	/** 业务扩展参数 */
	private String biz_extends_params;

	public String getTrade_sn() {
		return trade_sn;
	}

	public void setTrade_sn(String trade_sn) {
		this.trade_sn = trade_sn;
	}

	

	public Integer getPay_deal_status() {
		return pay_deal_status;
	}

	public void setPay_deal_status(Integer pay_deal_status) {
		this.pay_deal_status = pay_deal_status;
	}

	public Integer getPay_result() {
		return pay_result;
	}

	public void setPay_result(Integer pay_result) {
		this.pay_result = pay_result;
	}

	public String getBiz_extends_params() {
		return biz_extends_params;
	}

	public void setBiz_extends_params(String biz_extends_params) {
		this.biz_extends_params = biz_extends_params;
	}
	
	
}

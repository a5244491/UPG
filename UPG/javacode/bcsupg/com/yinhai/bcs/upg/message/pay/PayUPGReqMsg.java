package com.yinhai.bcs.upg.message.pay;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.yinhai.bcs.upg.message.common.ReqUPGMessage;


public class PayUPGReqMsg extends ReqUPGMessage {
	
	/** 消息通知地址 */
	private String  notify_url;
	
	/** 返回地址 */
	private String  return_url;
	
	/** 请求出错返回地址 */
	private String  error_notify_url;
	
	/** 交易流水号 */
	private String  trade_sn;
	
	/** 交易说明 */
	private String  trade_desc;
	
	/** 支付账号 */
	private String pay_account;
	
	/** 收款账号 */
	private String receive_account;
	
	/** 交易金额 */
	private BigDecimal trade_balance;
	
	/** 业务扩展参数 */
	private String biz_extends_params;
	
	/** 处理状态 */
	private Integer pay_deal_status;
	
	/** 处理结果 */
	private Integer pay_result;
	
	/** 通知状态：1）未通知，2）通知成功，3）通知未送达 */
	private Integer pay_notice_status;
	
	/** 交易结果通知次数 */
	private Integer pay_notice_count;
	
	/** 业务回传参数（原样返回） */
	private String biz_back_params;
	
	/** 虚拟支付交易密码  */
	private String trade_psw;
	
	/** 支付渠道*/
	private String payWayId;
	
	/** 民生银行E支付 使用缺省银行参数*/
	private String default_bank;
	
	
	public String getPayWayId() {
		return payWayId;
	}
	public void setPayWayId(String payWayId) {
		this.payWayId = payWayId;
	}
	public String getBiz_back_params() {
		return biz_back_params;
	}
	public void setBiz_back_params(String biz_back_params) {
		this.biz_back_params = biz_back_params;
	}
	
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getReturn_url() {
		return return_url;
	}
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	public String getError_notify_url() {
		return error_notify_url;
	}
	public void setError_notify_url(String error_notify_url) {
		this.error_notify_url = error_notify_url;
	}

	
	public String getTrade_sn() {
		return trade_sn;
	}
	public void setTrade_sn(String trade_sn) {
		this.trade_sn = trade_sn;
	}
	public String getTrade_desc() {
		return trade_desc;
	}
	public void setTrade_desc(String trade_desc) {
		this.trade_desc = trade_desc;
	}
	public String getPay_account() {
		return pay_account;
	}
	public void setPay_account(String pay_account) {
		this.pay_account = pay_account;
	}
	public String getReceive_account() {
		return receive_account;
	}
	public void setReceive_account(String receive_account) {
		this.receive_account = receive_account;
	}
	public BigDecimal getTrade_balance() {
		return trade_balance;
	}
	public void setTrade_balance(BigDecimal trade_balance) {
		this.trade_balance = trade_balance;
	}
	
	public String getBiz_extends_params() {
		return biz_extends_params;
	}
	public void setBiz_extends_params(String biz_extends_params) {
		this.biz_extends_params = biz_extends_params;
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
	public Integer getPay_notice_status() {
		return pay_notice_status;
	}
	public void setPay_notice_status(Integer pay_notice_status) {
		this.pay_notice_status = pay_notice_status;
	}
	public Integer getPay_notice_count() {
		return pay_notice_count;
	}
	public void setPay_notice_count(Integer pay_notice_count) {
		this.pay_notice_count = pay_notice_count;
	}
	 
	@Override
	public Map<String,Object> toMap(){
		Map<String,Object> _map = new HashMap<String,Object> ();
		_map.put("opt_sn", getMsgHeader().getOpt_sn());
		_map.put("service_id", getMsgHeader().getService_id());
		_map.put("client_id", getMsgHeader().getClient_id());
		_map.put("sign_data", getMsgHeader().getSign_data());
		_map.put("biz_back_params",biz_back_params);
		_map.put("notify_url", notify_url);
		_map.put("return_url", return_url);
		_map.put("error_notify_url", error_notify_url);
		_map.put("trade_sn", trade_sn);
		_map.put("trade_desc", trade_desc);
		_map.put("pay_account", pay_account);
		_map.put("receive_account", receive_account);
		_map.put("trade_balance", trade_balance);
		_map.put("biz_extends_params", biz_extends_params);
		_map.put("pay_deal_status", pay_deal_status);
		_map.put("pay_result", pay_result);
		_map.put("pay_notice_status", pay_notice_status);
		_map.put("pay_notice_count", pay_notice_count);
		_map.put("payway_id", payWayId);
		_map.put("trade_psw", trade_psw);
		_map.put("default_bank", default_bank);
		return _map;
	}
	public String getTrade_psw() {
		return trade_psw;
	}
	public void setTrade_psw(String trade_psw) {
		this.trade_psw = trade_psw;
	}
	public String getDefault_bank() {
		return default_bank;
	}
	public void setDefault_bank(String default_bank) {
		this.default_bank = default_bank;
	}
	
	
}

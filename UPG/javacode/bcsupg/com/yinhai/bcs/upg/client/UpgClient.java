package com.yinhai.bcs.upg.client;

import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.message.pay.PayUPGRspMsg;
import com.yinhai.bcs.upg.message.trade.CancelTradeReqUPGMsg;
import com.yinhai.bcs.upg.message.trade.CancelTradeRspUPGMsg;
import com.yinhai.bcs.upg.message.trade.TransAmountReqUPGMsg;
import com.yinhai.bcs.upg.message.trade.TransAmountRspUPGMsg;
import com.yinhai.bcs.upg.message.trade.WithdrawReqUPGMsg;
import com.yinhai.bcs.upg.message.trade.WithdrawRspUPGMsg;

public class UpgClient {
	
	
	/**
	 * 支付服务——后台模式
	 * @param reqMessage
	 * @return
	 */
	public PayUPGRspMsg payBMode(PayUPGReqMsg reqMessage){
		
		
		return null;
	}
	
	
	/**
	 * 支付服务——前台模式
	 * @param reqMessage
	 * @return 返回要转跳的url;
	 */
	public String payFMode(PayUPGReqMsg reqMessage){
		return "url";
	}
	
	
	
	/**
	 * 取消交易结果
	 * @param reqMessage
	 * @return
	 */
	public CancelTradeRspUPGMsg cancelTrade(CancelTradeReqUPGMsg reqMessage){
		return null;
	}
	
	/**
	 * 提现接口
	 * @param reqMessage
	 * @return
	 */
	public WithdrawRspUPGMsg withdraw(WithdrawReqUPGMsg reqMessage){
		return null;
	}
	
	/**
	 * 转账接口
	 * @param reqMessage
	 * @return
	 */
	public TransAmountRspUPGMsg transAmount(TransAmountReqUPGMsg reqMessage){
		return null;
	}
}

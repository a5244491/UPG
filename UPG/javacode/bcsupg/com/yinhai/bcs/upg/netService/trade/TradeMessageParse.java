package com.yinhai.bcs.upg.netService.trade;

import javax.servlet.http.HttpServletRequest;

import com.yinhai.bcs.upg.message.trade.CancelTradeReqUPGMsg;
import com.yinhai.bcs.upg.message.trade.TransAmountReqUPGMsg;
import com.yinhai.bcs.upg.message.trade.WithdrawReqUPGMsg;

public class TradeMessageParse {

	
	
	/**
	 * 获取交易请求数据包
	 * @param request
	 * @return
	 */
	public static String  getTradeResultDataString(HttpServletRequest request){
		return "";
	}
	
	
	/**
	 * 构造交易转账消息
	 * @param dataStr 支付请求数据信息
	 * @return ReqMessage 支付请求消息
	 */
	public static TransAmountReqUPGMsg createTransAmountReqMsg(String dataStr){
		
		return null;
	}
	
	/**
	 * 构造交易提现消息
	 * @param dataStr 支付请求数据信息
	 * @return ReqMessage 支付请求消息
	 */
	public static WithdrawReqUPGMsg createWithdrawReqMsg(String dataStr){
		
		return null;
	}
	
	/**
	 * 构造交易撤销消息
	 * @param dataStr 支付请求数据信息
	 * @return ReqMessage 支付请求消息
	 */
	public static CancelTradeReqUPGMsg createCancelTradeReqMsg(String dataStr){
		
		return null;
	}
	
	
	public static String processCoreCancelTrade (CancelTradeReqUPGMsg cancelTradeReqMsg){
		return null;
	}
	public static String processCoreTransAmount (TransAmountReqUPGMsg transAmountReqMsg){
		return null;
	}
	public static String processCoreWithdraw (WithdrawReqUPGMsg withdrawReqMsg){
		return null;
	}
}

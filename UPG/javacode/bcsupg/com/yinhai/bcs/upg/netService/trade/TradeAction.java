/*package com.yinhai.bcs.upg.netService.trade;

import com.yinhai.bcs.upg.message.common.ReqUPGMsgHeader;
import com.yinhai.bcs.upg.message.trade.CancelTradeReqUPGMsg;
import com.yinhai.bcs.upg.message.trade.TransAmountReqUPGMsg;
import com.yinhai.bcs.upg.message.trade.WithdrawReqUPGMsg;
import com.yinhai.bcs.upg.message.util.MessageUtil;
import com.yinhai.webframework.BaseAction;


*//**
 * 交易服务Action 一个业务一对一方法
 * @author kai
 * @version 1.0
 * @updated 15-4-2014 17:20:47
 *//*
public class TradeAction extends BaseAction{
	
	//请求 http://xxxxx/tradeAction.c!processCancleTrade.do
	public String processCancleTrade(){		
		
		//dataStr  取出整个协议包
	    String dataStr = TradeMessageParse.getTradeResultDataString(request);
	   
	    //解析报文
	    CancelTradeReqUPGMsg cancelTradeReqMsg= TradeMessageParse.createCancelTradeReqMsg(dataStr);
	    
	    //解析请求消息头
		ReqUPGMsgHeader reqHeadMsg= cancelTradeReqMsg.getMsgHeader();
		
		    //验证请求报文签名
//		if(MessageUtil.verifySign(reqHeadMsg.getSign_data())==1){
//			//返回消息
//			
//			//调用核心系统，执行交易撤销操作
//			String returnMsg = TradeMessageParse.processCoreCancelTrade(cancelTradeReqMsg);
//		}else{
//			//签名验证失败
//		}
		
		return null;
	}
	
	
	
	
	//请求 http://xxxxx/tradeAction.c!processTransAmount.do
	public String processTransAmount(){
		
		//dataStr  取出整个协议包
	    String dataStr = TradeMessageParse.getTradeResultDataString(request);
	   
	    //解析报文
//	    TransAmountReqUPGMsg transAmountReqMsg= TradeMessageParse.createTransAmountReqMsg(dataStr);
	    
	    //解析请求消息头
//		ReqUPGMsgHeader reqHeadMsg= transAmountReqMsg.getMsgHeader();
		
		  //验证请求报文签名
//	    if(MessageUtil.verifySign(reqHeadMsg.getSign_data())==1){
//		  //返回消息
//		  
//	      
//		  //调用核心系统，执行交易转账操作
//	    	String returnMsg = TradeMessageParse.processCoreTransAmount(transAmountReqMsg);
//	    }else{
//		  //签名验证失败
//	    }
		
		return null;
	}
	
	
	
	
	
	
	//请求 http://xxxxx/tradeAction.c!processWithdraw.do
	public String processWithdraw(){
		
		//dataStr  取出整个协议包
//	    String dataStr = TradeMessageParse.getTradeResultDataString(request);
//	   
//	    //解析报文
//	    WithdrawReqUPGMsg withdrawReqMsg= TradeMessageParse.createWithdrawReqMsg(dataStr);
//	    
//	    //解析请求消息头
//		ReqUPGMsgHeader reqHeadMsg= withdrawReqMsg.getMsgHeader();
//		
//		  //验证请求报文签名
//	    if(MessageUtil.verifySign(reqHeadMsg.getSign_data())==1){
//		  //返回消息
//		  //调用核心系统，执行交易提现操作
//	    	String returnMsg = TradeMessageParse.processCoreWithdraw(withdrawReqMsg);
//	    }else{
//		  //签名验证失败
//	    }
		return null;
	}
	
}
*/
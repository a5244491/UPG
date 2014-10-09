package com.yinhai.bcs.upg.netService.pay.dealProcess;

import java.math.BigDecimal;
import java.util.Map;


import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.dbservice.SDBClientFactory;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;




public class ABPaySettleTradeProcess implements PayDealProcess {

	@Override
	public int deal(OutFPayResultMsg outPayResultMsg,Map<String,Object> payRecord) {
		//支付成功后的处理动作
		//调用核心系统AB交易处理操作
		if(outPayResultMsg != null && payRecord != null){
//			AccountABSettleSDBReqMsg reqMessage = new AccountABSettleSDBReqMsg();
//			ReqSDBMessageHeader reqMessageHeader = new ReqSDBMessageHeader();
//			reqMessageHeader.setClientId(9001);
//			reqMessageHeader.setOpFlag("accountABSettle");
//			reqMessageHeader.setOpSn(payRecord.get("opt_sn").toString());
//			reqMessageHeader.setOpUser(10000L);
//			reqMessageHeader.setSignData("");
//			reqMessage.setBizId(3);
//			reqMessage.setOpenPsw(0);//不开启支付密码
//			reqMessage.setTradePsw("noneedpsw");
//			reqMessage.setPayType("outer");
//			reqMessage.setPayAccountId(Integer.parseInt(payRecord.get("pay_account").toString()));
//			reqMessage.setRemark("订单支付-交易");
//			reqMessage.setSettleAccountId(Integer.parseInt(payRecord.get("receive_account").toString()));
//			reqMessage.setSettleAmount(new BigDecimal(payRecord.get("trade_balance").toString()));
//			reqMessage.setReqMsgHeader(reqMessageHeader);
//			RspSDBMessage rspMessage;
//			try {
//				rspMessage = SDBClientFactory.sdbClient.sendMessage(reqMessage, AccountABSettleSDBRspMsg.class);
//				if(rspMessage.getRspMsgHeader().getReturnCode() == 1){
//					return IConstants.DEAL_STATUS_2;
//				}else{
//					return IConstants.DEAL_STATUS_0;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				return IConstants.DEAL_STATUS_0;
//			}
			
			return IConstants.DEAL_STATUS_0;
		}else{
			return IConstants.DEAL_STATUS_0;
		}
	}
}

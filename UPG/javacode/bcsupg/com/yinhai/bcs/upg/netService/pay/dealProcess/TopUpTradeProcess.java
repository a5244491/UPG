package com.yinhai.bcs.upg.netService.pay.dealProcess;

import java.math.BigDecimal;
import java.util.Map;


import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.dbservice.SDBClientFactory;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;




public class TopUpTradeProcess implements PayDealProcess {

	@Override
	public int deal(OutFPayResultMsg outPayResultMsg,Map<String,Object> payRecord) {
		//支付成功后的处理动作
		//调用核心系统AB交易处理操作
		if(outPayResultMsg != null && payRecord != null){
//			AccountRechargeSDBReqMsg reqMessage = new AccountRechargeSDBReqMsg();
//			ReqSDBMessageHeader reqMessageHeader = new ReqSDBMessageHeader();
//			reqMessageHeader.setClientId(9001);
//			reqMessageHeader.setOpFlag("accountRecharge");
//			reqMessageHeader.setOpSn(payRecord.get("opt_sn").toString());
//			reqMessageHeader.setOpUser(10000L);
//			reqMessageHeader.setSignData("");
//			
//			BigDecimal _temp_test_money = new BigDecimal(10000);//TEST 可删
//			
//			reqMessage.setAccountId(Integer.parseInt(payRecord.get("receive_account").toString()));
//			reqMessage.setAmount(_temp_test_money.multiply(new BigDecimal(payRecord.get("trade_balance").toString())));
//			reqMessage.setRemark("账户资金充值");
//			reqMessage.setReqMsgHeader(reqMessageHeader);
//			RspSDBMessage rspMessage;
//			try {
//				rspMessage = SDBClientFactory.sdbClient.sendMessage(reqMessage, AccountRechargeSDBRspMsg.class);
//				
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

package com.yinhai.bcs.upg.pay3Interface.virtual;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.yinhai.bcs.sdb.common.message.ReqSDBMessageHeader;
//import com.yinhai.bcs.sdb.common.message.RspSDBMessage;
//import com.yinhai.bcs.sdb.trade.message.AccountABSettleSDBReqMsg;
//import com.yinhai.bcs.sdb.trade.message.AccountABSettleSDBRspMsg;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.dbservice.SDBClientFactory;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.Pay3ProtocolTrans;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;

public class VirtualProtocolTrans implements Pay3ProtocolTrans{

	@Override
	public Map<String,Object> reqBPayTrans(PayUPGReqMsg payReqMsgBody) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,Object> reqFPayTrans(PayUPGReqMsg payReqMsgBody,
			Map<String, Object> payInterfaceMap) {
//		//装配虚拟账户交易所需参数
//		AccountABSettleSDBReqMsg reqMessage = new AccountABSettleSDBReqMsg();
//		ReqSDBMessageHeader reqMessageHeader = new ReqSDBMessageHeader();
//		reqMessageHeader.setClientId(payReqMsgBody.getMsgHeader().getClient_id());
//		reqMessageHeader.setOpFlag("accountABSettle");
//		reqMessageHeader.setOpSn(payReqMsgBody.getMsgHeader().getOpt_sn());
//		reqMessageHeader.setOpUser(1000000L);
//		reqMessageHeader.setSignData("");
//		reqMessage.setBizId(3);
//		reqMessage.setOpenPsw(1);
//		reqMessage.setTradePsw(payReqMsgBody.getTrade_psw());
//		reqMessage.setPayType("inner");
//		reqMessage.setPayAccountId(Integer.parseInt(payReqMsgBody.getPay_account()));
//		reqMessage.setRemark("订单虚拟账户支付-交易");
//		reqMessage.setSettleAccountId(Integer.parseInt(payReqMsgBody.getReceive_account()));
//		reqMessage.setSettleAmount(payReqMsgBody.getTrade_balance());
//		reqMessage.setReqMsgHeader(reqMessageHeader);
//		RspSDBMessage rspMessage = null;
//		try {
//			rspMessage = SDBClientFactory.sdbClient.sendMessage(reqMessage, AccountABSettleSDBRspMsg.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Map<String,Object> resultMap=new HashMap<String, Object>();
		Map<String,Object> postDataMap = new HashMap<String,Object>();
//		String extra_common_param = IConstants.PAY_SN_LINK_FLAG+payReqMsgBody.getMsgHeader().getOpt_sn();
//		if(rspMessage.getRspMsgHeader().getReturnCode() == 1){//交易成功
//			postDataMap.put("extra_common_param", extra_common_param);
//			postDataMap.put("pay_account", payReqMsgBody.getPay_account());
//			postDataMap.put("receive_account", payReqMsgBody.getReceive_account());
//			postDataMap.put("total_fee", payReqMsgBody.getTrade_balance().toString());
//			postDataMap.put("trade_status", "SUCCESS");
//			postDataMap.put("out_trade_no", payReqMsgBody.getMsgHeader().getOpt_sn());
//			postDataMap.put("order_sn", payReqMsgBody.getTrade_sn());
//			postDataMap.put("trade_desc", payReqMsgBody.getTrade_desc());
//		}
		
		
		
		
		
//		String reqMsgStr = MessageUtil.coverObject2Json(reqMessage);
//
//		Map<String,Object> resultMap=new HashMap<String, Object>();
//		InputStream inputStream = null;
//		try {
//			inputStream = new ByteArrayInputStream(reqMsgStr.getBytes("UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} 
//		//生成请求
//		Map<String,Object> postDataMap = new HashMap<String,Object>();
//		postDataMap.put("inputStream", inputStream);
		resultMap.put(IConstants.FPAY_POST_URL, payInterfaceMap.get("return_url"));
		resultMap.put(IConstants.FPAY_POST_DATA, postDataMap);
		
		return resultMap;
	}

	@Override
	public OutFPayResultMsg createPayResult(Map<String, String> reqParamMap) {
		OutFPayResultMsg resultMsg=new OutFPayResultMsg();
		String trade_status=reqParamMap.get("trade_status");
		int payResult = 2;
		try{
			if(trade_status !=null && trade_status.equals("SUCCESS")){
				payResult=IConstants.PAY_RESULT_SUCCESS;
			}
			if(payResult==IConstants.PAY_RESULT_SUCCESS){
				resultMsg.setPayResultInfo("支付成功");
			}else{
				resultMsg.setPayResultInfo(reqParamMap.get("error_code"));
			}
			resultMsg.setPayResult(payResult);
			resultMsg.setOrgData(reqParamMap);
			resultMsg.setTradeSN(reqParamMap.get("out_trade_no"));
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public String createFPayNoticeReturnStr(OutFPayResultMsg rspMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkSign(HttpServletRequest request, Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return true;
	}
}

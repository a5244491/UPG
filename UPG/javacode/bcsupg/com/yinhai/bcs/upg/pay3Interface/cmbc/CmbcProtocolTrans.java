package com.yinhai.bcs.upg.pay3Interface.cmbc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.Pay3ProtocolTrans;
//import com.yinhai.bcs.upg.pay3Interface.cmbc.config.CmbcEConfig; 
//import com.yinhai.bcs.upg.pay3Interface.cmbc.sign.SignHelper;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;
import com.yinhai.sysframework.util.ValidateUtil;

public class CmbcProtocolTrans implements Pay3ProtocolTrans{

	@Override
	public Map reqBPayTrans(PayUPGReqMsg payReqMsgBody) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Map reqFPayTrans(PayUPGReqMsg payReqMsgBody,Map<String, Object> payInterfaceMap) {
//		CmbcEConfig cmbcEconfig = CmbcEConfig.getInstance();
//		cmbcEconfig.init(payReqMsgBody.getPayWayId().toString());
//		
//		//整和民生银行E支付接口
//		String service = CmbcEConfig.service;
//		String partner_id = cmbcEconfig.getPartner_id();
//		String input_charset = CmbcEConfig.input_charset;
//		String sign_type = CmbcEConfig.sign_type;
//		String notify_url = (String)payInterfaceMap.get("notify_url");
//		String out_trade_no = IConstants.PAY_SN_LINK_FLAG+payReqMsgBody.getMsgHeader().getOpt_sn();
//		String subject = payReqMsgBody.getTrade_desc();
//		String buyer_email = "";
//		String seller_email = payReqMsgBody.getReceive_account();
//		String amount = payReqMsgBody.getTrade_balance().toString();
//		String body = payReqMsgBody.getTrade_desc();
//		String show_url = CmbcEConfig.show_url;
//		String payMethod = CmbcEConfig.pay_method;
//		String default_bank = "";
//		if(payReqMsgBody.getDefault_bank() == null){
//			default_bank = CmbcEConfig.default_bank;
//		}else{
//			default_bank = payReqMsgBody.getDefault_bank();
//		}
//		String royalty_parameters = "";
//		String return_url = (String)payInterfaceMap.get("return_url");
//		
//		//请联系客户经理索要商户签约密钥key
//		String key = cmbcEconfig.getKey();
//		String sign = "";
//		
//		
		Map<String, String> sParaTemp = new HashMap<String, String>();
//		sParaTemp.put("service", service);
//		sParaTemp.put("partner_id", partner_id);
//		sParaTemp.put("input_charset", input_charset);
//		sParaTemp.put("sign_type", sign_type);
//		sParaTemp.put("notify_url", notify_url);
//		sParaTemp.put("out_trade_no", out_trade_no);
//		sParaTemp.put("subject", subject);
//		sParaTemp.put("buyer_email", buyer_email);
//		sParaTemp.put("seller_email", seller_email);
//		sParaTemp.put("amount", amount);
//		sParaTemp.put("body", body);
//		sParaTemp.put("show_url", show_url);
//		sParaTemp.put("payMethod", payMethod);
//		sParaTemp.put("default_bank", default_bank);
//		sParaTemp.put("royalty_parameters", royalty_parameters);
//		sParaTemp.put("return_url", return_url);
//		sParaTemp.put("sign", sign);
//		
//		
//		if(ValidateUtil.isNotEmpty(key)){
//			sign = SignHelper.sign(sParaTemp, key);
//			sParaTemp.put("sign", sign);
//		}else{
//			System.out.println("key不能为空");
//			return null;
//		}
//		String postUrl = CmbcEConfig.CMBCE_GATEWAY;
		String postUrl = "";
		//生成请求
		Map resultMap = new HashMap<String, Object>();
		resultMap.put(IConstants.FPAY_POST_URL, postUrl);
		resultMap.put(IConstants.FPAY_POST_DATA, sParaTemp);
		
		return resultMap;
	}



	@Override
	public String createFPayNoticeReturnStr(OutFPayResultMsg rspMsg) {
		return "success";
	}



	@Override
	public OutFPayResultMsg createPayResult(Map<String, String> reqParamMap) {
		OutFPayResultMsg resultMsg = new OutFPayResultMsg();
		String isSuccessStr = reqParamMap.get("is_success");
		String trade_status = reqParamMap.get("trade_status");
		int payResult = 2;
		try{
			if(isSuccessStr != null&&!isSuccessStr.equals("")){
				payResult=IConstants.PAY_RESULT_SUCCESS;
			}else{
				payResult=IConstants.PAY_RESULT_FAILD;
			}
			
			if(trade_status!=null&&trade_status.equals("TRADE_FINISHED")){
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
	public boolean checkSign(HttpServletRequest request,
			Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return true;
	}



	
	
}

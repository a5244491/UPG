package com.yinhai.bcs.upg.pay3Interface.alipay;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.Pay3ProtocolTrans;
import com.yinhai.bcs.upg.pay3Interface.alipay.config.AlipayConfig;
import com.yinhai.bcs.upg.pay3Interface.alipay.util.AlipaySubmit;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;


public class AplipayProtocolTrans implements Pay3ProtocolTrans{

	@Override
	public Map reqFPayTrans(PayUPGReqMsg payReqMsgBody,Map<String, Object> payInterfaceMap) {
		
		//初始化支付宝接口参数
		AlipayConfig alipayconfig = AlipayConfig.getInstance();
		alipayconfig.init(payReqMsgBody.getPayWayId().toString());
		
		//整合支付宝接口参数
		String service = AlipayConfig.ALIPAY_SERVICE_NAME;
		String partner = AlipayConfig.getInstance().getPartner();
		String payment_type = AlipayConfig.ALIPAY_PAYMENT_TYPE;
		String _input_charset = AlipayConfig.input_charset;
		String notify_url = (String)payInterfaceMap.get("notify_url");
		String return_url = (String)payInterfaceMap.get("return_url");
		String error_notify_url = payReqMsgBody.getError_notify_url();
		String seller_email = payReqMsgBody.getReceive_account();
		String out_trade_no = payReqMsgBody.getMsgHeader().getOpt_sn();
		String subject = payReqMsgBody.getTrade_desc();
		String total_fee = payReqMsgBody.getTrade_balance().toString();
		String extra_common_param = IConstants.PAY_SN_LINK_FLAG+payReqMsgBody.getMsgHeader().getOpt_sn();
		String body = "";
		String show_url = "";
		String anti_phishing_key = "";
		String exter_invoke_ip = "";
		
		
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", service);
        sParaTemp.put("partner", partner);
        sParaTemp.put("_input_charset", _input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("error_notify_url", error_notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("seller_email", seller_email);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("extra_common_param", extra_common_param);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		
		String postUrl=AlipayConfig.ALIPAY_GATEWAY_NEW+ "_input_charset=" + AlipayConfig.input_charset;
		Map resultMap=new HashMap<String, Object>();
		//生成请求
		Map postDataMap = AlipaySubmit.buildRequestMap(sParaTemp);
		
		resultMap.put(IConstants.FPAY_POST_URL, postUrl);
		resultMap.put(IConstants.FPAY_POST_DATA, postDataMap);
		
		return resultMap;
	}

	

	@Override
	public Map reqBPayTrans(PayUPGReqMsg payReqMsgBody) {
		return null;
	}



	@Override
	public String createFPayNoticeReturnStr(OutFPayResultMsg rspMsg) {
		return "success";
	}


	
	@Override
	public OutFPayResultMsg createPayResult(Map<String, String> reqParamMap) {
		/**
		 * 支付宝同步回页面参数说明详见支付接口参数表
		 */
		OutFPayResultMsg result_msg = new OutFPayResultMsg();
		String is_success   = reqParamMap.get("is_success");
		String trade_status = reqParamMap.get("trade_status");
		int payResult       = IConstants.PAY_RESULT_FAILD;
		try{
			if(is_success != null && IConstants.USE_INTERFACE_STATUS_SUCCESS.equals(is_success)){
				if(trade_status != null && IConstants.TRADE_SUCCESS.equals(trade_status)){
					//交易成功
					payResult = IConstants.PAY_RESULT_SUCCESS;
				}
			}
			if(payResult == IConstants.PAY_RESULT_SUCCESS){
				result_msg.setPayResultInfo("支付成功.");
			}else{
				result_msg.setPayResultInfo(reqParamMap.get("error_code"));
			}
			result_msg.setPayResult(payResult);
			result_msg.setOrgData(reqParamMap);
			result_msg.setTradeSN(reqParamMap.get("out_trade_no"));
		}catch (Exception ex) {
			ex.printStackTrace();
			result_msg.setPayResultInfo("Exception:"+ex.getMessage());
		}
		return result_msg;
	}



	@Override
	public boolean checkSign(HttpServletRequest request,
			Map<String, String> paramMap, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return true;
	}
	

}

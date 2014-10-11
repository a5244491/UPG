package com.yinhai.bcs.upg.pay3Interface.llpay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.common.util.SpringContextUtil;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.pay3Interface.Pay3ProtocolTrans;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;

public class LlProtocolTrans implements Pay3ProtocolTrans {
	protected final Log log = LogFactory.getLog(getClass());
	PartnerConfig pConfig = (PartnerConfig) SpringContextUtil.getBean("llpayConfig");

	@Override
	public Map<?, ?> reqBPayTrans(PayUPGReqMsg payReqMsgBody) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> reqFPayTrans(PayUPGReqMsg payReqMsgBody, Map<String, Object> payInterfaceMap) {
		PaymentInfo paymentInfo = new PaymentInfo();

		paymentInfo.setVersion(pConfig.getVERSION());
		paymentInfo.setOid_partner(pConfig.getOID_PARTNER()); // 支付交易商户编号 必录*
		paymentInfo.setUser_id(pConfig.getOID_PARTNER()); // 商户用户唯一编号 必录*

		paymentInfo.setBusi_partner(pConfig.getBUSI_PARTNER()); // 商户业务类型 必录*
		paymentInfo.setNo_order(payReqMsgBody.getMsgHeader().getOpt_sn()); // 商户唯一订单号
																			// 必录*
		paymentInfo.setDt_order(LLPayUtil.getCurrentDateTimeStr()); // 商户订单时间
																	// 必录*
		paymentInfo.setName_goods(payReqMsgBody.getTrade_desc()); // 商品名称 必录*
		paymentInfo.setInfo_order(payReqMsgBody.getTrade_desc()); // 订单描述 非必录
		paymentInfo.setMoney_order(payReqMsgBody.getTrade_balance().toString()); // 交易金额
																					// 必录*
		paymentInfo.setNotify_url((String) payInterfaceMap.get("notify_url")); // 服务器异步通知地址
																				// 必录*
		paymentInfo.setUrl_return((String) payInterfaceMap.get("return_url")); // 支付结束回显url
																				// 非必录
		// 用户端申请 IP 用户访问商户的请求 IP,银通支付网兲会根据这个 ip 校验用户支付的 ip 是否一致,防止钓鱼
		// paymentInfo.setUserreq_ip(LLPayUtil.getIpAddr(req));
		paymentInfo.setUserreq_ip("127.0.0.1"); // 用户端申请 IP 必录*
		paymentInfo.setUrl_order(""); // 订单地址 非必录
		paymentInfo.setValid_order("10080");// 订单有效时间 单位分钟，可以为空，默认7天 非必录
		paymentInfo.setTimestamp(LLPayUtil.getCurrentDateTimeStr()); // 时间戳
		// paymentInfo.setRisk_item(createRiskItem()); // 风险控制参数 非必录
		paymentInfo.setSign_type(pConfig.getSIGN_TYPE()); // 签名方式 RSA 或者
															// MD5 必录*
		// 加签名
		String sign = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(paymentInfo)), pConfig.getTRADER_PRI_KEY(),
				pConfig.getMD5_KEY());
		paymentInfo.setSign(sign); // 签名
		// String sign = LLPayUtil.addSignRSA(JSON.parseObject(JSON
		// .toJSONString(paymentInfo)), PartnerConfig.TRADER_PRI_KEY,
		// PartnerConfig.MD5_KEY);

		String postUrl = ServerURLConfig.PAY_URL;
		// 生成请求
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(IConstants.FPAY_POST_URL, postUrl);
		resultMap.put(IConstants.FPAY_POST_DATA, paymentInfo.toMap());
		return resultMap;
	}

	@Override
	public String createFPayNoticeReturnStr(OutFPayResultMsg rspMsg) {
		RetBean retBean = new RetBean();
		retBean.setRet_code("0000");
		retBean.setRet_msg("交易成功");
		return JSON.toJSONString(retBean);
	}

	@Override
	public OutFPayResultMsg createPayResult(Map<String, String> reqParamMap) {
		OutFPayResultMsg resultMsg = new OutFPayResultMsg();
		String result_pay = reqParamMap.get("result_pay");
		int payResult = 2;
		try {
			if ("SUCCESS".equals(result_pay)) {
				payResult = IConstants.PAY_RESULT_SUCCESS;
				resultMsg.setPayResultInfo("支付成功");
			} else {
				payResult = IConstants.PAY_RESULT_FAILD;
				resultMsg.setPayResultInfo("支付失败");
			}
			resultMsg.setPayResult(payResult);
			resultMsg.setOrgData(reqParamMap);
			resultMsg.setTradeSN(reqParamMap.get("no_order"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public boolean checkSign(HttpServletRequest request, Map<String, String> paramMap) {
		
		try {
			// String reqStr = LLPayUtil.readReqStr(request);
			// Map<String, String> temp = new HashMap<String, String>();
			// temp.putAll(paramMap);
			// changeMap(temp);

			if (!LLPayUtil.checkSign(paramMap, pConfig.getYT_PUB_KEY(), pConfig.getMD5_KEY())) {
				log.debug("连连支付异步通知验签失败");
				System.out.println("连连支付异步通知验签失败");
				return false;
			}
		} catch (Exception e) {
			log.debug("连连支付异步通知报文解析异常："+ e);
			System.out.println("连连支付异步通知报文解析异常：" + e);
			return false;
		}
		log.debug("连连支付异步通知数据接收验签成功");
		System.out.println("连连支付异步通知数据接收验签成功");
		return true;
	}

	private void changeMap(Map<String, String> paramMap) {
		// 商户编号 oid_partner
		// 签名方式 sign_type
		// 签名 sign
		// 商户订单时间 dt_order
		// 商户唯一订单号 no_order
		// 连连支付支付单号 oid_paybill
		// 交易金额 money_order
		// 支付结果 result_pay
		// 清算日期 settle_date
		// 订单描述 info_order
		// 支付方式 pay_type
		// 银行编号 bank_code
		// 签约协议号 no_agree
		// 证件类型 id_type
		// 证件号码 id_no
		// 银行账号姓名 acct_name
		paramMap.put("sign", paramMap.get("sign_data"));
		paramMap.remove("sign_data");
	}

}

package com.yinhai.bcs.upg.message.util;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.message.common.ReqUPGMsgHeader;
import com.yinhai.bcs.upg.message.common.RspUPGMessage;
import com.yinhai.bcs.upg.message.common.RspUPGMsgHeader;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.message.pay.PayUPGRspMsg;

public class MessageUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	static Random random = new Random();
	static AtomicLong serial = new AtomicLong(1);

	/**
	 * 构造支付请求消息
	 * 
	 * @param dataStr
	 *            支付请求数据信息
	 * @return ReqMessage 支付请求消息
	 */
	public static PayUPGReqMsg createPayReqMsg(Map<String, String[]> dataMap) throws Exception {

		// 构造支付请求消息
		PayUPGReqMsg reqMsg = new PayUPGReqMsg();
		// 构造支付请求消息头
		ReqUPGMsgHeader msgHeader = constructionReqMsgHeader(dataMap);

		reqMsg.setMsgHeader(msgHeader);

		// 构造支付请求消息体
		try {
			/** 交易流水号 */
			String trade_sn = null;
			if (dataMap.containsKey("trade_sn")) {
				trade_sn = dataMap.get("trade_sn")[0];
			}
			/** 交易说明 */
			String trade_desc = null;
			if (dataMap.containsKey("trade_desc")) {
				trade_desc = dataMap.get("trade_desc")[0];
			}
			/** 支付账号 */
			String pay_account = null;
			if (dataMap.containsKey("pay_account")) {
				pay_account = dataMap.get("pay_account")[0];
			}
			/** 收款账号 */
			String receive_account = null;
			if (dataMap.containsKey("receive_account")) {
				receive_account = dataMap.get("receive_account")[0];
			}
			/** 交易金额 */
			BigDecimal trade_balance = null;
			if (dataMap.containsKey("trade_balance")) {
				trade_balance = new BigDecimal(dataMap.get("trade_balance")[0]);
			}
			/** 虚拟支付支付密码 */
			String trade_psw = null;
			if (dataMap.containsKey("trade_psw")) {
				trade_psw = dataMap.get("trade_psw")[0];
			}

			/** 处理状态 */
			Integer pay_deal_status = IConstants.PAY_DEAL_STATUS_UNDEAL;

			/** 同步返回地址URL */
			String return_url = null;
			if (dataMap.containsKey("return_url")) {
				return_url = dataMap.get("return_url")[0];
			}
			/** 异步通知地址URL */
			String notify_url = null;
			if (dataMap.containsKey("notify_url")) {
				notify_url = dataMap.get("notify_url")[0];
			}

			/** 缺省银行（民生银行E支付请求参数） */
			String default_bank = null;
			if (dataMap.containsKey("default_bank")) {
				default_bank = dataMap.get("default_bank")[0];
			}

			reqMsg.setReturn_url(return_url);
			reqMsg.setNotify_url(notify_url);
			reqMsg.setTrade_sn(trade_sn);
			reqMsg.setTrade_desc(trade_desc);
			reqMsg.setPay_account(pay_account);
			reqMsg.setReceive_account(receive_account);
			reqMsg.setTrade_balance(trade_balance);
			reqMsg.setPay_deal_status(pay_deal_status);
			reqMsg.setTrade_psw(trade_psw);
			reqMsg.setDefault_bank(default_bank);

			return reqMsg;
		} catch (Exception e) {
			throw new Exception("Invalid message body!");
		}
	}

	/**
	 * 构造支付响应消息
	 * 
	 * @param dataStr
	 *            响应数据信息
	 * @return ReqMessage 响应消息
	 */
	public static PayUPGRspMsg createPayRspMsg(String dataStr) {

		// 按规定格式拆分协议包
		String msg[] = dataStr.split("&");

		// 构造支付请求消息头
		RspUPGMsgHeader rspMsgHeader = constructionRspMsgHeader(msg[0]);

		// 构造支付请求消息
		PayUPGRspMsg rspMsg = new PayUPGRspMsg();
		rspMsg.setRspMsgHeader(rspMsgHeader);

		return rspMsg;
	}

	/**
	 * 构造错误响应消息
	 * 
	 * @param dataStr
	 *            响应数据信息
	 * @return ReqMessage 响应消息
	 */
	public static RspUPGMessage createErrorRspMsg(String errorCode) {

		RspUPGMessage rspMsg = new RspUPGMessage();
		return rspMsg;
	}

	/**
	 * 构造支付响应消息头
	 * 
	 * @param dataStrHeader
	 *            消息头字符串
	 * @return RspMsgHeader 支付响应消息头
	 */
	private static RspUPGMsgHeader constructionRspMsgHeader(String dataStrHeader) {
		RspUPGMsgHeader rspMsgHeader = new RspUPGMsgHeader();
		// 解析dataStrHeader操作
		String payRspMsgHeaderParams[] = dataStrHeader.split("&");
		rspMsgHeader.setClientId(100);
		rspMsgHeader.setOpSn("sn10000");
		rspMsgHeader.setServiceId(10000);
		rspMsgHeader.setSignData(payRspMsgHeaderParams[3]);
		return rspMsgHeader;
	}

	/**
	 * 生成消息流水号 生成规则：服务标识(4位)+客户端ID(4位)+当前时间(17位)+流水号(6位)+随机号(1位)
	 */
	public static String createSN(String serviceId, String clientId) {
		// 时间
		String t = sdf.format(new Date());
		// 随机数
		// int max = 999999;
		// int min = 100000;
		// int i = random.nextInt(max) % (max - min + 1) + min;
		// String n = new Integer(i).toString();
		// 返回值
		String returnStr = null;
		// modify by CQ
		// returnStr = serviceId + clientId + t + n;
		returnStr = serviceId + clientId + t + getSerial()+ random.nextInt(9);
		// returnStr = serviceId + clientId + t +
		// UUID.randomUUID().toString().toUpperCase().replace("-", "");
		return returnStr;
	}

	/**
	 * 获取6位流水号，从1开始到999990
	 * 
	 * @return
	 * @throws SerialGenneratorException
	 */
	public static String getSerial() {
		long sn = serial.getAndIncrement();
		if (sn + 1 > 999990) {// 如果达到上限，则从0开始
			synchronized (serial) {// serial是AtomicLong类型
				if (sn + 1 > 999990) {
					serial.set(1);
				}
			}
			sn = serial.getAndIncrement();
		}
		return seiralFormat(sn, "######000000");
	}

	private static String seiralFormat(long sn, String format) {
		DecimalFormat df1 = new DecimalFormat(format);
		return df1.format(sn);
	}

	/**
	 * 从支付返回的消息得到opt_sn 生成规则：服务标识+客户端ID+当前时间(14位)+随机数(6位)
	 */
	public static String findSN(Map<String, String> paramMap) {
		// add by CQ for test
		if (true) {
			String temp = paramMap.get("no_order");
			System.out.println("no_order:" + temp);
			return temp;
		}
		String snKey = "";
		if (paramMap != null) {
			for (String key : paramMap.keySet()) {
				if (paramMap.get(key) != null) {
					if (paramMap.get(key).indexOf(IConstants.PAY_SN_LINK_FLAG) > -1) {
						snKey = key;
						break;
					}
				}
			}
		}
		String snOrg = paramMap.get(snKey);
		if (snOrg != null) {
			snOrg = snOrg.replaceAll(IConstants.PAY_SN_LINK_FLAG, "");
		}
		return snOrg;
	}

	/**
	 * 构造支付请求消息头
	 * 
	 * @param dataMap
	 *            requestMap
	 * @return ReqMsgHeader 支付请求消息头
	 */
	public static ReqUPGMsgHeader constructionReqMsgHeader(Map<String, String[]> dataMap) throws Exception {

		ReqUPGMsgHeader reqMsgHeader = new ReqUPGMsgHeader();
		try {
			/** 服务编号 */
			Integer service_id = null;
			if (dataMap.containsKey("service_id")) {
				service_id = new Integer(dataMap.get("service_id")[0]);
			}
			/** 客户端编号 */
			Integer client_id = null;
			if (dataMap.containsKey("client_id")) {
				client_id = new Integer(dataMap.get("client_id")[0]);
			}
			/** 签名数据 */
			String sign_data = null;
			if (dataMap.containsKey("sign_data")) {
				sign_data = dataMap.get("sign_data")[0];
			}
			/** 获取操作流水号 */
			String opt_sn = null;
			if (dataMap.containsKey("opt_sn")) {
				opt_sn = dataMap.get("opt_sn")[0];
			}
			reqMsgHeader.setService_id(service_id);
			reqMsgHeader.setClient_id(client_id);
			reqMsgHeader.setOpt_sn(opt_sn);
			reqMsgHeader.setSign_data(sign_data);

			return reqMsgHeader;
		} catch (Exception e) {
			throw new Exception("Invalid message header!");
		}
	}

	/**
	 * 验证操作流水号的有效性
	 * 
	 * @param serviceId
	 * @param clientId
	 * @param opsn
	 * @return
	 */
	public static boolean verifyOPSN(String serviceId, String clientId, String opsn) {
		String opSnTmp = opsn;
		if (clientId == null) {
			clientId = "";
		}
		if (serviceId == null) {
			serviceId = "";
		}
		if (opSnTmp == null) {
			opSnTmp = "";
		}
		int serviceIdLen = serviceId.length();
		int clientIdLen = clientId.length();
		int opsnLen = opsn.length();
		if (opsnLen <= serviceIdLen || opsnLen <= clientIdLen) {
			return false;
		}
		String serviceIdTmp = opSnTmp.substring(0, serviceIdLen);
		String clientIdTmp = opSnTmp.substring(serviceIdLen, serviceIdLen + clientIdLen);
		String opSnTmp2 = opSnTmp.substring((serviceIdLen + clientIdLen));
		if (!serviceIdTmp.equals(serviceId)) {
			return false;
		}
		if (!clientIdTmp.equals(clientId)) {
			return false;
		}
		// modify by CQ 之前流水号长度20,现在改为46
		if (opSnTmp2.length() != 24) {
			return false;
		}
		String opSnTmp3 = opSnTmp2.substring(0, 8);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String curDate = sdf.format(new Date(System.currentTimeMillis()));
		if (!opSnTmp3.equals(curDate)) {
			return false;
		}
		return true;
	}

	public static boolean verifyRepeatOPSN(String serviceId, String clientId, String opsn) {

		String opSnTmp = opsn;
		if (clientId == null) {
			clientId = "";
		}
		if (serviceId == null) {
			serviceId = "";
		}
		if (opSnTmp == null) {
			opSnTmp = "";
		}
		int serviceIdLen = serviceId.length();
		int clientIdLen = clientId.length();
		int opsnLen = opSnTmp.length();
		if (opsnLen <= serviceIdLen || opsnLen <= clientIdLen) {
			return false;
		}
		String serviceIdTmp = opSnTmp.substring(0, serviceIdLen);
		String clientIdTmp = opSnTmp.substring(serviceIdLen, serviceIdLen + clientIdLen);
		String opSnTmp2 = opSnTmp.substring((serviceIdLen + clientIdLen));
		if (!serviceIdTmp.equals(serviceId)) {
			return false;
		}
		if (!clientIdTmp.equals(clientId)) {
			return false;
		}
		if (opSnTmp2.length() != 20) {
			return false;
		}
		String opSnTmp3 = opSnTmp2.substring((serviceIdLen + clientIdLen), 16);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String curDate = sdf.format(new Date(System.currentTimeMillis()));
		if (!opSnTmp3.equals(curDate)) {
			return false;
		}

		return true;
	}

	// 服务ID+客户端ID+流水号+订单号+交易金额 顺序要准确
	public static String signFPayMessage(Map<String, String> reqParam, String privateCertPath, String certPwd) {

		String signOrgStr = "";
		signOrgStr += reqParam.get("service_id");
		signOrgStr += reqParam.get("client_id");
		signOrgStr += reqParam.get("opt_sn");
		signOrgStr += reqParam.get("trade_sn");
		signOrgStr += reqParam.get("trade_balance");
		String signData = "";

		try {
			signData = CertUtil.signStr(signOrgStr, privateCertPath, certPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return signData;
	}

	/**
	 * 验证签名 服务ID+客户端ID+流水号+订单号+交易金额 顺序要准确
	 * 
	 * @param signData
	 * @return false-失败,true-成功
	 */
	public static boolean verifyFPaySign(Map<String, String> reqParam, String signData, String clientPubKey) {

		String signOrgStr = "";
		signOrgStr += reqParam.get("service_id");
		signOrgStr += reqParam.get("client_id");
		signOrgStr += reqParam.get("opt_sn");
		signOrgStr += reqParam.get("trade_sn");
		signOrgStr += reqParam.get("trade_balance");
		boolean result = false;
		try {
			PublicKey publicKey = RSAUtil.getPublicKey(clientPubKey);
			result = CertUtil.verifyStr(signOrgStr, signData, "utf-8", publicKey);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * 将请求信息转化为一个Map数据结构
	 * 
	 * @param rsqMessage
	 *            请求消息
	 * @return Map Map数据集结构
	 */
	public static Map<String, Object> payReqMsgBody2Map(PayUPGReqMsg payReqMsg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payReqMsg.toMap();
		return map;
	}

	/**
	 * 将响应信息转化为一个Map数据结构
	 * 
	 * @param rsqMessage
	 *            响应消息
	 * @return Map Map数据集结构
	 */
	public static Map<String, Object> rspMessage2Map(RspUPGMessage rsqMessage) {
		Map<String, Object> map = new HashMap<String, Object>();

		return map;
	}

	/**
	 * BCSUPG SIGN签名操作(示例方法)
	 * 
	 * @param originalData
	 *            原始数据
	 * @return newData 签名后的数据
	 */
	public static String bcsupgSign(String originalData, String signData) {
		StringBuffer newData = new StringBuffer();
		newData.append("9283UYUXBCJNUYBUIUI");
		newData.append(originalData);
		for (int i = 10; i < 16; i++) {
			newData.append("I" + i + "U");
		}
		newData.append(signData);
		return newData.toString();
	}

	public static String coverObject2Jason(Object obj) {
		return "";
	}

	public static String coverObject2UrlParam(Object obj) {
		return "";
	}

	public static String coverObject2Json(Object object) {
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
	}

	public static Object coverJson2Object(String json, Class<?> classType) {
		Gson gson = new Gson();
		Object object = gson.fromJson(json, classType);
		return object;
	}
}



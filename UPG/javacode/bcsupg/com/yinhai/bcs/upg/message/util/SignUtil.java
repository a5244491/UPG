package com.yinhai.bcs.upg.message.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yinhai.bcs.upg.pay3Interface.llpay.LLPayUtil;
import com.yinhai.bcs.upg.pay3Interface.llpay.enums.SignTypeEnum;
import com.yinhai.bcs.upg.pay3Interface.llpay.secu.Md5Algorithm;
import com.yinhai.bcs.upg.pay3Interface.llpay.secu.TraderRSAUtil;

public class SignUtil
{
	protected final static Log log = LogFactory.getLog(SignUtil.class);
	
	private static final char[] bcdLookup = { '0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	public static String SignData(String text,String priKey){ 
		String str="";
		try
		{
			//使用私鈅签名 
			Signature sig=Signature.getInstance("MD5withRSA"); 
			sig.initSign(RSAUtil.getPrivateKey(priKey));
			sig.update(text.getBytes("ISO-8859-1"));
			byte[] signData=sig.sign();
			str= SignUtil.bytesToHexStr(signData);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		} catch (InvalidKeyException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return str;
	} 
	/**
	 * 验证签名
	 * @see [类、类#方法、类#成员]   
	 * @since [1.0]
	 * @param text 未签名的原值
	 * @param signed 签名后的值
	 * @param pubKey 公钥
	 * @return
	 */
	public static boolean validSign(String text,String signed,String pubKey)
	{
		boolean flag = false;
		//使用公鈅验证 
		try
		{
			byte[]  signData = SignUtil.hexStrToBytes(signed);
			Signature sig=Signature.getInstance("MD5withRSA"); 
			sig.initVerify(RSAUtil.getPublicKey(pubKey));
			sig.update(text.getBytes("ISO-8859-1"));
			try{ 
				if(sig.verify(signData)){
					flag=true;
					//Log.info("验证签名成功！");
				}else
				{
					//Log.error("验证签名失败！");
				}
			}catch(SignatureException e){ 
				e.printStackTrace();
				//Log.error("验证签名异常=="+e.getMessage());
			} 
		} catch (InvalidKeyException e1)
		{
			e1.printStackTrace();
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
		return flag;
	}
	/**
	* 获取签名后的值
	*/
	public static final String bytesToHexStr(byte[] bcd) {
		StringBuffer s = new StringBuffer(bcd.length * 2);
	
		for (int i = 0; i < bcd.length; i++) {
			s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
			s.append(bcdLookup[bcd[i] & 0x0f]);
		}
	
		return s.toString();
	}
	/**
	* 文本转成字节
	*/
	public static final byte[] hexStrToBytes(String s) {
		byte[] bytes;
	
		bytes = new byte[s.length() / 2];
	
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2),16);
		}
	
		return bytes;
	}
	
	
	
	/**
	 * str空判断
	 * 
	 * @param str
	 * @return
	 * @author guoyx
	 */
	public static boolean isnull(String str) {
		if (null == str || str.equalsIgnoreCase("null") || str.equals("")) {
			return true;
		} else
			return false;
	}
	
	/**
	 * 生成待签名串
	 * 
	 * @param paramMap
	 * @return
	 * @author guoyx
	 */
	public static String genSignData(JSONObject jsonObject) {
		StringBuffer content = new StringBuffer();

		// 按照key做首字母升序排列
		List<String> keys = new ArrayList<String>(jsonObject.keySet());
		Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			if ("sign".equals(key)) {
				continue;
			}
			String value = jsonObject.getString(key);
			// 空串不参与签名
			if (isnull(value)) {
				continue;
			}
			content.append((i == 0 ? "" : "&") + key + "=" + value);
		}
		String signSrc = content.toString();
		if (signSrc.startsWith("&")) {
			signSrc = signSrc.replaceFirst("&", "");
		}
		return signSrc;
	}

	/**
	 * 加签
	 * 
	 * @param reqObj
	 * @param rsa_private
	 * @param md5_key
	 * @return
	 * @author guoyx
	 */
	public static String addSign(JSONObject reqObj, String rsa_private, String md5_key) {
		if (reqObj == null) {
			return "";
		}
		String sign_type = reqObj.getString("sign_type");
		String sign_src = genSignData(reqObj);
		if (SignTypeEnum.MD5.getCode().equals(sign_type)) {
			return addSignMD5(sign_src, md5_key);
		} else {
			return addSignRSA(sign_src, rsa_private);
		}
	}

	/**
	 * 签名验证
	 * 
	 * @param reqStr
	 * @param paramMap
	 * @return
	 */
	public static boolean checkSign(Map<String, String> paramMap, String rsa_public, String md5_key) {
		// JSONObject reqObj = JSON.parseObject(reqStr);
		JSONObject reqObj = (JSONObject) JSON.toJSON(paramMap);
		if (reqObj == null)
			return false;
		// if (reqObj == null) {
		// reqObj = (JSONObject) JSON.toJSON(paramMap);
		// // reqObj = JSON.parseObject(paramMap.toString());
		// if (reqObj == null)
		// return false;
		// }
		String sign_type = reqObj.getString("sign_type");
		String sign_src = genSignData(reqObj);
		String sign = reqObj.getString("sign");
		if (SignTypeEnum.MD5.getCode().equals(sign_type)) {
			return checkSignMD5(sign_src, sign, md5_key);
		} else {
			return checkSignRSA(sign_src, sign, rsa_public);
		}
	}

	/**
	 * RSA签名验证
	 * @param sign_src
	 * @param sign
	 * @param rsa_public
	 * @return
	 */
	public static boolean checkSignRSA(String sign_src, String sign, String rsa_public) {
		if (sign_src == null || sign == null) {
			return false;
		}
		//String sign = reqObj.getString("sign");
		// 生成待签名串
		//String sign_src = genSignData(reqObj);
		log.debug("待签名原串" + sign_src);
		log.debug("签名串" + sign);
		try {
			if (TraderRSAUtil.checksign(rsa_public, sign_src, sign)) {
				log.debug("待签名原串[" + sign_src + "]RSA签名验证通过");
				return true;
			} else {
				log.debug("待签名原串[" + sign_src + "]RSA签名验证未通过");
				return false;
			}
		} catch (Exception e) {
			log.debug("待签名原串[" + sign_src + "]RSA签名验证异常" + e.getMessage());
			return false;
		}
	}

	/**
	 * MD5签名验证
	 * @param sign_src
	 * @param sign
	 * @param md5_key
	 * @return
	 */
	public static boolean checkSignMD5(String sign_src, String sign,  String md5_key) {
		if (sign_src == null) {
			return false;
		}
		//String sign = reqObj.getString("sign");
		// 生成待签名串
		//String sign_src = genSignData(reqObj);
		log.debug("待签名原串" + sign_src);
		log.debug("验证签名串" + sign);
		sign_src += "&key=" + md5_key;
		try {
			if (sign.equals(Md5Algorithm.getInstance().md5Digest(sign_src.getBytes("utf-8")))) {
				log.debug("待签名原串[" + sign_src+ "]MD5签名验证通过");
				return true;
			} else {
				log.debug("待签名原串[" + sign_src + "]MD5签名验证未通过");
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			log.debug("待签名原串[" + sign_src + "]MD5签名验证异常" + e.getMessage());
			return false;
		}
	}

	/**
	 *  RSA加签名
	 * @param sign_src
	 * @param rsa_private
	 * @return
	 */
	public static String addSignRSA(String sign_src, String rsa_private) {
		log.debug("进入商户[" + sign_src + "]RSA加签名");
		if (sign_src == null) {
			return "";
		}
		// 生成待签名串
		//String sign_src = genSignData(reqObj);
		try {
			return TraderRSAUtil.sign(rsa_private, sign_src);
		} catch (Exception e) {
			log.debug("商户[" + sign_src + "]RSA加签名异常" + e.getMessage());
			return "";
		}
	}

	/**
	 *  MD5加签名
	 * @param sign_src
	 * @param md5_key
	 * @return
	 */
	public static String addSignMD5(String sign_src, String md5_key) {
		log.debug("进入[" + sign_src + "]MD5加签名");
		if (sign_src == null) {
			return "";
		}
		// 生成待签名串
		//String sign_src = genSignData(reqObj);
		sign_src += "&key=" + md5_key;
		try {
			return Md5Algorithm.getInstance().md5Digest(sign_src.getBytes("utf-8"));
		} catch (Exception e) {
			log.debug("[" + sign_src + "]MD5加签名异常" + e.getMessage());
			return "";
		}
	}
	
	
	public static void main(String[] args) throws UnsupportedEncodingException
	{
		String str="{\"recordCount\":5,\"mapList\":[{\"cardNo\":\"8601999900000001\",\"accountName\":\"\",\"accountBalance\":\"\",\"accountStatus\":\"\",\"accountType\":\"\",\"cardBinName\":\"测试卡Bin\",\"cusName\":\"test\"},{\"cardNo\":\"8601999900000002\",\"accountName\":\",\"accountBalance\":\"\",\"accountStatus\":\"\",\"accountType\":\"\",\"cardBinName\":\"测试卡Bin\",\"cusName\":\"test\"},{\"cardNo\":\"8601999900000005\",\"accountName\":\"\",\"accountBalance\":\"\",\"accountStatus\":\"\",\"accountType\":\"\",\"cardBinName\":\"测试卡Bin\",\"cusName\":\"\"},{\"cardNo\":\"8601999900000004\",\"accountName\":\"\",\"accountBalance\":\"\",\"accountStatus\":\"\",\"accountType\":\"\",\"cardBinName\":\"测试卡Bin\",\"cusName\":\"\"},{\"cardNo\":\"8601999900000003\",\"accountName\":\"\",\"accountBalance\":\"\",\"accountStatus\":\"\",\"accountType\":\"\",\"cardBinName\":\"测试卡Bin\",\"cusName\":\"ss\"}]}";
		String _str = SignUtil.SignData(str, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM8GorEp8ANCsVEJyNTbvATloscrL598++6TzlMcrUjZPRnAvMKtdvJQvU5NsFcfPSwfO0nIXBgu6Z5jseGqr1UjhFxAgVbdRcBBAGJ2xYGday/paccehwvtEl8zLu3BKB0/JVVEPB2ClKvTBLDzevajyet8PQNbwPT41M2EA+F9AgMBAAECgYAl8RZiF8iIIHH04zEuabMUxq1FiVGqDjLx757RtqC/iCjdjmhJ2ZbCJC/9qNlXrj781iB8jj7qo7ZnM+hG7oxBXuPDSIs7dRugdrovfyUgkMx1igzarE/n39sflVm8KGHchZLidhrGz8N6acyYTySIQPnuf06kUtDGUj76uLT3IQJBAOlEzwQna4hg9i4oF59PM8E1hDnfYabDx6gNYTP1eWYkeLYzKNh6N1XjrPlsELo9pK+WpqTNirWNUTBDa309JdkCQQDjMyoppeclmLrDRENlZhG22JYKlbLVVtxZPxAahUc13SbsaKf6K88k59p7lLOq2G748wTfrk/uHMRkpHWe215FAkAcLBZAby5agzNYMblgoSUkAX2dq6/UfzKexjbmGpB12JPHlXgqZOBH/D5IxVdj1swL9MrdfoFxGccjaBEUSA1JAkEAwGd38UU59rDcmLiaiqhhoALTLauQgvLIMBwjuxHbOFZMvC/08PtgtNRURgusC6a2c8T5/6NStUdPWhucMCd+MQJAXJqP+GCXoJAVycYVPhXNCgYWGhFfupVqoCVkpE2n6pox+trnJK6nANlvMeeHcXVQZ6w9ccEsGWf+5galxGE1dQ\\=\\=");
		System.out.println(_str);
		boolean f = SignUtil.validSign(str, _str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPBqKxKfADQrFRCcjU27wE5aLHKy+ffPvuk85THK1I2T0ZwLzCrXbyUL1OTbBXHz0sHztJyFwYLumeY7Hhqq9VI4RcQIFW3UXAQQBidsWBnWsv6WnHHocL7RJfMy7twSgdPyVVRDwdgpSr0wSw83r2o8nrfD0DW8D0+NTNhAPhfQIDAQAB");
		System.out.println(f);
		
		//byte [] b = SignUtil.hexStrToBytes("a941be7836a1d4a986c8dbd18d354fe92899f433d2407579dd5fabe3a99e20e314168fad30e87dc1601011c0ef6ac8601fc8380bb2347c8ad7f2d33e92c5e7630f1a6b55502f176eec83649ef2c279ddc16a055bcf8a9f433a467e789851f127d1edbfd86bd9f012ae2e08218c52186c3104b89cc58cb60cbc78d44362c68de8");
		//System.out.println(new String(b,"GB2312"));
		
	}
}

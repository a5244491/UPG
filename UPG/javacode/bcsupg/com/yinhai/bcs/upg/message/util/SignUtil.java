package com.yinhai.bcs.upg.message.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

public class SignUtil
{
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

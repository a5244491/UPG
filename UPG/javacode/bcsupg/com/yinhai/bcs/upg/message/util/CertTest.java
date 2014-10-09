package com.yinhai.bcs.upg.message.util;

import java.security.PrivateKey;
import java.security.PublicKey;

import sun.misc.BASE64Encoder;


public class CertTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String certPath="G:/OpenSSl-64B/ca1/certs/client.p12";
		String password="123456";
		
		String testData="测试数据";
		try{
//			CertUtil.getPublickeyFormP12(certPath, password);
//			String singStr= CertUtil.signStr(testData, certPath, password);
//			System.out.println("singStr="+singStr);
			
//			PublicKey publicKey= CertUtil.getPublickeyFormP12(certPath, password);
			
//			PublicKey publicKey = CertUtil.getPublicKeyFromX509(certPath);
			
//			String publicKeyStr= RSAUtil.getKeyString(publicKey);
			
//			System.out.println("publicKey="+publicKey.getEncoded().toString());
//			System.out.println("publicKeyBase64Str="+publicKeyStr+"+L+"+publicKeyStr.length());
			
//			boolean verfiyResult= CertUtil.verifyStr(testData, singStr, "UTF-8", publicKey); 
			
//			System.out.println("verfiyResult="+verfiyResult);
			
			
			
			PrivateKey privateKey = CertUtil.getPrivatekeyFormP12(certPath, password);
			
			System.out.println((new BASE64Encoder()).encode(privateKey.getEncoded()).replaceAll("\n\t", "").replaceAll(
					"\n", "").replaceAll("\t", "").replaceAll("\r", "").length());
			
			String p = CertUtil.getPrivateKeyFormP12(certPath, password);
			
			PublicKey publicKey= CertUtil.getPublickeyFormP12(certPath, password);
			
			System.out.println(RSAUtil.getKeyString(publicKey));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

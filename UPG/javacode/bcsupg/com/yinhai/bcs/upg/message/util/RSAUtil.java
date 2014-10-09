package com.yinhai.bcs.upg.message.util;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.lang.ArrayUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.rsa.RSAPublicKeyImpl;

public class RSAUtil {

	public static final int DER_PUBLIC_KEY = 0;
	public static final int XML_PUBLIC_KEY = 1;

	/**
	 * 
	 * 得到公钥
	 * 
	 * @param key  密钥字符串（经过base64编码）
	 * 
	 * @throws Exception
	 * 
	 */

	public static PublicKey getPublicKey(String key) throws Exception {

		byte[] keyBytes;

		keyBytes = (new BASE64Decoder()).decodeBuffer(key);

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		PublicKey publicKey = keyFactory.generatePublic(keySpec);

		return publicKey;

	}

	public static RSAPublicKey getPublicKeyFormXMLBase64(String key)
			throws Exception {

		byte[] keyBytes;

		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		String publickKeyXml = new String(keyBytes);

		Document doc = DocumentHelper.parseText(publickKeyXml);

		Node mNode = doc.selectSingleNode("//RSAKeyValue/Modulus");
		Node eNode = doc.selectSingleNode("//RSAKeyValue/Exponent");

		String modStr = mNode.getText();
		String expStr = eNode.getText();

		System.out.println("modStr=" + modStr);

		BigInteger mod = new BigInteger(new BASE64Decoder()
				.decodeBuffer(modStr));
		BigInteger exp = new BigInteger(new BASE64Decoder()
				.decodeBuffer(expStr));
		RSAPublicKey publicKey = new RSAPublicKeyImpl(mod, exp);

		return publicKey;

	}

	/**
	 * 
	 * 得到私钥
	 * 
	 * @param key  密钥字符串（经过base64编码）
	 * 
	 * @throws Exception
	 * 
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {

		byte[] keyBytes;

		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
	
		return privateKey;

	}
	public static RsaVO getKeyPairStr() {
		RsaVO rsaVO = null;

		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			// 密钥位数
			keyPairGen.initialize(1024);

			// 密钥对
			KeyPair keyPair = keyPairGen.generateKeyPair();

			// 公钥
			PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
			byte[] publicKeyBytes = publicKey.getEncoded();
			String publicKeyString = (new BASE64Encoder())
					.encode(publicKeyBytes);
			// 私钥
			PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

			byte[] privateKeyBytes = privateKey.getEncoded();
			String privateKeyString = (new BASE64Encoder())
					.encode(privateKeyBytes);

			rsaVO = new RsaVO();
			rsaVO.setPrivateKeyStr(privateKeyString);
			rsaVO.setPublicKeyStr(publicKeyString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsaVO;
	}
	/**
	 * 
	 * 得到密钥字符串（经过base64编码）
	 * 
	 * @return
	 * 
	 */

	public static String getKeyString(Key key) throws Exception {

		byte[] keyBytes = key.getEncoded();

		String s = (new BASE64Encoder()).encode(keyBytes);

		return s;

	}
	public static String getRSAPublicKeyAsXMLString(RSAPublicKey key) {

		byte[] modulusBytes = key.getModulus().toByteArray();
		byte[] modulusBytes2 = stripLeadingZeros(modulusBytes);
		modulusBytes = modulusBytes2;
		byte[] exponentBytes = key.getPublicExponent().toByteArray();

		String xml = "<RSAKeyValue>" + "<Modulus>"
				+ new sun.misc.BASE64Encoder().encode(modulusBytes)
				+ "</Modulus>" + "<Exponent>"
				+ new sun.misc.BASE64Encoder().encode(exponentBytes)
				+ "</Exponent>" + "</RSAKeyValue>";

		xml= xml.replaceAll("[ \t\n\r]", "");
		
		return xml;
	}

	private static byte[] stripLeadingZeros(byte[] a) {
		int lastZero = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				lastZero = i;
			} else {
				break;
			}
		}
		lastZero++;
		byte[] result = new byte[a.length - lastZero];
		System.arraycopy(a, lastZero, result, 0, result.length);
		return result;
	}

	/**
	 * RSA解密
	 * @param privateKeyStr 私钥
	 * @param cipherText 密文base64编码
	 * @return 返回解密后的明文
	 */
	public static String decrypt(String privateKeyStr, String cipherTextBase64) {
		String plainText = "";
		try {
			PrivateKey privateKey = getPrivateKey(privateKeyStr);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);

			byte[] cipherTextBytes = new BASE64Decoder()
					.decodeBuffer(cipherTextBase64);
			
			int cipherTextLen = cipherTextBytes.length;
			int blockLen = 128;
			byte[] deBytes = null;

			int offset = 0;
			while (offset < cipherTextLen) {
				int len = blockLen;

				if ((offset + blockLen) > cipherTextLen) {
					len = cipherTextLen - offset;
				}

				// System.out.println("RSAUtil.decrypt->len="+len+"offset="+offset+",cipherTextLen="+cipherTextLen+",cipherTextBytes="+cipherTextBytes);
				byte[] temp_deBytes = cipher.doFinal(cipherTextBytes, offset,
						len);
				// System.out.println(new String(temp_deBytes));

				deBytes = ArrayUtils.addAll(deBytes, temp_deBytes);
				offset += len;
			}
			plainText = new String(deBytes, "utf-8");
		} catch (Exception ex) {
			 //Log.error(cipherTextBase64);
			ex.printStackTrace();
		}

		return plainText;
	}

	public static String encrypt(String publicKeyStr, String plainText,
			int publickKeyType) {

		if (publickKeyType == RSAUtil.DER_PUBLIC_KEY) {
			return encryptDER(publicKeyStr, plainText);
		} else if (publickKeyType == RSAUtil.XML_PUBLIC_KEY) {
			return encryptXML(publicKeyStr, plainText);
		} else {
			//Log.error("unkonw publickKeyType!!");
			return "";
		}
	}

	/**
	 * RAS加密
	 * 
	 * @param publicKeyStr
	 *            公钥
	 * @param plainText
	 *            明文
	 * @return 返回密文字节的base64编码
	 */
	public static String encryptDER(String publicKeyStr, String plainText) {
		String cipherTextBase64 = "";
		byte[] enBytes = null;
		try {
			Key publicKey = RSAUtil.getPublicKey(publicKeyStr);
			Cipher cipher = Cipher.getInstance("RSA");
			// /////////////////// 加密
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] plainTextBytes = plainText.getBytes("utf-8");
			int plainTextLen = plainTextBytes.length;
			int blockLen = 117;

			int offset = 0;
			while (offset < plainTextLen) {
				int len = blockLen;

				if ((offset + blockLen) > plainTextLen) {
					len = plainTextLen - offset;
				}

				byte[] enBytes_temp = cipher.doFinal(plainTextBytes, offset,
						len);
				enBytes = ArrayUtils.addAll(enBytes, enBytes_temp);
				offset += len;
			}

			cipherTextBase64 = new BASE64Encoder().encode(enBytes);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return cipherTextBase64;
	}

	/**
	 * RAS加密
	 * 
	 * @param publicKeyStr
	 *            公钥
	 * @param plainText
	 *            明文
	 * @return 返回密文字节的base64编码
	 */
	public static String encryptXML(String publicKeyStrBase64XML,
			String plainText) {
		String cipherTextBase64 = "";
		//byte[] enBytes = null;
		try {
			RSAPublicKey publicKey = RSAUtil
					.getPublicKeyFormXMLBase64(publicKeyStrBase64XML);

			String publicKeyStr = (new BASE64Encoder()).encode(publicKey
					.getEncoded());
			
			cipherTextBase64=RSAUtil.encryptDER(publicKeyStr, plainText);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return cipherTextBase64;
	}

	public static void main(String[] args) throws Exception {

		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

		// 密钥位数
		keyPairGen.initialize(1024);
		// 密钥对

		KeyPair keyPair = keyPairGen.generateKeyPair();

		// 公钥
		PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		// 私钥
		PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		String publicKeyString = getKeyString(publicKey);
		String privateKeyString = getKeyString(privateKey);
		System.out.println("public key string:\n" + publicKeyString);
		System.out.println("private key string:\n" + privateKeyString);

		// 加解密类
		Cipher cipher = Cipher.getInstance("RSA");// Cipher.getInstance("RSA/ECB/PKCS1Padding");

		// algorithm/mode/padding

		// 明文
		byte[] plainText = (" 作者：instant "
				+ "人物介绍：侯龙涛有六个把兄弟，都是从小就在一起跟人打架打大的。在他高一那年，七个人喝了血酒，结为兄弟。"
				+ " 老大，刘宏达，外号大胖。为人仗义，豪爽，但做事不计后果，极易冲动，还有些好高骛远。现年二十五，没有正经工作，有很多的黑道朋友。 "
				+ "老二，武兵，外号武大。为人极有城府，攻于心计，是侯龙涛的小学同学。现年二十四，在银行工作。 "
				+ " 老三，刘南。富家子弟，最爱用钱买女人心。现年二十四，也是个海归派，自己开了一家广告公司。 "
				+ "老五，岑小宇，外号二德子。央视某部门主任的公子，和央视有着千丝万缕的联系。为人大大咧咧，不修边浮，却也对周围人事心知肚明。现年二十三，"
				+ "北体大毕业，是国家级的台球裁判，刘南广告公司的合伙人，也是侯龙涛的小学同学。 "
				+ " 老六，马明，外号马脸。北京某城区交通队大队长的儿子，在河北某市更是有强大的家族势力"
				+ "为人阴险，但对兄弟却也没的说。现年二十三，由于老爸的势力，一直游手好闲，最近才转入正行，干起房屋中介的行当。 "
				+ " 老七，林文龙。从小和侯龙涛在一个院里长大，两人如同亲兄弟般。为人重情重义，极好接触，所以在他家"
				+ "那一片儿是黑白两道通吃，但就是办事不太牢靠，总让侯龙涛不能对他完全放心。现年二十二，在刘南的广告公司里任设计主任。 "
				+ " 除了这六个过命的兄弟，侯龙涛还有几个非常好的朋友，都是他的高中同学，会对他的未来起决定性作用。 "
				+ " 李宝丁，北京某派出所民警。 项念休，外号一休，美国一大型药业公司驻京代表处的小头目。 "
				+ "李昂扬，国家质检委检察员。  左魏，北京一拍卖行拍卖师。 ").getBytes();

		// /////////////////// 加密
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		int totalLen = plainText.length;
		int blockLen = 100;
		//int encryptCount = totalLen / blockLen;
		byte[] enBytes = null;

		// System.out.println("plainText byte len:"+totalLen);
		int offset = 0;
		while (offset < totalLen) {
			// System.out.println("offset="+offset);

			int len = blockLen;

			if ((offset + blockLen) > totalLen) {
				len = totalLen - offset;
			}

			byte[] enBytes_temp = cipher.doFinal(plainText, offset, len);
			enBytes = ArrayUtils.addAll(enBytes, enBytes_temp);
			offset += len;
		}

		// System.out.println("密文:"+new String(enBytes));

		// 通过密钥字符串得到密钥
		publicKey = getPublicKey(publicKeyString);
		privateKey = getPrivateKey(privateKeyString);

		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		totalLen = enBytes.length;
		blockLen = 128;
	//	int deCount = totalLen / blockLen;
		byte[] deBytes = null;
		//ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		offset = 0;
		// System.out.println("total size="+totalLen);
		while (offset < totalLen) {
			// System.out.println("offset="+offset);
			int len = blockLen;

			if ((offset + blockLen) > totalLen) {
				len = totalLen - offset;
			}
			byte[] temp_deBytes = cipher.doFinal(enBytes, offset, len);
			deBytes = ArrayUtils.addAll(deBytes, temp_deBytes);
			offset += len;
		}

//		String s = new String(deBytes);
		// System.out.println("s len:"+deBytes.length);
		// System.out.println("明文:"+s);

	}

	private static byte[] removeMSZero(byte[] data) {
        byte[] data1;
        int len = data.length;
        if (data[0] == 0) {
            data1 = new byte[data.length - 1];
            System.arraycopy(data, 1, data1, 0, len - 1);
        } else
            data1 = data;

        return data1;
    }


	
	 public static String getRSAPrivateKeyAsXMLString(PrivateKey privateKey) {
	        try {
	        	
	            RSAPrivateCrtKey pvkKey = (RSAPrivateCrtKey)privateKey;
	            StringBuffer buff=new StringBuffer();
	            buff.append("<RSAKeyValue>");
	            buff.append("<Modulus>"
	                    + new sun.misc.BASE64Encoder().encode(removeMSZero(pvkKey.getModulus().toByteArray()))
	                    + "</Modulus>");

	            buff.append("<Exponent>"
	                    + new sun.misc.BASE64Encoder().encode(removeMSZero(pvkKey.getPublicExponent()
	                            .toByteArray())) + "</Exponent>");

	            buff.append("<P>"
	                    + new sun.misc.BASE64Encoder().encode(removeMSZero(pvkKey.getPrimeP().toByteArray()))
	                    + "</P>");

	            buff.append("<Q>"
	                    + new sun.misc.BASE64Encoder().encode(removeMSZero(pvkKey.getPrimeQ().toByteArray()))
	                    + "</Q>");

	            buff.append("<DP>"
	                    + new sun.misc.BASE64Encoder().encode(removeMSZero(pvkKey.getPrimeExponentP()
	                            .toByteArray())) + "</DP>");

	            buff.append("<DQ>"
	                    + new sun.misc.BASE64Encoder().encode(removeMSZero(pvkKey.getPrimeExponentQ()
	                            .toByteArray())) + "</DQ>");

	            buff.append("<InverseQ>"
	                    + new sun.misc.BASE64Encoder().encode(removeMSZero(pvkKey.getCrtCoefficient()
	                            .toByteArray())) + "</InverseQ>");

	            buff.append("<D>"
	                    + new sun.misc.BASE64Encoder().encode(removeMSZero(pvkKey.getPrivateExponent()
	                            .toByteArray())) + "</D>");
	            buff.append("</RSAKeyValue>");

	            return buff.toString().replaceAll("[ \t\n\r]", "");
	        } catch (Exception e) {
	            System.err.println(e);
	            return null;
	        }
	    }


}

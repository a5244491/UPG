package com.yinhai.bcs.upg.message.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <证书工具类>
 * 
 * @author Administrator
 * 
 */

@SuppressWarnings( { "rawtypes", "unused" })
public class CertUtil {

	/**
	 * 根据请求获取所持有X509证书的商户号
	 * 
	 * @param request
	 *            当前请求对象
	 * @return 持有X509证书的商户号
	 */
	public static String getX509MerchantNoByReq(HttpServletRequest request) {

		X509Certificate x509Cert = getX509CertificateByReq(request);
		if (null == x509Cert) {
			return null;
		}

		Principal principal = x509Cert.getSubjectX500Principal();
		String name = principal.getName();
		Pattern pattern = Pattern.compile("@(\\d+)");
		Matcher matcher = pattern.matcher(name);

		while (matcher.find()) {
			String merchantNo = matcher.group(1);
			if (null != merchantNo) {
				return merchantNo;
			}
		}

		return null;
	}

	/**
	 * 根据请求获取X509证书
	 * 
	 * @param request
	 *            当前请求对象
	 * @return X509证书
	 */
	public static X509Certificate getX509CertificateByReq(
			HttpServletRequest request) {

		X509Certificate[] x509Cert = (X509Certificate[]) request
				.getAttribute("javax.servlet.request.X509Certificate");
		int length = x509Cert.length;
		return length > 0 ? x509Cert[0] : null;

	}

	/**
	 * 签名
	 * 
	 * @param dataStr
	 *            本地待签名数据
	 * @param certPath
	 *            证书路径
	 * @param certPwd
	 *            证书密码
	 * @return
	 * @throws InvalidKeyException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws SignatureException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String signStr(String dataStr, String certPath, String certPwd)
			throws InvalidKeyException, UnrecoverableKeyException,
			NoSuchAlgorithmException, SignatureException, KeyStoreException,
			CertificateException, UnsupportedEncodingException, IOException {
		byte[] signData = sign(dataStr.getBytes("UTF-8"), certPath, certPwd);
		String newString = new BASE64Encoder().encode(signData);
		return newString;
	}

	/**
	 * 签名转byte[]
	 * 
	 * @param fileName
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws IOException
	 * @throws SignatureException
	 * @throws UnrecoverableKeyException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 */
	private static byte[] sign(byte[] data, String fileName, String password)
			throws NoSuchAlgorithmException, InvalidKeyException, IOException,
			SignatureException, UnrecoverableKeyException, KeyStoreException,
			CertificateException {
		PrivateKey privateKey = getPrivatekeyFormP12(fileName, password);
		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initSign(privateKey);
		signature.update(data);
		return signature.sign();
	}

	/**
	 * 获取私钥
	 * 
	 * @param fileName
	 * @param password
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws UnrecoverableKeyException
	 */
	public static PrivateKey getPrivatekeyFormP12(String fileName,
			String password) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException,
			UnrecoverableKeyException {

		KeyStore ks = KeyStore.getInstance("PKCS12");
		FileInputStream fis = new FileInputStream(fileName);

		char[] nPassword = null;
		if ((password == null) || password.trim().equals("")) {
			nPassword = null;
		} else {
			nPassword = password.toCharArray();
		}
		ks.load(fis, nPassword);
		fis.close();

		Enumeration enum1 = ks.aliases();
		String keyAlias = null;
		if (enum1.hasMoreElements()) {
			keyAlias = (String) enum1.nextElement();
		}
		PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
		return prikey;
	}

	/**
	 * 验签
	 * 
	 * @param dateStr
	 *            本地组装数据
	 * @param signData
	 *            客户端签名数据
	 * @param certificatePath
	 *            证书路径
	 * @param keyPassword
	 *            证书密码
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyStr(String dataStr, String signData,
			String charSet, String certificatePath, String keyPassword) {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] signByte;
		try {
			signByte = decoder.decodeBuffer(signData);
			return verify(dataStr.getBytes(charSet), signByte, certificatePath,
					keyPassword);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 验签使用public key
	 * 
	 * @param dataStr
	 * @param signData
	 * @param charSet
	 * @param certificatePath
	 * @param keyPassword
	 * @return
	 */
	public static boolean verifyStr(String dataStr, String signData,
			String charSet, PublicKey publicKey) {
		BASE64Decoder decoder = new BASE64Decoder();
		boolean verifyResult = false;
		byte[] signByte;
		try {
			signByte = decoder.decodeBuffer(signData);

			Signature signetcheck = java.security.Signature
					.getInstance("MD5withRSA");
			signetcheck.initVerify(publicKey);
			signetcheck.update(dataStr.getBytes(charSet));
			verifyResult = signetcheck.verify(signByte);

			return verifyResult;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// public static void main(String[] args) throws Exception {
	// Map<String, String> cmbcParaTemp = new HashMap<String, String>();
	// cmbcParaTemp.put("do", "execBusi");
	// cmbcParaTemp.put("partner", "100000000000001");
	// cmbcParaTemp.put("notify_url",
	// "http://www.kelunyy.com/alipay_notify.shtml");
	// cmbcParaTemp.put("return_url",
	// "http://www.kelunyy.com/alipay_return.jsp");
	// cmbcParaTemp.put("out_trade_no", "XSF00001141");
	// cmbcParaTemp.put("subject", "kldd");
	// cmbcParaTemp.put("cmbcbody", "kldd");
	// cmbcParaTemp.put("total_fee", "0.01");
	// cmbcParaTemp.put("paymethod", "bankPay");
	// cmbcParaTemp.put("defaultbank", "CEBBANK");
	// cmbcParaTemp.put("extend_param", "");
	// cmbcParaTemp.put("msgExt", "");
	// cmbcParaTemp.put("businessType", "1014");
	// cmbcParaTemp.put("char_set", "gbk");
	// cmbcParaTemp.put("strMethod", "get");
	// cmbcParaTemp.put("opFlag", "create_direct_pay_by_user");
	// String dataString = CMBCCore.createLinkString(cmbcParaTemp);
	//		
	// System.out.println(dataString);
	// // String dataString = "businessType=1014&char_set=gbk&cmbcbody=kldd&" +
	// // "defaultbank=CEBBANK&" +
	// // "do=execBusi&" +
	// // "extend_param=&"+
	// // "msgExt=&" +
	// // "notify_url=http://www.kelunyy.com/alipay_notify.shtml&"
	// // + "opFlag=create_direct_pay_by_user&"+
	// // "out_trade_no=XSF00001139&"+
	// // "partner=100000000000001&" +
	// // "paymethod=bankPay&" +
	// // "return_url=http://www.kelunyy.com/alipay_return.jsp&" +
	// // "strMethod=get&" +
	// // "subject=kldd&" +
	// // "total_fee=0.01";
	// String sign= CMBCSignUtil.signStr(dataString);
	// System.out.println(sign);
	// boolean ce
	// = verifyStr(
	// dataString,
	// "mDSMoOWxtqUC8g1LXo8CRmzxXRBxIZEnrnKNuYpwjwMDAOeXGFo5oZD6XBNKY5dWxSoqTthlKkMOHglib6WhYNLWXTq7i21H6yi4z54lbzYkFgrX7HHFNadtl7F54Z/rH4GfSSKtr+cOyw1JqbuQ53X+BsMM0RjwK0txCjSf7IU=",
	// "gbk","C:/apache-tomcat-6.0.18/webapps/cmbcproxyfees/config/testuser.p12","123456");
	// System.out.println(ce);
	// }

	/**
	 * 验签过程byte[]
	 * 
	 * @param data
	 * @param sign
	 * @param certificatePath
	 * @return
	 * @throws Exception
	 */
	private static boolean verify(byte[] data, byte[] sign,
			String certificatePath, String keyPassword) throws Exception {
		// 获得证书
		Certificate certificate = (Certificate) getCertificate(certificatePath,
				keyPassword);
		// 由证书构建签名
		Signature signature = Signature.getInstance("MD5withRSA");
		// 由证书初始化签名，实际上是使用了证书中的公钥
		signature.initVerify(certificate);
		signature.update(data);
		return signature.verify(sign);
	}

	/**
	 * 获取证书 通过P12得到
	 * 
	 * @param certificatePath
	 * @return
	 * @throws Exception
	 */
	private static Certificate getCertificate(String certificatePath,
			String keypasswd) throws Exception {
		KeyStore ks = KeyStore.getInstance("PKCS12");
		FileInputStream fin = new FileInputStream(certificatePath);
		ks.load(fin, keypasswd.toCharArray());

		Enumeration enum1 = ks.aliases();
		String keyAlias = null;
		if (enum1.hasMoreElements()) {
			keyAlias = (String) enum1.nextElement();
		}
		Certificate cert = ks.getCertificate(keyAlias);
		return cert;
	}

	// public static void main(String[] args) throws Exception {

	// System.out
	// .println(new BASE64Encoder()
	// .encode(sign(
	// "e26995ea-9336-4403-88f2-433d79d84cd0<Body>\n
	// <merchantID>100290000010001</merchantID>"
	// .getBytes(),
	// "D:\\config\\cmbc\\testuser1.p12", "123456")));
	//
	// String sign =
	// "i3kTDpAXJ3Lh6aHu2tgmFVE8LNE8i5/W9bPI8kvriAHtMktt8NlglU7/nIwDDspIT7Kkk4EItJvH\nBWZ4gSUNyeqOev4qEwGzFbFRDEw+5qInB6/D34zRpDDDCasQIG8v0poEzVYJW3/eo28311MkcW4S\nSum5S9byibfmH51zRoU=";
	// BASE64Decoder decoder = new BASE64Decoder();
	// byte[] b = decoder.decodeBuffer(sign);
	//
	// boolean bol = verify(
	// "e26995ea-9336-4403-88f2-433d79d84cd0<Body>\n
	// <merchantID>100290000010001</merchantID>"
	// .getBytes(), b, "D:\\config\\cmbc\\testuser1.p12",
	// "123456");
	//
	// System.out.println(bol);
	// tring string = "e19aa457-3439-455b-8b2f-7325d96b4916<Body>\n
	// <merchantID>100290000010001</merchantID>";
	// String string =
	// "d8a05ffa-3e03-4e90-bbc1-5516ceadff4c<Body><merchantID>100650000010016</merchantID><tra";
	// System.out.println(string.length());
	// byte[] signbyte = sign(string.getBytes(),
	// "D:\\createcert\\1qthd_ca\\client\\scjxwl@100650000010016.p12",
	// "123456");
	// String singString = new BASE64Encoder().encode(signbyte);
	// System.out.println(singString);
	//		
	//		
	// String string2 =
	// "o84ZW4+OjS9Q0q1WI9TGABWcRLw/76AIzkxlfbVSfzBZxAmCTS/w5EH2lJ86nuQ+okDpQ/TstEprn2H67qpdOSGNBXAPUt4thT4L1tl1S20v3phc3vocAlcpnZjSY5hyCObST3rqd8hOcAYep+C+Pr5upl0plznLUOTdFOkIh3w=";
	// BASE64Decoder decoder = new BASE64Decoder();
	// byte[] b = decoder.decodeBuffer(string2);
	// boolean boollString = verify(string.getBytes(), b,
	// "D:\\createcert\\1qthd_ca\\client\\scjxwl@100650000010016.p12",
	// "123456");
	// System.out.println(boollString);

	// PrivateKey privateKey = getPrivatekey(
	// "E:/colcert_tomcat/test@100000000010001.p12", "123456");
	// System.out.println();
	// ppp(args);
	// }

	public static void main(String[] args) {
		getPrivateKeyFormP12(args);
	}

	public static void getPrivateKeyFormP12(String[] args) {
		// final String KEYSTORE_FILE =
		// "D:/jx_cert/qthd_ca/client/testuser@100000000000001.p12";
		final String KEYSTORE_FILE = "D:/testuser.p12";
		final String KEYSTORE_PASSWORD = "123456";
		final String KEYSTORE_ALIAS = "alias";
		try {
			KeyStore ks = KeyStore.getInstance("PKCS12");
			FileInputStream fis = new FileInputStream(KEYSTORE_FILE);
			char[] nPassword = null;
			if ((KEYSTORE_PASSWORD == null)
					|| KEYSTORE_PASSWORD.trim().equals("")) {
				nPassword = null;
			} else {
				nPassword = KEYSTORE_PASSWORD.toCharArray();
			}
			ks.load(fis, nPassword);
			fis.close();
			// System.out.println("keystore type=" + ks.getType());
			Enumeration enumz = ks.aliases();
			String keyAlias = null;
			if (enumz.hasMoreElements()) {
				keyAlias = (String) enumz.nextElement();
				// System.out.println("alias=[" + keyAlias + "]");
			}
			// System.out.println("is key entry=" + ks.isKeyEntry(keyAlias));
			PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
			Certificate cert = ks.getCertificate(keyAlias);
			PublicKey pubkey = cert.getPublicKey();
			pubkey.getEncoded();

			// System.out.println("cert class = " + cert.getClass().getName());
			// System.out.println("cert = " + cert);
			// System.out.println("public key = " + pubkey);
			// System.out.println("private key = " + prikey);

			byte[] privateKeyBytes = prikey.getEncoded();
			String privateKeyString = (new BASE64Encoder())
					.encode(privateKeyBytes);
			privateKeyString = privateKeyString.replaceAll("\n\t", "")
					.replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r",
							"");
			System.out.println(privateKeyString);

			// 将privateStr转换成PrivateKey
			// byte[] keyBytes;
			// String privateKey =
			// "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPsqKn5Im2bL3Jvi4cOFIt4Zqk3OWqtkT1L/zsC4K/30SXiu20Z4fOgoP4l3nnEg6/S2cVZkBxHio2dv9rghcqsQuMKFxtQoa2dHwNQCkKiFH33YknVU+tHiBkrxw/p93k/wakeohO02zqQbf4vNGxOhhk9zuuWpCcxp2qLkBHbXAgMBAAECgYAf+Us1jlqyKGuqMKTa9hztN0k15HoobXmnsEcKw6deCfY8dc4WV4pXJ6CHCIJUFoPTQFKHU+6OeVKh/V/kKuXk3ojkuV72BOmx8m2AN3Svv4mQNc7ZZdDyg9yi+S8BP8MpncsMee09OqUjpgBh42h1L/xlput75vnUs4Kjb91meQJBAP+bE1VLFqfrHNF/rw6lwi42PTlPDP+q3qNnNlzKxbgh8oU1haer7XAedrT+BaLt6n6tSbkbSoGXD4RYvGG1u1sCQQD7jVZCA4mWet0w5NtH511jXAUVPjcv5b3Efik88MkL7djk6SSniLlUCjohT8m8/Zy9yTskDQg5GZQy0ltHRpc1AkBasNYiPDs0pyoZdxlQtCV6qgn9DHxLNoA6MAPM1rFijMD03LGodUsQre5md37eeVXrTmbLA9DivAtoZOeqL4XjAkEA57BUBFVRwmHDnKcNOPrmTv+QRvKYzerikDpLLS/xXKVjIeOCuTP6zmblB41/mCxW046mhBvkuQLQNsb8/3cLCQJAY4mh51K36EHuop5XT4fuz1evGSPF3PvLVwsKJOn1I029o8cP8ZFoFRzQz7mq8hC3QtwyEVyhRAPc7Qvvac6Ieg==";
			// keyBytes = (new BASE64Decoder()).decodeBuffer(privateKey);
			// PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			//
			// KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			//
			// keyFactory.getProvider();
			//
			// PrivateKey privateKeyz = keyFactory.generatePrivate(keySpec);
			// System.out.println(privateKeyz);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取证书中的私钥(p12)
	 * 
	 * @param certPath
	 * @param certPsw
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKeyFormP12(String certPath, String certPsw)
			throws Exception {
		KeyStore ks = KeyStore.getInstance("PKCS12");
		FileInputStream fis = new FileInputStream(certPath);
		char[] nPassword = null;
		if ((certPsw == null) || certPsw.trim().equals("")) {
			nPassword = null;
		} else {
			nPassword = certPsw.toCharArray();
		}
		ks.load(fis, nPassword);
		fis.close();
		Enumeration enumz = ks.aliases();
		String keyAlias = null;
		if (enumz.hasMoreElements()) {
			keyAlias = (String) enumz.nextElement();
		}
		PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
		Certificate cert = ks.getCertificate(keyAlias);
		PublicKey pubkey = cert.getPublicKey();
		pubkey.getEncoded();

		byte[] privateKeyBytes = prikey.getEncoded();
		String privateKeyString = (new BASE64Encoder()).encode(privateKeyBytes);
		privateKeyString = privateKeyString.replaceAll("\n\t", "").replaceAll(
				"\n", "").replaceAll("\t", "").replaceAll("\r", "");
		return privateKeyString;
	}

	/**
	 * 获取证书中的私钥(p12)
	 * 
	 * @param certPath
	 * @param certPsw
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPublickeyFormP12(String certPath, String certPsw)
			throws Exception {
		KeyStore ks = KeyStore.getInstance("PKCS12");
		FileInputStream fis = new FileInputStream(certPath);
		char[] nPassword = null;
		if ((certPsw == null) || certPsw.trim().equals("")) {
			nPassword = null;
		} else {
			nPassword = certPsw.toCharArray();
		}
		ks.load(fis, nPassword);
		fis.close();
		Enumeration enumz = ks.aliases();
		String keyAlias = null;
		if (enumz.hasMoreElements()) {
			keyAlias = (String) enumz.nextElement();
			// System.out.println("alias=[" + keyAlias + "]");
		}
		// System.out.println("is key entry=" + ks.isKeyEntry(keyAlias));
		PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
		Certificate cert = ks.getCertificate(keyAlias);
		PublicKey pubkey = cert.getPublicKey();

		return pubkey;
	}

	public static PublicKey getPublicKeyFromX509(String certPath)throws Exception {

		InputStream fin =  new FileInputStream(certPath);
		CertificateFactory f = CertificateFactory.getInstance("X.509");
		X509Certificate certificate = (X509Certificate)f.generateCertificate(fin);
		PublicKey pk = certificate.getPublicKey();

		return pk;

	}
}

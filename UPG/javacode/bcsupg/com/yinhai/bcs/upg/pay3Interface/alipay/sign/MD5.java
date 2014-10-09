package com.yinhai.bcs.upg.pay3Interface.alipay.sign;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import org.apache.commons.codec.digest.DigestUtils;

/** 
* 功能：支付宝MD5签名处理核心文件，不需要修改
* 版本：3.3
* 修改日期：2012-08-17
* 说明：
* 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
* 该代码仅供学习和研究支付宝接口使用，只是提供一个
* */

public class MD5 {

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String input_charset) {
    	text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }
    
    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
    	text = text + key;
    	String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    
public static void main(String[] args) {
		
		String text="buyer_email=18699178090&buyer_id=2088802606842006&exterface=create_direct_pay_by_user&is_success=T&notify_id=RqPnCoPT3K9%252Fvwbh3InR8UH3s9LthXlqBxLEzYcKMptRdN6J5%252Ftv2GMZmAHFrHvFNbWh&notify_time=2014-05-14+13%3A55%3A41&notify_type=trade_status_sync&out_trade_no=T22&payment_type=1&seller_email=liukaiy%40yinhai.com&seller_id=2088411579626674&subject=%E5%8F%AF%E5%8F%A3%E5%8F%AF%E4%B9%90&total_fee=0.01&trade_no=2014051427984700&trade_status=TRADE_SUCCESS";
		String sign="944a9a2d7ba05371d696fc7ff0eeb174";
		String key="51ymajni6db5k3sa343n6v4e27krsir4";
		try{
			boolean result = verify(text, sign, key, "UTF-8");
			if(result){
				System.out.println("T");
			}else{
				System.out.println("F");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
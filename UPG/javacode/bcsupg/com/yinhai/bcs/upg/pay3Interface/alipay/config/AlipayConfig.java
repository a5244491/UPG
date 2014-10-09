package com.yinhai.bcs.upg.pay3Interface.alipay.config;

import java.util.HashMap;
import java.util.Map;

import com.yinhai.bcs.upg.dbservice.Pay3Service;
import com.yinhai.webframework.BaseAction;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig extends BaseAction{
	
	private Pay3Service pay3Service = (Pay3Service) getService("pay3Service");
	
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	private String partner;

	// 商户的私钥
	private String key;
	
	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "/home/cq/";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";
	
	private static AlipayConfig instance = new AlipayConfig();
	
	private boolean inited = false;
	
	/**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    public static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
    /**
     * 支付宝服务接口名称
     */
    public static final String ALIPAY_SERVICE_NAME = "create_direct_pay_by_user";
    /**
     * 支付宝支付类型
     */
    public static final String ALIPAY_PAYMENT_TYPE = "1";//{"1":"商品购买","2":"捐赠"}
	
	private AlipayConfig(){
	}
	
	public static synchronized AlipayConfig getInstance(){
		return instance;
	}
	
	public synchronized void init(String payway_id){
		if(!inited){
			//根据payway_id获取商户号和密钥
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("payway_id", payway_id);
			Map<String, Object> payInterface = pay3Service.getPay3Interface(params);
			String partner_id = (String)payInterface.get("partner_id");
			String user_key = (String)payInterface.get("user_key");
			setPartner(partner_id);
			setKey(user_key);
			inited = true;
		}
	}
	
	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}

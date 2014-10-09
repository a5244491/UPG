package com.yinhai.bcs.upg.pay3Interface.llpay;

import java.io.Serializable;

/**
* 商户配置信息
* @author guoyx e-mail:guoyx@lianlian.com
* @date:2013-6-25 下午01:45:40
* @version :1.0
*
*/
 class  PartnerConfig implements Serializable {
    // 银通公钥
    private String YT_PUB_KEY;//     = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB";
    // 商户私钥
    private String TRADER_PRI_KEY;// = "";
    // MD5 KEY
    private String MD5_KEY;//        = "201306031000001013";
    // 接收异步通知地址
    private String NOTIFY_URL;//     = "http://ip:port/wepdemo/notify.htm";
    // 支付结束后返回地址
    private String URL_RETURN;//     = "http://ip:port/wepdemo/urlReturn.jsp";
    // 商户编号
    private String OID_PARTNER;//    = "201306031000001013";
    // 签名方式 RSA或MD5
    private String SIGN_TYPE;//     = "MD5";
    // 接口版本号，固定1.0
    private String VERSION;//        = "1.0";

    // 业务类型，连连支付根据商户业务为商户开设的业务类型； （101001：虚拟商品销售、109001：实物商品销售、108001：外部账户充值）

    private String BUSI_PARTNER;//   = "101001";

	public String getYT_PUB_KEY() {
		return YT_PUB_KEY;
	}

	public void setYT_PUB_KEY(String yT_PUB_KEY) {
		YT_PUB_KEY = yT_PUB_KEY;
	}

	public String getTRADER_PRI_KEY() {
		return TRADER_PRI_KEY;
	}

	public void setTRADER_PRI_KEY(String tRADER_PRI_KEY) {
		TRADER_PRI_KEY = tRADER_PRI_KEY;
	}

	public String getMD5_KEY() {
		return MD5_KEY;
	}

	public void setMD5_KEY(String mD5_KEY) {
		MD5_KEY = mD5_KEY;
	}

	public String getNOTIFY_URL() {
		return NOTIFY_URL;
	}

	public void setNOTIFY_URL(String nOTIFY_URL) {
		NOTIFY_URL = nOTIFY_URL;
	}

	public String getURL_RETURN() {
		return URL_RETURN;
	}

	public void setURL_RETURN(String uRL_RETURN) {
		URL_RETURN = uRL_RETURN;
	}

	public String getOID_PARTNER() {
		return OID_PARTNER;
	}

	public void setOID_PARTNER(String oID_PARTNER) {
		OID_PARTNER = oID_PARTNER;
	}

	public String getSIGN_TYPE() {
		return SIGN_TYPE;
	}

	public void setSIGN_TYPE(String sIGN_TYPE_MD5) {
		SIGN_TYPE = sIGN_TYPE_MD5;
	}


	public String getVERSION() {
		return VERSION;
	}

	public void setVERSION(String vERSION) {
		VERSION = vERSION;
	}

	public String getBUSI_PARTNER() {
		return BUSI_PARTNER;
	}

	public void setBUSI_PARTNER(String bUSI_PARTNER) {
		BUSI_PARTNER = bUSI_PARTNER;
	}
    
}

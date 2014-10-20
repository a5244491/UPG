package com.yinhai.bcs.upg.message.util;

import java.io.Serializable;

/**
 * 商户配置信息
 * 
 * @author guoyx e-mail:guoyx@lianlian.com
 * @date:2013-6-25 下午01:45:40
 * @version :1.0
 * 
 */
public class BusiTradeConfig implements Serializable {
	private String LY_PUB_KEY;
	// 商户私钥
	private String TRADER_PRI_KEY;
	// MD5 KEY
	private String MD5_KEY;
	// 签名方式 RSA或MD5
	private String SIGN_TYPE;

	// 业务类型，连连支付根据商户业务为商户开设的业务类型； （101001：虚拟商品销售、109001：实物商品销售、108001：外部账户充值）

	public String getLY_PUB_KEY() {
		return LY_PUB_KEY;
	}

	public void setLY_PUB_KEY(String tLY_PUB_KEY) {
		LY_PUB_KEY = tLY_PUB_KEY;
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

	public String getSIGN_TYPE() {
		return SIGN_TYPE;
	}

	public void setSIGN_TYPE(String sIGN_TYPE_MD5) {
		SIGN_TYPE = sIGN_TYPE_MD5;
	}

}

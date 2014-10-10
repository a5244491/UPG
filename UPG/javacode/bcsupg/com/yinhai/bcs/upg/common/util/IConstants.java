package com.yinhai.bcs.upg.common.util;

public interface IConstants {
	//add by CQ 
	/**验签失败*/
	public static final int CHECK_SIGN_ERR = 0;
	
	/**前台支付错误消息*/
	public static final String FPAY_EEROR_MSG = "FPAY_EEROR_MSG";
	
	/**前台支付错误代码*/
	public static final String FPAY_EEROR_CODE = "FPAY_EEROR_CODE";
	
	/**前台支付请求地址*/
	public static final String FPAY_POST_URL="FPAY_POST_URL";
	
	/**前台支付请求数据*/
	public static final String FPAY_POST_DATA="FPAY_POST_DATA";
	
	/**支付操作流水号关联标识**/
	public static final String PAY_SN_LINK_FLAG = "P_";
	
	/**支付操作流水号长度**/
	// modify by CQ
	public static final int PAY_OPT_SN_LENGTH = 32;
	
	
	/**前台支付支付完成后返回地址*/
	public static final String FPAY_RETURN_URL="FPAY_RETURN_URL";
	
	/**前台支付支付完成后返回数据*/
	public static final String FPAY_RETURN_DATA="FPAY_RETURN_DATA";
	
	public static final String FPAY_NOTICE_MSG="FPAY_NOTICE_MSG";
	
	
	public static final String PAY_RECORDS_MSG = "PAY_RECORDS_MSG";
	
	/**
	 * 支付处理 未处理
	 */
	public static final int PAY_DEAL_STATUS_UNDEAL=1;
	
	/**
	 * 支付处理成功
	 */
	public static final int PAY_DEAL_STATUS_SUCCESS=2;
	
	/**
	 * 支付处理失败
	 */
	public static final int PAY_DEAL_STATUS_FAILD=3;
	
	
	/**
	 * 前台支付成功
	 */
	public static final int PAY_RESULT_SUCCESS=1;
	
	/**
	 * 前台支付失败
	 */
	public static final int PAY_RESULT_FAILD=2;
	
	/**
	 * 支付结果异步通知成功 1 成功  2失败
	 */
	public static final int PAY_NOTICE_STATUS_SUCCESS = 1;
	/**
	 * 支付结果异步通知失败 1 成功  2失败
	 */
	public static final int PAY_NOTICE_STATUS_FAILURE = 2;
	
	/** 默认异步通知次数 0 次 */
	public static final int PAY_NOTICE_COUNT_DEFAULT = 0 ;
	
	/**
	 * 数据状态值无效  0 无效  1 有效
	 */
	public static final int UPG_DATA_STATUS_0 = 0;
	/**
	 * 数据状态值有效  0 无效  1 有效
	 */
	public static final int UPG_DATA_STATUS_1 = 1;
	
	
	/** 支付通道：民生E支付 */
	Integer PAYWAY_ID_MINSHENG = 1001;
	/** 支付通道：支付宝 */
	Integer PAYWAY_ID_ZHIFUBAO = 1002;
	
	
	/** 操作虚拟账户失败 0 失败   2 成功*/
	public static final int DEAL_STATUS_0 = 0;
	/** 操作虚拟账户成功 0 失败   2 成功*/
	public static final int DEAL_STATUS_2 = 2;
	
	
	/** 支付通道状态：有效 */
	Integer PAY_INTERFACE_VALID = 1;
	/** 支付通道状态：无效 */
	Integer PAY_INTERFACE_INVALID = 2;
	/** 支付通道状态：注销 */
	Integer PAY_INTERFACE_CANCEL = 99;
	
	/** 服务接口状态：有效 */
	Integer SERVICE_INTERFACE_VALID = 1;
	/** 服务接口状态：无效 */
	Integer SERVICE_INTERFACE_INVALID = 2;
	/** 服务接口状态：注销 */
	Integer SERVICE_INTERFACE_CANCEL = 99;
	
	/** 签名加密方式：MD5 */
	String SIGN_TYPE_MD5 = "MD5";
	/** 签名加密方式：RAS */
	String SIGN_TYPE_RSA = "RSA";
	
	String SIGN_TYPE_MD5RSA = "MD5WithRSA";
	
	public static final String CACHE_UPG_PAYTREAD_OPTSN = "UPG_PAYTREAD_OPTSN";
	
	/**调用接口状态值*/
	public static final String USE_INTERFACE_STATUS_SUCCESS = "T";
	
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS";
	
	public static final String UPG_NOTICE_STATUS_SUCCESS = "success";
	
	public static final String UPG_NOTICE_STATUS_FAILURE = "failure";
	
	public static final int    UPG_NOTICE_COUNT_PARAM = 1;
	
	public static final int    UPG_NOTICE_COUNT_MAXLI = 20;
	
}

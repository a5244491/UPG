package com.yinhai.tcas.model;

import java.util.HashMap;
import java.util.Map;


/**
 * Cas单点登录用户表 Domain
 * @author YINHAI SOFTWARE
 * @copyright Copyrigt 银海软件 2011
 * @version 3.2 2013-6-28 14:12:16
 */
public class CasUserDomain extends BaseDomain {

	private static final long serialVersionUID = 1L;

	/** 单点登录用户ID */
	private Long cas_id;

	/** 单点登录用户登录号 */
	private String cas_logid;

	/** 单点登录用户登录密码 */
	private String cas_pwd;

	/** 公民身份号码 */
	private String id_card;

	/** 姓名 */
	private String user_name;

	/** 性别 */
	private String sex;

	/** 手机号码 */
	private String mobile_tel;

	/** 办公号码 */
	private String office_phone;

	/** 邮件地址 */
	private String email;

	/** 最后登录时间 */
	private java.math.BigDecimal last_log_time;
	
	/** 密码最后修改时间*/
	private java.math.BigDecimal last_pwd_change_time;

	/** 密码错误次数 */
	private Integer err_pwd_times;

	/** 用户状态 */
	private String state;

	public CasUserDomain() {
	}

	public CasUserDomain(Long cas_id) {
		this.cas_id = cas_id;
	}

	@Override
	public Map getKey() {
		Map key = new HashMap();
		if (this.getCas_id() == null) {
			throw new IllegalArgumentException("主键cas_id不能为空。");
		}
		key.put("cas_id", this.getCas_id());
		return key;
	}

	public CasUserDomain(Long cas_id, String cas_logid, String cas_pwd) {
		this.cas_id = cas_id;
		this.cas_logid = cas_logid;
		this.cas_pwd = cas_pwd;
	}

	/**
	 * 设置 cas_id 单点登录用户ID
	 * @param cas_id 单点登录用户ID
	 */
	public void setCas_id(Long cas_id) {
		this.cas_id = cas_id;
	}

	/**
	 * 获取 cas_id 单点登录用户ID
	 * @return 单点登录用户ID
	 */
	public Long getCas_id() {
		return this.cas_id;
	}

	/**
	 * 设置 cas_logid 单点登录用户登录号
	 * @param cas_logid 单点登录用户登录号
	 */
	public void setCas_logid(String cas_logid) {
		this.cas_logid = cas_logid;
	}

	/**
	 * 获取 cas_logid 单点登录用户登录号
	 * @return 单点登录用户登录号
	 */
	public String getCas_logid() {
		return this.cas_logid;
	}

	/**
	 * 设置 cas_pwd 单点登录用户登录密码
	 * @param cas_pwd 单点登录用户登录密码
	 */
	public void setCas_pwd(String cas_pwd) {
		this.cas_pwd = cas_pwd;
	}

	/**
	 * 获取 cas_pwd 单点登录用户登录密码
	 * @return 单点登录用户登录密码
	 */
	public String getCas_pwd() {
		return this.cas_pwd;
	}

	/**
	 * 设置 id_card 公民身份号码
	 * @param id_card 公民身份号码
	 */
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	/**
	 * 获取 id_card 公民身份号码
	 * @return 公民身份号码
	 */
	public String getId_card() {
		return this.id_card;
	}

	/**
	 * 设置 user_name 姓名
	 * @param user_name 姓名
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * 获取 user_name 姓名
	 * @return 姓名
	 */
	public String getUser_name() {
		return this.user_name;
	}

	/**
	 * 设置 sex 性别
	 * @param sex 性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取 sex 性别
	 * @return 性别
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * 设置 mobile_tel 手机号码
	 * @param mobile_tel 手机号码
	 */
	public void setMobile_tel(String mobile_tel) {
		this.mobile_tel = mobile_tel;
	}

	/**
	 * 获取 mobile_tel 手机号码
	 * @return 手机号码
	 */
	public String getMobile_tel() {
		return this.mobile_tel;
	}

	/**
	 * 设置 office_phone 办公号码
	 * @param office_phone 办公号码
	 */
	public void setOffice_phone(String office_phone) {
		this.office_phone = office_phone;
	}

	/**
	 * 获取 office_phone 办公号码
	 * @return 办公号码
	 */
	public String getOffice_phone() {
		return this.office_phone;
	}

	/**
	 * 设置 email 邮件地址
	 * @param email 邮件地址
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取 email 邮件地址
	 * @return 邮件地址
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 设置 last_log_time 最后登录时间
	 * @param last_log_time 最后登录时间
	 */
	public void setLast_log_time(java.math.BigDecimal last_log_time) {
		this.last_log_time = last_log_time;
	}

	/**
	 * 获取 last_log_time 最后登录时间
	 * @return 最后登录时间
	 */
	public java.math.BigDecimal getLast_log_time() {
		return this.last_log_time;
	}
	
	public java.math.BigDecimal getLast_pwd_change_time() {
		return last_pwd_change_time;
	}

	public void setLast_pwd_change_time(java.math.BigDecimal last_pwd_change_time) {
		this.last_pwd_change_time = last_pwd_change_time;
	}

	/**
	 * 设置 err_pwd_times 密码错误次数
	 * @param err_pwd_times 密码错误次数
	 */
	public void setErr_pwd_times(Integer err_pwd_times) {
		this.err_pwd_times = err_pwd_times;
	}

	/**
	 * 获取 err_pwd_times 密码错误次数
	 * @return 密码错误次数
	 */
	public Integer getErr_pwd_times() {
		return this.err_pwd_times;
	}

	/**
	 * 设置 state 用户状态
	 * @param state 用户状态
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 获取 state 用户状态
	 * @return 用户状态
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * 转换为map对象
	 * @return Map
	 */
	public java.util.Map toMap() {
		java.util.Map map = new java.util.HashMap();
		map.put("cas_id", getCas_id()); //单点登录用户ID
		map.put("cas_logid", getCas_logid()); //单点登录用户登录号
		map.put("cas_pwd", getCas_pwd()); //单点登录用户登录密码
		map.put("id_card", getId_card()); //公民身份号码
		map.put("user_name", getUser_name()); //姓名
		map.put("sex", getSex()); //性别
		map.put("mobile_tel", getMobile_tel()); //手机号码
		map.put("office_phone", getOffice_phone()); //办公号码
		map.put("email", getEmail()); //邮件地址
		map.put("last_log_time", getLast_log_time()); //最后登录时间
		map.put("last_pwd_change_time", getLast_pwd_change_time()); 
		map.put("err_pwd_times", getErr_pwd_times()); //密码错误次数
		map.put("state", getState()); //用户状态
		return map;
	}

}

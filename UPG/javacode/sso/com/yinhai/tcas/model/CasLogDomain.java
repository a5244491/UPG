package com.yinhai.tcas.model;

import java.util.HashMap;
import java.util.Map;



/**
 * Cas操作日志表 Domain
 * @author YINHAI SOFTWARE
 * @copyright Copyrigt 银海软件 2011
 * @version 3.2 2013-6-28 14:11:53
 */
public class CasLogDomain extends BaseDomain {

	private static final long serialVersionUID = 1L;

	/** 日志ID */
	private Long log_id;

	/** 操作者所属系统标识 */
	private String sys_id;

	/** 操作者ID */
	private String operator_id;

	/** 操作者姓名 */
	private String operator_name;

	/** 操作者IP地址 */
	private String operator_ip;

	/** 操作时间 */
	private java.math.BigDecimal operate_time;

	/** 操作类型 */
	private String operate_type;

	/** 操作对象描述 */
	private String operate_desc;

	public CasLogDomain() {
	}

	public CasLogDomain(Long log_id) {
		this.log_id = log_id;
	}

	@Override
	public Map getKey() {
		Map key = new HashMap();
		if (this.getLog_id() == null) {
			throw new IllegalArgumentException("主键log_id不能为空。");
		}
		key.put("log_id", this.getLog_id());
		return key;
	}

	public CasLogDomain(Long log_id, String operator_id, String operator_name,
			java.math.BigDecimal operate_time, String operate_type) {
		this.log_id = log_id;
		this.operator_id = operator_id;
		this.operator_name = operator_name;
		this.operate_time = operate_time;
		this.operate_type = operate_type;
	}

	/**
	 * 设置 log_id 日志ID
	 * @param log_id 日志ID
	 */
	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}

	/**
	 * 获取 log_id 日志ID
	 * @return 日志ID
	 */
	public Long getLog_id() {
		return this.log_id;
	}

	/**
	 * 设置 sys_id 操作者所属系统标识
	 * @param sys_id 操作者所属系统标识
	 */
	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}

	/**
	 * 获取 sys_id 操作者所属系统标识
	 * @return 操作者所属系统标识
	 */
	public String getSys_id() {
		return this.sys_id;
	}

	/**
	 * 设置 operator_id 操作者ID
	 * @param operator_id 操作者ID
	 */
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}

	/**
	 * 获取 operator_id 操作者ID
	 * @return 操作者ID
	 */
	public String getOperator_id() {
		return this.operator_id;
	}

	/**
	 * 设置 operator_name 操作者姓名
	 * @param operator_name 操作者姓名
	 */
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}

	/**
	 * 获取 operator_name 操作者姓名
	 * @return 操作者姓名
	 */
	public String getOperator_name() {
		return this.operator_name;
	}

	/**
	 * 设置 operator_ip 操作者IP地址
	 * @param operator_ip 操作者IP地址
	 */
	public void setOperator_ip(String operator_ip) {
		this.operator_ip = operator_ip;
	}

	/**
	 * 获取 operator_ip 操作者IP地址
	 * @return 操作者IP地址
	 */
	public String getOperator_ip() {
		return this.operator_ip;
	}

	/**
	 * 设置 operate_time 操作时间
	 * @param operate_time 操作时间
	 */
	public void setOperate_time(java.math.BigDecimal operate_time) {
		this.operate_time = operate_time;
	}

	/**
	 * 获取 operate_time 操作时间
	 * @return 操作时间
	 */
	public java.math.BigDecimal getOperate_time() {
		return this.operate_time;
	}

	/**
	 * 设置 operate_type 操作类型
	 * @param operate_type 操作类型
	 */
	public void setOperate_type(String operate_type) {
		this.operate_type = operate_type;
	}

	/**
	 * 获取 operate_type 操作类型
	 * @return 操作类型
	 */
	public String getOperate_type() {
		return this.operate_type;
	}

	/**
	 * 设置 operate_desc 操作对象描述
	 * @param operate_desc 操作对象描述
	 */
	public void setOperate_desc(String operate_desc) {
		this.operate_desc = operate_desc;
	}

	/**
	 * 获取 operate_desc 操作对象描述
	 * @return 操作对象描述
	 */
	public String getOperate_desc() {
		return this.operate_desc;
	}

	/**
	 * 转换为map对象
	 * @return Map
	 */
	public java.util.Map toMap() {
		java.util.Map map = new java.util.HashMap();
		map.put("log_id", getLog_id()); //日志ID
		map.put("sys_id", getSys_id()); //操作者所属系统标识
		map.put("operator_id", getOperator_id()); //操作者ID
		map.put("operator_name", getOperator_name()); //操作者姓名
		map.put("operator_ip", getOperator_ip()); //操作者IP地址
		map.put("operate_time", getOperate_time()); //操作时间
		map.put("operate_type", getOperate_type()); //操作类型
		map.put("operate_desc", getOperate_desc()); //操作对象描述

		return map;
	}

}

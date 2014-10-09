package com.yinhai.tcas.model;

import java.util.HashMap;
import java.util.Map;


/**
 * Cas用户映射表 Domain
 * @author YINHAI SOFTWARE
 * @copyright Copyrigt 银海软件 2011
 * @version 3.2 2013-6-28 14:12:33
 */
public class CasUserMappingDomain extends BaseDomain {

	private static final long serialVersionUID = 1L;

	/** 单点登录用户ID */
	private Long cas_id;

	/** 映射系统标识 */
	private String client_sys_id;

	/** 映射系统登录名 */
	private String client_sys_logid;

	/** 映射状态 */
	private String state;

	public CasUserMappingDomain() {
	}

	public CasUserMappingDomain(Long cas_id, String client_sys_id,
			String client_sys_logid) {
		this.cas_id = cas_id;
		this.client_sys_id = client_sys_id;
		this.client_sys_logid = client_sys_logid;
	}

	@Override
	public Map getKey() {
		Map key = new HashMap();
		if (this.getCas_id() == null) {
			throw new IllegalArgumentException("主键cas_id不能为空。");
		}
		key.put("cas_id", this.getCas_id());
		if (this.getClient_sys_id() == null) {
			throw new IllegalArgumentException("主键client_sys_id不能为空。");
		}
		key.put("client_sys_id", this.getClient_sys_id());
		if (this.getClient_sys_logid() == null) {
			throw new IllegalArgumentException("主键client_sys_logid不能为空。");
		}
		key.put("client_sys_logid", this.getClient_sys_logid());
		return key;
	}

	public CasUserMappingDomain(Long cas_id, String client_sys_id,
			String client_sys_logid, String state) {
		this.cas_id = cas_id;
		this.client_sys_id = client_sys_id;
		this.client_sys_logid = client_sys_logid;
		this.state = state;
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
	 * 设置 client_sys_id 映射系统标识
	 * @param client_sys_id 映射系统标识
	 */
	public void setClient_sys_id(String client_sys_id) {
		this.client_sys_id = client_sys_id;
	}

	/**
	 * 获取 client_sys_id 映射系统标识
	 * @return 映射系统标识
	 */
	public String getClient_sys_id() {
		return this.client_sys_id;
	}

	/**
	 * 设置 client_sys_logid 映射系统登录名
	 * @param client_sys_logid 映射系统登录名
	 */
	public void setClient_sys_logid(String client_sys_logid) {
		this.client_sys_logid = client_sys_logid;
	}

	/**
	 * 获取 client_sys_logid 映射系统登录名
	 * @return 映射系统登录名
	 */
	public String getClient_sys_logid() {
		return this.client_sys_logid;
	}

	/**
	 * 设置 state 映射状态
	 * @param state 映射状态
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 获取 state 映射状态
	 * @return 映射状态
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
		map.put("client_sys_id", getClient_sys_id()); //映射系统标识
		map.put("client_sys_logid", getClient_sys_logid()); //映射系统登录名
		map.put("state", getState()); //映射状态
		return map;
	}

}

package com.yinhai.tcas.model;

import java.util.HashMap;
import java.util.Map;


/**
 * Cas客户端系统表 Domain
 * @author YINHAI SOFTWARE
 * @copyright Copyrigt 银海软件 2011
 * @version 3.2 2013-6-28 14:11:35
 */
public class CasClientDomain extends BaseDomain {

	private static final long serialVersionUID = 1L;

	/** 客户端系统标识 */
	private String client_sys_id;

	/** 客户端系统名称 */
	private String client_sys_name;

	/** 客户端访问地址 */
	private String client_sys_url;

	public CasClientDomain() {
	}

	public CasClientDomain(String client_sys_id) {
		this.client_sys_id = client_sys_id;
	}

	@Override
	public Map getKey() {
		Map key = new HashMap();
		if (this.getClient_sys_id() == null) {
			throw new IllegalArgumentException("主键client_sys_id不能为空。");
		}
		key.put("client_sys_id", this.getClient_sys_id());
		return key;
	}

	public CasClientDomain(String client_sys_id, String client_sys_name,
			String client_sys_url) {
		this.client_sys_id = client_sys_id;
		this.client_sys_name = client_sys_name;
		this.client_sys_url = client_sys_url;
	}

	/**
	 * 设置 client_sys_id 客户端系统标识
	 * @param client_sys_id 客户端系统标识
	 */
	public void setClient_sys_id(String client_sys_id) {
		this.client_sys_id = client_sys_id;
	}

	/**
	 * 获取 client_sys_id 客户端系统标识
	 * @return 客户端系统标识
	 */
	public String getClient_sys_id() {
		return this.client_sys_id;
	}

	/**
	 * 设置 client_sys_name 客户端系统名称
	 * @param client_sys_name 客户端系统名称
	 */
	public void setClient_sys_name(String client_sys_name) {
		this.client_sys_name = client_sys_name;
	}

	/**
	 * 获取 client_sys_name 客户端系统名称
	 * @return 客户端系统名称
	 */
	public String getClient_sys_name() {
		return this.client_sys_name;
	}

	/**
	 * 设置 client_sys_url 客户端访问地址
	 * @param client_sys_url 客户端访问地址
	 */
	public void setClient_sys_url(String client_sys_url) {
		this.client_sys_url = client_sys_url;
	}

	/**
	 * 获取 client_sys_url 客户端访问地址
	 * @return 客户端访问地址
	 */
	public String getClient_sys_url() {
		return this.client_sys_url;
	}

	/**
	 * 转换为map对象
	 * @return Map
	 */
	public java.util.Map toMap() {
		java.util.Map map = new java.util.HashMap();
		map.put("client_sys_id", getClient_sys_id()); //客户端系统标识
		map.put("client_sys_name", getClient_sys_name()); //客户端系统名称
		map.put("client_sys_url", getClient_sys_url()); //客户端访问地址
		return map;
	}

}

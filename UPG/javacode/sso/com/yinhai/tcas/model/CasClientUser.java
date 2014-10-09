package com.yinhai.tcas.model;

import java.util.HashMap;
import java.util.Map;

public class CasClientUser extends CasUserDomain {
	private static final long serialVersionUID = 1593509883998400324L;

	public CasClientUser() {
		super();
	}

	public CasClientUser(Long cas_id) {
		super.setCas_id(cas_id);
	}

	@Override
	public Map getKey() {
		Map key = new HashMap();
		key.put("cas_id", this.getCas_id());
		key.put("client_sys_id", this.getClient_sys_id());
		key.put("client_sys_logid", this.getClient_sys_logid());
		return key;
	}
	
	@Override
	public java.util.Map toMap() {
		java.util.Map map = super.toMap();
		map.put("client_sys_id", getClient_sys_id()); //映射系统标识
		map.put("client_sys_logid", getClient_sys_logid()); //映射系统登录名
		return map;
	}
	/** 映射系统登录名 */
	private String client_sys_logid;
	/** 映射系统标识 */
	private String client_sys_id;

	public String getClient_sys_id() {
		return client_sys_id;
	}

	public void setClient_sys_id(String client_sys_id) {
		this.client_sys_id = client_sys_id;
	}

	public String getClient_sys_logid() {
		return client_sys_logid;
	}

	public void setClient_sys_logid(String client_sys_logid) {
		this.client_sys_logid = client_sys_logid;
	}
}

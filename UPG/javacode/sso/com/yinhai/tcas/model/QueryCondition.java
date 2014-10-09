package com.yinhai.tcas.model;

import java.io.Serializable;

public class QueryCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cas_logid;
	private String id_card;
	private String user_name;
	private String sex;
	private String mobile_tel;
	private String office_phone;
	private String email;
	private String state;
	private int curPage;
	private int pageSize;
	public String getCas_logid() {
		return cas_logid;
	}
	public void setCas_logid(String cas_logid) {
		this.cas_logid = cas_logid;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile_tel() {
		return mobile_tel;
	}
	public void setMobile_tel(String mobile_tel) {
		this.mobile_tel = mobile_tel;
	}
	public String getOffice_phone() {
		return office_phone;
	}
	public void setOffice_phone(String office_phone) {
		this.office_phone = office_phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}


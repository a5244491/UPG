package com.yinhai.tcas.model;

import java.io.Serializable;
/**
 * 操作用户信息
 * @author yinhai
 */
public class Operator implements Serializable{
	private static final long serialVersionUID = 1L;
	private String systemID;
	private String userID;
	private String userName;
	private String userIPAddress;
	private String operateType;
	public String getSystemID() {
		return systemID;
	}
	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIPAddress() {
		return userIPAddress;
	}
	public void setUserIPAddress(String userIPAddress) {
		this.userIPAddress = userIPAddress;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
}

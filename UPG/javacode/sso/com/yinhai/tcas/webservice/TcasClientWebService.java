package com.yinhai.tcas.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.SOAPFaultException;

import com.yinhai.tcas.model.CasClientUser;
import com.yinhai.tcas.model.MapConvertor;
import com.yinhai.tcas.model.Operator;
import com.yinhai.tcas.model.PageWebBean;
import com.yinhai.tcas.model.QueryCondition;

@WebService
public interface TcasClientWebService {
	/**
	 * 获取客户端系统用户ID(登录号)
	 */
	@WebMethod(operationName = "getCasClientUserID")
	public String getCasClientUserID(
			@WebParam(name = "casUserLogID") String casUserLogID,
			@WebParam(name = "clientSysID") String clientSysID)
			throws SOAPFaultException;

	/**
	 * 锁定用户
	 */
	@WebMethod(operationName = "lock")
	public int lock(@WebParam(name = "casClientUserID") String casClientUserID,
			@WebParam(name = "operator") Operator operator)
			throws SOAPFaultException;

	/**
	 * 解锁用户
	 */
	@WebMethod(operationName = "unLock")
	public int unLock(
			@WebParam(name = "casClientUserID") String casClientUserID,
			@WebParam(name = "operator") Operator operator)
			throws SOAPFaultException;

	/**
	 * 删除用户
	 */
	@WebMethod(operationName = "delete")
	public int delete(
			@WebParam(name = "casClientUserID") String casClientUserID,
			@WebParam(name = "operator") Operator operator)
			throws SOAPFaultException;

	/**
	 * 新增用户映射
	 */
	@WebMethod(operationName = "addCasUserMapping")
	public int addCasUserMapping(
			@WebParam(name = "casClientUser") CasClientUser casClientUser,
			@WebParam(name = "operator") Operator operator)
			throws SOAPFaultException;

	/**
	 * 查询Cas认证中心所有用户列表
	 */
	@WebMethod(operationName = "queryCasUserListForPage")
	public PageWebBean queryCasUserListForPage(
			@WebParam(name = "clientSysID") String clientSysID,
			@WebParam(name = "casClientUserID") String casClientUserID,
			@WebParam(name = "queryCondition") QueryCondition queryCondition)
			throws SOAPFaultException;

	@WebMethod(operationName = "queryCasUserList")
	public List<MapConvertor> queryCasUserList(
			@WebParam(name = "clientSysID") String clientSysID,
			@WebParam(name = "casClientUserID") String casClientUserID,
			@WebParam(name = "queryCondition") QueryCondition queryCondition)
			throws SOAPFaultException;

}

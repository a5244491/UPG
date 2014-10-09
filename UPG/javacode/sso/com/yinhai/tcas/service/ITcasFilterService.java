package com.yinhai.tcas.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * tcas-client客户端处理接口
 * 
 * @author com.yinhai
 * 
 */
public interface ITcasFilterService {
	// 注册session
	public void registerSession(HttpServletRequest request,HttpServletResponse response,
			String casClientSysID, String casUserLogID) throws Exception;

	// 销毁session，该方法一般不需要实现
	public void destroySession(HttpServletRequest request) throws Exception;

	// 获取不需要cas-client过滤器处理的url列表
	public List<String> getNoneFilterUrls() throws Exception;

	// 根据过滤url列表解析目标url是否匹配过滤规则
	public boolean isNeedAuthentication(List<String> noneFilterUrls,
			HttpServletRequest request);

	// 处理服务地址,这里是login.jsp，因为当校验通过后在转向服务地址时，如果是login.jsp会将session杀掉
	public String dealServiceUrl(String serviceUrl);

	// 当前客户端服务地址是否为登出请求
	public boolean isLogoutUrl(String serviceUrl);

	// 当前客户端服务地址是否为登录请求
	public boolean isLoginUrl(String serviceUrl);
}

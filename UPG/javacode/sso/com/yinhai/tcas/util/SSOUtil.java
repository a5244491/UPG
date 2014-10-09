package com.yinhai.tcas.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yinhai.sysframework.service.ServiceLocator;
import com.yinhai.tcas.service.ITcasFilterService;

public class SSOUtil {

	public static void registerSession(HttpServletRequest request,
			HttpServletResponse response, String serviceID,
			String casClientSysID, String casUserLogID) throws Exception {
		ITcasFilterService service = (ITcasFilterService) ServiceLocator
				.getService(serviceID);
		service.registerSession(request, response, casClientSysID, casUserLogID);
		return;
	}

	public static void destroySession(HttpServletRequest request,
			String serviceID) throws Exception {
		ITcasFilterService service = (ITcasFilterService) ServiceLocator
				.getService(serviceID);
		service.destroySession(request);
		return;
	}

	public static List<String> getNoneFilterUrls(String serviceID)
			throws Exception {
		
		ITcasFilterService service = (ITcasFilterService) ServiceLocator
				.getService(serviceID);
		
		return service.getNoneFilterUrls();
	}

	public static boolean isNeedAuthentication(String serviceID,
			List<String> noneFilterUrls, HttpServletRequest request) {
		ITcasFilterService service = (ITcasFilterService) ServiceLocator
				.getService(serviceID);
		return service.isNeedAuthentication(noneFilterUrls, request);
	}

	public static boolean isLogoutUrl(String serviceID, String requestURI) {
		ITcasFilterService service = (ITcasFilterService) ServiceLocator
				.getService(serviceID);
		return service.isLogoutUrl(requestURI);
	}

	public static boolean isLoginUrl(String serviceID, String requestURI) {
		ITcasFilterService service = (ITcasFilterService) ServiceLocator
				.getService(serviceID);
		return service.isLoginUrl(requestURI);
	}

	public static String dealServiceUrl(String serviceID, String requestURI) {
		ITcasFilterService service = (ITcasFilterService) ServiceLocator
				.getService(serviceID);
		return service.dealServiceUrl(requestURI);
	}

	public static void main(String[] args) {

	}
}

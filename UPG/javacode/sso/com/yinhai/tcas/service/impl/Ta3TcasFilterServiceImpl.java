package com.yinhai.tcas.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import com.yinhai.sysframework.organization.IMenu;
import com.yinhai.sysframework.organization.IOrganizationService;
import com.yinhai.sysframework.organization.ISecurityService;
import com.yinhai.sysframework.organization.IUser;
import com.yinhai.sysframework.service.AppManager;
import com.yinhai.sysframework.service.BaseService;
import com.yinhai.ta3.rmUzWqQrYQmyYvFT1de0faT7JWvJJ3Ja.PowerChartTool;
import com.yinhai.tcas.service.ITcasFilterService;
import com.yinhai.tcas.util.SSOUtil;
import com.yinhai.tcas.webservice.TcasClientWebService;
import com.yinhai.webframework.security.domain.Ad60Domain;
import com.yinhai.webframework.security.service.UserLoginInfoService;
import com.yinhai.webframework.session.SessionManager;
import com.yinhai.webframework.session.UserSession;

public class Ta3TcasFilterServiceImpl extends BaseService implements
		ITcasFilterService {
	private final Log log = LogFactory.getLog(getClass());
	private UserLoginInfoService userLoginInfoService;
	private IOrganizationService organization4FrameworkService;
	public ISecurityService security4FrameworkService;
	private TcasClientWebService tcasClientService;
	private SessionManager sessionRegistry;

	@Override
	public void registerSession(HttpServletRequest request,HttpServletResponse response,
			String casClientSysID, String casUserLogID) throws Exception {
		UserSession session = UserSession.getUserSession(request);
		if (session == null || session.getUser() == null) {
			try {
				String clientUserLogID = tcasClientService.getCasClientUserID(
						casUserLogID, casClientSysID);
				log.debug("--Tcas客户端系统用户名（登录名）：" + clientUserLogID);
				if (!PowerChartTool.verify(sessionRegistry.getSessionSize()))
					throw new Exception(PowerChartTool.EXCEPTION_MESSAGE);
				IUser user = organization4FrameworkService
						.login(clientUserLogID);
				UserSession us = UserSession.createNewUserSession(request);
				us.setUser(user);
				us.getHttpSession().setAttribute("authenticateFlag", "true");
				Ad60Domain ad60 = userLoginInfoService.saveLoginInfo(us,
						request);
				us.setLoginNumber(ad60.getYad608());
				sessionRegistry.registerUserSession(request.getSession()
						.getId(), us);
				String isAllow = AppManager.getSysConfig("splitRolePermission");
				List menuList = null;
				if ("false".equals(isAllow)) {
					menuList = security4FrameworkService.getAllMenusAllRoles(
							null, user);
				} else {
					menuList = security4FrameworkService.getAllMenus(user);
				}
				request.getSession().setAttribute("user_seq_list", menuList);
				request.getSession().setAttribute("user_perview_flag",
						dearUrl(menuList));
				log.debug("--Tcas客户端完成登录");
			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					e.printStackTrace();
				}
				UserSession s = UserSession.getUserSession(request);
				if (s != null) {
					s.killUserSession();
				}
				String msg = e.getMessage() == null ? "Tcas客户端登录失败！" : e
						.getMessage();
				throw new Exception(msg);
			}
		}

	}

	private HashSet<String> dearUrl(List<IMenu> paramList) {
		HashSet localHashSet = new HashSet();
		Iterator localIterator = paramList.iterator();
		while (localIterator.hasNext()) {
			IMenu localIMenu = (IMenu) localIterator.next();
			if (localIMenu.getFunctionUrl() != null) {
				String str = localIMenu.getFunctionUrl();
				int i = str.indexOf("?");
				if (i > -1)
					str = str.substring(0, i);
				localHashSet.add("/" + str);
			}
		}
		return localHashSet;
	}

	@Override
	public void destroySession(HttpServletRequest request) throws Exception {
		sessionRegistry.removeSessionInformation(request.getSession().getId());
	}

	@Override
	public List<String> getNoneFilterUrls() throws Exception {
		
		List<String> noneFilterUrls = new ArrayList<String>();
		InputStream inputXml = new SSOUtil().getClass().getResourceAsStream(
				"/spring-security.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputXml);
		Element employees = document.getRootElement();
		for (Iterator i = employees.elementIterator(); i.hasNext();) {
			Element node = (Element) i.next();
				if (node.getName().equals("http")) {
					List<DefaultAttribute> attributes = node.attributes();//Checked
					String noneFilterUrl = null;
					boolean isNoneFilterUrl = false;
					for (DefaultAttribute attr : attributes) {
						if (attr.getName().toLowerCase().equals("security")
								&& attr.getText().toLowerCase().equals("none")) {
							isNoneFilterUrl = true;
						} else if (attr.getName().toLowerCase()
								.equals("pattern")) {
							noneFilterUrl = attr.getText();
						}
					}
					if (isNoneFilterUrl) {
						noneFilterUrls.add(noneFilterUrl);
					}
				}
		}
		noneFilterUrls.remove("/login.jsp*");// login.jsp需要认证,不然无法到cas-server的登录界面
		
		return noneFilterUrls;
	}

	@Override
	public boolean isNeedAuthentication(List<String> noneFilterUrls,
			HttpServletRequest request) {
		RequestMatcher urlMatcher = null;
	
		for (String url : noneFilterUrls) {
			urlMatcher = new AntPathRequestMatcher(url);
			if (urlMatcher.matches(request)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isLogoutUrl(String serviceUrl) {
		return false;
	}

	@Override
	public boolean isLoginUrl(String serviceUrl) {
		if (serviceUrl != null && serviceUrl.indexOf("/login.jsp") != -1) {
			return true;
		}
		return false;
	}
	
	@Override
	public String dealServiceUrl(String serviceUrl) {
		String result = serviceUrl.replaceFirst("login.jsp", "indexAction.do");
		if(result.endsWith("/")){
			result+="indexAction.do";
		}
		return result;
	}

	public UserLoginInfoService getUserLoginInfoService() {
		return userLoginInfoService;
	}

	public void setUserLoginInfoService(
			UserLoginInfoService userLoginInfoService) {
		this.userLoginInfoService = userLoginInfoService;
	}

	public IOrganizationService getOrganization4FrameworkService() {
		return organization4FrameworkService;
	}

	public void setOrganization4FrameworkService(
			IOrganizationService organization4FrameworkService) {
		this.organization4FrameworkService = organization4FrameworkService;
	}

	public ISecurityService getSecurity4FrameworkService() {
		return security4FrameworkService;
	}

	public void setSecurity4FrameworkService(
			ISecurityService security4FrameworkService) {
		this.security4FrameworkService = security4FrameworkService;
	}

	public TcasClientWebService getTcasClientService() {
		return tcasClientService;
	}

	public void setTcasClientService(TcasClientWebService tcasClientService) {
		this.tcasClientService = tcasClientService;
	}

	public SessionManager getSessionRegistry() {
		return sessionRegistry;
	}

	public void setSessionRegistry(SessionManager sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}
}

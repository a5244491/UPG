package com.yinhai.tcas.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import com.yinhai.sysframework.organization.IMenu;
import com.yinhai.sysframework.organization.IOrganizationService;
import com.yinhai.sysframework.organization.ISecurityService;
import com.yinhai.sysframework.organization.IUser;
import com.yinhai.sysframework.service.AppManager;
import com.yinhai.sysframework.service.BaseService;
import com.yinhai.sysframework.service.ServiceLocator;
import com.yinhai.ta3.rmUzWqQrYQmyYvFT1de0faT7JWvJJ3Ja.PowerChartTool;
import com.yinhai.tcas.service.ITcasFilterService;
import com.yinhai.tcas.util.SSOUtil;
import com.yinhai.webframework.security.domain.Ad60Domain;
import com.yinhai.webframework.security.filter.SecurityInterceptorFilter;
import com.yinhai.webframework.security.model.AppRole;
import com.yinhai.webframework.security.model.AppUser;
import com.yinhai.webframework.security.service.UserLoginInfoService;
import com.yinhai.webframework.session.SessionManager;
import com.yinhai.webframework.session.UserSession;
import com.yinhai.yhcip.app.organization.domain.RoleScope;

/**
 * @ClassName Ta3TcasFilterLocalServiceImpl
 * @Description: 无需webservice的支持，获取客户端的映射用户通过访问本地数据库
 * @Company: com.yinhai
 * @author huangyh
 * @date 2013-9-23
 * @version 1.0
 */
public class Ta3TcasFilterECServiceImpl extends BaseService implements
		ITcasFilterService {
	private final Log log = LogFactory.getLog(getClass());
	private UserLoginInfoService userLoginInfoService;
	private IOrganizationService organization4FrameworkService;
	public ISecurityService security4FrameworkService;
	private SessionManager sessionRegistry;

	@Override
	public void registerSession(HttpServletRequest request,
			HttpServletResponse response, String casClientSysID,
			String casUserLogID) throws Exception {
		UserSession session = UserSession.getUserSession(request);
		if (session == null || session.getUser() == null) {
			try {
				// String clientUserLogID =
				// tcasClientService.getCasClientUserID(
				// casUserLogID, casClientSysID);
				String clientUserLogID = casUserLogID;
				log.debug("--Tcas客户端系统用户名（登录名）：" + clientUserLogID);
				if (!PowerChartTool.verify(sessionRegistry.getSessionSize()))
					throw new Exception(PowerChartTool.EXCEPTION_MESSAGE);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("username", clientUserLogID);
				List<HashMap<String, String>> list = getDao().queryForList(
						"security.getAppUser", map);
				AppUser myAppUser = new AppUser();
				myAppUser.setUsername(clientUserLogID);
				myAppUser.setUserId(list.get(0).get("yae092"));
				myAppUser.setPassword(list.get(0).get("yae042"));
				myAppUser.setOrgId(list.get(0).get("yab003"));
				myAppUser.setDepartId(list.get(0).get("yab109"));
				myAppUser.setLastLoginDepartId(list.get(0).get("yae376"));
				myAppUser.setLastLoginRoleId(list.get(0).get("yae113"));
				//myAppUser.setLocked(list.get(0).get("yae361"));
				HashSet<AppRole> roleSet = new HashSet<AppRole>();
				List<RoleScope> roleScopes = organization4FrameworkService
						.getRoleScopes(list.get(0).get("yae092"));
				for (RoleScope rs : roleScopes) {
					AppRole appRole = new AppRole();
					appRole.setRoleId(rs.getRoleId());
					roleSet.add(appRole);//rs.getDepartId())
				}
				myAppUser.setRoles(roleSet);
				// UserSession us = UserSession.createNewUserSession(request);
				// us.setUser(user);
				// us.getHttpSession().setAttribute("authenticateFlag", "true");
				// Ad60Domain ad60 = userLoginInfoService.saveLoginInfo(us,
				// request);
				// us.setLoginNumber(ad60.getYad608());
				// sessionRegistry.registerUserSession(request.getSession()
				// .getId(), us);
				// String isAllow =
				// AppManager.getSysConfig("splitRolePermission");
				// List menuList = null;
				// if ("false".equals(isAllow)) {
				// menuList = security4FrameworkService.getAllMenusAllRoles(
				// null, user);
				// } else {
				// menuList = security4FrameworkService.getAllMenus(user);
				// }
				// request.getSession().setAttribute("user_seq_list", menuList);
				// request.getSession().setAttribute("user_perview_flag",
				// dearUrl(menuList));
				//创建一个空的SecurityContext（如果session中没有SecurityContext实例），然后持久化到session中
				//SecurityContextPersistenceFilter,
				//SessionManagementFilter要从securityContextRepository(其实在session里)里面获取SPRING_SECURITY_CONTEXT_KEY
				SecurityContextRepository repo=new HttpSessionSecurityContextRepository();
				HttpRequestResponseHolder holder = new HttpRequestResponseHolder(
						request, response);
				SecurityContext contextBeforeChainExecution = repo.loadContext(holder);
				SecurityContextHolder.setContext(contextBeforeChainExecution);
				SecurityContextHolder.getContext()
						.setAuthentication(new UsernamePasswordAuthenticationToken(
								myAppUser, null,myAppUser.getAuthorities()));
				SecurityContext contextAfterChainExecution = SecurityContextHolder
						.getContext();
				SecurityContextHolder.clearContext();
				repo.saveContext(
						contextAfterChainExecution, holder.getRequest(),
						holder.getResponse());
				// rememberMeServices.loginSuccess(request, response,
				// authResult);
				// successHandler
				IUser user = organization4FrameworkService.login(clientUserLogID);
				UserSession us = UserSession.createNewUserSession(request);
				us.setUser(user);
				// 记录用户登录信息
				us.getHttpSession().setAttribute("authenticateFlag", "true");
				Ad60Domain ad60Domain = userLoginInfoService.saveLoginInfo(us, request);
				// 将登录流水号放到UserSession中
				us.setLoginNumber(ad60Domain.getYad608());
				sessionRegistry.registerUserSession(us.getSessionId(), us, myAppUser);
				loadPermission(user, request.getSession());
				// 记录错误标志
				request.getSession().setAttribute("login_error_flag", "false");
				log.debug("--Tcas客户端完成登录");
			} catch (Exception e) {
				e.printStackTrace();
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

	protected void loadPermission(IUser user, HttpSession session) {
		ISecurityService securityService = (ISecurityService) ServiceLocator
				.getService("security4FrameworkService");
		String splitRolePermission = AppManager
				.getSysConfig("splitRolePermission");
		List<IMenu> list = null;
		// 用户登录后只显示当前角色的权限，如果要显示所有角色权限就配置成小写false，在config.properties里配置
		if ("false".equals(splitRolePermission)) {
			list = securityService.getAllMenusAllRoles(null, user);
		} else {
			list = securityService.getAllMenus(user);
		}
		// session.setAttribute("user_seq_list",
		// list);//indexaction第一次访问的时候使用，第一次使用后将被清除。
		// 当前用户权限信息
		session.setAttribute(SecurityInterceptorFilter.USER_PERVIEW_FLAG,
				dearTaUrl(list));

	}

	protected HashSet<String> dearTaUrl(List<IMenu> list) {
		HashSet<String> set = new HashSet<String>();
		for (IMenu menu : list) { // checked
			if (menu.getFunctionUrl() != null) {
				String url = menu.getFunctionUrl();
				int b = url.indexOf("?");
				if (b > -1) {
					url = url.substring(0, b);
				}
				set.add("/" + url);
			}
		}
		return set;
	}

	// protected String determineTargetUrl(HttpServletRequest request,
	// HttpServletResponse response) {
	// String isajax = request.getHeader("x-requested-with");
	// if("XMLHttpRequest".equals(isajax)){
	// return getDefaultTargetUrl();
	// }
	// return super.determineTargetUrl(request, response);
	// }

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

	/*
	public boolean isNeedAuthentication(List<String> noneFilterUrls,
			String requestURI) {
		AntUrlPathMatcher urlMatcher = new AntUrlPathMatcher();
		for (String url : noneFilterUrls) {
			if (urlMatcher.pathMatchesUrl(url, requestURI)) {
				return false;
			}
		}
		return true;
	}
	*/
	
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
		if (result.endsWith("/")) {
			result += "indexAction.do";
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

	public SessionManager getSessionRegistry() {
		return sessionRegistry;
	}

	public void setSessionRegistry(SessionManager sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}
}

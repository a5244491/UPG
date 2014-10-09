package com.yinhai.tcas.client.authentication;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.HostnameVerifier;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.authentication.DefaultGatewayResolverImpl;
import org.jasig.cas.client.authentication.GatewayResolver;
import org.jasig.cas.client.proxy.AbstractEncryptedProxyGrantingTicketStorageImpl;
import org.jasig.cas.client.proxy.Cas20ProxyRetriever;
import org.jasig.cas.client.proxy.CleanUpTimerTask;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorage;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorageImpl;
import org.jasig.cas.client.session.SingleSignOutHandler;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.AbstractConfigurationFilter;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.ReflectUtils;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.Cas20ProxyTicketValidator;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;

import com.yinhai.tcas.util.CasUtil;
import com.yinhai.tcas.util.PropertiesUtil;
import com.yinhai.tcas.util.PropsKeys;
import com.yinhai.tcas.util.SSOUtil;

/**
 * 
 * 实现四个AuthenticationFilter，Cas20ProxyReceivingTicketValidationFilter，
 * HttpServletRequestWrapperFilter，AssertionThreadLocalFilter
 * 并通过返回的logid获取本客户端应用的session
 * 
 * @author yinhai
 * 
 */
public class TcasFilter extends AbstractConfigurationFilter {

	public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";

	protected final Log log = LogFactory.getLog(getClass());
	private String casServerUrlPrefix;
	private String casServerLoginUrl;
	private String casServerLogoutUrl;
	private String serverName;
	private String service;
	private boolean renew = false;
	private boolean gateway = false;
	private static final String[] RESERVED_INIT_PARAMS = new String[] {
			"proxyGrantingTicketStorageClass", "proxyReceptorUrl",
			"acceptAnyProxy", "allowedProxyChains", "casServerUrlPrefix",
			"proxyCallbackUrl", "renew", "exceptionOnValidationFailure",
			"redirectAfterValidation", "useSession", "serverName", "service",
			"artifactParameterName", "serviceParameterName",
			"encodeServiceUrl", "millisBetweenCleanUps", "hostnameVerifier",
			"encoding", "config" };
	private static final int DEFAULT_MILLIS_BETWEEN_CLEANUPS = 60 * 1000;
	private String proxyReceptorUrl;
	private Timer timer;
	private TimerTask timerTask;
	private int millisBetweenCleanUps;
	private TicketValidator ticketValidator;
	private boolean redirectAfterValidation = false;
	private boolean exceptionOnValidationFailure = true;
	private boolean useSession = true;
	private String roleAttribute;
	private boolean ignoreCase;
	private boolean isEnableFilter = false;
	private String clientSysID;
	private String tcasFilterService;
	private String allowAnyProxy;
	private String allowedProxyChains;
	private String encoding;
	private String proxyCallbackUrl;
	private List<String> noneFilterUrls;

	public void setNoneFilterUrls(List<String> noneFilterUrls) {
		this.noneFilterUrls = noneFilterUrls;
	}

	public void setAllowAnyProxy(String allowAnyProxy) {
		this.allowAnyProxy = allowAnyProxy;
	}

	public void setAllowedProxyChains(String allowedProxyChains) {
		this.allowedProxyChains = allowedProxyChains;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setProxyCallbackUrl(String proxyCallbackUrl) {
		this.proxyCallbackUrl = proxyCallbackUrl;
	}

	public void setCasServerUrlPrefix(String casServerUrlPrefix) {
		this.casServerUrlPrefix = casServerUrlPrefix;
	}

	public void setTcasFilterService(String tcasFilterService) {
		this.tcasFilterService = tcasFilterService;
	}

	public void setClientSysID(String clientSysID) {
		this.clientSysID = clientSysID;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public TimerTask getTimerTask() {
		return timerTask;
	}

	public void setTimerTask(TimerTask timerTask) {
		this.timerTask = timerTask;
	}

	public boolean isUseSession() {
		return useSession;
	}

	public void setUseSession(boolean useSession) {
		this.useSession = useSession;
	}

	public boolean isRenew() {
		return renew;
	}

	public boolean isGateway() {
		return gateway;
	}

	public String getProxyReceptorUrl() {
		return proxyReceptorUrl;
	}

	public void setProxyReceptorUrl(String proxyReceptorUrl) {
		this.proxyReceptorUrl = proxyReceptorUrl;
	}

	public boolean isRedirectAfterValidation() {
		return redirectAfterValidation;
	}

	public void setRedirectAfterValidation(boolean redirectAfterValidation) {
		this.redirectAfterValidation = redirectAfterValidation;
	}

	public boolean isExceptionOnValidationFailure() {
		return exceptionOnValidationFailure;
	}

	public void setExceptionOnValidationFailure(
			boolean exceptionOnValidationFailure) {
		this.exceptionOnValidationFailure = exceptionOnValidationFailure;
	}

	public void setTicketValidator(TicketValidator ticketValidator) {
		this.ticketValidator = ticketValidator;
	}

	public String getRoleAttribute() {
		return roleAttribute;
	}

	public void setRoleAttribute(String roleAttribute) {
		this.roleAttribute = roleAttribute;
	}

	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	public boolean isEnableFilter() {
		return isEnableFilter;
	}

	public void setEnableFilter(boolean isEnableFilter) {
		this.isEnableFilter = isEnableFilter;
	}

	public void setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

	private String artifactParameterName = "ticket";
	private String serviceParameterName = "service";
	private String logoutParameterName = "logoutRequest";
	private boolean encodeServiceUrl = true;
	private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();
	private ProxyGrantingTicketStorage proxyGrantingTicketStorage = new ProxyGrantingTicketStorageImpl();
	private static final SingleSignOutHandler handler = new SingleSignOutHandler();

	public final String getServerName(final String serverName) {
		if (serverName != null && serverName.endsWith("/")) {
			return serverName.substring(0, serverName.length() - 1);
		} else {
			return serverName;
		}
	}

	/**
	 * 通过filter在web.xml配置的参数或者Properties属性文件初始化配置信息
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// SingleSignOutFilter
		if (!isIgnoreInitConfiguration()) {
			handler.setArtifactParameterName(this.artifactParameterName);
			handler.setLogoutParameterName(this.logoutParameterName);
		}
		handler.init();
		setCasServerLogoutUrl(getPropertyFromInitParams(filterConfig,
				"casServerLogoutUrl", null));
		// AuthenticationFilter
		setCasServerLoginUrl(getPropertyFromInitParams(filterConfig,
				"casServerLoginUrl", null));
		setServerName(getPropertyFromInitParams(filterConfig, "serverName",
				null));
		setService(getPropertyFromInitParams(filterConfig, "service", null));
		setRenew(parseBoolean(getPropertyFromInitParams(filterConfig, "renew",
				"false")));
		setGateway(parseBoolean(getPropertyFromInitParams(filterConfig,
				"gateway", "false")));
		final String gatewayStorageClass = getPropertyFromInitParams(
				filterConfig, "gatewayStorageClass", null);
		if (gatewayStorageClass != null) {
			try {
				this.gatewayStorage = (GatewayResolver) Class.forName(
						gatewayStorageClass).newInstance();
			} catch (final Exception e) {
				log.error(e, e);
				throw new ServletException(e);
			}
		}
		// Cas20ProxyReceivingTicketValidationFilter
		setAllowAnyProxy(getPropertyFromInitParams(filterConfig,
				"acceptAnyProxy", null));
		setAllowedProxyChains(getPropertyFromInitParams(filterConfig,
				"allowedProxyChains", null));
		setProxyCallbackUrl(getPropertyFromInitParams(filterConfig,
				"proxyCallbackUrl", null));
		setEncoding(getPropertyFromInitParams(filterConfig, "encoding", "UTF-8"));
		setCasServerUrlPrefix(getPropertyFromInitParams(filterConfig,
				"casServerUrlPrefix", null));
		setExceptionOnValidationFailure(parseBoolean(getPropertyFromInitParams(
				filterConfig, "exceptionOnValidationFailure", "true")));
		setRedirectAfterValidation(parseBoolean(getPropertyFromInitParams(
				filterConfig, "redirectAfterValidation", "true")));
		setUseSession(parseBoolean(getPropertyFromInitParams(filterConfig,
				"useSession", "true")));
		setProxyReceptorUrl(getPropertyFromInitParams(filterConfig,
				"proxyReceptorUrl", null));
		final String proxyGrantingTicketStorageClass = getPropertyFromInitParams(
				filterConfig, "proxyGrantingTicketStorageClass", null);
		if (proxyGrantingTicketStorageClass != null) {
			this.proxyGrantingTicketStorage = ReflectUtils
					.newInstance(proxyGrantingTicketStorageClass);
			if (this.proxyGrantingTicketStorage instanceof AbstractEncryptedProxyGrantingTicketStorageImpl) {
				final AbstractEncryptedProxyGrantingTicketStorageImpl p = (AbstractEncryptedProxyGrantingTicketStorageImpl) this.proxyGrantingTicketStorage;
				final String cipherAlgorithm = getPropertyFromInitParams(
						filterConfig,
						"cipherAlgorithm",
						AbstractEncryptedProxyGrantingTicketStorageImpl.DEFAULT_ENCRYPTION_ALGORITHM);
				final String secretKey = getPropertyFromInitParams(
						filterConfig, "secretKey", null);
				p.setCipherAlgorithm(cipherAlgorithm);
				try {
					if (secretKey != null) {
						p.setSecretKey(secretKey);
					}
				} catch (final Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		this.millisBetweenCleanUps = Integer
				.parseInt(getPropertyFromInitParams(filterConfig,
						"millisBetweenCleanUps",
						Integer.toString(DEFAULT_MILLIS_BETWEEN_CLEANUPS)));
		// HttpServletRequestWrapperFilter
		this.roleAttribute = getPropertyFromInitParams(filterConfig,
				"roleAttribute", null);
		this.ignoreCase = Boolean.parseBoolean(getPropertyFromInitParams(
				filterConfig, "ignoreCase", "false"));
		// AssertionThreadLocalFilter

		// web.xml没有设置的参数从tcas.properties中获取
		if (this.casServerUrlPrefix == null) {
			setCasServerUrlPrefix(PropertiesUtil
					.get(PropsKeys.TCAS_SERVER_URL_PREFIX));
		}
		if (this.casServerLoginUrl == null) {
			setCasServerLoginUrl(PropertiesUtil
					.get(PropsKeys.TCAS_SERVER_LOGIN_URL));
		}
		if (this.casServerLogoutUrl == null) {
			setCasServerLogoutUrl(PropertiesUtil
					.get(PropsKeys.TCAS_SERVER_LOGOUT_URL));
		}
		if (this.serverName == null) {
			setServerName(PropertiesUtil.get(PropsKeys.TCAS_CLIENT_SERVERNAME));
		}
		if (this.service == null) {
			setService(PropertiesUtil.get(PropsKeys.TCAS_CLIENT_SERVICEURL));
		}
		if (PropertiesUtil.get(PropsKeys.TCAS_AUTH_ENABLED) != null) {
			setEnableFilter(PropertiesUtil
					.getBoolean(PropsKeys.TCAS_AUTH_ENABLED));
		}
		setClientSysID(PropertiesUtil.get(PropsKeys.TCAS_CLIENT_SYS_ID));
		setTcasFilterService(PropertiesUtil
				.get(PropsKeys.TCAS_CLIENT_FILTER_SERVICE));
		setTicketValidator(getTicketValidator(filterConfig));// 初始化Ticket校验器

		checkParameters();
		
		try {
			if (this.tcasFilterService != null) {
				setNoneFilterUrls(SSOUtil
						.getNoneFilterUrls(this.tcasFilterService));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

	public void checkParameters() {
		CommonUtils.assertNotNull(this.artifactParameterName,
				"artifactParameterName cannot be null.");
		CommonUtils.assertNotNull(this.serviceParameterName,
				"serviceParameterName cannot be null.");
		CommonUtils.assertNotNull(this.casServerUrlPrefix,
				"casServerUrlPrefix cannot be null.");
		CommonUtils.assertNotNull(this.casServerLoginUrl,
				"casServerLoginUrl cannot be null.");
		CommonUtils.assertNotNull(this.casServerLogoutUrl,
				"casServerLogoutUrl cannot be null.");
		CommonUtils.assertTrue(CommonUtils.isNotEmpty(this.serverName)
				|| CommonUtils.isNotEmpty(this.service),
				"serverName or service must be set.");
		CommonUtils
				.assertTrue(
						CommonUtils.isBlank(this.serverName)
								|| CommonUtils.isBlank(this.service),
						"serverName and service cannot both be set.  You MUST ONLY set one.");
		CommonUtils.assertNotNull(this.ticketValidator,
				"ticketValidator cannot be null.");
		CommonUtils.assertNotNull(this.proxyGrantingTicketStorage,
				"proxyGrantingTicketStorage cannot be null.");
		if (this.timer == null) {
			this.timer = new Timer(true);
		}
		if (this.timerTask == null) {
			this.timerTask = new CleanUpTimerTask(
					this.proxyGrantingTicketStorage);
		}
		this.timer.schedule(this.timerTask, this.millisBetweenCleanUps,
				this.millisBetweenCleanUps);
	}

	@Override
	public final void doFilter(final ServletRequest servletRequest,
			final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		request.setCharacterEncoding("UTF-8");
		log.debug("Ignoring URI " + request.getRequestURI());
		/**
		 * basePath:http://localhost:8080/test/ getContextPath:/test
		 * getServletPath:/test.jsp getRequestURI:/test/test.jsp
		 * getRequestURL:http://localhost:8080/test/test.jsp
		 * getRealPath:D:\Tomcat 6.0\webapps\test\
		 * getServletContext().getRealPath:D:\Tomcat 6.0\webapps\test\
		 * getQueryString:p=fuck
		 */
		final String servletPath = request.getServletPath();
		if (!isEnableFilter()
				|| (this.noneFilterUrls != null
						&& this.noneFilterUrls.size() > 0 && !SSOUtil
							.isNeedAuthentication(this.tcasFilterService,
									this.noneFilterUrls, request))) {
			// 排除spring-security不需要校验的URL
			filterChain.doFilter(request, response);
		} else {
			// 客户端请求url中包含logout则认为客户端登出，则向CasServer端发出单点登出请求
			if (SSOUtil.isLogoutUrl(this.tcasFilterService, servletPath)) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect(this.casServerLogoutUrl);
				return;
			}
			processSingleSignOut(request, response, filterChain);
		}
	}

	// CasServer端发出单点登出请求
	private void processSingleSignOut(final ServletRequest servletRequest,
			final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;

		log.debug(request.getParameter(this.artifactParameterName));
		log.debug(request.getParameter(this.logoutParameterName));
		// 判断参数中是否具有artifactParameterName属性指定的参数名称，默认是ticket
		if (handler.isTokenRequest(request)) {
			// 将session记录到sessionMappingStorage
			handler.recordSession(request);
		} else if (handler.isLogoutRequest(request)) {// 判断是否具有logoutParameterName参数指定的参数，默认参数名称为logoutRequest
			// 如果存在，则在sessionMappingStorage中删除记录，并注销session
			handler.destroySession(request);
			try {
				SSOUtil.destroySession(request, this.tcasFilterService);// 这个基本没用了
			} catch (Exception e) {
				throw new ServletException(
						"destroy cas client session error,client system ID is "
								+ this.clientSysID + " ,session service is "
								+ this.tcasFilterService);
			}
			// Do not continue up filter chain
			return;
		}
		processAuthentication(request, response, filterChain);
		return;
	}

	private void processAuthentication(final ServletRequest servletRequest,
			final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 从session中取得Assertion
		final HttpSession session = request.getSession(false);
		final Assertion assertion = session != null ? (Assertion) session
				.getAttribute(CONST_CAS_ASSERTION) : null;
		// 如果存在，则说明已经登录，本过滤器处理完成，处理下个过滤器
		if (assertion != null) {
			onSuccessfulValidation(request, response, assertion);
			processTicketValidation(request, response, filterChain);
			return;
		}
		// 如果session中没有Assertion对象，组装serviceUrl并试着从参数中取得ticket属性
		final String serviceUrl = constructServiceUrl(request, response);
		final String ticket = CommonUtils.safeGetParameter(request,
				this.artifactParameterName);
		final boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(
				request, serviceUrl);

		// 如果ticket不为空，或者wasGatewayed为true，则本过滤器处理完成，处理下个过滤器
		if (CommonUtils.isNotBlank(ticket) || wasGatewayed) {
			processTicketValidation(request, response, filterChain);
			return;
		}

		// ticket 为空，并且wasGatewayed也为false，则根据初始化参数gateway的值来组装跳转url
		redirectCasServerLogin(request, response, serviceUrl);
	}

	private void redirectCasServerLogin(HttpServletRequest request,
			HttpServletResponse response, String serviceUrl)
			throws IOException, ServletException {
		final String modifiedServiceUrl;
		log.debug("no ticket and no assertion found");
		if (this.gateway) {
			log.debug("setting gateway attribute in session");
			modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(
					request, serviceUrl);
		} else {
			modifiedServiceUrl = serviceUrl;
		}

		if (log.isDebugEnabled()) {
			log.debug("Constructed service url: " + modifiedServiceUrl);
		}
		// 组装跳转url,如果没有配置gateway，则跳转到casServerLoginUrl参数指定的url
		final String urlToRedirectTo = CommonUtils.constructRedirectUrl(
				this.casServerLoginUrl, this.serviceParameterName,
				modifiedServiceUrl, this.renew, this.gateway);

		if (log.isDebugEnabled()) {
			log.debug("redirecting to \"" + urlToRedirectTo + "\"");
		}
		response.sendRedirect(urlToRedirectTo);
	}

	private void processTicketValidation(final ServletRequest servletRequest,
			final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		// 判断前置条件由其子类Cas20ProxyReceivingTicketValidationFilter实现，如果是代理的话直接返回
		if (!preFilter(servletRequest, servletResponse, filterChain)) {
			return;
		}
		// 获取ticket
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final String ticket = CommonUtils.safeGetParameter(request,
				this.artifactParameterName);

		if (CommonUtils.isNotBlank(ticket)) {
			if (log.isDebugEnabled()) {
				log.debug("Attempting to validate ticket: " + ticket);
			}
			try {
				// 通过ticket客户端从cas服务端校验取得返回的Assertion对象
				final Assertion assertion = this.ticketValidator.validate(
						ticket, constructServiceUrl(request, response));
				if (log.isDebugEnabled()) {
					log.debug("Successfully authenticated user: "
							+ assertion.getPrincipal().getName());
				}
				// 将Assertion写入request和session之中
				request.setAttribute(CONST_CAS_ASSERTION, assertion);

				if (this.useSession) {
					request.getSession().setAttribute(CONST_CAS_ASSERTION,
							assertion);
				}
				onSuccessfulValidation(request, response, assertion);

				if (this.redirectAfterValidation) {// 校验成功后跳转到客户端原来的地址
					log.debug("Redirecting after successful ticket validation.");
					// 客户端自定义对原服务地址做处理防止kill session
					response.sendRedirect(SSOUtil.dealServiceUrl(
							this.tcasFilterService,
							constructServiceUrl(request, response)));
					return;
				}
			} catch (final TicketValidationException e) {
				final String serviceUrl = constructServiceUrl(request, response);
				// request.getParameterMap().remove(this.artifactParameterName);会报错
				// request.getSession().invalidate();
				removeSessionByToken(ticket);
				redirectCasServerLogin(request, response, serviceUrl);
				log.warn(e, e);
				return;
			} catch (final ServletException e) {
				// 说明当前客户端应用注册session失败，比如获取本客户端的用户失败，cas的session依然有效，cas体系中的其他客户端应用仍然可以使用
				removeSessionByToken(ticket);
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				log.warn(e, e);
				throw e;
			}
		}
		// ticket为空(已登录)，校验后不跳转的话（第一次登录,默认是要跳转的），则
		processHttpServletRequestWrapper(request, response, filterChain);
	}

	private void removeSessionByToken(String ticket) {
		final HttpSession session = handler.getSessionMappingStorage()
				.removeSessionByMappingId(ticket);
		if (session != null) {
			try {
                session.invalidate();
            } catch (final IllegalStateException e) {
                log.debug("Error invalidating session.", e);
            }
		}
	}

	// 身份校验后成功后的
	private void processHttpServletRequestWrapper(
			final ServletRequest servletRequest,
			final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		// ta3的login.jsp初始化时杀死现有session，这里必须对原服务地址做处理
		String servletPath = request.getServletPath();
		if (SSOUtil.isLoginUrl(this.tcasFilterService, servletPath)) {
			response.sendRedirect(SSOUtil.dealServiceUrl(
					this.tcasFilterService,
					constructServiceUrl(request, response)));
			return;
		}
		final AttributePrincipal principal = retrievePrincipalFromSessionOrRequest(servletRequest);
		processAssertionThreadLocal(new CasHttpServletRequestWrapper(
				(HttpServletRequest) servletRequest, principal),
				servletResponse, filterChain);
	}

	private void processAssertionThreadLocal(
			final ServletRequest servletRequest,
			final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpSession session = request.getSession(false);
		final Assertion assertion = (Assertion) (session == null ? request
				.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION) : session
				.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION));
		try {
			AssertionHolder.setAssertion(assertion);
			// 将Assertion对象保存到ThreadLocal中，
			// Fileter和Servlet可以在线程中取得Assertion对象，直到过滤器链执行完成
			filterChain.doFilter(servletRequest, servletResponse);
		} finally {
			AssertionHolder.clear();
		}
	}

	private AttributePrincipal retrievePrincipalFromSessionOrRequest(
			final ServletRequest servletRequest) {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpSession session = request.getSession(false);
		final Assertion assertion = (Assertion) (session == null ? request
				.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION) : session
				.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION));

		return assertion == null ? null : assertion.getPrincipal();
	}

	private void onFailedValidation(HttpServletRequest request,
			HttpServletResponse response) {
	}

	private void onSuccessfulValidation(HttpServletRequest request,
			HttpServletResponse response, Assertion assertion)
			throws IOException, ServletException {
		if (assertion != null && this.tcasFilterService != null
				&& this.clientSysID != null) {
			AttributePrincipal attributePrincipal = assertion.getPrincipal();
			String casUserLogID = attributePrincipal.getName();
			try {
				SSOUtil.registerSession(request,response, tcasFilterService,
						clientSysID, casUserLogID);
			} catch (Exception e) {
				throw new ServletException(
						"register cas client session error,client system ID is "
								+ this.clientSysID + " ,session service is "
								+ this.tcasFilterService, e);
			}
		}
	}

	private boolean preFilter(final ServletRequest servletRequest,
			final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final String requestUri = request.getRequestURI();
		// 参数proxyReceptorUrl为空或者不是以proxyReceptorUrl结尾的，则返回true
		if (CommonUtils.isEmpty(this.proxyReceptorUrl)
				|| !requestUri.endsWith(this.proxyReceptorUrl)) {
			return true;
		}
		// 读取和响应代理请求
		try {
			CommonUtils.readAndRespondToProxyReceptorRequest(request, response,
					this.proxyGrantingTicketStorage);
		} catch (final RuntimeException e) {
			log.error(e.getMessage(), e);
			throw e;
		}

		return false;
	}

	protected final String constructServiceUrl(
			final HttpServletRequest request, final HttpServletResponse response) {
		return CasUtil.constructServiceUrl(request, response, this.service,
				this.serverName, this.artifactParameterName,
				this.encodeServiceUrl);
	}

	public final void setRenew(final boolean renew) {
		this.renew = renew;
	}

	public final void setGateway(final boolean gateway) {
		this.gateway = gateway;
	}

	public void setCasServerLogoutUrl(String casServerLogoutUrl) {
		this.casServerLogoutUrl = casServerLogoutUrl;
	}

	public final void setCasServerLoginUrl(final String casServerLoginUrl) {
		this.casServerLoginUrl = casServerLoginUrl;
	}

	public final void setGatewayStorage(final GatewayResolver gatewayStorage) {
		this.gatewayStorage = gatewayStorage;
	}

	@Override
	public void destroy() {
		this.timer.cancel();
	}

	private final TicketValidator getTicketValidator(FilterConfig filterConfig) {
		final Cas20ServiceTicketValidator validator;
		if (CommonUtils.isNotBlank(this.allowAnyProxy)
				|| CommonUtils.isNotBlank(this.allowedProxyChains)) {
			final Cas20ProxyTicketValidator v = new Cas20ProxyTicketValidator(
					this.casServerUrlPrefix);
			v.setAcceptAnyProxy(parseBoolean(this.allowAnyProxy));
			v.setAllowedProxyChains(CommonUtils
					.createProxyList(this.allowedProxyChains));
			validator = v;
		} else {
			validator = new Cas20ServiceTicketValidator(this.casServerUrlPrefix);
		}
		validator.setProxyCallbackUrl(this.proxyCallbackUrl);
		validator
				.setProxyGrantingTicketStorage(this.proxyGrantingTicketStorage);
		validator.setProxyRetriever(new Cas20ProxyRetriever(
				this.casServerUrlPrefix, this.encoding));
		validator.setRenew(this.renew);
		validator.setEncoding(this.encoding);

		final Map<String, String> additionalParameters = new HashMap<String, String>();
		final List<String> params = Arrays.asList(RESERVED_INIT_PARAMS);

		for (final Enumeration<?> e = filterConfig.getInitParameterNames(); e
				.hasMoreElements();) {
			final String s = (String) e.nextElement();// Checked

			if (!params.contains(s)) {
				additionalParameters.put(s, filterConfig.getInitParameter(s));
			}
		}
		// 自定义参数
		validator.setCustomParameters(additionalParameters);
		validator.setHostnameVerifier(getHostnameVerifier(filterConfig));
		return validator;
	}

	private HostnameVerifier getHostnameVerifier(final FilterConfig filterConfig) {
		final String className = getPropertyFromInitParams(filterConfig,
				"hostnameVerifier", null);
		log.trace("Using hostnameVerifier parameter: " + className);
		final String config = getPropertyFromInitParams(filterConfig,
				"hostnameVerifierConfig", null);
		log.trace("Using hostnameVerifierConfig parameter: " + config);
		if (className != null) {
			if (config != null) {
				return ReflectUtils.newInstance(className, config);
			} else {
				return ReflectUtils.newInstance(className);
			}
		}
		return null;
	}

	final class CasHttpServletRequestWrapper extends HttpServletRequestWrapper {

		private final AttributePrincipal principal;

		CasHttpServletRequestWrapper(final HttpServletRequest request,
				final AttributePrincipal principal) {
			super(request);
			this.principal = principal;
		}

		@Override
		public Principal getUserPrincipal() {
			return this.principal;
		}

		@Override
		public String getRemoteUser() {
			return principal != null ? this.principal.getName() : null;
		}

		@Override
		public boolean isUserInRole(final String role) {
			if (CommonUtils.isBlank(role)) {
				log.debug("No valid role provided.  Returning false.");
				return false;
			}

			if (this.principal == null) {
				log.debug("No Principal in Request.  Returning false.");
				return false;
			}

			if (CommonUtils.isBlank(roleAttribute)) {
				log.debug("No Role Attribute Configured. Returning false.");
				return false;
			}

			final Object value = this.principal.getAttributes().get(
					roleAttribute);

			if (value instanceof Collection<?>) {
				for (final Object o : (Collection<?>) value) {
					if (rolesEqual(role, o)) {
						log.debug("User [" + getRemoteUser() + "] is in role ["
								+ role + "]: " + true);
						return true;
					}
				}
			}

			final boolean isMember = rolesEqual(role, value);
			log.debug("User [" + getRemoteUser() + "] is in role [" + role
					+ "]: " + isMember);
			return isMember;
		}

		private boolean rolesEqual(final String given, final Object candidate) {
			return ignoreCase ? given.equalsIgnoreCase(candidate.toString())
					: given.equals(candidate);
		}
	}
}

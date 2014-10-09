package com.yinhai.bcs.upg.common.core;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.yinhai.bcs.sdb.client.SDBClient;
import com.yinhai.bcs.upg.dbservice.SDBClientFactory;

public class InitFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req; 
	    HttpServletResponse response=(HttpServletResponse)resp;   
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String classpath = filterConfig.getServletContext().getRealPath("/WEB-INF/classes/");
		String fileseparator = System.getProperty("file.separator");
		Properties prop = new Properties();
		
		try {
			
//			InputStream in = new FileInputStream(new File(classpath+fileseparator+"sdbconfig"+fileseparator+"app-params.properties"));
//			prop.load(in);
//			SDBClientFactory.sdbClient = SDBClient.initClient();
//			SDBClientFactory.sdbClient.setRequestRsaUrl(prop.getProperty("SDB_REQUEST_URL").trim());
//			SDBClientFactory.sdbClient.setServerIpAndPort(prop.getProperty("SDB_SERVER_IP_PORT").trim());
//			SDBClientFactory.sdbClient.setClientCertPath(classpath+fileseparator+"sdbconfig"+fileseparator+prop.getProperty("CLIENT_CERTS_CLIENTNAME").trim());
//			SDBClientFactory.sdbClient.setClientCertPswd(prop.getProperty("CLIENT_CERTS_PASSWORD").trim());
//			SDBClientFactory.sdbClient.setServerCertPath(classpath+fileseparator+"sdbconfig"+fileseparator+prop.getProperty("CLEINT_CERTS_SERVERNAME").trim());
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

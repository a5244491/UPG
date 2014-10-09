package com.yinhai.tcas.test;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;

import com.yinhai.tcas.model.PageWebBean;
import com.yinhai.tcas.model.QueryCondition;
import com.yinhai.tcas.webservice.TcasClientWebService;
import com.yinhai.tcas.webservice.client.interceptor.TcasClientInterceptor;

public class CasClient {
	private static final Logger logger = Logger.getLogger(CasClient.class); 
	
	public static void main(String args[]) throws Exception {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		// 注入拦截器，getOutInterceptors代表调用服务端时触发,getInInterceptors就是被调用才触发
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		// 拦截器安全验证
		TcasClientInterceptor tci = new TcasClientInterceptor();
		factory.getOutInterceptors().add(tci);
		factory.setServiceClass(TcasClientWebService.class);
		factory.setAddress("http://localhost:8080/tcas-server/ws/tcasClientService");
		TcasClientWebService tcws = (TcasClientWebService) factory.create();
		try {
			QueryCondition qc=new QueryCondition();
			qc.setCurPage(2);
			qc.setPageSize(2);
			PageWebBean result=tcws.queryCasUserListForPage(null, null,qc);
			logger.info(result.getList());
		} catch (SOAPFaultException e) {// WebService默认的异常信息描述
			e.printStackTrace();
			logger.info(e.getFault().getFaultString());
		}
	}

}

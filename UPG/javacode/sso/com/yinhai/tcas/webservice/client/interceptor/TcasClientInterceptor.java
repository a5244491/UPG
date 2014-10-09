package com.yinhai.tcas.webservice.client.interceptor;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.yinhai.tcas.util.CasUtil;
import com.yinhai.tcas.util.PropertiesUtil;
import com.yinhai.tcas.util.PropsKeys;

public class TcasClientInterceptor extends AbstractSoapInterceptor {
	public static final String xml_namespaceUR_att = "http://webservice.tcas.yinhai.com/";
	public static final String xml_header_el = "soap:Header";
	public static final String xml_authentication_el = "auth:authentication";
	public static final String xml_userID_el = "auth:companyid";
	public static final String xml_password_el = "auth:license";

	public TcasClientInterceptor() {
		super(Phase.WRITE);// 指定该拦截器在哪个阶段被激发
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		QName qname = new QName("RequestSOAPHeader");
		final String companyID = PropertiesUtil.get(PropsKeys.COMPANY_ID);
		final String license = PropertiesUtil.get(PropsKeys.LICENSE);
		if (CasUtil.isEmpty(companyID) || CasUtil.isEmpty(license)) {
			throw new Fault(
					new SOAPException(
							"tcas-client.properties文件必须配置companyid和license属性，否则无法进行WebService访问"));
		}
		Document doc = DOMUtils.createDocument();
		Element root = doc.createElement(xml_header_el);
		Element eUserId = doc.createElement(xml_userID_el);
		eUserId.setTextContent(companyID);
		Element ePwd = doc.createElement(xml_password_el);
		ePwd.setTextContent(license);
		Element child = doc.createElementNS(xml_namespaceUR_att,
				xml_authentication_el);
		child.appendChild(eUserId);
		child.appendChild(ePwd);
		root.appendChild(child);
		// XMLUtils.printDOM(root);// 只是打印xml内容到控制台,可删除
		SoapHeader head = new SoapHeader(qname, root);
		List<Header> headers = message.getHeaders();
		headers.add(head);
	}
}
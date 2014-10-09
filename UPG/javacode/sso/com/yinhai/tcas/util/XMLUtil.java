package com.yinhai.tcas.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;

public class XMLUtil {
	public static List<String> parserNoneFilterUrls(String fileName)
			throws Exception {
		List<String> noneFilterUrls = new ArrayList<String>();
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputXml);
		Element employees = document.getRootElement();
		for (Iterator i = employees.elementIterator(); i.hasNext();) {
			Element employee = (Element) i.next();
			for (Iterator j = employee.elementIterator(); j.hasNext();) {
				Element node = (Element) j.next();
				if (node.getName().equals("intercept-url")) {
					List<DefaultAttribute> attributes = node.attributes();//Checked
					String noneFilterUrl = null;
					boolean isNoneFilterUrl = false;
					for (DefaultAttribute attr : attributes) {
						if (attr.getName().toLowerCase().equals("filters")
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
		}
		return noneFilterUrls;
	}

	public static void main(String[] args) {
		try {
			List list = XMLUtil
					.parserNoneFilterUrls("E:\\yinhai\\svn\\JY11YF009\\04.Implement\\tcas-app\\demo\\javacode\\config\\spring-security.xml");
			//System.out.println(list);//Checked
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
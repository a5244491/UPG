package com.yinhai.tcas.util;

import java.io.InputStream;
import java.util.Properties;

public class ServerPathPropUtil {
	private static Properties prop;

	static {
		init();
	}

	public ServerPathPropUtil() {
	}

	private static void init() {
		try {
			if (prop == null) {
				prop = new Properties();
				InputStream in = null;
				in = ServerPathPropUtil.class.getResourceAsStream("/serverPath.properties");
				prop.load(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	public static String getCdecServerPath() {
		try {
			return prop.getProperty("server.cdec");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getEcadminServerPath() {
		try {
			return prop.getProperty("server.ecadmin");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getYhcrmServerPath() {
		try {
			return prop.getProperty("server.yhcrm");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getYhinfoServerPath() {
		try {
			return prop.getProperty("server.yhinfo");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getSysappServerPath() {
		try {
			return prop.getProperty("server.sysapp");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

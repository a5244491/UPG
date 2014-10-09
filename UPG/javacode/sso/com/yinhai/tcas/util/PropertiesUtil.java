package com.yinhai.tcas.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesUtil {

	private static PropertiesUtil instance;

	private static Properties initProp;

	private PropertiesUtil() {
	}

	private static Properties _getInstance() {
		if (instance == null || initProp == null) {
			instance = new PropertiesUtil();
			instance.init();
		}
		return initProp;
	}

	private void init() {
		initProp = new Properties();
		InputStream in = null;
		try {
			in = this.getClass().getResourceAsStream("/tcas/tcas-client.properties");
			initProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String get(String key) {
		String value = _getInstance().getProperty(key);
		if (value == null)
			return null;

		try {
			value = new String(value.getBytes("ISO8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String get(String key, String encoding) {
		String value = _getInstance().getProperty(key);
		if (value == null)
			return null;

		try {
			value = new String(value.getBytes("ISO8859-1"), encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;

	}

	public static void set(String key, String value) {
		_getInstance().setProperty(key, value);
	}

	public static boolean getBoolean(String key) {
		return GetterUtil.getBoolean(get(key));
	}
	
	public static long getLong(String key) {
		return GetterUtil.getLong(get(key));
	}

	public static void main(String[] args) {

	}
}

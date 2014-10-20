package com.yinhai.bcs.upg.pay3Interface.llpay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yinhai.bcs.upg.message.util.SignUtil;
import com.yinhai.bcs.upg.pay3Interface.llpay.enums.SignTypeEnum;
import com.yinhai.bcs.upg.pay3Interface.llpay.secu.Md5Algorithm;
import com.yinhai.bcs.upg.pay3Interface.llpay.secu.TraderRSAUtil;

/**
 * 常用工具函数
 * 
 * @author guoyx e-mail:guoyx@lianlian.com
 * @date:2013-6-25 下午05:23:05
 * @version :1.0
 * 
 */
public class LLPayUtil {
	protected final static Log log = LogFactory.getLog(LLPayUtil.class);

	/**
	 * 获取当前时间str，格式yyyyMMddHHmmss
	 * 
	 * @return
	 * @author guoyx
	 */
	public static String getCurrentDateTimeStr() {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String timeString = dataFormat.format(date);
		return timeString;
	}

	/**
	 * 
	 * 功能描述：获取真实的IP地址
	 * 
	 * @param request
	 * @return
	 * @author guoyx
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (!SignUtil.isnull(ip) && ip.contains(",")) {
			String[] ips = ip.split(",");
			ip = ips[ips.length - 1];
		}
		return ip;
	}



	/**
	 * 读取request流
	 * 
	 * @param req
	 * @return
	 * @author guoyx
	 */
	public static String readReqStr(HttpServletRequest request) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {

			}
		}
		return sb.toString();
	}
}

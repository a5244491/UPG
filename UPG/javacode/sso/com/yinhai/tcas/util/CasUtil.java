package com.yinhai.tcas.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.CommonUtils;

import com.yinhai.tcas.model.MapConvertor;
import com.yinhai.tcas.model.Operator;

/**
 * 工具类 huangyh
 * 
 * @author com.yinhai
 * 
 */
public class CasUtil {

	public static List<MapConvertor> toMapConvertorInList(
			List<Map<String, Object>> mapList) {
		List<MapConvertor> mapConvertorList = new ArrayList<MapConvertor>();
		for (Map<String, Object> map : mapList) {
			MapConvertor mc = new MapConvertor();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				MapConvertor.MapEntry e = new MapConvertor.MapEntry(entry);// Checked
				mc.addEntry(e);
			}
			mapConvertorList.add(mc);
		}
		return mapConvertorList;
	}

	public static List<Map<String, Object>> toMapInList(
			List<MapConvertor> mapConvertorList) {
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		for (MapConvertor mc : mapConvertorList) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (MapConvertor.MapEntry e : mc.getEntries()) {
				map.put(e.getKey(), e.getValue());
			}
			maplist.add(map);
		}
		return maplist;
	}

	public static boolean isEmpty(Object object) {
		if (object == null)
			return true;
		if ((object instanceof String)) {
			if (((String) object).trim().length() == 0
					|| "null".equals(((String) object).trim().toLowerCase()))
				return true;
		} else if ((object instanceof Collection)) {
			if (((Collection) object).size() == 0)
				return true;
		} else if ((object instanceof Map)) {
			if (((Map) object).size() == 0)
				return true;
		}
		return false;
	}

	public static String printDate(Long longValue) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(parseDate(longValue));
	}

	public static Date parseDate(long longValue) {
		return new Date(longValue);
	}

	public static boolean isSameDay(Date date1, Date date2) {
		return date1.getDate() == date2.getDate();
	}

	public static int calBetweenDays(long longValue1, long longValue2) {
		long betweenDays = ((longValue1 - longValue2) / 1000) / (60 * 60 * 24);
		return Math.abs((int) betweenDays);
	}

	/**
	 * 检测JavaBean对象指定属性是否存在空属性值
	 * 
	 * @param javaBean
	 * @param attributeNames
	 *            未设置则检测所有的属性值
	 * @throws Exception
	 */
	public static void checkJavaBean(Object javaBean, String[] attributeNames)
			throws Exception {
		Method[] methods = javaBean.getClass().getMethods();
		boolean isSetAttributeNames = (attributeNames == null || attributeNames.length == 0) ? false
				: true;
		if (isSetAttributeNames) {
			for (String setAttributeName : attributeNames) {
				for (int i = 0; i < methods.length; i++) {
					Method method = methods[i];
					if (method.getName().startsWith("get")) {
						String attributeName = method.getName().substring(3)
								.toLowerCase();// Checked
						if (setAttributeName.toLowerCase()
								.equals(attributeName)
								&& CasUtil.isEmpty(method.invoke(javaBean))) {
							throw new IllegalArgumentException("the attribute "
									+ attributeName + " value of "
									+ javaBean.getClass().getName()
									+ " is null");
						}
					}
				}
			}
		} else {
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if (method.getName().startsWith("get")) {
					String attributeName = method.getName().substring(3)
							.toLowerCase();// Checked
					if (CasUtil.isEmpty(method.invoke(javaBean))) {
						throw new IllegalArgumentException("the attribute "
								+ attributeName + " value of "
								+ javaBean.getClass().getName() + " is null");
					}
				}
			}
		}
	}

	/**
	 * 检测JavaBean对象指定属性是否存在空属性值
	 * 
	 * @param javaBean
	 * @param includeAttributeNames
	 * @param exceptAttributeNames
	 * @throws Exception
	 */
	public static void checkJavaBean(Object javaBean,
			String[] includeAttributeNames, String[] exceptAttributeNames)
			throws Exception {
		Method[] methods = javaBean.getClass().getMethods();
		List<String> includeList = null, exceptList = null, allAttributeList = null, checkAttributeList = null;
		if (includeAttributeNames != null && includeAttributeNames.length > 0) {
			includeList = new ArrayList<String>();
			Collections.addAll(includeList, includeAttributeNames);
		}
		if (exceptAttributeNames != null && exceptAttributeNames.length > 0) {
			exceptList = new ArrayList<String>();
			Collections.addAll(exceptList, exceptAttributeNames);
		}
		for (int i = 0; i < methods.length; i++) {
			if (allAttributeList == null) {
				allAttributeList = new ArrayList<String>();
			}
			Method method = methods[i];
			if (method.getName().startsWith("get")) {
				allAttributeList.add(method.getName().substring(3)
						.toLowerCase());
			}
		}
		checkAttributeList = new ArrayList<String>();
		if (includeList != null && includeList.size() > 0) {
			includeList.removeAll(exceptList);
			checkAttributeList.addAll(includeList);
		} else {
			allAttributeList.removeAll(exceptList);
			checkAttributeList.addAll(allAttributeList);
		}
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().startsWith("get")) {
				String attributeName = method.getName().substring(3)
						.toLowerCase();// Checked
				if (checkAttributeList.contains(attributeName)
						&& CasUtil.isEmpty(method.invoke(javaBean))) {
					throw new IllegalArgumentException("the attribute "
							+ attributeName + " value of "
							+ javaBean.getClass().getName() + " is null");
				}
			}
		}
	}

	// 获取操作动作
	public static String getOperateAction(String operate_type) {
		if (isEmpty(operate_type)) {
			return "未知操作";
		} else if (IConst.ACTION_NEW_CAS_USER.equals(operate_type)) {
			return "新增Cas用户";
		} else if (IConst.ACTION_NEW_CAS_USER_MAPPING.equals(operate_type)) {
			return "新增Cas用户映射";
		} else if (IConst.ACTION_NEW_CAS_USER_CASCADE_MAPPING
				.equals(operate_type)) {
			return "新增Cas用户并级联新增Cas用户映射";
		} else if (IConst.ACTION_EDIT_CAS_USER.equals(operate_type)) {
			return "修改Cas用户";
		} else if (IConst.ACTION_EDIT_CAS_USER_MAPPING.equals(operate_type)) {
			return "修改Cas用户映射";
		} else if (IConst.ACTION_OFF_CAS_USER_MAPPING.equals(operate_type)) {
			return "注销Cas用户映射";
		} else if (IConst.ACTION_LOCK_CAS_USER_MAPPING.equals(operate_type)) {
			return "锁定Cas用户映射";
		} else if (IConst.ACTION_UNLOCK_CAS_USER_MAPPING.equals(operate_type)) {
			return "解锁Cas用户映射";
		} else if (IConst.ACTION_PASS_NEW_CAS_USER_MAPPING.equals(operate_type)) {
			return "审核通过Client新增Cas用户映射生效";
		} else if (IConst.ACTION_REFUSE_NEW_CAS_USER_MAPPING
				.equals(operate_type)) {
			return "审核拒绝Client新增Cas用户映射生效";
		} else if (IConst.ACTION_DELETE_CAS_USER_CASCADE_MAPPING
				.equals(operate_type)) {
			return "删除Cas用户并级联删除Cas用户映射";
		} else if (IConst.ACTION_DELETE_CAS_USER_MAPPING.equals(operate_type)) {
			return "删除Cas用户映射";
		} else {
			return "未知操作";
		}
	}

	public static String constructServiceUrl(final HttpServletRequest request,
			final HttpServletResponse response, final String service,
			final String serverName, final String artifactParameterName,
			final boolean encode) {
		if (CommonUtils.isNotBlank(service)) {
			return encode ? response.encodeURL(service) : service;
		}

		final StringBuilder buffer = new StringBuilder();

		if (!serverName.startsWith("https://")
				&& !serverName.startsWith("http://")) {
			buffer.append(request.isSecure() ? "https://" : "http://");
		}
		buffer.append(serverName);
		buffer.append((request.getContextPath() + "/").equals(request
				.getRequestURI()) ? (request.getRequestURI() + request
				.getServletPath().substring(1)) : request.getRequestURI());

		if (CommonUtils.isNotBlank(request.getQueryString())) {
			final int location = request.getQueryString().indexOf(
					artifactParameterName + "=");

			if (location == 0) {
				final String returnValue = encode ? response.encodeURL(buffer
						.toString()) : buffer.toString();
				return returnValue;
			}
			buffer.append("?");
			if (location == -1) {
				buffer.append(request.getQueryString());
			} else if (location > 0) {
				final int actualLocation = request.getQueryString().indexOf(
						"&" + artifactParameterName + "=");

				if (actualLocation == -1) {
					buffer.append(request.getQueryString());
				} else if (actualLocation > 0) {
					buffer.append(request.getQueryString().substring(0,
							actualLocation));
				}
			}
		}

		final String returnValue = encode ? response.encodeURL(buffer
				.toString()) : buffer.toString();
		return returnValue;
	}

	public static void main(String[] args) {
		Operator op = new Operator();
		op.setSystemID("1");
		op.setUserID("1");
		// op.setUserIPAddress("1");
		// op.setUserName("1");
		try {
			CasUtil.checkJavaBean(op, new String[] { "SystemID", "UserID",
					"userIpAddress" }, new String[] { "userIpAddress" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
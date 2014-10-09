<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.yinhai.bcs.upg.common.util.IConstants"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
支付成功 !  success!
<%		
			StringBuffer sbHtml = new StringBuffer();
			Map<String, String[]> requsetMap = request.getParameterMap();
			if(requsetMap != null){
				for(String key : requsetMap.keySet()){
					if(requsetMap.get(key) != null){
						if(requsetMap.get(key).length > 0){
							
				            String[] value = requsetMap.get(key);
				            sbHtml.append("<label>"+ key +"</label><input name=\"" + key + "\" value=\"" + value + "\"/> </br>");
				            //map.put(key, requsetMap.get(key)[0]);
						}
					}
				}
				out.println(sbHtml.toString());
			}
			//Map postDataMap=(Map)request.getParameter(IConstants.FPAY_RETURN_DATA);
			
%>


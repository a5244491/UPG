success
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.mysql.jdbc.Driver" %> 
<%@page import="java.sql.*" %>
<%@page import="java.util.Map"%>
<%
	/* Map<String,String[]> postParam = request.getParameterMap();
	String posturl="";
	
	for(String key:postParam.keySet()){
		if(postParam.get(key).length>0){
			posturl+=key+"="+postParam.get(key)[0]+"&";
		}
	}
	
	
	String username=SaeUserInfo.getAccessKey();
	String password=SaeUserInfo.getSecretKey();
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_hmyujian";
	Class.forName(driver).newInstance();
	Connection conn=DriverManager.getConnection(url,username,password);
	Statement stmt = conn.createStatement(); 

	
	

	String insert_sql = "insert into test values( 0, sysdate(), 'notify_url', '" + posturl + "')"; 
	try { 
		stmt.execute(insert_sql); 
	}catch(Exception e) { 
		e.printStackTrace(); 
	}
	stmt.close(); 
	conn.close(); */
%>
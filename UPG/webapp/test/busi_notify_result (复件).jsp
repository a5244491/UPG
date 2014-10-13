<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.io.BufferedReader"%>
success
<%

		BufferedReader br =request.getReader();
		String reqData="";
		String tmp="";
		while((tmp=br.readLine())!=null){
			reqData+=tmp;
		}

		System.out.println("收到支付结果异步通知！");
		
		System.out.println("所有数据："+reqData);
		
  		System.out.println("支付流水(opSn)："+request.getParameter("opSn"));
        System.out.println("clientId："+request.getParameter("clientId"));
       	System.out.println("serviceId："+request.getParameter("serviceId"));
       	System.out.println("signData："+request.getParameter("signData"));
       	System.out.println("trade_sn："+request.getParameter("trade_sn"));
       	System.out.println("pay_deal_status："+request.getParameter("pay_deal_status")); 
       	System.out.println("pay_result："+request.getParameter("pay_result"));
        System.out.println("biz_back_params："+request.getParameter("biz_back_params"));
%>

<html>
  <head>
    <title>支付成功</title>
  </head>
  <body>
        亲，支付成功啦！<BR>
        错误原因: ${requestScope.FPAY_EEROR_MSG}<BR>
  </body>
</html>

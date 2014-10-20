<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.yinhai.bcs.upg.message.util.MessageUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.yinhai.bcs.upg.common.util.SpringContextUtil"%>
<%@page import="com.yinhai.bcs.upg.pay3Interface.llpay.PartnerConfig"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>支付测试页面</title>
	</head>
	<body>
	<div align="left" style="margin-left: 300">
	
	<h2>准备提交到支付页面....</h2>
	<form name="payForm" action="<%=request.getContextPath() %>/test/payFService!service.do" method=post >
				<input type="hidden" size="30" name="client_id" value="<%=request.getParameter("client_id") %>"/>
				<input type="hidden" size="30" name="service_id" value="<%=request.getParameter("service_id") %>"/>
				<input type="hidden" size="30" name="opt_sn" value="<%=request.getParameter("opt_sn") %>"/>
				<input type="hidden" size="30" name="trade_sn" value="<%=request.getParameter("trade_sn") %>"/>
				<input type="hidden" size="30" name="trade_desc" value="<%=request.getParameter("trade_desc") %>"/>
				<input type="hidden" size="30" name="trade_balance" value="<%=request.getParameter("trade_balance") %>"/>
				<input type="hidden" size="30" name="biz_back_params" value="<%=request.getParameter("biz_back_params") %>" />
				<input type="hidden" size="30" name="pay_account" value="<%=request.getParameter("pay_account") %>" />
				<input type="hidden" size="30" name="receive_account" value="<%=request.getParameter("receive_account") %>" />
				<input type="hidden" size="30" name="trade_psw" value="<%=request.getParameter("trade_psw") %>" />
				
				<%
					Map<String,String> paramMap=new HashMap<String,String>();
					paramMap.put("service_id",request.getParameter("service_id"));
					paramMap.put("client_id",request.getParameter("client_id"));
					paramMap.put("opt_sn",request.getParameter("opt_sn"));
					paramMap.put("trade_sn",request.getParameter("trade_sn"));
					paramMap.put("trade_balance",request.getParameter("trade_balance"));
					
					
					//String signData=MessageUtil.signFPayMessage(paramMap,"/home/cq/test/colmscs@100000000000001.p12","colmscs123456");
					String prikey = ( (PartnerConfig) SpringContextUtil.getBean("llpayConfig")).getTRADER_PRI_KEY();
					System.out.println("客户私钥：" + prikey);
					//String signData=MessageUtil.signFPayMessageRSA(MessageUtil.geneFpayMsg(paramMap), MessageUtil.readFile("/home/cq/.ssh/rsa_pri_pkcs8.pem"));
					String signData=MessageUtil.signFPayMessageRSA(MessageUtil.geneFpayMsg(paramMap), prikey);
				 %>
				
				<input size="30" name="sign_data" value="<%=signData%>" />
				<input size="30" name="return_url" value="<%=request.getParameter("return_url") %>" />
				<input size="30" name="notify_url" value="<%=request.getParameter("notify_url") %>" />
				<input size="30" name="default_bank" value="<%=request.getParameter("default_bank") %>" />
	</form>

		<script type="text/javascript">
			//var form2 = document.getElementById("goPayForm");
			document.forms['payForm'].submit();
			
    		//form2.submit();
    		//alert(1);
		</script>
	</body>
</html>

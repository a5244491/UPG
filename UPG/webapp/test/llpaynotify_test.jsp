<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.mysql.jdbc.Driver" %> 
<%@page import="java.sql.*" %>
<%@page import="java.util.Map"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>连连支付异步通知消息测试页</title>
	</head>
	<body>
	<div align="left" style="margin-left: 300">
	
	<h2>连连支付异步通知测试页面</h2>
	*号字段为必填
	<!-- <form name="payForm" action="<%=request.getContextPath() %>/test/payResultNoticeListener.do" method=post > -->
	<form name="payForm" action="http://192.168.9.197:8080/UPG/test/payResultNoticeListener.do" method=post >
			<dt>商户唯一订单号 out_trade_no：</dt>
				<input size="32" name="out_trade_no" value="10239001201410091108401410000015"/>
			<dt>商户编号 oid_partner：</dt>
				<input size="30" name="oid_partner" value="201408071000001546"/>
			<dt>签名方式 sign_type ：</dt>
				<input size="30" name="sign_type" value="MD5"/>
			<dt>签名 sign：</dt>
				<input size="30" name="sign" value="248c15ad1709ccb0d0bd03ca843b20f6" />
			<dt>dt_order：唱户订单时间</dt>
				<input size="30" name="notify_time" value="2014-05-20 10:25:16" />
			<dt>商户唯一订单号 no_order：</dt>
				<input size="30" name="no_order" value="10239001201410081123083970000024"/>
			<dt>交易金额 money_order：</dt>
				<input size="30" name="money_order" value="0.01"/>
			<dt>支付结果  result_pay：</dt>
				<input size="30" name="result_pay" value="SUCCESS" />*
			<dt>清算日期 settle_date：</dt>
				<input size="30" name="settle_date" value="2014-05-20 10:25:16" />
			<dt>订单描述 info_order：</dt>
				<input size="30" name="info_order" value="可口可乐"/>
			<dt>支付方式 pay_type：</dt> 1:网银支付(借记卡)
8:网银支付(信用卡)
2:快捷支付(借记卡)
3:快捷支付(信用卡)
9:B2B 企业网银支付<br/>
				<input size="30" name="pay_type" value="" />
			<dt>银行编号 bank_code：</dt>
				<input size="30" name="bank_code" value="" />
			<dt>签约协议号 no_agree：</dt>
				<input size="30" name="no_agree" value="" />
			<dt>证件类型 id_type：</dt>
				<input size="30" name="id_type" value="" />
			<dt>证件号码 id_no：</dt>
				<input size="30" name="id_no" value="" />
			<dt>银行账号姓名 acct_name	：</dt>
				<input size="30" name="acct_name" value="" />
		
			
			<br/>
			<button type="submit">确 认</button>
		</form>
	</div>
	</body>
</html>
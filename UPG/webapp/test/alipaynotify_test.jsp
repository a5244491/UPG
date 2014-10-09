<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.mysql.jdbc.Driver" %> 
<%@page import="java.sql.*" %>
<%@page import="java.util.Map"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>支付宝异通知消息测试页</title>
	</head>
	<body>
	<div align="left" style="margin-left: 300">
	
	<h2>支付宝异步通知测试页面</h2>
	*号字段为必填
	<!-- <form name="payForm" action="<%=request.getContextPath() %>/test/payResultNoticeListener.do" method=post > -->
	<form name="payForm" action="http://192.168.9.197:8080/UPG/test/payResultNoticeListener.do" method=post >
	
			<dt>subject：</dt>
				<input size="30" name="subject" value="可口可乐"/>
			<dt>sign_type：</dt>
				<input size="30" name="sign_type" value="MD5"/>
			<dt>is_total_fee_adjust：</dt>
				<input size="30" name="is_total_fee_adjust" value="N"/>
			<dt>notify_type：</dt>
				<input size="30" name="notify_type" value="trade_status_sync"/>
			<dt>out_trade_no：</dt>
				<input size="30" name="out_trade_no" value="1023900120140923150302195292"/>
			<dt>buyer_email:</dt>
				<input size="30" name="buyer_email" value="lklk0@163.com"/>
			<dt>extra_common_param：</dt>
				<input size="30" name="extra_common_param" value="@yhpay@1002900120140604165019316876"/>*
			<dt>total_fee：</dt>
				<input size="30" name="total_fee" value="0.01"/>
			<dt>quantity：</dt>
				<input size="30" name="quantity" value="1"/>
			<dt>buyer_id：</dt>
				<input size="30" name="buyer_id" value="2088002190665739" />
			<dt>trade_no：</dt>
				<input size="30" name="trade_no" value="2014052045979473" />
			<dt>notify_time：</dt>
				<input size="30" name="notify_time" value="2014-05-20 10:25:16" />
			<dt>use_coupon：</dt>
				<input size="30" name="use_coupon" value="N" />
			<dt>trade_status：</dt>
				<input size="30" name="trade_status" value="SUCCESS" />*
			<dt>gmt_payment：</dt>
				<input size="30" name="gmt_payment" value="2014-05-20 10:25:16" />
			<dt>discount：</dt>
				<input size="30" name="discount" value="0.00" />
			<dt>sign：</dt>
				<input size="30" name="sign_data" value="019d94c1189ddd2d0ce644d42d6b45a6" />
			<dt>gmt_create：</dt>
				<input size="30" name="gmt_create" value="2014-05-20 10:25:02" />
			<dt>price：</dt>
				<input size="30" name="price" value="0.01" />
			<dt>gmt_create：</dt>
				<input size="30" name="gmt_create" value="2014-05-20 10:25:02" />
			<dt>seller_id：</dt>
				<input size="30" name="seller_id" value="2088411579626674" />
			<br>
			<dt>seller_email：</dt>
				<input size="30" name="seller_email" value="liukaiy@yinhai.com" />
			<br>
			<dt>notify_id：</dt>
				<input size="30" name="return_url" value="c66ae7b8e3767979919ebdfc6a52588d62" />
			<br>
			<dt>payment_type：</dt>
				<input size="30" name="payment_type" value="1" />
			<br>
			<button type="submit">确 认</button>
		</form>
	</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.yinhai.bcs.upg.message.util.MessageUtil"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>支付测试页面</title>
	</head>	
	<body>
	<div align="left" style="margin-left: 300">
	
	<h2>支付测试页面</h2>
	*号字段为必填
	<form name="payForm" action="<%=request.getContextPath() %>/test/go_pay_test.jsp" method=post target="_blank">
			<dt>客户ID：</dt>
				<input size="30" name="client_id" value="9001"/>*(平台分配)
			<dt>服务ID：</dt>
				<input size="30" name="service_id" value="1023"/>*(平台分配)
			<dt>交易流水号：</dt>
				<input size="30" name="opt_sn" value="<%=MessageUtil.createSN("1023","9001") %>"/>*(服务ID+客户ID+yyMMddHHmmssxxxxxx)
			<dt>订单编号：</dt>
				<input size="30" name="trade_sn" value="34324343551"/>*(必填，商户网站唯一订单号)
			<dt>订单描述：</dt>
				<input size="30" name="trade_desc" value="可口可乐"/>
			<dt>付款金额：</dt>
				<input size="30" name="trade_balance" value="0.01"/>*
			<dt>支付密码：</dt>
				<input type="password" size="30" name="trade_psw" value="123456"/>*（可空，根据业务情况填写）	
			<dt>业务回传参数：</dt>
				<input size="30" name="biz_back_params" value="" />（交易完后，原样返回）
			<dt>付款虚拟子账户账号：</dt>
				<input size="30" name="pay_account" value="3" />（可空，根据业务情况填写）		
			<dt>收款虚拟子账户账号：</dt>
				<input size="30" name="receive_account" value="1" />（可空，根据业务情况填写）	
			
			<dt>同步返回地址：</dt>
				<input size="30" name="return_url" value="/UPG/test/busi_return_result.jsp" />*
			<dt>异步通知地址：</dt>
				<input size="30" name="notify_url" value="http://nat.nat123.net:25458/UPG/test/busi_notify_result.jsp" />*
			<br>
			<button type="submit">确 认</button>
		</form>
	</div>
	
	</body>
</html>

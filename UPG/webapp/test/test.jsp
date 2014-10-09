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
				<input size="30" name="service_id" value="1005"/>*(平台分配)
			<dt>交易流水号：</dt>
				<input size="30" name="opt_sn" value="<%=MessageUtil.createSN("1005","9001") %>"/>*(服务ID+客户ID+yyMMddHHmmssxxxxxx)
			<dt>订单编号：</dt>
				<input size="30" name="trade_sn" value="1000009000"/>*(必填，商户网站唯一订单号)
			<dt>订单描述：</dt>
				<input size="30" name="trade_desc" value="小米2s智能手机"/>
			<dt>付款金额：</dt>
				<input size="30" name="trade_balance" value="0.01"/>*
			<dt>业务回传参数：</dt>
				<input size="30" name="biz_back_params" value="" />（交易完后，原样返回）
			<dt>付款虚拟子账户账号：</dt>
				<input size="30" name="pay_account" value="" />（可空，根据业务情况填写）		
			<dt>收款虚拟子账户账号：</dt>
				<input size="30" name="receive_account" value="" />（可空，根据业务情况填写）	
			<dt>签名：</dt>
				<input size="30" name="sign_data" value="1234qwerasdfzxcv" />*(使用客户端私钥签名)
			<br>
			<dt>返回地址：</dt>
				<input size="30" name="return_url" value="http://127.0.0.1:8808/UPG/test/payResult.jsp" />*
			<dt>通知地址：</dt>
				<input size="30" name="notify_url" value="http://127.0.0.1:8808/UPG/test/payResult.jsp" />*
			<br>
			<dt>使用缺省银行（EPay）：</dt>
			<select id="default_bank" name="default_bank">
				<option id="300904" value="300904">中国民生银行（CMBC）</option>
				<option id="100204" value="100204">中国银行（BOC）</option>
				<option id="100304" value="100304">农业银行（ABC）</option>
				<option id="200304" value="200304">工商银行（ICBC）</option>
				<option id="200404" value="200404">建设银行（CCB）</option>
				<option id="200504" value="200504">交通银行（BCOM）</option>
				<option id="300104" value="300104">中信银行（CITIC）</option>
				<option id="300204" value="300204">华夏银行（hxb）</option>
				<option id="300304" value="300304">招商银行（CMB）</option>
				<option id="300504" value="300504">兴业银行（CIB）</option>
				<option id="300604" value="300604">中国光大银行（CEB）</option>
				<option id="300804" value="300804">上海浦东发展银行（SPDB）</option>
			</select>
			（默认为民生银行）
			<br>
			<button type="submit">确 认</button>
		</form>
	</div>
	
	</body>
</html>

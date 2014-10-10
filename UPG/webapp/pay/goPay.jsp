<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.yinhai.bcs.upg.common.util.IConstants"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
	</head>
	<script>
		//alert(0);
	</script>
	<body>
		正常在为您跳转到支付页面，请稍后...<br>
		<BR>
		<form id="goPayForm" name="goPayForm" action="${requestScope.FPAY_POST_URL}" method="post">
		<%
			Map postDataMap=(Map)request.getAttribute(IConstants.FPAY_POST_DATA);
			if(postDataMap!=null){
				List<String> keys = new ArrayList<String>(postDataMap.keySet());
	        	StringBuffer sbHtml = new StringBuffer();
		        for (int i = 0; i < keys.size(); i++) {
		            String name = (String) keys.get(i);
		            String value = (String) postDataMap.get(name);
		            sbHtml.append("<label>"+ name +"</label><input name=\"" + name + "\" value=\"" + value + "\"/> </br>");
		        }
		        out.println(sbHtml.toString());
			}
		 %>
		</form>
		<button id="sub" onclick="document.forms['goPayForm'].submit();">submit</button> 
		<script type="text/javascript">
			//document.forms['goPayForm'].submit();
		</script>
	</body>
</html>


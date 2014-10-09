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
	<body>
		正常在为您跳转到支付结果页面，请稍后...<br>
		
		<BR>
		<form id="goReturnForm" name="goReturnForm" action="${requestScope.FPAY_POST_URL}" method="post">
		<%
			Map postDataMap=(Map)request.getAttribute(IConstants.FPAY_POST_DATA);
			if(postDataMap!=null){
				List<String> keys = new ArrayList<String>(postDataMap.keySet());
	        	StringBuffer sbHtml = new StringBuffer();
		        for (int i = 0; i < keys.size(); i++) {
		            String name = (String) keys.get(i);
		            String value = (String) postDataMap.get(name);
		
		            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
		        }
		        out.println(sbHtml.toString());
			}
		 %>
			
		</form>
		<script type="text/javascript">
			document.forms['goPayForm'].submit();
		</script>
	</body>
</html>


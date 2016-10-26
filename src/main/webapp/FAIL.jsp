<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fail</title>
</head>
<body>
	<p>access token get fail !</p>
	<p>click "刷新" to restart the thread!</p>
	<%
		String appid = (String) request.getAttribute("appid");
		String appsecret = (String) request.getAttribute("appsecret");
	%>
	<form action="./index.do" method="post">
		<input type="hidden" id="appid" name="appid" value=appid /> <input
			type="hidden" id="appsecret" name="appsecret" value=appsecret /> <input
			type="submit" value="刷新" />
	</form>
</body>
</html>
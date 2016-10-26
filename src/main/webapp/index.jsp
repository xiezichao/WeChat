<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<script type="text/javascript" src="./js/index.js"> </script>
</head>
<body>
	<p>Input your appid and appsecret</p>
	<p>then click the button!</p>
	<form action="./index.do" method="post">
		<tr>
			<td>
				appid: <input type="text" name="appid" value="appid"/>
			</td>
		</tr>
		<tr>
			<td>
				appsecret: <input type="password" name="appsecret" value="appsecret"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="提交"/>
			</td>
		</tr>
	</form>
</body>
</html>
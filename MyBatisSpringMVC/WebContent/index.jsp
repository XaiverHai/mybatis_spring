<%@ page import="java.sql.*" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>
	<center>
		<form action="login" method="post">
			username:<input type="text" name="username">
			<p>
				password:<input type="password" name="password">
			<p>
				<input type="submit" value="登录">
		</form>
	</center>
</body>
</html>
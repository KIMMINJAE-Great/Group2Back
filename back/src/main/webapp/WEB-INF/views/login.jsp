<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form method="post" action="/login">
		ID : <input type="text" name="username">
		PW : <input type="password" name="password">
		<input type="submit" value="로그인 전송">
	</form>
</body>
</html>
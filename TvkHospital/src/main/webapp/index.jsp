<%@page import="models.Credentials"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<form action="login" method="post">
<input type="text" placeholder="Username" name="username"><br><br>
<input type="password" placeholder="Password" name="password"><br><br>
<% if(!Credentials.isValid) {%>
	<span style="color:red">Invalid credentials</span><br><br>
<%}%>
<input type="submit" name="action" value="login">
</form>
</body>
</html>
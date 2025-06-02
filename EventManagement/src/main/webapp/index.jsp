<%@page import="entity.Credentials"%>
<%@page import="service.AuthService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
Login<br><br>
<form action="login" method = "POST">
<input placeholder = "Username" name = "username" required="required">
<br><br>
<input type="password" placeholder="Password" name="password" required="required">
<%
String password = request.getParameter("password");
    if (password != null && !Credentials.isValid) {
%>
    <br><span style="color:red;">Invalid Credentials !</span>
<% 
    } 
%>
<br><br>
<input type = "submit" name = "action" value = "login">
</form>
</body>
</html>
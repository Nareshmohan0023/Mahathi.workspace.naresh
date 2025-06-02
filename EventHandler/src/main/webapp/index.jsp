<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Hi, Admin</h1></center>
<form action="Login" method="post" style="display:flex;align-items:center;justify-content:center;flex-direction:column;gap:9px;">

<input type=text name="userName" placeholder="UserName:">
<input type=text name="password" placeholder="password">
<input type=submit name="action" value="validate" >

<c:if test="${not empty message}">
<p>${message}</p>
</c:if>
</form>

<p>New User?<a href="Login?action=newUser" >Click here</a></p>

</body>
</html>
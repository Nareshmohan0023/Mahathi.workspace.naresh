<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body style="display:flex;align-items:center;justify-content:center;flex-direction:column">
<h1>Register Here!</h1>
<form action=RegisterServlet method=post style="display:flex;gap:8px;flex-direction:column;align-items:center;justify-content:center;">

<input type=text placeholder="Name" name="name">
<input type=text placeholder="User Name" name="userName">
<input type=text placeholder="Password" name="password">
<input type=submit value="submit">
<%
String msg=(String)request.getAttribute("message");
if(msg!=null){
%>

<p style="color:red"><%=msg %></p>

<%} %>
<a href="LoginServlet">Already a user</a>

</form>

</body>
</html>
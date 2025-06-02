<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<table border='1'>
	<tr>
	<c:forEach var="column" items="${col}">
		<td>${column}</td>
	</c:forEach>
	</tr>

	<c:forEach var="row" items="${row}">
		<tr>
		<c:forEach var="column" items="${col}">
			<td>${row[column]}</td>
		</c:forEach>
		</tr>
	</c:forEach>
</table>
Register to event:
<br><br>
<form action="admin" method = "POST">
<input type = "text" placeholder="EVENT-ID" name = "eId" required="required"></input><br><br>
<input type = "text" placeholder="PARTICIPANT-ID" name = "pId" required="required"></input><br><br>
<input type = "submit" name = "action" value = "register">
</form>
</body>
</html>
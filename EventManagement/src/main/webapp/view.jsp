<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display events</title>
</head>
<body>
<script src = "eventEdit.js"></script>
<form action="login" method = "POST">
<input type = "submit" name ="action" value = "Back">
</form><br>
<table border='1' id = "editTable">
	<tr>
	<c:forEach var="column" items="${columns}">
		<td>${column}</td>
	</c:forEach>
	</tr>

	<c:forEach var="row" items="${rows}">
		<tr>
		<c:forEach var="column" items="${columns}">
			<td data-column="${column}" data-eid ="${row['EVENT_ID']}">${row[column]}</td>
		</c:forEach>
		</tr>
	</c:forEach>
</table>
Delete:
<form action = "admin" method = "POST">
<input type = "text" placeholder="Event-ID" name = "Id"></input>
<input type = "submit" name = "action" value = "delete-event">
</form>

</body>
</html>
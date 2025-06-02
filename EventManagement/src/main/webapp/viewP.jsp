<%@page import="servlet.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display participants</title>
</head>
<body>
<script src ="participantEdit.js" type="text/javascript"></script>
<% String name = Login.getpName(); 
   String pwd =Login.getPwd();
	%>
<form action="login" method="post">
<input type = "hidden" name = "action" value="login">
<input type ="hidden" name = "username" value=<%=name%>></input>
<input type ="hidden" name = "password" value=<%=pwd%>></input>
<button type ="submit">Back</button>
</form>
<br>
<table border='1' id = "editTable">
	<tr>
	<c:forEach var="column" items="${columns}">
		<td>${column}</td>
	</c:forEach>
	</tr>

	<c:forEach var="row" items="${rows}">
		<tr>
		<c:forEach var="column" items="${columns}">
			<td data-column="${column}" data-pid ="${row['P_ID']}">${row[column]}</td>
		</c:forEach>
		</tr>
	</c:forEach>
</table>
Delete:
<form action = "admin" method = "POST">
<input type = "text" placeholder="Partcipant-ID" name = "Id"></input>
<input type = "submit" name = "action" value = "delete-participant">
</form>
</body>
</html>
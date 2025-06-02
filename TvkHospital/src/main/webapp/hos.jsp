<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TVK hospital</title>
</head>
<body>
<script src="editDoc.js" ></script>
<table border = '1' id ="editTable">
<tr>
	<c:forEach var="column" items="${columns}">
		<td>${column}</td>
	</c:forEach>
</tr>
	<c:forEach var="row" items="${rows}">
		<tr>
			<c:forEach var="column" items="${columns}">
				<td data-column="${column}" data-docid="${row['docId']}">${row[column]}</td>
			</c:forEach>
		</tr>	
	</c:forEach>
</table>
<br>
Delete Doctor<br>
---------------------------------------------------------------------------------------------------------------------------------
<form action="doctor" method="post">
	<input type ="text" placeholder="Doctor id" name="docId" required="required">
	<button type ="submit" name="action" value="delete">Delete</button>
	<% 	String addError = (String)request.getAttribute("docError");
		if(addError != null){ %>
		<span style="color: red;"><%= addError %></span>
	<%} %>
</form><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View appointment</title>
</head>
<body>
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
</body>
</html>
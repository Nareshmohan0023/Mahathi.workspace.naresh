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
	<table border="1">
	
	<tr>
	<c:forEach var="column" items="${columns}">
	<th>${column}</th>
	</c:forEach>
	</tr>
	
	
	<c:forEach var="row" items="${rows}">
	<tr>
	<c:forEach var="column" items="${columns}">
	<td>${row[column]}</td>
	</c:forEach>
	<tr>
	
	</c:forEach>
	</table>

</body>
</html>
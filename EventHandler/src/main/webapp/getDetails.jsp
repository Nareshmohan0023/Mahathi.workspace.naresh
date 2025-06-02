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

	<form action="Admin" method="post">
	<c:forEach var="row" items="${rows}">
	<c:forEach var="column" items="${columns }">
	<label for="${column}">${column}</label>
	<input type="text" name="${column}" value="${row[column]}" >
	</c:forEach>
	</c:forEach>
	<input type="hidden" name="action" value="makeChanges">
	<input type="hidden" name="id" value="${id}">
	<input type="submit" value="submit">
	</form>

</body>
</html>
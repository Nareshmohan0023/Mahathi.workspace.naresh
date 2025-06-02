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

<form action=Login method="post">

<input type="text" name="name" placeholder="Enter The Name">
<input type="text" name="userName" placeholder="Enter The Name">
<input type="text" name="password" placeholder="Enter The Password">
<input type="submit" name="action" value="addAdmin">
<c:if test="${not empty message}">
<p>"${message}"</p>
</c:if>
</form>

</body>
</html>
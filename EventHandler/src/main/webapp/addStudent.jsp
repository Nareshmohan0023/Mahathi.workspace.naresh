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
<h1>Add Student:</h1>
<form action="Admin" method="post">
<input type="text" name="name" placeholder="Name">
<input type="text" name="email" placeholder="Email">
<input type="text" name="phone" placeholder="Phone-Number">
<input type = "hidden" name = "action" value="addStudentDetails">

<input type="submit" value="Add Participant">

<c:if test="${not empty message }">
<p>${message}</p>
</c:if>
</form>

<a href="Admin?action=back">Back To Home</a>
<a href="Login?action=logout"><button>LogOut</button></a>
</body>
</html>
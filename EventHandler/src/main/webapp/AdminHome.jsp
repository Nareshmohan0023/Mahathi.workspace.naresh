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
	<h1>Welcome ,${userName}</h1>
	<a href="Admin?action=addStudent"><button>Add Student</button></a>
	<a href="Admin?action=displayStudent"><button>display Student</button></a>
	<a href="Admin?action=editStudent"><button>Edit Student</button></a>
	<br>
	<c:if test="${not empty message}">
		<p>${message}</p>
	</c:if>
</body>
</html>
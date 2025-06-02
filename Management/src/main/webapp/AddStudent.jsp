<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	style="display: flex; align-items: center; justify-content: center; flex-direction: column">

	<c:if test="${empty sessionScope.userName}">
		<jsp:forward page="NoAccessServlet" />
	</c:if>
	<form action="AddStudentServlet"
		style="display: flex; flex-direction: column; gap: 8px" method="post">
		<input type="text" placeholder="Enter The Name" name="name"> <input
			type="date" placeholder="Enter The D.O.B" name="DOB"> <input
			type="text" placeholder="Street" name="street"> <input
			type="text" placeholder="city" name="city"> <input
			type="text" placeholder="State" name="state"> <input
			type="submit" value="submit">
	</form>
	<a href="LogoutServlet"><button>Logout</button></a>

</body>
</html>
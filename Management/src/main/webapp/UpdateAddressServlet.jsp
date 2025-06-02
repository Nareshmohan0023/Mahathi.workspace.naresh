<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty sessionScope.userName}">
		<jsp:forward page="NoAccessServlet" />
	</c:if>
	<h1>Table</h1>
	<table border=1>
		<tr>
			<c:forEach var="column" items="${columns}">
				<th>${column}</th>
			</c:forEach>

		</tr>
		<c:forEach var="row" items="${rows }">
			<tr>
				<c:forEach var="column" items="${columns}">
					<td><c:out value="${row[column]}"></c:out></td>
				</c:forEach>
			<tr>
		</c:forEach>
	</table>
	<br>
	<p>By above mentioned table choose the student id to Make Change to
		it</p>
	<form action="UpdateAddressServlet" method="post">
		<input type="number" placeholder="Enter The Student Id to edit"
			name="studId"> <input type="submit"
			value="Start Editing -> click here">
		<c:if test="${not empty requestScope.message}">
			<p>${message}</p>
		</c:if>
	</form>

</body>
</html>
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
	<p>
		<%
		String id = request.getParameter("studId");
		request.setAttribute("stdId", id);
		%>
	</p>
	<form action="HandlingUpdateServlet" method="post">
		<c:forEach var="row" items="${rows}">
			<c:forEach var="column" items="${columns}">

				<input type=text name="${column}" placeholder="${column}"
					value="${row[column]}">
			</c:forEach>
		</c:forEach>
		<input type="hidden" name="stud_id" value="${stdId}"> <input
			type="submit" value="submit">

	</form>
	<a href="LogoutServlet"><button>Logout</button></a>


</body>
</html>
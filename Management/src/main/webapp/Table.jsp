<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%

	%>
	<%
	if (request.getSession(false).getAttribute("userName") == null) {
	%>
	<%
	request.getRequestDispatcher("unAuthorized.jsp").forward(request, response);
	%>
	<%
	}
	%>

	<h1>Table</h1>

	<%
	List<Map<String, Object>> rows = (List<Map<String, Object>>) request.getAttribute("rows");
	List<String> columns = (List<String>) request.getAttribute("columns");
	%>
	<table border="1">
		<tr>
			<%
			for (String str : columns) {
			%>
			<th><%=str%></th>
			<%
			}
			%>
		
		<tr>
			<%
			for (Map<String, Object> row : rows) {
			%>
		
		<tr>
			<%
			for (String str : columns) {
			%>
			<td><%=row.get(str)%></td>
			<%
			}
			%>
		</tr>

		<%
		}
		%>

	</table>
	<a href="LogoutServlet"><button>Logout</button></a>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	style="display: flex; align-items: center; justify-content: center; flex-direction: column; gap: 8px">
	<%if(session.getAttribute("userName")==null){ %>
	<%request.getRequestDispatcher("unAuthorized.jsp").forward(request,response); %>
	<%} %>
	<h1>
		Welcome,
		<%=session.getAttribute("userName")%></h1>


	<a href="AddStudentServlet"><button>Add Student</button></a>
	<a href="DisplayStudentsServlet"><button>Display Student</button></a>
	<a href="UpdateAddressServlet"><button>Update Address</button></a>
	<a href="AuditAddressServlet"><button>Audit Address</button></a>

	<%
	 String msg=(String)request.getAttribute("message"); 
	%>
	<% if(msg!=null){%>
	<p><%= msg %></p>

	<%} %>
	<a href="LogoutServlet"><button>Logout</button></a>




</body>
</html>
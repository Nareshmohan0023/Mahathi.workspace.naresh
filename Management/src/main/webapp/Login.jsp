<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>


	<h1>Hi,Admin</h1>
	<form action="LoginServlet" method="post"
		style="gap: 8px; border: 1px solid black; padding: 20px; width: fit-content; display: flex; align-items; center; justify-content: center; flex-direction: column">
		<label for="userName">User Name:</label> <input type="text"
			name="userName"> <label for="password">Password:</label> <input
			type="text" name="password">
		
		<input type="submit" value="Submit">
		<p>
			New User? <a href="RegisterServlet">Click here!</a>
		</p>
		<%
		

				String msg = (String) request.getAttribute("message");
		%>
		<%if(msg!=null){ %>
		<p><%=msg %></p>
		<%}%>
	</form>



</body>
</html>
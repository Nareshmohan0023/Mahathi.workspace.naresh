<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="home" method="POST">
<strong>Login here !</strong><br><br>
Uid:
<input placeholder="User id" name="id"></input><br><br>
Pwd:
<input type = "password" placeholder="Password" name="password" required="required"></input><br><br>
<input type="submit" name ="action" value="login" required="required">
</form>
</center>
</body>
</html>
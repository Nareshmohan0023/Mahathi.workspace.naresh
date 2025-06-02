<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctors</title>
</head>
<body>
Add doctor:<br>
---------------------------------------------------------------------------------------------------------------------------------
<form action="doctor" method="post">
	<input type ="text" placeholder="Doctor id" name="docId" required="required">
	<input type ="text" placeholder="Doctor name" name="docName" required="required">
	<input type ="text" placeholder="Doctor Specialization" name="docSpl" required="required">
	<button type ="submit" name="action" value="add">Add Doctor</button><br>
	<% 	String addError = (String)request.getAttribute("docError");
		if(addError != null){ %>
		<span style="color: red;"><%= addError %></span>
	<%} %>
</form><br><br>
View Available Doctors<br>
---------------------------------------------------------------------------------------------------------------------------------
<form action="doctor" method="post">
	<button type ="submit" name="action" value="view">View Doctors</button>
</form><br><br>
View Doctor Appointments<br>
---------------------------------------------------------------------------------------------------------------------------------
<form action="doctor" method="post">
	<button type ="submit" name="action" value="viewAppointments">View Doctor Appointments</button>
</form><br>
<br>
Patient control<br>
----------------------------------------------------------------------------------------------------------------------------------
<form action="patient" method="post">
<button type="submit" name="action" value="access">Access patients</button>
</form><br>
<form action="login" method ="post">
	<button type ="submit" name="action" value="logout">Logout</button>
</form>
</body>
</html>

<%@page import="service.DocService"%>
<%@page import="utils.HtmlHelpers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patients</title>
</head>
<body>
<% String rs = (String)HtmlHelpers.buildHtml(DocService.viewDoctors()); %>
<%= rs %>
<br>
Add patient<br>
-------------------------------------------------------------------------------------------------
<br>
<form action="patient" method="POST">
	<input type="text" placeholder="Patient Id" name="patId">
	<input type="text" placeholder="Patient Diesease" name="patIll">
	<input type="text" placeholder="Patient Name" name="patName">
	<input type="text" placeholder="Enter shwon docID" name="docId">
	<button type="submit" name="action" value="add">Add patient</button>
</form>
<br><br>
<form action="patient" method="POST">
	<button type="submit" name="action" value="view">View patients</button>
</form>
</body>
</html>
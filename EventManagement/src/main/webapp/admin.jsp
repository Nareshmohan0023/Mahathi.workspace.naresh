<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin PAGE</title>
</head>
<body>

Accessing as Admin
<br><br>
Add event:
<br><br>
<form action="admin" method = "POST">
<input type = "text" placeholder="Event-ID" name = "eId" required="required"></input>
<input type = "text" placeholder="Event-NAME" name = "eName" required="required"></input>
<input type = "text" placeholder="Event-DESC" name = "eDesc" required="required"></input>
<input type = "text" placeholder="Event-VENUE" name = "eVenue" required="required"></input>
<input type = "submit" name = "action" value = "add-event">
<% 
    String e = (String)request.getAttribute("event");
    if (e != null) {
%>
    <br><span style="color:red;">Error: <%= e %></span>
<% } %>

</form>
<br><br>
Add participant:
<br><br>
<form action="admin" method = "POST">
<input type = "text" placeholder="Participant-ID" name = "pId" required="required"></input>
<input type = "text" placeholder="Participant-NAME" name = "pName" required="required"></input>
<input type = "email" placeholder="Participant-EMAIL" name = "pEmail" required="required"></input>
<input type = "text" placeholder="Participant-PHONE" name = "phone" required="required"></input>
<input type = "password" placeholder="PASSWORD" name = "pwd" required="required"></input>
<% 
    String e2 = (String)request.getAttribute("participant");
    if (e2 != null) {
%>
    <br><span style="color:red;">Error: <%= e2 %></span>
<% } %> 

<input type = "submit" name = "action" value = "add-participant">
</form>
<br><br>
<form action ="admin" method="POST">
<input type = "submit" name  = "action" value = "add-register">
</form>
<br><br>
View participant:
<br><br>
<form action="admin" method = "GET">
<input type = "submit" name = "action" value = "view-participants">
</form>
<br><br>
View event:
<br><br>
<form action="admin" method = "GET">
<input type = "submit" name = "action" value = "view-events">
</form>
<br><br>
<form action="login" method="POST">
<input type = "submit" name = "action" value = "logout">
</form>
</body>
</html>
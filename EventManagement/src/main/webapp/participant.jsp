<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Participant</title>
</head>
<body>
<script src ="participantEdit.js" type="text/javascript"></script>
View participant:
<br><br>
<form action="participant" method = "GET">
<input type = "submit" name = "action" value = "view-participant-id">
</form>
<br><br>
<form action="login" method="POST">
<input type = "submit" name = "action" value = "logout">
</body>
</html>
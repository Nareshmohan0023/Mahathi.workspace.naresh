<%@page import="utitls.HtmlHelpers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<script src="JsHelper.js"></script>
<%= HtmlHelpers.back()%>
<br>

<table border="1" id = "editTable" >
    <tr>
        <c:forEach var="column" items="${columns}">
            <th>${column}</th>
        </c:forEach>
    </tr>
    <c:forEach var="row" items="${rows}">
        <tr>
            <c:forEach var="column" items="${columns}">
                <td data-column="${column}" data-id ="${row['ISBN']}" >${row[column]}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
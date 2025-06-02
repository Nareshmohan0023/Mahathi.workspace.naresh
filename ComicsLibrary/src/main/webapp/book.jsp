<%@page import="utitls.HtmlHelpers"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library</title>
</head>
<body>

<script type="text/javascript">
document.addEventListener("DOMContentLoaded", () => {
    const table = document.getElementById("editTable");

    table.addEventListener("dblclick", (e) => {
        if (e.target.tagName === "TD") {
            const td = e.target;
            const originalValue = td.innerText;
            const isbn = td.dataset.id;
            const column = td.dataset.column;

            const input = document.createElement("input");
            input.type = "text";
            input.value = originalValue;
            td.innerHTML = "";
            td.appendChild(input);
            input.focus();

            input.addEventListener("blur", () => {
                const newValue = input.value;
                td.innerHTML = newValue;

                fetch("library", {
                    method: "POST",
                    headers: { "Content-type": "application/x-www-form-urlencoded" },
                    body: "action=edit&isbn=" + encodeURIComponent(isbn) + "&column=" + encodeURIComponent(column) + "&value=" + encodeURIComponent(newValue)
                })
                .then(response => response.text())
                .then(result => { console.log("Updated:", result); })
                .catch(error => console.log("Error:", error));
            });

            input.addEventListener("keydown", (event) => {
                if (event.key === "Escape") {
                    td.innerHTML = originalValue;
                }
            });
            
            fetch("library",{
            	method : "POST",
            	headers: { "Content-type": "application/x-www-form-urlencoded" },
            	body: "action=viewBooks"
            })
        }
    });
});

</script>


	<%=HtmlHelpers.back()%>
	<br>
	<table border='1'>
		<%
		ResultSet set = (ResultSet) request.getAttribute("rs");
		ResultSetMetaData metaData = set.getMetaData();
		int columns = metaData.getColumnCount();
		%>
		<tr>
		 	<%
			for (int i = 1; i <= columns; i++) {
			%>
			<td><%=metaData.getColumnName(i)%></td>
			<%
		 	}
			%>
		</tr>
		<%
		while (set.next()) {
		%>
		<tr>
			<%
			for (int i = 1; i <= columns; i++) {
			%>
			<td><%=set.getObject(i)%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
package utils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlHelpers {
	
	public static void prepareTable(HttpServletRequest request, HttpServletResponse response,ResultSet rs, String view) throws SQLException, ServletException, IOException {
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		List<String> column = new ArrayList<>();
		List<Map<String,Object>> rows = new ArrayList<>();
		
		for(int i = 1; i <= columnCount; i++) {
			column.add(metaData.getColumnName(i));
		}
		
		while(rs.next()) {
			Map<String,Object> row = new HashMap<>();
			for(String col:column) {
				row.put(col, rs.getObject(col));
			}
			rows.add(row);
		}
		
		if(view.equals("doc")) {
			request.setAttribute("columns", column);
			request.setAttribute("rows", rows);
			request.getRequestDispatcher("hos.jsp").forward(request, response);
		}
		else if(view.equals("pat")) {
			request.setAttribute("columns", column);
			request.setAttribute("rows", rows);
			request.getRequestDispatcher("patient.jsp").forward(request, response);			
		}
		else if(view.equals("app")) {
			request.setAttribute("columns", column);
			request.setAttribute("rows", rows);
			request.getRequestDispatcher("viewAppointment.jsp").forward(request, response);			
		}
	}
	
	public static String buildHtml(ResultSet set) throws SQLException {
		StringBuilder html = new StringBuilder();
		ResultSetMetaData metaData = set.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		html.append("<table border = '1'>");
		
		html.append("<tr>");
		for(int i=1;i<=columnCount;i++) {
			html.append("<td>").append(metaData.getColumnName(i)).append("</td>");
		}
		html.append("</tr>");

		while(set.next()){
			html.append("<tr>");
			for(int i=1;i<=columnCount;i++) {
				html.append("<td>").append(set.getObject(i)).append("</td>");
			}
			html.append("</tr>");
		}
		html.append("</table>");
		
		return html.toString();
	}

}

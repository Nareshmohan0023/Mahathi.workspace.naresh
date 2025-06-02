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

public class HtmlHelper {
	
	public static void prepareTable(HttpServletRequest request, HttpServletResponse response, ResultSet set, String table) throws SQLException, ServletException, IOException {
		ResultSetMetaData metaData = set.getMetaData();
		
		List<String> column = new ArrayList<>();
		List<Map<String,Object>> rows = new ArrayList<>();
		int columnCount = metaData.getColumnCount();
		
		for(int i=1;i<=columnCount;i++) {
			column.add(metaData.getColumnName(i));
		}
		
		while(set.next()) {
			Map<String,Object> row = new HashMap<>();
			for(String col:column) {
				row.put(col,set.getObject(col));
			}
			rows.add(row);
		}
		
		if(table.equals("Register")) {
			request.setAttribute("col", column);
			request.setAttribute("row", rows);
			request.getRequestDispatcher("RegisterForm.jsp").forward(request, response);
		}
		else if(table.equals("Events")){
			request.setAttribute("columns", column);
			request.setAttribute("rows", rows);
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
		else if(table.equals("Participants")){
			request.setAttribute("columns", column);
			request.setAttribute("rows", rows);
			request.getRequestDispatcher("viewP.jsp").forward(request, response);
		}
		else if(table.equals("pId")) {
			request.setAttribute("columns", column);
			request.setAttribute("rows", rows);
			request.setAttribute("events",false);
			request.setAttribute("participants",false);
			request.getRequestDispatcher("viewP.jsp").forward(request, response);
		}
	}
	
	

}

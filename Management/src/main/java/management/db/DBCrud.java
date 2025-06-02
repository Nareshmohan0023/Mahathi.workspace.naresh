package management.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DBCrud {

	public static Statement getStatement() throws SQLException {
		Statement st = DBConnection.getConnection().createStatement();
		return st;
	}

	public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
		PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql);
		return pstmt;
	}

	public static int executeUpdate(String sql) throws SQLException {
		return getStatement().executeUpdate(sql);
	}

	public static int executeUpdate(String sql, Object... params) throws SQLException {
		PreparedStatement pstmt = getPreparedStatement(sql);
		setParams(pstmt, params);
		return pstmt.executeUpdate();
	}

	public static ResultSet resultSet(String sql) throws SQLException {
		Statement st = getStatement();
		return st.executeQuery(sql);
	}

	public static ResultSet resultSet(String sql, Object... params) throws SQLException {
		PreparedStatement pstmt = getPreparedStatement(sql);
		setParams(pstmt, params);
		return pstmt.executeQuery();
	}

	public static void setParams(PreparedStatement pstmt, Object... params) throws SQLException {
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i + 1, params[i]);
		}
	}
	public static List<Map<String,Object>> rsToMap(ResultSet rs) throws SQLException{
		ResultSetMetaData md=rs.getMetaData();
		List<Map<String,Object>> rows=new LinkedList<>();
		while(rs.next()) {
			Map<String,Object> row=new LinkedHashMap<>();
			for(int i=1;i<=md.getColumnCount();i++) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			rows.add(row);
		}
		
		return rows;
	}
	
//	public static void main(String[] args) throws SQLException {
//		List<Map<String,Object>> rows=new LinkedList<>();
//		rows=rsToMap(DBCrud.resultSet("SELECT * FROM STUDENTS"));
//		List<String> columns=new LinkedList<>(rows.get(0).keySet());
//		for(String str:columns) {
//			System.out.print(str+" ");
//		}
//		System.out.println();
//		for(Map<String,Object> row:rows) {
//			
//			for(Map.Entry<String, Object> e:row.entrySet()) {
//				System.out.print(e.getValue()+" ");
//			}
//			System.out.println();
//			System.out.println("----------------------------");
//
//		}
//		
//	}

}

package event.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DBCrud {

	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
		return ps;
	}

	public static boolean executeUpdate(String sql, Object... params) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = getPreparedStatement(sql);
		setParams(ps, params);
		int updatedRows = ps.executeUpdate();
		if (updatedRows > 0) {
			return true;
		}
		return false;
	}

	public static ResultSet resultSet(String sql, Object... params) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = getPreparedStatement(sql);
		setParams(ps, params);
		return ps.executeQuery();
	}

	public static List<Map<String, Object>> rsToListOfMap(ResultSet rset) throws SQLException {
		ResultSet rs = rset;
		ResultSetMetaData md = rs.getMetaData();
		List<Map<String, Object>> rows = new LinkedList<>();
		while (rs.next()) {
			Map<String, Object> row = new LinkedHashMap<>();
			for (int i = 0; i < md.getColumnCount(); i++) {
				row.put(md.getColumnName(i + 1), rs.getObject(i + 1));
			}
			rows.add(row);
		}
		return rows;
	}

	private static void setParams(PreparedStatement ps, Object... params) throws SQLException {

		for (int i = 0; i < params.length; i++) {
			ps.setObject(i + 1, params[i]);
		}

	}

}

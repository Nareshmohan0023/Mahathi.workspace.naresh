package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RunQuery {
	
	static PreparedStatement prep;
	
	// create , update, delete
	public static void update(String query, Object... params) throws ClassNotFoundException, SQLException {
		prep = PreparedStmt.prepQuery(query);
		for(int i = 0; i < params.length; i++) {
			prep.setObject(i+1, params[i]);
		}
		prep.executeUpdate();
	}
	
	// read
	public static ResultSet view(String query, Object... params) throws ClassNotFoundException, SQLException {
		prep = PreparedStmt.prepQuery(query);
		for(int i = 0; i < params.length; i++) {
			prep.setObject(i+1, params[i]);
		}
		return  prep.executeQuery();
	}

}

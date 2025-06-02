package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnection;

public class PrepapredStmtUtil {
	private static PreparedStatement prep ;
	
	
	public static PreparedStatement preparpStmt(String query) {
		try {
			prep = DatabaseConnection.getInstance().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prep;
	}

}

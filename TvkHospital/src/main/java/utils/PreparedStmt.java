package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnection;

public class PreparedStmt {
	@SuppressWarnings("unused")
	private static PreparedStatement prep;
	
	public static PreparedStatement prepQuery(String query) throws ClassNotFoundException, SQLException {
		return prep = DatabaseConnection.getInstance().prepareStatement(query);
	}

}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection connection;
	
	DatabaseConnection (){}
	
	public static Connection getInstance() throws SQLException {
		if(connection == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LIBRARYMANAGEMENT;encrypt=true;trustServerCertificate=true;","sa","P@ssword@321");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}

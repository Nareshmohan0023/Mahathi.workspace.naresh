package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DatabaseConnection {
	private static Connection connection;
	
	public DatabaseConnection() {}
	
	public static Connection getInstance() throws SQLException, SQLServerException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=EVENT;encrypt=true;trustServerCertificate=true;";
		String username =  "sa";
		String pws = "P@ssword@321";
		if(connection == null) {
			try { 
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection= DriverManager.getConnection(url,username, pws);
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}

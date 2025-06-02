package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection connection;

	public DatabaseConnection() {
		super();
	}
	
	public static Connection getInstance() throws SQLException, ClassNotFoundException {
		if( connection == null ) {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=HOSPITAL;encrypt=true;trustServerCertificate=true";
			String user = "sa";
			String pwd = "P@ssword@321";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url,user,pwd);
		}
		return connection;
	}
	

}

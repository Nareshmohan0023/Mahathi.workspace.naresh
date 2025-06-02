package event.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection con;
	
	private DBConnection() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
//		String url = "jdbc:sqlserver://localhost:1433;databaseName=EVENT;encrypt=true;trustServerCertificate=true;";

		String url="jdbc:sqlserver://localhost:1433;databaseName=EVENT;encrypt=true;trustServerCertificate=true";
		String userName="sa";
		String password="P@ssword@321";
		if(con==null) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url,userName,password);
			return con;
		}
		
		return con;
		
	}

}

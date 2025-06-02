package management.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection con=null;
	private static String userName="sa";
	private static String password="P@ssword@321";
	
	private DBConnection() {
		
	}
	
	public static Connection getConnection() {
		if(con==null) {
			try {
				String url="jdbc:sqlserver://localhost:1433;databaseName=STUDENT_DB;encrypt=true;trustServerCertificate=true";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con=DriverManager.getConnection(url,userName,password);
				return con;
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}
	
	public static void main(String[] args) {
		getConnection();
		System.out.println("Connnection Successfull");
	}

}

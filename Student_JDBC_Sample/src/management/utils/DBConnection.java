package management.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection connection=null;
	static String user="sa";
	static String password="P@ssword@321";
	
	
	private DBConnection(){
		
	}
	
	public static Connection getConnection() {
		if(connection==null) {
			String url="jdbc:sqlserver://localhost:1433;databaseName=studentTable;encrypt=true;trustServerCertificate=true";
			try {
				connection=DriverManager.getConnection(url,user,password);
				System.out.println("Connection established");
				return connection;
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("connection fetched(already existing one)");
		return connection;
		
	}
	

}

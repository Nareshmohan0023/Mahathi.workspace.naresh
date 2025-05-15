package jdbc.main;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		System.out.println("Hello");
		String url="jdbc:sqlserver://localhost:1433;databaseName=Inventory_Management;encrypt=true;trustServerCertificate=true";
		String user="sa";
		String password="P@ssword@321";
		
		
		
		try(Connection conn=DriverManager.getConnection(url,user,password)){
			System.out.println("Connected to MSSQL successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}

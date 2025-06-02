package dao;

import java.sql.Connection;
import java.sql.SQLException;

import database.DatabaseConnection;

public class LibraryDAO {

	public static void main(String[] mohanLibrary) throws SQLException {
		try (Connection conn = DatabaseConnection.getInstance()){
			System.out.println("Connected to Database Succesfully !");
				
		}
	}
}

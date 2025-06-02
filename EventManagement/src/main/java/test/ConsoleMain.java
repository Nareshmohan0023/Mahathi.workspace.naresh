package test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnection;

public class ConsoleMain {
	public static void main(String[] args) {
		try {
			PreparedStatement prep  = DatabaseConnection.getInstance().prepareStatement("query");
			System.out.println("Sucesss");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

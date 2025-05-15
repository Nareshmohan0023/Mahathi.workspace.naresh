package management.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import management.utils.DBConnection;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		Connection con=DBConnection.getConnection();
		
		Statement statement=con.createStatement();
		String querry="select * from studentDetails";
		ResultSet rs=statement.executeQuery(querry);
		while(rs.next()) {
			System.out.print(rs.getInt(1 ));
			System.out.print("||"+rs.getString("studentName"));
			System.out.print("||"+rs.getString("Gender"));
			System.out.println();
			System.out.println("==============================================");
		}
		
		Connection con1=DBConnection.getConnection();
		String sql = "UPDATE studentDetails SET Gender = ? WHERE studentId = ?";
		PreparedStatement ps=con1.prepareStatement(sql);
		ps.setInt(2, 3);
		ps.setString(1,"M");
		int res=ps.executeUpdate();
		System.out.println(res);
	}

}

package service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Credentials;
import utitls.PrepareQuery;
import utitls.Queries;

public class LoginServiceImpl {

	public static Boolean validateCredentials(Credentials credentials) throws ClassNotFoundException, SQLException, IOException {
		ResultSet rs = PrepareQuery.view(Queries.getGetCredentials());
		boolean flag = false;
		while(rs.next()) {
			int id = rs.getInt("USER_ID");
			String password = rs.getString("PASSWORD");
			if(id == credentials.getUser_id() && password.equals(credentials.getPassword())) {
				Credentials.setUsername(rs.getString("USERNAME"));
				flag = true;
				break;
			}
		}
		if(flag) return true;
		else return false;
	}
}

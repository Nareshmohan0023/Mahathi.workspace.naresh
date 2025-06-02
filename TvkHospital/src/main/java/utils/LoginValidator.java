package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Credentials;

public class LoginValidator {

	public static boolean isHospital(Credentials credentials) throws ClassNotFoundException, SQLException {
		ResultSet set = RunQuery.view(Queries.GET_HOS_USERS);
		boolean flag = false;
		while(set.next()) {
			if(credentials.getUsername().equals(set.getObject("username")) && credentials.getPassword().equals(set.getObject("password"))) {
				flag = true;
				break;
			}
		}
		if(flag) return true;
		else return false;
	}
}

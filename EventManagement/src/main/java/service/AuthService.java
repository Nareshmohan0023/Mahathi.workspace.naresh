package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Participant;
import utils.PrepareQuery;
import utils.Queries;

public class AuthService {
	
	public static boolean participantLogin(Participant p) throws SQLException {
		boolean flag =  false;
		ResultSet rs = PrepareQuery.view(Queries.VIEW_PARTICIPANT);
		while(rs.next()) {
			if(rs.getString("P_NAME").equals(p.getpName()) && rs.getString("P_PASSWORD").equals(p.getPassword())) {
				flag = true;
				break;
			}
		}
		if(flag) return true;
		else return flag;
	}

}

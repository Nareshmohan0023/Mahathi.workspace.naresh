package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class PrepareQuery {
	
	private static PreparedStatement prep;
	
	//Create, Update, Delete
	public static int update(String query,Object... params) throws SQLException, SQLServerException{
		prep = PrepapredStmtUtil.preparpStmt(query);
		for(int i=0;i<params.length; i++) {
			prep.setObject(i+1, params[i]);
		}
		return prep.executeUpdate();
	}

	//View
	public static ResultSet view(String query,Object... params) throws SQLException, SQLServerException {
		prep = PrepapredStmtUtil.preparpStmt(query);
		for(int i=0;i<params.length; i++) {
			prep.setObject(i+1, params[i]);
		}
		return prep.executeQuery();
		
	}
}

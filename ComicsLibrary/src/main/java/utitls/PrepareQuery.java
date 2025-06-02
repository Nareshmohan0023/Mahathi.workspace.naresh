package utitls;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareQuery {

	private static PreparedStatement prep;
	
	// UPDATE & ADD & DELETE
	public static int update(String query, Object... params) throws SQLException, ClassNotFoundException, IOException {
	    try (PreparedStatement prep = PreparedUtil.preparedStatement(query)) {
	        for (int i = 0; i < params.length; i++) {
	            prep.setObject(i + 1, params[i]); 
	        }
	        return prep.executeUpdate();
	    }
	}

	// DISPLAY DATA
	public static ResultSet view(String query, Object... params) throws SQLException, ClassNotFoundException, IOException {
	    PreparedStatement prep = PreparedUtil.preparedStatement(query);
	    for (int i = 0; i < params.length; i++) {
	        prep.setObject(i + 1, params[i]); 
	    }
	    return prep.executeQuery();
	}
}

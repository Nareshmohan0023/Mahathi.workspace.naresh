package utitls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.DatabaseConnection;

public class PreparedUtil {
	
	public static PreparedStatement preparedStatement(String Query) throws SQLException, IOException {
		PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(Query);
		return preparedStatement;
	}
}

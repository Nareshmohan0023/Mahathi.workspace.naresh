package management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import management.db.DBCrud;
import management.util.SqlUtil;

public class AdminDao {

	public  void addAdmin(String name, String userName, String password) throws SQLException {
		String sql = SqlUtil.ADD_ADMIN;
		DBCrud.executeUpdate(sql, name, userName, password);
	}

	public  boolean isAdminPresent(String userName) throws SQLException {
		String sql = SqlUtil.ADMIN_VALIDATION;
		return DBCrud.resultSet(sql, userName).next();
	}
	public  boolean isAdminUnique(String userName) throws SQLException {
		String sql = SqlUtil.ADMIN_VALIDATION;
		return !DBCrud.resultSet(sql, userName).next();
	}

	public boolean validateCredentials(String userName, String password) throws SQLException {
		String sql = SqlUtil.ADMIN_VALIDATION;
		ResultSet rs = DBCrud.resultSet(sql, userName);
		while (rs.next()) {
			if (rs.getString(1).equals(userName) && rs.getString(2).equals(password)) {
				return true;
			}
		}
		return false;
	}
//	public static void main(String[] args) throws SQLException {
//		String userName="Nareshmohan0023";
//		String password="Naresh*2003";
//		System.out.println(isAdminPresent(userName));
//		System.out.println(validateCredentials(userName, password));
//	}

}

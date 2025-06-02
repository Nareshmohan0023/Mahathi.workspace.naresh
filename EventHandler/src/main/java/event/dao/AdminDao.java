package event.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import event.database.DBCrud;
import event.util.SqlUtil;

public class AdminDao {
	
	public boolean isUserNameUnique(String userName) throws ClassNotFoundException, SQLException {
		String sql=SqlUtil.IS_USERNAME_UNIQUE;
		ResultSet rs=DBCrud.resultSet(sql, userName);
		while(rs.next()) {
			return false;
		}
		return true;
	}

	public boolean addAdmin(String name, String userName, String password) throws ClassNotFoundException, SQLException {
		String sql=SqlUtil.ADD_ADMIN;
		return DBCrud.executeUpdate(sql, name,userName,password);
	}
	
	

	public boolean iValidateAdmin(String userName, String password) throws ClassNotFoundException, SQLException {
		String sql=SqlUtil.GET_ADMIN_DETAILS;
		ResultSet rs=DBCrud.resultSet(sql, userName);
		String uName = null;
		String pass=null;
		while(rs.next()) {
			uName=rs.getString(1);
			pass=rs.getString(2);
		}
		System.out.println(uName);
		System.out.println(pass);
		System.out.println("//");
		System.out.println(userName);
		System.out.println(password);
		if(uName.equals(userName)&&pass.equals(password)) {
			return true;
		}
		return false;
	}

}

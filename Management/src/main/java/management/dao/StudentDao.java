package management.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import management.db.DBCrud;
import management.entity.Address;
import management.entity.Student;
import management.util.SqlUtil;

public class StudentDao {
	
	public int getAddressId() throws SQLException {
		String sql=SqlUtil.GET_LAST_ADD_IS;
		ResultSet rs=DBCrud.resultSet(sql);
		int id=100;
	
		if(rs.next()) {
			if(!rs.wasNull()) {
				id=rs.getInt(1)+1;
				return id;
			}
		}
		return id;	
		
	}
	
	public void addStudent(Student st,Address ad) throws SQLException {
		String sql=SqlUtil.ADD_STUDENT;
		int i=DBCrud.executeUpdate(sql, st.getName(),st.getDOB(),st.getAddId());
		if(i>0) {
			System.out.println("Student added successfully");
			addAddress(ad);
			return;
		}
		System.out.println("not added");
	}
	
	public void addAddress(Address ad) throws SQLException {
		String sql=SqlUtil.ADD_ADDRESS;
		int i=DBCrud.executeUpdate(sql,ad.getAddId(),ad.getStreet(),ad.getCity(),ad.getState());
		if(i>0) {
			System.out.println("Student coressponding address added successfully");
		}
	}

	public List<Map<String, Object>> displayStudentsList() throws SQLException {
		String sql=SqlUtil.DISPLAY_STUDENTS_WITH_ADD;
		ResultSet rs=DBCrud.resultSet(sql);
		return DBCrud.rsToMap(rs);
	}



	public List<Map<String, Object>> getStudentById(int id) {
		String sql=SqlUtil.GET_STUDENTS_WITH_ADD;
		ResultSet rs;
		try {
			rs = DBCrud.resultSet(sql,id);
			return DBCrud.rsToMap(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean updateStudent(String name, Date dob, boolean is_current, int id) throws SQLException {
		String sql=SqlUtil.UPDATE_STUDENT;
		int i=DBCrud.executeUpdate(sql, name,dob,is_current);
		if(i>0) {
			return true;
		}
		return false;
		
	}

	public boolean updateAddress(String street, String city, String state, int id) throws SQLException {
		String sql=SqlUtil.UPDATE_ADDRESS;
		int i=DBCrud.executeUpdate(sql, street,city,state,id);
		if(i>0) {
			return true;
		}
		return false;
	}

	public List<Map<String, Object>> displayAddressAudit() throws SQLException {
		String sql=SqlUtil.DISPLAY_AUDITTABLE;
		return DBCrud.rsToMap(DBCrud.resultSet(sql));
	}
	

}

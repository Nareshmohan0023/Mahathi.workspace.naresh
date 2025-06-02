package event.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import event.database.DBCrud;
import event.util.SqlUtil;

public class ParticipantDao {

	public boolean addParticipant(String name, String email, String phone) throws ClassNotFoundException, SQLException {
		String sql=SqlUtil.ADD_STUDENT;
		return DBCrud.executeUpdate(sql,name,email,phone);
	}

	public List<Map<String,Object>> displayParticipants() throws ClassNotFoundException, SQLException {
		String sql=SqlUtil.GET_PARTICIPANTS;
		return DBCrud.rsToListOfMap(DBCrud.resultSet(sql));
	}

	public List<Map<String, Object>> editParticipantById(int id) throws ClassNotFoundException, SQLException {
		String sql=SqlUtil.GetStudentById;
		System.out.println("id is "+id);
		return DBCrud.rsToListOfMap(DBCrud.resultSet(sql,id));
	}

	public boolean updateStudent(String name, String email, String phone,int id) throws ClassNotFoundException, SQLException {
		String sql=SqlUtil.UPDATE_STUDENT;
		return DBCrud.executeUpdate(sql, name,email,phone,id);
	}

}

package event.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Service {

	

	boolean isUserNameUnique(String userName) throws ClassNotFoundException, SQLException;

	boolean addAdmin(String name, String userName, String password) throws ClassNotFoundException, SQLException;

	boolean validateAdmin(String userName, String password) throws ClassNotFoundException, SQLException;

	boolean addParticipants(String name, String email, String password) throws ClassNotFoundException, SQLException;

	List<Map<String,Object>> displayStudent() throws ClassNotFoundException, SQLException;

	List<Map<String, Object>> editStudentById(int id) throws ClassNotFoundException, SQLException;

	boolean updateStudents(String name, String email, String phone,int id) throws ClassNotFoundException, SQLException;

}

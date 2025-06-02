package management.service;

import java.util.List;
import java.util.Map;

import management.entity.Address;
import management.entity.Student;

public interface Service {
	
	void addAdmin(String name,String userName,String password) ;

	boolean isUserNameUnique(String userName);

	boolean isUserNamePresent(String userName);

	boolean validateLoginCredentials(String userName, String password);
	
	void addStudent(Student st,Address ad);
	
	int getAddressId();
	
	List<Map<String,Object>> displayStudents();

	List<Map<String, Object>> getStudentById(int id);

	boolean updateStudentAndAddress(Student student, Address address,boolean is_current,int id);

	List<Map<String, Object>> displayAddressAudit();
}
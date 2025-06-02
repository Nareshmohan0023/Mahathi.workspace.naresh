package event.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import event.dao.AdminDao;
import event.dao.ParticipantDao;

public class ServiceImpl implements Service{
	AdminDao adao=new AdminDao();
	ParticipantDao pdao=new ParticipantDao();

	@Override
	public boolean isUserNameUnique(String userName) throws ClassNotFoundException, SQLException {
		boolean isUnique=adao.isUserNameUnique(userName);
		return isUnique;
	}

	@Override
	public boolean addAdmin(String name, String userName, String password) throws ClassNotFoundException, SQLException {
		boolean addAdmin=adao.addAdmin(name,userName,password);
		return addAdmin;
	}

	@Override
	public boolean validateAdmin(String userName, String password) throws ClassNotFoundException, SQLException {
		return adao.iValidateAdmin(userName,password);
	}

	@Override
	public boolean addParticipants(String name, String email, String phone) throws ClassNotFoundException, SQLException {
		
		return pdao.addParticipant(name,email,phone);
	}

	@Override
	public List<Map<String, Object>> displayStudent() throws ClassNotFoundException, SQLException {
		return pdao.displayParticipants();
	}

	@Override
	public List<Map<String, Object>> editStudentById(int id) throws ClassNotFoundException, SQLException {
		return pdao.editParticipantById(id);
	}

	@Override
	public boolean updateStudents(String name, String email, String phone,int id) throws ClassNotFoundException, SQLException {
		return pdao.updateStudent(name,email,phone,id);
	}

	

	
}

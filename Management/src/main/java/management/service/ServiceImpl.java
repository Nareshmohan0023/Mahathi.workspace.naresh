package management.service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import management.dao.AdminDao;
import management.dao.StudentDao;
import management.entity.Address;
import management.entity.Student;

public class ServiceImpl implements Service {
	AdminDao ADao=new AdminDao();
	StudentDao SDao=new StudentDao();
	@Override
	public void addAdmin(String name, String userName, String password) {
		// TODO Auto-generated method stub
		try {
			ADao.addAdmin(name, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean isUserNameUnique(String userName) {

		try {
			return ADao.isAdminUnique(userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean isUserNamePresent(String userName) {
		try {
			return ADao.isAdminPresent(userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean validateLoginCredentials(String userName, String password) {
		// TODO Auto-generated method stub
		try {
			return ADao.validateCredentials(userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addStudent(Student st, Address ad) {
		try {
			SDao.addStudent(st, ad);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getAddressId() {
		try {
			return SDao.getAddressId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Map<String, Object>> displayStudents() {
		try {
			return SDao.displayStudentsList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override 
	public List<Map<String, Object>> getStudentById(int id) {
		return SDao.getStudentById(id);
//		return null;
	}

	@Override
	public boolean updateStudentAndAddress(Student student, Address ad,boolean is_current,int id) {
		try {
			boolean addr=SDao.updateAddress(ad.getCity(),ad.getState(),ad.getState(),id);
			boolean stud=SDao.updateStudent(student.getName(),student.getDOB(),is_current,id);
			if(addr&&stud) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<Map<String, Object>> displayAddressAudit() {
		List<Map<String, Object>> rows=new LinkedList<>();
		try {
			rows = SDao.displayAddressAudit();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}

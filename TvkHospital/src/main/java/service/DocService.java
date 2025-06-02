package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Doctor;
import utils.Queries;
import utils.RunQuery;

public class DocService {
	
	public static void addDoctor(Doctor doctor) throws ClassNotFoundException, SQLException {
		RunQuery.update(Queries.ADD_DOCTER, doctor.getDocId(),doctor.getDocName(),doctor.getDocSpl());
	}
	
	public static void deleteDoctor(int docId) throws ClassNotFoundException, SQLException {
		RunQuery.update(Queries.DELETE_DOCTOR, docId);
	}

	public static ResultSet viewDoctors() throws ClassNotFoundException, SQLException {
		return RunQuery.view(Queries.VIEW_DOCTORS);
	}
	
	public static ResultSet viewAllAppointments() throws ClassNotFoundException, SQLException {
		return RunQuery.view(Queries.VIEW_APPOINTMENTS);
	}
	
	public static void editDoctor(String column,String newValue,int dodId) throws ClassNotFoundException, SQLException {
		RunQuery.update("update doctors set "+column+" = ? where docId = ?", newValue,dodId);
	}
}

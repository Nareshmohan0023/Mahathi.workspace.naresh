package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Patient;
import utils.Queries;
import utils.RunQuery;

public class PatService {
	
	public static void addPatient(Patient patient,int docId) throws ClassNotFoundException, SQLException {
		RunQuery.update(Queries.ADD_PATIENT, patient.getPatId(),patient.getPatName(),patient.getPatIll(),docId);
	}

	public static void deletePatient(int patId) throws ClassNotFoundException, SQLException {
		RunQuery.update(Queries.DELETE_PATIENT, patId);
	}
	
	public static ResultSet viewPatients() throws ClassNotFoundException, SQLException {
		return RunQuery.view(Queries.VIEW_PATIENTS);
	}
	
	public static void editPatient(String column, String newValue,int patId) throws ClassNotFoundException, SQLException {
		RunQuery.update("update patients set "+column+" = ? where = ?", newValue,patId);
	}
}
	
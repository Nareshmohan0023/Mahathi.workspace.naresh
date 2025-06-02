package utils;

public class Queries {
	
	public final static String GET_HOS_USERS = "select username,password from TvkHospital;";
	
	public final static String ADD_DOCTER = "insert into doctors(docId,docName,docSpl) values(?,?,?);";
	public final static String DELETE_DOCTOR = "update doctors set isDeleted = 1 where docId = ?;";
	public final static String VIEW_DOCTORS = "select docId,docName,docSpl from doctors where isDeleted = 0 ;";
		
	public final static String ADD_PATIENT = "insert into patients(patId,patName,patIll,docId) values(?,?,?,?);";
	public final static String DELETE_PATIENT= "update patients set isDeleted = 1 where patId = ?;";
	public final static String VIEW_PATIENTS = "select patId,patName,patIll,docId from patients;";
	public final static String VIEW_PATIENT_BY_ID = "select patId,patName,patIll,docId from patients where patId = ?";
	
	public final static String VIEW_APPOINTMENTS = "select d.docName,d.docSpl,String_agg(p.patName,',') as pName, String_agg(p.patIll,',') as pIll from doctors d left join patients p on d.docId = p.docId where d.isDeleted =0 and p.isDeleted =0 group by d.docName,d.docSpl;";
}

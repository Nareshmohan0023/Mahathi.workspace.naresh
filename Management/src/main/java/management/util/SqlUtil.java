package management.util;

public class SqlUtil {
	
	public static final String ADMIN_VALIDATION = "SELECT A_USER_NAME,A_PASSWORD FROM ADMINS WHERE A_USER_NAME=? ";;
	public static final String ADD_ADMIN="INSERT INTO ADMINS(A_NAME,A_USER_NAME,A_PASSWORD) VALUES (?,?,?);";
	public static final String GET_LAST_ADD_IS = "SELECT MAX(ADD_ID) FROM ADDRESS";
	public static final String ADD_STUDENT = "INSERT INTO STUDENTS(STUD_NAME,STUD_DOB,ADD_ID) VALUES (?,?,?);";
	public static final String ADD_ADDRESS="INSERT INTO ADDRESS(ADD_ID,ADD_STREET,ADD_CITY,ADD_STATE) VALUES (?,?,?,?);";
	public static final String DISPLAY_STUDENTS_WITH_ADD = "SELECT S.STUD_ID,S.STUD_NAME,S.STUD_DOB,S.ADD_ID,A.ADD_STREET,A.ADD_CITY,A.ADD_STATE,S.IS_AVAILABLE AS CURRENTLY_STUDYING FROM STUDENTS S JOIN ADDRESS A ON S.ADD_ID=A.ADD_ID WHERE A.IS_CURRENT=1;";
	public static final String GET_STUDENTS_WITH_ADD = "SELECT S.STUD_NAME,S.STUD_DOB,A.ADD_STREET,A.ADD_CITY,A.ADD_STATE,S.IS_AVAILABLE AS CURRENTLY_STUDYING FROM STUDENTS S JOIN ADDRESS A ON S.ADD_ID=A.ADD_ID WHERE A.IS_CURRENT=1 AND S.STUD_ID=?;";
	public static final String UPDATE_STUDENT = "UPDATE STUDENTS SET STUD_NAME=?,STUD_DOB=? WHERE STUD_ID=?";
	public static final String UPDATE_ADDRESS = "UPDATE A SET A.ADD_STREET=?,A.ADD_CITY=?,A.ADD_STATE =? ,A.OPERATION = 'UPDATED 'FROM ADDRESS A JOIN STUDENTS S ON S.ADD_ID=A.ADD_ID WHERE S.STUD_ID=?";
	public static final String DISPLAY_AUDITTABLE="SELECT * FROM ADDRESS ORDER BY ADD_ID";

}

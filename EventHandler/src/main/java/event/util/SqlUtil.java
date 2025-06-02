package event.util;

public class SqlUtil {
	
	public static final String IS_USERNAME_UNIQUE="SELECT * FROM ADMIN WHERE A_USER_NAME=?";

	public static final String ADD_ADMIN = "INSERT INTO ADMIN (A_NAME,A_USER_NAME,A_PASSWORD) VALUES(?,?,?);";

	public static final String GET_ADMIN_DETAILS = "SELECT A_USER_NAME,A_PASSWORD FROM ADMIN WHERE A_USER_NAME=? ;";

	public static final String ADD_STUDENT = "INSERT INTO PARTICIPANTS (P_NAME,P_EMAIL,P_PHONE) VALUES (?,?,?)";

	public static final String GET_PARTICIPANTS = "SELECT * FROM PARTICIPANTS";

	public static final String GetStudentById = "SELECT P_NAME,P_EMAIL,P_PHONE FROM PARTICIPANTS WHERE P_ID=?;";

	public static final String UPDATE_STUDENT = "UPDATE PARTICIPANTS SET P_NAME=?,P_EMAIL=?,P_PHONE=? WHERE P_ID=?";

	

}

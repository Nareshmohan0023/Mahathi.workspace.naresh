package entity;

public class Credentials {
	
	private String username;
	private String password;
	private static String uName;
	public static boolean isValid;
	
	public static String getuName() {
		return uName;
	}
	public static void setuName(String uName) {
		Credentials.uName = uName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

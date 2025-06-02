package entity;

public class Credentials {

	private int user_id;
	private String password;
	private static String username;
	
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Credentials.username = username;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

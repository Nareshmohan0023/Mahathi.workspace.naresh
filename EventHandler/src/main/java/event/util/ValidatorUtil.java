package event.util;

import java.util.regex.Pattern;

public class ValidatorUtil {
	
	public static boolean isGmail(String gmail) {
		String regex="^[A-Za-z0-9._+-]+@[a-zA-Z]{2,6}\\.[a-zA-Z]{2,6}$";
		return Pattern.matches(regex, gmail);
	}
	
	public static boolean isPhoneNum(String phone) {
		String regex="^[6-9][0-9]{9}$";
		return Pattern.matches(regex, phone);
	}

}

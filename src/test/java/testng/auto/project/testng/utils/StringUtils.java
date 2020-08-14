package testng.auto.project.testng.utils;

public class StringUtils {

	public StringUtils() {
		// TODO Auto-generated constructor stub
	}
	public static String [] parseString (String str, String delimit) {
		return str.split(delimit);
	}

}

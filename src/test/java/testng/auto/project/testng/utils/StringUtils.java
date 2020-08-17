package testng.auto.project.testng.utils;

public class StringUtils {

	public StringUtils() {
		// TODO Auto-generated constructor stub
	}
	public static String [] parseString (String str, String delimit, boolean trim) {
		String [] array;
		array = str.split(delimit);
		if (trim) {
			for (int i=0; i < array.length; i++) {
				array[i] = (array[i]).trim();
			}
		} 
		return array;
	}

	public static String [] parseString (String str, String delimit) { 
		return str.split(delimit);
	}
}

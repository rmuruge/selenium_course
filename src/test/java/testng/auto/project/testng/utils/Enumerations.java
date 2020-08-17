/**
 * 
 */
package testng.auto.project.testng.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



/**
 * @author rmuruge
 *
 */
public class Enumerations {

	
	public static final String LOGIN_ERROR = "Incorrect login details.";
	public static final String LOGIN_ERROR_MAX = "Max Login attempts limit reached, Try again after 10 minutes.";
	public static final String THREAD_WAIT = "";
	public WebDriver driver;
	
	public static enum WAITS {
		IMPLICIT, EXPLICIT, FLUENT, THREAD	
	}

	public static enum WAIT_ACTION {
		BUTTON, VISIBLE, XX, XXXXX	
	}
	
	public static enum FINDBY {
		ID, LINK, CSS, XPATH
	}
	
	/**
	 * 
	 */
	public Enumerations() {
		// TODO Auto-generated constructor stub
		this.driver = new ChromeDriver();
	}
	
	
}

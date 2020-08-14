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
public class PageWaits {

	
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
	
	/**
	 * 
	 */
	public PageWaits() {
		// TODO Auto-generated constructor stub
		this.driver = new ChromeDriver();
	}
	

	
	public static WebDriverWait waitForElement(WebDriver driver, WAITS wait) {

		switch(wait) {

		case IMPLICIT:
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case EXPLICIT:
			WebDriverWait wWait = new WebDriverWait(driver, 15);
			return wWait;		
		case FLUENT: 
			break;
		case THREAD:
			break;
		default:

		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String status = "Test failed";
		String baseUrl = "https://www.shopclues.com/";
		System.setProperty("webdriver.chrome.driver", "/home/rmuruge/tools/webdrivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1400,600");
		//using options to maximize window.
		options.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		System.out.println("Starting Assignment IV...");
		// Navigate to an URL
		driver.get(baseUrl);
		
		// Wait for the pop-up using implicit wait.
		waitForElement(driver, WAITS.IMPLICIT);
		driver.findElement(By.xpath("//button[contains(@class,'block')]")).click();
		System.out.println("Found and closed the Pop-Up.");
		//Button Close - Covid message
		driver.findElement(By.id("btnCloseInfo")).click();
		System.out.println("Found and closed Covid Message.");
		// Click on SignIn Link
		waitForElement(driver, WAITS.EXPLICIT).until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In"))).click();
		System.out.println("Clicked Sign-in.");
		//wait for Benefits, one image, login sections to display
		waitForElement(driver,WAITS.EXPLICIT).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'benefits_section')]")));
		waitForElement(driver,WAITS.EXPLICIT).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//i[contains(@class, 'loyalty')]")));
		waitForElement(driver,WAITS.EXPLICIT).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'login_sec')]")));
		System.out.println("Benefits Section, Loyalty Icon and Login Sections are visible.");
		// Once Login screen comes up enter login and password
		driver.findElement(By.id("main_user_login")).sendKeys("batman554466@gmail.com");
		driver.findElement(By.name("password")).sendKeys("batman554466");
		System.out.println("Entered user and password.");
		// Click on the login button. assuming if login_sec is located login button should be visible.
		driver.findElement(By.linkText("Login")).click();
		System.out.println("Login clicked");
		String message = "none";
		
		// locate Login error
		message = waitForElement(driver, WAITS.EXPLICIT).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'password_err')]"))).getText();
		System.out.println("Login error message is : "+ message);
		try {
			Assert.assertEquals(message, LOGIN_ERROR);
			status = "Test Passed.";
		} catch (AssertionError e) {
			try { 
				Assert.assertEquals(message, LOGIN_ERROR_MAX);
				status = "Test Passed.";
			} catch (AssertionError er) {
				System.out.println(e.getMessage());	
			}
			System.out.println(e.getMessage());
		} finally {
			// quite browser 
			System.out.println(status);
			driver.quit();
			System.out.println("Closed browser. This concludes Assignment IV.");
		}


	}

}

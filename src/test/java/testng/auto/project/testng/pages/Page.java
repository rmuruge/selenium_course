package testng.auto.project.testng.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testng.auto.project.testng.utils.PageWaits;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected static WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
	static Logger log = Logger.getLogger(Page.class);
	public Page(WebDriver d) {
    driver = d;
  }

  public String getTitle() {
    return driver.getTitle();
  }
  
  public static WebDriverWait waitForElement (PageWaits.WAITS wait) {

		switch(wait) {

		case IMPLICIT:
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case EXPLICIT:
			return new WebDriverWait(driver, 5);
		case FLUENT:
			log.debug("FLUENT wait is not implemented in waitForElement method");
			break;
		case THREAD:

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:

		}
		return null;
	}

  public static WebElement waitForElement (PageWaits.WAITS wait, PageWaits.WAIT_ACTION action, WebElement element) {

		switch(wait) {

		case IMPLICIT:
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case EXPLICIT:
			WebDriverWait wWait = new WebDriverWait(driver, 10);
			switch (action) {
			case BUTTON:
				wWait.until(ExpectedConditions.elementToBeClickable(element));
			break;
			case VISIBLE: 
				wWait.until(ExpectedConditions.visibilityOf(element));
				break;
			default:
				wWait.until(ExpectedConditions.visibilityOf(element));
			}
			return element;		
			
		case FLUENT: 
			break;
		case THREAD:
			break;
		default:

		}
		return null;
	}
  
  
	public void switchTab (int i) {
		ArrayList <String> tab = new ArrayList <String> (driver.getWindowHandles());
		driver.switchTo().window(tab.get(i));
		log.debug("Tab Name is " + tab.get(i) + "  " + driver.getTitle());
	}
}

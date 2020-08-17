package testng.auto.project.testng.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testng.auto.project.testng.utils.Enumerations;
import testng.auto.project.testng.utils.Enumerations.WAITS;
import testng.auto.project.testng.utils.Enumerations.WAIT_ACTION;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected static WebDriver driver;


	@FindBy(how = How.XPATH, using = "//div[@class='breadcrums']/ul")
	public WebElement breadCrums;
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
  
  public static WebDriverWait waitForElement (Enumerations.WAITS wait) {

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

  public static WebElement waitForElement (Enumerations.WAITS wait, Enumerations.WAIT_ACTION action, WebElement element) {

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
	
	public WebElement getWebElement(String element, Enumerations.FINDBY findby) {
		WebElement webElement;
		switch (findby) {
		case XPATH:
			webElement = waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE,
					driver.findElement(By.xpath(element)));
			break;
		case ID:
			webElement = waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE,
					driver.findElement(By.id(element)));
			break;
		case LINK:
			webElement = waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE,
					driver.findElement(By.linkText(element)));
			break;
		case CSS:
			webElement = waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE,
					driver.findElement(By.cssSelector(element)));
			break;
		default:
			webElement = waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE,
					driver.findElement(By.name(element)));
		}
		return webElement;
	}
	
	public String getBreadCrums () {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE,breadCrums);
		List <WebElement> crums = breadCrums.findElements(By.tagName("li"));
		log.debug("Crums Size is " + crums.size());
		return crums.get(crums.size()-1).getText();
	}
}

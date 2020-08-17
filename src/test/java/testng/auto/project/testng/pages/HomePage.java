package testng.auto.project.testng.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testng.auto.project.testng.TestNgTestBase;
import testng.auto.project.testng.utils.Enumerations.WAITS;

/**
 * Sample page
 */
public class HomePage extends Page {

	static Logger log = Logger.getLogger(HomePage.class);
	
  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  
  public String observeDropdowns (By by) {
	 String text = waitForElement(WAITS.EXPLICIT).until(ExpectedConditions.visibilityOf(driver
			  .findElement(by))).getText();
	 
	 return text;
	  
  }
  
  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }
}

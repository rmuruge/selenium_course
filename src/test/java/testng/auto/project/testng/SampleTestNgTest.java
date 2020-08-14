package testng.auto.project.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import testng.auto.project.testng.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test (priority=0)
  public void testObserver3Dropdowns() {
    driver.get(baseUrl);
    
    //homepage.observeDropdowns();
    By by = By.xpath("//label[contains(@for, 'countryCode')]");
    Assert.assertTrue("Country Name".equals(homepage.observeDropdowns(by)));
    
    by = By.xpath("//label[contains(@for, 'regionName')]");
    Assert.assertTrue("Region Name".equals(homepage.observeDropdowns(by)));
    
    by = By.xpath("//label[contains(@for, 'cityName')]");
    Assert.assertTrue("City Name".equals(homepage.observeDropdowns(by)));
  }
  
  @Test (priority=1)
  
  public void testSelectCountry() {
  
	  By by = By.id("countryCode");
	  Select coDrop = new Select (driver.findElement(by));		 
	  coDrop.selectByValue("AU");
	  Assert.assertEquals(coDrop.getFirstSelectedOption().getText().trim(),"Australia");
  }

  @Test (priority=2)
  public void testSelectRegion() throws InterruptedException {
  
	  By by = By.id("regionName");
	  Select regDrop = new Select (driver.findElement(by));
	  List <WebElement> options =  regDrop.getOptions();
	  if (options.size()>1) {
		 regDrop.selectByVisibleText("Western Australia");
	  }
	  Assert.assertEquals(regDrop.getFirstSelectedOption().getText().trim(),"Western Australia");
  }
  
  
  @Test (priority=3)
  public void testCityName() {
	  
	  By byCity = By.id("cityName");
	  Select cityDrop = new Select (driver.findElement(byCity));
	  List <WebElement> options =  cityDrop.getOptions();
	  if (options.size()>1) {
		 cityDrop.selectByVisibleText("Perth");
	  }
			 
	  Assert.assertEquals(cityDrop.getFirstSelectedOption().getText().trim(),"Perth");
  }
}

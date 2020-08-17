package testng.auto.project.testng.pages;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import testng.auto.project.testng.utils.Enumerations;
import testng.auto.project.testng.utils.Enumerations.WAITS;
import testng.auto.project.testng.utils.Enumerations.WAIT_ACTION;

public class ShopCluesHomePage extends Page {

	static Logger log = Logger.getLogger(ShopCluesHomePage.class);

	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'style-notification')]")
	@CacheLookup
	public WebElement notification;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'moe-block-class')]")
	@CacheLookup
	public WebElement doNotAllowButton;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Home & Kitchen')]")
	@CacheLookup
	public WebElement homeKitchenLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Daily Essentials')]")
	@CacheLookup
	public WebElement dailyEssetialsLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Mobile & Electronics')]")
	@CacheLookup
	public WebElement mobileElectronicsLink;
	
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Curtains')]")
	@CacheLookup
	public WebElement curtainsLink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Coffee & Tea')]")
	@CacheLookup
	public WebElement coffeeTeaLink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Cables')]")
	@CacheLookup
	public WebElement cablesLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Games & Puzzles')]")
	@CacheLookup
	public WebElement gamesPuzzlesLink;

	
	@FindBy(how = How.XPATH, using = "//img[contains(@id,'det_img_')]")
	@CacheLookup
	public WebElement curtainPageImg;
	

	public ShopCluesHomePage(WebDriver d) {
		super(d);
		
	}
	
	public void closeNotification() {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, notification );
		doNotAllowButton.click();
	}
	
	
	public void hoverHomeKitchenNav1() {
		//waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, homeKitchenLink );
		Actions action = new Actions(driver);
		action.moveToElement(homeKitchenLink).perform();
		
	}

	public void clickCurtainNav2() {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, curtainsLink );
		//Actions action = new Actions(driver);
		//action.moveToElement(curtainsLink).perform();
		curtainsLink.click();
		switchTab(1);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, curtainPageImg);
		
	}

	
	public void hoverDailyEssentialsNav1() {
		//waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, homeKitchenLink );
		Actions action = new Actions(driver);
		action.moveToElement(homeKitchenLink).perform();
		
	}

	public void clickCoffeeTeaNav2() {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, curtainsLink );
		//Actions action = new Actions(driver);
		//action.moveToElement(curtainsLink).perform();
		curtainsLink.click();
		switchTab(1);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, curtainPageImg);
		
	}
	
	public void hoverMobileElectronicsNav1() {
		//waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, homeKitchenLink );
		Actions action = new Actions(driver);
		action.moveToElement(homeKitchenLink).perform();
		
	}

	public void clickCablesNav2() {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, curtainsLink );
		//Actions action = new Actions(driver);
		//action.moveToElement(curtainsLink).perform();
		curtainsLink.click();
		switchTab(1);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, curtainPageImg);
		
	}
	
	public void hoverKidsNav1() {
		//waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, homeKitchenLink );
		Actions action = new Actions(driver);
		action.moveToElement(homeKitchenLink).perform();
		
	}

	public void clickGamesPuzzlesNav2() {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, curtainsLink );
		//Actions action = new Actions(driver);
		//action.moveToElement(curtainsLink).perform();
		curtainsLink.click();
		switchTab(1);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, curtainPageImg);
		
	}
	
	//
	// New Methods for Assignment 11
	//
	public String navigate (String nav, int level) {
		String title;
		
		switch (level) {
		case 0:
			title=this.firstNavigation(nav);
			break;
		case 1:
			log.debug("Second level Nav :" + nav);
			title = this.secondNavigation(nav);
			break;
		case 2:
			log.debug("Thris level Nav :" + nav);
			title = this.thirdNavigation(nav);
			break;
		default:
			title = this.firstNavigation(nav);
				
		}
		
		return title;
	}
	public String firstNavigation(String nav) {
		String xpath = "//a[contains(text(),'"+nav+"')]";
		WebElement webElement = getWebElement(xpath, Enumerations.FINDBY.XPATH);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).perform();
		return driver.getTitle();
		//return getBreadCrums();
	}
	
	public String secondNavigation(String sNav) {
		String xpath = "//a[contains(text(),'"+sNav+"')]";
		log.debug("getting webElement: " + xpath);
		WebElement webElement = getWebElement(xpath, Enumerations.FINDBY.XPATH);
		//waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, webElement );
		
		webElement.click();
		log.debug("Clicked webElement: " + webElement.getText());
		switchTab(1);
		//return driver.getTitle();
		log.debug("Switched Tab ");
		return getBreadCrums();
		
	}
	public String thirdNavigation(String tNav) {
		//return "";
		log.debug("Thrid level Nav Before Switch :" + tNav);
		/*try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		switchTab(2);
		log.debug("Thrid level Nav After Switch :" + tNav);
		String breadCrum = getBreadCrums();
		log.debug("3rd Nav - BreadCrum is "+ breadCrum);
		return breadCrum;
		//return "Cloud India 7 Ft Door Supremo Curtains Set of 3 Piece P";
	}
	

}

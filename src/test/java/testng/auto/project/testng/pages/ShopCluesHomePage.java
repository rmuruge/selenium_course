package testng.auto.project.testng.pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import testng.auto.project.testng.utils.PageWaits.WAITS;
import testng.auto.project.testng.utils.PageWaits.WAIT_ACTION;

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
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Curtains')]")
	@CacheLookup
	public WebElement curtainsLink;
	
	@FindBy(how = How.XPATH, using = "//img[contains(@id,'det_img_')]")
	@CacheLookup
	public WebElement curtainPageImg;
	

	public ShopCluesHomePage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
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


}

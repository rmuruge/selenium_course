package testng.auto.project.testng.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import testng.auto.project.testng.utils.PageWaits.WAITS;
import testng.auto.project.testng.utils.PageWaits.WAIT_ACTION;

public class ShopCluesProductDetail extends Page{

	public ShopCluesProductDetail(WebDriver d) {
		// TODO Auto-generated constructor stub
		super(d);
		
	}
	
	static Logger log = Logger.getLogger(ShopCluesProductDetail.class);

	
	@FindBy(how = How.XPATH, using = "//button[contains(@id,'add_cart')]")
	@CacheLookup
	public WebElement addToCartButton;

	@FindBy(how = How.XPATH, using = "//div[@id='snackbar' and @class='show']")
	@CacheLookup
	public WebElement confirmation;
	
	
	public void clickAddToCart () {
		
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, addToCartButton);
		log.debug("add to cart is " + addToCartButton.getText());
		addToCartButton.click();

	}
	
	
	public String confirmAddToCart () {
		
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, confirmation);

		log.debug("Message is : " + confirmation.getText());
		return confirmation.getText();

	}

}

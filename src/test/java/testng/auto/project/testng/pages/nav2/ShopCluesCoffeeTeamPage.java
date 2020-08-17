package testng.auto.project.testng.pages.nav2;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import testng.auto.project.testng.pages.Page;
import testng.auto.project.testng.utils.Enumerations.WAITS;
import testng.auto.project.testng.utils.Enumerations.WAIT_ACTION;

public class ShopCluesCoffeeTeamPage extends Page {

	public ShopCluesCoffeeTeamPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	static Logger log = Logger.getLogger(ShopCluesCoffeeTeamPage.class);

	
	@FindBy(how = How.XPATH, using = "//img[contains(@id,'det_img')]")
	@CacheLookup
	public List <WebElement> productImages;
	
	
	public boolean clickProductImage (int index) {
		
		WebElement element;
		boolean ret = false;
		
		if (index < productImages.size()) {
			element = productImages.get(index);
			waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, element );
			element.click();
			switchTab(2);
			ret = true;
		}

		return ret; 
	}
}

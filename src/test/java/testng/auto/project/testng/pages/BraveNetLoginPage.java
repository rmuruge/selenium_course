package testng.auto.project.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import testng.auto.project.testng.utils.Enumerations.WAITS;
import testng.auto.project.testng.utils.Enumerations.WAIT_ACTION;

public class BraveNetLoginPage extends Page {
	
	@FindBy(how = How.ID, using = "userid")
	@CacheLookup
	public WebElement userid;

	@FindBy(how = How.ID, using = "password")
	@CacheLookup
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@class='md-button md-accent md-raised md-theme-default']")
	@CacheLookup
	public WebElement login;
	
	@FindBy(how = How.XPATH, using = "//div[@class='error-container']")
	@CacheLookup
	public WebElement loing_error_message;
	
	@FindBy(how = How.XPATH, using = "//span[@class='md-error']")
	@CacheLookup
	public WebElement message;
	
	public BraveNetLoginPage(WebDriver d) {
		super(d);
	}
	
	public String login(String user, String pass) {
		String msg="";
		waitForElement(WAITS.EXPLICIT,WAIT_ACTION.BUTTON,login);
		userid.clear();
		userid.sendKeys(user);
		
		userid.clear();
		password.sendKeys(pass);
		login.click();
		waitForElement(WAITS.EXPLICIT,WAIT_ACTION.VISIBLE,message);
		msg = message.getText();
		return msg;
		
	}

}

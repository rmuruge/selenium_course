package testng.auto.project.testng.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testng.auto.project.testng.utils.PageWaits.WAITS;

public class GoFilePage extends Page {

	static Logger log = Logger.getLogger(GoFilePage.class);

	@FindBy(how = How.ID, using = "btnChooseFiles")
	@CacheLookup
	public WebElement chooseFilesButton;
/*
	@FindBy(how = How.ID, using = "btnUpload")
	@CacheLookup
	public WebElement uploadButton;
	*/
	
	@FindBy(how = How.ID, using = "mainContent")
	@CacheLookup
	public WebElement mainContent;
	
	@FindBy(how = How.XPATH, using = "//button[@id='btnUpload']")
	@CacheLookup
	public WebElement uploadButton;
	
	@FindBy(how = How.XPATH, using = "//tr[@id=\"file_0\"]/td[1]")
	@CacheLookup
	public WebElement uploadedFile;
	
	@FindBy(how = How.XPATH, using = "//h2[@id='swal2-title']")
	@CacheLookup
	public WebElement successMsg;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'confirm')]")
	@CacheLookup
	public WebElement confirmOkButton;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'swal2-show')]")
	@CacheLookup
	public WebElement okDiv;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'alert-success')]/span")
	@CacheLookup
	public WebElement successAlert;
	
	public void clickChooseFilesButton (){
		waitForElement(WAITS.EXPLICIT).until(ExpectedConditions.visibilityOf(chooseFilesButton));
		log.debug("Text in the Button is " + chooseFilesButton.getText());
		chooseFilesButton.click();
	}
	
	public void chooseFile (String filePath) throws AWTException, InterruptedException {
		StringSelection fileSelected = new StringSelection (filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileSelected, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public String validateUploadeFile() {
		waitForElement(WAITS.EXPLICIT).until(ExpectedConditions.visibilityOf(uploadedFile));
		return uploadedFile.getText();
	}

	public String uploadFile() {
		waitForElement(WAITS.EXPLICIT).until(ExpectedConditions.elementToBeClickable(uploadButton));
		//Actions action = new Actions(driver);
		//action.moveToElement(uploadButton).click().perform();	
		uploadButton.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return successMsg.getText();
	}
	public String clickOk() {
		waitForElement(WAITS.EXPLICIT).until(ExpectedConditions.visibilityOf(confirmOkButton));
		confirmOkButton.click();
		waitForElement(WAITS.EXPLICIT).until(ExpectedConditions.visibilityOf(successAlert));
		return successAlert.getText();	
	}
	public GoFilePage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
}

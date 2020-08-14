package testng.auto.project.testng;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testng.auto.project.testng.pages.GoFilePage;


public class RoboAssignmentVIII extends TestNgTestBase {

	static Logger log = Logger.getLogger(RoboAssignmentVIII.class);
	private GoFilePage page;
	private static String FILE="x";
	private static String PATH="/home/rmuruge/";
	
	
	public RoboAssignmentVIII() {
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void initPageObjects() {
	   page = PageFactory.initElements(driver, GoFilePage.class);
	}
	
	@Test (priority=0)
	public void testClickHereButton() throws Exception {
		driver.get(baseUrl);
		page.clickChooseFilesButton();		
	}
	
	@Test (priority=1)
	public void testChooseFile() throws AWTException, InterruptedException {
		page.chooseFile(PATH+FILE);		
	}
	
	@Test (priority=2)
	public void testValidateUploadeFile() {
		String result = page.validateUploadeFile();	
		Assert.assertEquals(result, FILE);
	}
	@Test (priority=3)
	public void testUploadFile() {
		String result = page.uploadFile();
		Assert.assertEquals(result, "Success !");
	}
	@Test (priority=4)
	public void testClickOk() {
		String result = page.clickOk();
		Assert.assertEquals(result, "Your files have been successfully uploaded");
	}

}

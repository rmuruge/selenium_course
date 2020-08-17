package testng.auto.project.testng;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testng.auto.project.testng.pages.ShopCluesHomePage;
import testng.auto.project.testng.pages.nav2.ShopCluesHomeFurnishingCurtains;
import testng.auto.project.testng.pages.nav3.ShopCluesProductDetail;
import testng.auto.project.testng.utils.StringUtils;
import testng.auto.project.testng.utils.TestDataLoader;

public class AssignmentXIDDXML extends TestNgTestBase {

	static Logger log = Logger.getLogger(AssignmentXIDDXML.class);
	
	public AssignmentXIDDXML() {
		// TODO Auto-generated constructor stub
	}

	//TestDataLoader
	private ShopCluesHomePage page;
	private ShopCluesHomeFurnishingCurtains curtainPage;
	private ShopCluesProductDetail detailPage;
	private TestDataLoader td;
	private String [] scenarios;
	private Map <String, String> testParmData;
	
	@BeforeClass
	public void initPageObjects() {
	   
	   page = PageFactory.initElements(driver, ShopCluesHomePage.class);
	   curtainPage = PageFactory.initElements(driver, ShopCluesHomeFurnishingCurtains.class);
	   detailPage =  PageFactory.initElements(driver, ShopCluesProductDetail.class);
	}
	
	@BeforeTest
	public void initTestData () {
		ITestContext itc = Reporter.getCurrentTestResult().getTestContext();
		ISuite is = itc.getSuite();
		testParmData = is.getXmlSuite().getAllParameters();
		td = new TestDataLoader();
		td.loadTestDataMap(testParmData);
		
	}
	@Test (priority=0)
	public void runScenarios() throws Exception {
		String scenario;
		String pageTitle;
		String productName=null;
		String currWindowHandle;
		String homeWindowHandle;
		
		Map <String, String []> scenarios;
		String [] navs;
		driver.get(baseUrl);
		page.closeNotification();
		homeWindowHandle = driver.getWindowHandle();
		
		scenarios = td.getTestScenarioMap();
		
		Iterator <String> iter = scenarios.keySet().iterator();
		
		while(iter.hasNext()) {
			scenario = iter.next();
			navs = scenarios.get(scenario);
			log.debug("Navs has " + navs.length + " items");
			
			for (int i=0; i < navs.length; i++) {
				log.debug("Being iteration # " + i);
				log.debug(i + "  is "+ navs[i]);
				pageTitle = page.navigate(navs[i],i);
				log.debug(i + " Page Title is " + pageTitle);
				currWindowHandle = driver.getWindowHandle();
				log.debug(i + " current window handle is " + currWindowHandle);
				if (pageTitle.startsWith("Curtains")) {
					log.debug("Inside Curtain..." + i);
					productName = curtainPage.getProductName(i);
					log.debug("Product Name is " + productName);
					Assert.assertEquals(curtainPage.clickProductImage(i),true);
				} else if (pageTitle.contains("Coffee")) {
					log.debug("Inside Curtain..." + i);
					productName = curtainPage.getProductName(i);
					log.debug("Product Name is " + productName);
					Assert.assertEquals(curtainPage.clickProductImage(i),true);
				} else if (pageTitle.contains("Cables")) {
					log.debug("Inside Cable..." + i);
					productName = curtainPage.getProductName(i);
					log.debug("Product Name is " + productName);
					Assert.assertEquals(curtainPage.clickProductImage(i),true);
				}
				
				if (productName != null && pageTitle.contains(productName)) {
					log.debug("Product Name is for 3rd: " + productName);
					detailPage.clickAddToCart();
					detailPage.confirmAddToCart();
				}
				log.debug("End iteration # "+ i);		
				
			}
			closeAllTabsBut(homeWindowHandle);
			driver.switchTo().window(homeWindowHandle);
			
		}
	}
	
	
	// 1. Hover on Nav1
	// 2. Click Nav 2
	/*
	@Test (priority=0)
	@Parameters ({"runScenarios",str})
	
	
	public void runTests(String runScenarios) {
		String [] scenarios = StringUtils.parseString(runScenarios, ",");
		for(int i=0; i < scenarios.length; i++) {
			//scenaios[i].
		}
	}
	
	@Test (priority=1)
	@Parameters ({"scenario1", "delimit"})
	public void testHoverHomeKitchenNav1(String scenario1, String delimit) throws AWTException, InterruptedException {
		String[] navs = StringUtils.parseString(scenario1, delimit);
		//page.runScenario(navs);
		//page.hoverHomeKitchenNav1();
	} */
}

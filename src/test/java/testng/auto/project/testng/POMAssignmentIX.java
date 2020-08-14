package testng.auto.project.testng;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testng.auto.project.testng.pages.ShopCluesHomeFurnishingCurtains;
import testng.auto.project.testng.pages.ShopCluesHomePage;
import testng.auto.project.testng.pages.ShopCluesProductDetail;

public class POMAssignmentIX extends TestNgTestBase {

	public POMAssignmentIX() {
		// TODO Auto-generated constructor stub
	}
	
	static Logger log = Logger.getLogger(POMAssignmentIX.class);
	private ShopCluesHomePage page;
	private ShopCluesHomeFurnishingCurtains curtainPage;
	private ShopCluesProductDetail detailPage;
	
	@BeforeClass
	public void initPageObjects() {
	   page = PageFactory.initElements(driver, ShopCluesHomePage.class);
	   curtainPage = PageFactory.initElements(driver, ShopCluesHomeFurnishingCurtains.class);
	   detailPage =  PageFactory.initElements(driver, ShopCluesProductDetail.class);
	}
	
	
	
	@Test (priority=0)
	public void testCloseNotification() throws Exception {
		driver.get(baseUrl);
		page.closeNotification();;		
	}
	
	@Test (priority=1)
	public void testHoverHomeKitchenNav1() throws AWTException, InterruptedException {
		page.hoverHomeKitchenNav1();		
	}
	
	@Test (priority=2)
	public void testClickCurtainNav2() {
		page.clickCurtainNav2();
		
	}
	@Test (priority=3)
	public void testClickProductImage() {
	
		Assert.assertEquals(curtainPage.clickProductImage(1),true);
	}
	@Test (priority=4)
	public void testClickAddToCart () {
		detailPage.clickAddToCart();
	}
	@Test (priority=5)
	public void testConfirmAddToCart () {
		
		Assert.assertEquals(detailPage.confirmAddToCart(), "Product added to cart");
	}
}

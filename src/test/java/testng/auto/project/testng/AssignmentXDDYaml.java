/**
 * 
 */
package testng.auto.project.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.yaml.snakeyaml.Yaml;

import testng.auto.project.testng.pages.BraveNetLoginPage;


/**
 * @author rmuruge
 *
 */
public class AssignmentXDDYaml extends TestNgTestBase {

	/**
	 * 
	 */
	public AssignmentXDDYaml() {
		// TODO Auto-generated constructor stub
	}

	static Logger log = Logger.getLogger(AssignmentXDDYaml.class);
	
	private static String INVALID_LOGIN_ERROR = "You must login with your username";
	BraveNetLoginPage page;
	Yaml yaml;
	InputStream is;
	Map <String, String> testData;

	@BeforeClass
	public void initPageObjects() throws FileNotFoundException {
	   page = PageFactory.initElements(driver, BraveNetLoginPage.class);
	   String dataFile = "testdata/assignment10_credentials.yml";
	   yaml = new Yaml();
	   is = new FileInputStream(dataFile);
	   testData = yaml.load(is);
	}
	
	@Test (priority=0)
	public void testInvalidLogin() throws Exception {
		driver.get(baseUrl);
		String expected="";
		for(int i=1; i < testData.size()/2; i++) {
			expected = page.login(testData.get("username"+i), testData.get("password"+1));
			Assert.assertEquals(expected, INVALID_LOGIN_ERROR);
		}
	}
}

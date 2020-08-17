package testng.auto.project.testng.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;




public class TestDataLoader implements ProjectConstants {

	static Logger log = Logger.getLogger(TestDataLoader.class);
	private  Map <String, String[]> testScenarioMap = new HashMap <String, String[]>();

	//private List <String> navList = new ArrayList <String> ();
	public TestDataLoader() {
		// TODO Auto-generated constructor stub
	}
	
	/*@Parameters ({
	  "Nav-Range",
	  "Product-Range",
	  "Nav1",
	  "Nav2",
	  "Nav3",
	  "Nav4",
	  "Nav1-Product1",
	  "Nav2-Product1",
	  "Nav3-Product1",
	  "Nav4-Product1"}) */

	public void loadTestDataMap(Map <String, String> testParmData) {
		
		String [] scenarios = StringUtils.parseString(testParmData.get(RUN_SCENARIOS),COMMA_DELIMIT,true);
		String [] navPath;

		for (String scenario: scenarios) {
			String nav = testParmData.get(scenario);
			navPath = StringUtils.parseString(nav, NAV_DELIMIT,true);
			testScenarioMap.put(scenario, navPath);
		}
			
	}

	/*
	public void loadTestData(Map <String, String> testParmData) {
		
		String [] scenarios = StringUtils.parseString(testParmData.get(RUN_SCENARIOS),COMMA_DELIMIT,true);
		String [] navPath;
		for (String scenario: scenarios) {
			String nav = testParmData.get(scenario);
			testScenarioMap.put(scenario, nav);
			navPath = StringUtils.parseString(nav, NAV_DELIMIT,true);
			for (int i=0; i< navPath.length; i++) {
				navScenarioMap.put(scenario+NAV_INDEX+i, navPath[i]);
			}
		}
			
	}
	*/

	public Map<String, String[]> getTestScenarioMap() {
		return testScenarioMap;
	}

}

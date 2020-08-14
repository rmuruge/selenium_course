package testng.auto.project.testng;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Loads test suite configuration from resource files.
 */
public class SuiteConfiguration {

	static Logger log = Logger.getLogger(SuiteConfiguration.class);
  private static final String DEBUG_PROPERTIES = "/debug.properties";

  private Properties properties;
  private Map <String, Capabilities> capabilitiesMap;
  
  public SuiteConfiguration() throws IOException {
  	this(System.getProperty("application.properties", DEBUG_PROPERTIES));
  	//initiaizeCapabilities();
  }

  public SuiteConfiguration(String fromResource) throws IOException {
    properties = new Properties();
    properties.load(SuiteConfiguration.class.getResourceAsStream(fromResource));
    this.initiaizeCapabilities();
  }

  public Capabilities getCapabilities(String browserName) {
	  return capabilitiesMap.get(browserName);
  }
  
  public void initiaizeCapabilities() throws IOException {
	String multi = properties.getProperty("browsers");
    String [] browsers = multi.split(",");
    Properties capsProps;
    capabilitiesMap = new HashMap <String, Capabilities> ();
    DesiredCapabilities capabilities;
    
    for (String browser : browsers ) {
    	capsProps = new Properties();
    	capsProps.load(SuiteConfiguration.class.getResourceAsStream("/"+browser+".capabilities"));
        capabilities = new DesiredCapabilities();
        for (String name : capsProps.stringPropertyNames()) {
            String value = capsProps.getProperty(name);
            if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
              capabilities.setCapability(name, Boolean.valueOf(value));
            } else if (value.startsWith("file:")) {
              capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
            } else if (name.contains(".driver")) {
          	  System.setProperty(name, value);
            } else {
              capabilities.setCapability(name, value);
            }        
          }
        capabilitiesMap.put(browser, capabilities);
    }
    log.debug("Capability Map is : "+ capabilitiesMap);
  }

  public boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  public String getProperty(String name) {
    return properties.getProperty(name);
  }
}

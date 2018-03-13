package vv.selenidesamples.framework.baseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Configuration.pageLoadStrategy;
import static com.codeborne.selenide.Configuration.remote;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


/**
 * Base test class for site testing. All test classes extend this class.
 * @author v.vyshenskyy 
 */
@Listeners({ ScreenShooter.class})

public abstract class BaseTest {
	// All these configurations are static in Selenide. We set their values only once.
	{
		browser = EnvironmentProperties.getBrowser();
		timeout = EnvironmentProperties.getSelenideTimeout();
		baseUrl = EnvironmentProperties.getBaseUrl();
		remote = EnvironmentProperties.getRemote();
		pageLoadStrategy = "normal";
	}
	
	/**
	 * This file contains the values like login password,  etc. that we use in the test class. <p>
	 * By default, we take the path to this file from the system variable;
	 *  we can set it in Maven pom file, <argLine> in maven-surefire-plugin  e.g. <br>
	 * <code> -Denvironment.file.name = ti; </code> <br>
	 * so we can use the same test class with different test environments. <p>  
	 * If a particular test class can be used only with a specific test environment,
	 *  we can specify this file in the static part of the test class, e.g. 
	 *  <code>
	 *  {
	 *  testPropertyFile = "ti";
	 *  }
	 *  </code> 
	 *  
	 *	 */
	protected String testPropertyFile = "";
	
	protected EnvironmentProperties environmentProperties;
	
	/**  
	 *  
	 * @param testPropertyFile in the TestNG xml file can override the default file for 
	 *  environment properties <br>
	 * 
	 *  If a child class implements {@link LoginBeforeClass} interface, we log in to the application before test class 
	 */
	@BeforeClass
	@Parameters ({"testPropertyFile"}) 
	public void setUp(@Optional("") String environmentPropertyFileName) {
		// Parameter overrides the value from class
		if(!"".equals(environmentPropertyFileName)) {
			testPropertyFile = environmentPropertyFileName;
		}
		environmentProperties = new EnvironmentProperties(testPropertyFile);
		openTestUrl();
		if(this instanceof LoginBeforeClass ) {
			loginToTestUrl();
		} 
	}
	
	/**
	 * @param testMethod used to log the running test method name
	 * 
	 * If a child class implements {@link LoginBeforeMethod} interface, we log in to the application before every test method 
	 */
	@BeforeMethod
	public void loginToApplication() {
		if(this instanceof LoginBeforeMethod ) {
			loginToTestUrl();
		}
	}
	
	
	/**
	 * Login to test environment 
	 */
	protected void loginToTestUrl() {

	}
	
	protected void openTestUrl() {
		String testUrl = environmentProperties.getTestUrl();
		open(testUrl);
	}


	
	
}

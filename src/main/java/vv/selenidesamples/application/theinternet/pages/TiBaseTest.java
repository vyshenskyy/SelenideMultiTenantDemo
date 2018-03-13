package vv.selenidesamples.application.theinternet.pages;

import vv.selenidesamples.framework.baseTest.BaseTest;
import static com.codeborne.selenide.Selenide.open;

public class TiBaseTest extends BaseTest {
	protected TiAbstractPage currentPage;
	
	protected TiLoginPage goToLoginPage() {
		String testUrl = environmentProperties.getLoginUrl();
		return open(testUrl, TiLoginPage.class);
	}
	
	/**
	 * Login to test environment 
	 */
	@Override
	protected void loginToTestUrl() {
		TiLoginPage loginPage = goToLoginPage();
		String loginName = environmentProperties.getLoginName();
		String password = environmentProperties.getPassword();
		currentPage = loginPage.doLogin(loginName, password); 
	}
}

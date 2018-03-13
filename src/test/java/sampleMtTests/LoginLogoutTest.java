package sampleMtTests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

import vv.selenidesamples.application.multitenant.pages.MtBaseTest;
import vv.selenidesamples.application.multitenant.pages.MtLoginPage;
import vv.selenidesamples.application.multitenant.pages.MtSitePage;

public class LoginLogoutTest extends MtBaseTest {

	@Test
	public void loginLogoutTest() {
		MtLoginPage loginPage = goToLoginPage();
		MtSitePage sitePage = loginPage.doLogin(environmentProperties.getLoginName(), environmentProperties.getPassword(), tenant);
		sitePage.shouldSeeCommon();
		sitePage.shouldBeLoggedIn();
		MtLoginPage loginPage2 = sitePage.doLogout();
		loginPage2.getCommonPart().getLogoutElement().shouldNotBe(visible);
		
	}
	
	@Test
	public void loginAndLogoutTest() {
		MtLoginPage loginPage = goToLoginPage();
		MtSitePage sitePage = loginPage.doLogin(environmentProperties.getLoginName(), environmentProperties.getPassword(), tenant);
		MtLoginPage loginPage2 = sitePage.doLogout();
		MtSitePage sitePage2 = loginPage2.doLogin(environmentProperties.getLoginName(), environmentProperties.getPassword(), tenant);
		sitePage2.shouldSeeCommon();
		sitePage2.shouldBeLoggedIn();
	}
}

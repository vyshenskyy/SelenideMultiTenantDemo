package sampleMtTests;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.visible;

import vv.selenidesamples.application.multitenant.pages.MtBaseTest;
import vv.selenidesamples.application.multitenant.pages.MtLoginPage;
import vv.selenidesamples.application.multitenant.pages.MtSitePage;

public class WrongLoginTest extends MtBaseTest {
	@Test
	public void wrongLoginTest() {
		MtLoginPage loginPage = goToLoginPage();
		MtLoginPage sitePage = (MtLoginPage) loginPage.doLogin("asdf", "qwerty", tenant);
		sitePage.getLoginErrorElement().shouldBe(visible);
		sitePage.getCommonPart().getLogoutElement().shouldNotBe(visible);
	}

	@Test
	public void correctAfterWrongLoginTest() {
		MtLoginPage loginPage = goToLoginPage();
		MtLoginPage loginPage2 = (MtLoginPage) loginPage.doLogin("asdf", "qwerty", tenant);
		MtSitePage sitePage =loginPage2.doLogin(environmentProperties.getLoginName(), environmentProperties.getPassword(), tenant);
		sitePage.shouldSeeCommon();
		sitePage.shouldBeLoggedIn();
	}
}

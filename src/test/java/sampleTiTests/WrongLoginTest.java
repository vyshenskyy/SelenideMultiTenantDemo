package sampleTiTests;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;

import vv.selenidesamples.application.theinternet.pages.TiAbstractPage;
import vv.selenidesamples.application.theinternet.pages.TiBaseTest;
import vv.selenidesamples.application.theinternet.pages.TiLoginPage;

public class WrongLoginTest extends TiBaseTest {

	@Test
	public void wrongLoginTest() {
		TiLoginPage loginPage = goToLoginPage();
		TiLoginPage loginPage2 = (TiLoginPage)loginPage.doLogin("abcd","1234");
		loginPage2.getFlashMessages().mustBeError();
		loginPage2.getFlashElement().shouldHave(text("Your username is invalid!"));
		TiLoginPage loginPage3 = (TiLoginPage) loginPage2.doLogin("tomsmith","1234");
		loginPage3.getFlashElement().shouldHave(text("Your password is invalid!"));
	}
	
	@Test
	public void correctAfterWrongLoginTest() {
		TiLoginPage loginPage = goToLoginPage();
		TiLoginPage loginPage2 = (TiLoginPage)loginPage.doLogin("abcd","1234");
		String loginName = environmentProperties.getLoginName();
		String password = environmentProperties.getPassword();
		TiAbstractPage securePage = loginPage2.doLogin(loginName, password);
		securePage.getFlashElement().shouldHave(text("You logged into a secure area!"));
	}
}

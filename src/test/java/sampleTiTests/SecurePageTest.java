package sampleTiTests;


import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;

import vv.selenidesamples.application.theinternet.pages.TiBaseTest;
import vv.selenidesamples.application.theinternet.pages.TiLoginPage;
import vv.selenidesamples.application.theinternet.pages.TiSecureAreaPage;
import vv.selenidesamples.framework.baseTest.LoginBeforeMethod;

public class SecurePageTest extends TiBaseTest implements LoginBeforeMethod{
	{
		   testPropertyFile = "ti";	
	}
	
	
	@Test
	public void logOutTest() {
		TiSecureAreaPage securePage = (TiSecureAreaPage) currentPage;
		TiLoginPage loginPage = securePage.doLogout();
		loginPage.getFlashElement().shouldHave(text("You logged out of the secure area!"));
	}
	
	@Test
	public void closeMessageTest() {
		TiSecureAreaPage securePage = (TiSecureAreaPage) currentPage;
		securePage.getFlashMessages().closeFlashMessage();
		securePage.getFlashElement().shouldNotBe(visible);
	}
}

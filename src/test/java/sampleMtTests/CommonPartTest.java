package sampleMtTests;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import vv.selenidesamples.application.multitenant.pages.MtBaseTest;
import vv.selenidesamples.framework.baseTest.LoginBeforeMethod;

public class CommonPartTest extends MtBaseTest implements LoginBeforeMethod{

	@Test
	public void toggleCommonTextTest() {
		mtPage.getCommonTextElement().shouldNotBe(visible);
		mtPage.toggleCommonText();
		mtPage.getCommonTextElement().shouldHave(text("Common text"));
		mtPage.toggleCommonText();
		mtPage.getCommonTextElement().shouldNotBe(visible);
	}
	
	
}

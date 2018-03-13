package sampleMtTests;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import vv.selenidesamples.application.multitenant.pages.MtBaseTest;
import vv.selenidesamples.framework.baseTest.LoginBeforeMethod;

public class FirstTenantTest extends MtBaseTest implements LoginBeforeMethod{
	   {
	   testPropertyFile = "mt_first";
	   }

	@Test
	public void toggleTextTest() {
		mtPage.getTenantTextElement().shouldNotBe(visible);
		mtPage.toggleTenantText();
		mtPage.getTenantTextElement().shouldHave(text("First text"));
		mtPage.toggleTenantText();
		mtPage.getTenantTextElement().shouldNotBe(visible);
	}
	
	@Test
	public void toggleCommonTextTest() {
		mtPage.getCommonTextElement().shouldNotBe(visible);
		mtPage.toggleCommonText();
		mtPage.getCommonTextElement().shouldHave(text("Common text"));
		mtPage.toggleCommonText();
		mtPage.getCommonTextElement().shouldNotBe(visible);
	}
	
	
}

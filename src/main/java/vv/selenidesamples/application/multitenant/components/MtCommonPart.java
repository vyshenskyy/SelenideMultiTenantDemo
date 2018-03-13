package vv.selenidesamples.application.multitenant.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import vv.selenidesamples.application.multitenant.pages.MtLoginPage;
import vv.selenidesamples.framework.pageObject.PageComponent;

public class MtCommonPart extends PageComponent {
	
	public MtCommonPart() {
		super(null,  "#common");
	}

	public SelenideElement getButtonElement() {
		return $("#common_button");
	}
	
	public void toggleCommonText() {
		getButtonElement().click();
	}	
	public SelenideElement getTextElement() {
		return $("#common_text");
	}
	
	public SelenideElement getLogoutElement() {
		return getPageComponentElement().$(".logout");
	}
	
	public MtLoginPage doLogout() {
		 getLogoutElement().click();
		 return page(MtLoginPage.class);
	}
}

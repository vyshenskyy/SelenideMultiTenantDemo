package vv.selenidesamples.application.theinternet.pages;

import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;

public class TiLoginPage extends TiAbstractPage {

	public TiAbstractPage doLogin(String loginName, String password) {
		SelenideElement loginElement = getContentElement().$("#username");
		SelenideElement passworsElement = getContentElement().$("#password");
		loginElement.setValue(loginName);
		passworsElement.setValue(password);
		SelenideElement loginButtonElement = getContentElement().$("button");
		loginButtonElement.click();
		if(isLoginFailed()) {
			return this;
		} else {
			return page(TiSecureAreaPage.class);
		}
		
	}
	
	public SelenideElement getLoginErrorElement() {
		return getFlashMessages().getPageComponentElement().$(".error");
	}
	
	public boolean isLoginFailed() {
		return getLoginErrorElement().isDisplayed();
	}
}

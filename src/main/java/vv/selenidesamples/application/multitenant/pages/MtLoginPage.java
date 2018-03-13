package vv.selenidesamples.application.multitenant.pages;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MtLoginPage extends MtAbstractPage {
	
	public MtSitePage doLogin(String loginName, String password, MtTenant tenant ) {
		SelenideElement mailElement = $("#login_name");
		SelenideElement passwordElement = $("#password");
		mailElement.setValue(loginName);
		passwordElement.setValue(password);
		SelenideElement loginButton = $("#login_button");
		loginButton.click();
		sleep(100);
		if(isLoginFailed()) {
			return this;
		} else  if (null== tenant) {
			return page(MtHomePage.class);
		} 
		else {
			switch(tenant) {
			case FIRST:
				return page(MtFirstPage.class);
			case SECOND:	
				return page(MtSecondPage.class);
			default: 
				return null;	
			}
		}
		
			
	}

	public SelenideElement getLoginErrorElement() {
		return $("#error");
	}
	
	public boolean isLoginFailed() {
		return getLoginErrorElement().isDisplayed();
	}
	
}

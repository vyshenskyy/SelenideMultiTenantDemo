package vv.selenidesamples.application.theinternet.components;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

import vv.selenidesamples.framework.pageObject.PageComponent;

public class TiFlashMessages extends PageComponent {
	
	public TiFlashMessages() {
		super(null, "#flash-messages");
	}
	
	public SelenideElement getFlashElement() {
		return getPageComponentElement().$("#flash");
	}

	public SelenideElement getCloseFlashElement() {
		return getFlashElement().$("a");
	}
	public String getFlashClasses() {
		return getFlashElement().getAttribute("class");
	}
	
	public void mustBeSuccess() {
		getFlashElement().shouldHave(cssClass("success"));
	}
	
	public void mustBeError() {
		getFlashElement().shouldHave(cssClass("error"));
	}
	
	public void closeFlashMessage() {
		getCloseFlashElement().click();
		getFlashElement().waitUntil(disappears, 2000);
	}
}

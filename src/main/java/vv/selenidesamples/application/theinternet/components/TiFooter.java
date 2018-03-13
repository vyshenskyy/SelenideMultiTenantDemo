package vv.selenidesamples.application.theinternet.components;

import com.codeborne.selenide.SelenideElement;

import vv.selenidesamples.framework.pageObject.PageComponent;

public class TiFooter extends PageComponent {
	public TiFooter() {
		super(null, "#page-footer");
	}
	
	public void goToElementalSeleniumSite() {
		SelenideElement linkElement = getPageComponentElement().$("a");
		linkElement.click();
	}
}

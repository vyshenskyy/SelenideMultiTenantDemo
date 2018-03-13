package vv.selenidesamples.application.multitenant.components;

import com.codeborne.selenide.SelenideElement;

import vv.selenidesamples.framework.pageObject.PageComponent;

public class MtSecondPart extends PageComponent {
	
	public MtSecondPart() {
		super(null, "#second");
	}

	public SelenideElement getButtonElement() {
		return getPageComponentElement().$(".button");
	}
	
	public void toggleText() {
		getButtonElement().click();
	}
	
	public SelenideElement getTextElement() {
		return getPageComponentElement().$(".tenant_text");
	}
}

package vv.selenidesamples.application.multitenant.pages;

import com.codeborne.selenide.SelenideElement;

public class MtSecondPage extends MtAbstractPage {

	@Override
	public void toggleTenantText() {
		getSecondPart().toggleText();
	}
	
	@Override
	public  SelenideElement getTenantTextElement() {
		return getSecondPart().getTextElement();
	}
	
}

package vv.selenidesamples.application.multitenant.pages;

import com.codeborne.selenide.SelenideElement;

public class MtFirstPage extends MtAbstractPage {
	
	@Override
	public void toggleTenantText() {
		getFirstPart().toggleText();
	}
	
	@Override
	public  SelenideElement getTenantTextElement() {
		return getFirstPart().getTextElement();
	}
}

package vv.selenidesamples.application.multitenant.pages;

import com.codeborne.selenide.SelenideElement;

public interface MtSitePage {
	public boolean isLoggedIn();
	public void shouldBeLoggedIn();
	public void shouldSeeCommon();
	public MtLoginPage doLogout();
	public SelenideElement getTenantTextElement();
	public void toggleTenantText();
	public SelenideElement getCommonTextElement();
	public void toggleCommonText();

}

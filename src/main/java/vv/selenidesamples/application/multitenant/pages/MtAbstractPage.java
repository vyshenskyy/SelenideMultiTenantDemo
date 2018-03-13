package vv.selenidesamples.application.multitenant.pages;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;

import vv.selenidesamples.application.multitenant.components.MtCommonPart;
import vv.selenidesamples.application.multitenant.components.MtFirstPart;
import vv.selenidesamples.application.multitenant.components.MtLoginPart;
import vv.selenidesamples.application.multitenant.components.MtSecondPart;

public abstract class MtAbstractPage implements MtSitePage {
	
	private final MtLoginPart loginPart;
	private final MtCommonPart commonPart;
	private final MtFirstPart firstPart;
	private final MtSecondPart secondPart;
	
	public MtAbstractPage() {
		loginPart = new MtLoginPart();
		commonPart = new MtCommonPart();
		firstPart = new MtFirstPart();
		secondPart = new MtSecondPart();
	}
	
	public boolean isLoggedIn() {
		boolean loginDisplayed = loginPart.getPageComponentElement().isDisplayed();
		return !loginDisplayed;
	}

	public MtLoginPart getLoginPart() {
		return loginPart;
	}

	public MtCommonPart getCommonPart() {
		return commonPart;
	}

	public MtFirstPart getFirstPart() {
		return firstPart;
	}

	public MtSecondPart getSecondPart() {
		return secondPart;
	}
	
	public void shouldBeLoggedIn() {
		loginPart.getPageComponentElement().shouldNotBe(visible);
	}
	
	public void shouldSeeCommon() {
		commonPart.getPageComponentElement().shouldBe(visible);
	}
	
	public MtLoginPage doLogout() {
		return commonPart.doLogout();
	}
	
	@Override
	public SelenideElement getTenantTextElement() {
		return null;
	}
	@Override
	public void toggleTenantText() {
		// do nothing
	}
	
	public SelenideElement getCommonTextElement() {
		return getCommonPart().getTextElement();
	}
	public void toggleCommonText() {
		getCommonPart().toggleCommonText();
	}
	
}

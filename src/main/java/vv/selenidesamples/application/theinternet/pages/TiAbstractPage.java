package vv.selenidesamples.application.theinternet.pages;

import com.codeborne.selenide.SelenideElement;

import vv.selenidesamples.application.theinternet.components.TiContent;
import vv.selenidesamples.application.theinternet.components.TiFlashMessages;
import vv.selenidesamples.application.theinternet.components.TiFooter;

public abstract class TiAbstractPage  {
	private final TiFooter footer;
	private final TiContent content;
	private final TiFlashMessages flashMessages;
	
	public TiAbstractPage() {
		footer = new TiFooter();
		content = new TiContent();
		flashMessages = new TiFlashMessages();
		
	}

	public TiFooter getFooter() {
		return footer;
	}

	public TiContent getContent() {
		return content;
	}
	
	public SelenideElement getContentElement() {
		return content.getPageComponentElement();
	}

	public TiFlashMessages getFlashMessages() {
		return flashMessages;
	}
	
	public SelenideElement getFlashElement() {
		return flashMessages.getFlashElement();
	}
	
	public void goToElementalSeleniumSite() {
		footer.goToElementalSeleniumSite();
	}
	
	
}

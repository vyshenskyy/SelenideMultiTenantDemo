package vv.selenidesamples.application.theinternet.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;

public class TiSecureAreaPage extends TiAbstractPage {

	
	public TiLoginPage doLogout() {
		SelenideElement logoutButtonElement = getContentElement().$("a.button");
		logoutButtonElement.click();
		return page(TiLoginPage.class);
	}
}

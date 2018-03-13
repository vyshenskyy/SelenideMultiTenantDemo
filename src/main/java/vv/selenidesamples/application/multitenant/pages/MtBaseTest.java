package vv.selenidesamples.application.multitenant.pages;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import java.net.URL;

import org.testng.annotations.BeforeClass;
import vv.selenidesamples.framework.baseTest.BaseTest;

public class MtBaseTest extends BaseTest {

	protected MtSitePage mtPage;
	
	protected MtTenant tenant;
	
	@BeforeClass
	public void setUpTenant() {
		String tenantName = environmentProperties.getTenant();
		tenant = (null == tenantName) ? null : MtTenant.fromName(tenantName);
	}
	
	protected MtLoginPage goToLoginPage() {
		String testFileName = environmentProperties.getLoginUrl();
		URL resource = getClass().getClassLoader().getResource(testFileName);
		if(null==mtPage) {
			return open(resource, MtLoginPage.class);
		} else if (mtPage.isLoggedIn())  {
			return open(resource, MtLoginPage.class);
		} else {
			return page(MtLoginPage.class);
		}
		
	}
	
	

	@Override
	protected void openTestUrl() {
		mtPage = goToLoginPage();	
	}

	@Override
	protected void loginToTestUrl() {
		MtLoginPage loginPage = goToLoginPage();
		mtPage = loginPage.doLogin(environmentProperties.getLoginName(), environmentProperties.getPassword(), tenant);

	}

}

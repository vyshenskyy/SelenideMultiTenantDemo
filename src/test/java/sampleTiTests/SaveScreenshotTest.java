package sampleTiTests;

import org.testng.annotations.Test;
import vv.selenidesamples.application.theinternet.pages.TiBaseTest;
import vv.selenidesamples.framework.baseTest.LoginBeforeClass;

public class SaveScreenshotTest extends TiBaseTest implements LoginBeforeClass{
	@Test
	public void saveScreenshotTest() {
		currentPage.getFlashMessages().mustBeError(); // Just to take a screenshot
	}
}

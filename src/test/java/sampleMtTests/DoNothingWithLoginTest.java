package sampleMtTests;

import org.testng.annotations.Test;

import vv.selenidesamples.application.multitenant.pages.MtBaseTest;
import vv.selenidesamples.framework.baseTest.LoginBeforeMethod;

public class DoNothingWithLoginTest extends MtBaseTest implements LoginBeforeMethod {
	@Test
	public void doNothingTest() {
		
	}
	
	@Test
	public void doNothingSecondTest() {
		
	}

}

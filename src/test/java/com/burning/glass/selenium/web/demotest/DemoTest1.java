package com.burning.glass.selenium.web.demotest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.burning.glass.selenium.pages.AbstractPage;
import com.burning.glass.selenium.pages.demotest.DemoHomePage;
import com.burning.glass.selenium.pages.demotest.MenuList;
import com.burning.glass.selenium.pages.demotest.Twitter;
import com.burning.glass.selenium.pages.demotest.WindowPopUpModelPage;
import com.burning.glass.selenium.test.AbstractTest;
import com.burning.glass.selenium.test.BrowserLogger;

public class DemoTest1 extends AbstractTest {


	@Test
	@Parameters({ "emailAdd", "password" })
	public void demotest1(final String emailAdd, final String password) throws Exception {
		AbstractPage.setCaptureMode(Boolean.FALSE);
		DemoHomePage demoHomePage = new DemoHomePage(getDriver());
		BrowserLogger.logStepResult("Demo Home Page", this.getClass().getName());
		demoHomePage.clickkNoThanks();
		Thread.sleep(5L);
	//	wait(10L);

}
	
	/**
	 * This Function handles alert, switches to twitter window, and enter username and password to twitter handle
	 * @param emailAdd twitter emailaddress
	 * @param password twitter password
	 * @throws Exception
	 */
	@Test
	@Parameters({ "emailAdd", "password" })
	public void handleAlert(final String emailAdd, final String password) throws Exception {
		AbstractPage.setCaptureMode(Boolean.TRUE);
		DemoHomePage demoHomePage = new DemoHomePage(getDriver());
		BrowserLogger.logStepResult("Demo Home Page", this.getClass().getName());
		MenuList menuList = demoHomePage.getMenuList();
		Assert.assertTrue(menuList.expandAlertsAndModels(),"Alert and Model  Menu is not expanded");
		WindowPopUpModelPage windowPopUpModelPage=  menuList.clickWindowPopUpModel();
		Twitter  twitter =windowPopUpModelPage.followOnTwitter();
	
		twitter.enterUsernameOrEmailOrPhone(emailAdd);
		twitter.enterPassword(password);

}
}
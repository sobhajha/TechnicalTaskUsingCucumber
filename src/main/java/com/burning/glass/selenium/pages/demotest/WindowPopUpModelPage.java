package com.burning.glass.selenium.pages.demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.burning.glass.selenium.pages.AbstractPage;
import com.burning.glass.selenium.util.RenewableWebElement;

public class WindowPopUpModelPage extends AbstractPage{

	private static final By WINDOW_PAGE_HEADER = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[1]/h3");
	private static final By FOLLOW_ON_TWITTER = By.xpath(".//a[contains(text(),'Follow On Twitter')]");

	
	public WindowPopUpModelPage(AbstractPage parentPage) throws Exception {
		super(parentPage);
	}

	public WindowPopUpModelPage(WebDriver driver) throws Exception {
    super(driver);
}

	@Override
	public void resetActiveIFrame() {
		// TODO Auto-generated method stub
		
	}
	
	
	public Twitter followOnTwitter() throws Exception {
			
		switchToNewWindowByClick(FOLLOW_ON_TWITTER);

		return new Twitter(getDriver());
	
	}
	

	@Override
	public void waitForLoad() throws Exception {
		waitForElement(WINDOW_PAGE_HEADER, WAIT_TIME_LIMIT);

		
	}

}

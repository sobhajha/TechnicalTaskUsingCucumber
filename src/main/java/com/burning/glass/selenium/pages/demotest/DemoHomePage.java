package com.burning.glass.selenium.pages.demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.burning.glass.selenium.pages.AbstractPage;
import com.burning.glass.selenium.util.RenewableWebElement;

public class DemoHomePage extends AbstractPage {
	
	private MenuList menuList;
	private final static By START_PRACTISING = By
			.xpath(".//a[@id='btn_basic_example']");
	private final static By YES_PLEASE_BUTTON = By
			.xpath(".//a[@class='at-cv-button at-cv-lightbox-yesno at-cm-yes-button']");
	private final static By NO_THANKS_BUTTON = By
			.xpath(".//a[@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']");
	private final static By DEMO_HOME = By.xpath(".//*[text()='Demo Home']");
	public DemoHomePage(AbstractPage parentPage) throws Exception {
		super(parentPage);
	}

	public DemoHomePage(WebDriver driver) throws Exception {
		super(driver);
		menuList = new MenuList(driver);


	}

	public boolean isDemoHomeVisible() {
		return AbstractPage.isElementPresent(DEMO_HOME, IOS_SAFARI_WEB_WAIT_TIME_LIMIT, getDriver());
	}


	public void clickkNoThanks() {
	
		RenewableWebElement noThanksButton = waitForElement(NO_THANKS_BUTTON, WAIT_TIME_LIMIT);
		noThanksButton.click();
	}
	
    public void clickYesPlease() {
    	RenewableWebElement yesPleaseButton = waitForElement(YES_PLEASE_BUTTON, WAIT_TIME_LIMIT);
    	yesPleaseButton.click();
	}
	
    public MenuList getMenuList() {
     return menuList;	
    }
    
	@Override
	public void resetActiveIFrame() {
		
	}

	@Override
	public void waitForLoad() throws Exception {
		waitForElement(START_PRACTISING, WAIT_TIME_LIMIT);

	}

}

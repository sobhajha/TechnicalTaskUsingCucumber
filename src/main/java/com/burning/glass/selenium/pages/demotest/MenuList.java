package com.burning.glass.selenium.pages.demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.burning.glass.selenium.pages.AbstractPage;
import com.burning.glass.selenium.util.PageFactory;
import com.burning.glass.selenium.util.RenewableWebElement;

public class MenuList extends AbstractPage{

	public MenuList(AbstractPage parentPage) throws Exception {
		super(parentPage);
	}

	public MenuList(WebDriver driver) throws Exception {
		super(driver);
	}
	
	
private final static String EXPANDED_MENU_CLASS="[@class='tree-indicator glyphicon glyphicon-chevron-down']";
	private final static By ALL_EXAMPLE = By
			.xpath(".//a[text()='All Examples']");
	
	private final static By TREE_MENU_EXPANDED = By
			.xpath(".//*"+EXPANDED_MENU_CLASS);
	private final static By ALERT_MENU_EXPANDED = By
			.xpath(".//a[text()='Alerts & Modals']");
	private final static By WINDOW_POP_UP_MODAL = By.xpath("//*[@id='treemenu']/li/ul/li[5]/ul/li[3]/a");

	public boolean expandAllExamples() {
		System.out.println(TREE_MENU_EXPANDED);
		if (!AbstractPage.isElementPresent(TREE_MENU_EXPANDED,AbstractPage.WAIT_TIME_LIMIT , getDriver())) {
			RenewableWebElement allExampleButtons = waitForElement(ALL_EXAMPLE, WAIT_TIME_LIMIT);
			allExampleButtons.click();
			
		}
		return AbstractPage.isElementPresent(TREE_MENU_EXPANDED,AbstractPage.WAIT_TIME_LIMIT , getDriver());
	}


	public boolean expandAlertsAndModels() {
			RenewableWebElement alertMenu = waitForElement(ALERT_MENU_EXPANDED, WAIT_TIME_LIMIT);
			alertMenu.click();
			

		return AbstractPage.isElementPresent(WINDOW_POP_UP_MODAL,AbstractPage.WAIT_TIME_LIMIT , getDriver());
	}

	public WindowPopUpModelPage clickWindowPopUpModel() throws InterruptedException {
		Thread.sleep(10L);
		return (WindowPopUpModelPage) PageFactory.goToPageVia(WINDOW_POP_UP_MODAL, this, WindowPopUpModelPage.class,
				null, null);
	}
	
	@Override
	public void resetActiveIFrame() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void waitForLoad() throws Exception {
		// TODO Auto-generated method stub
		
	}
}

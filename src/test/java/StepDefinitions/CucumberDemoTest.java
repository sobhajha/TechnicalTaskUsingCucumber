package StepDefinitions;


import java.io.File;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.burning.glass.selenium.pages.AbstractPage;
import com.burning.glass.selenium.pages.demotest.DemoHomePage;
import com.burning.glass.selenium.test.BrowserLogger;

import io.cucumber.java.en.*;

public class CucumberDemoTest {
	
	//final String operatingSystem = "mac";
	String driverPath="drivers/ChromeDriver/chromedriver";
	 WebDriver fDriver = null;
	 String testTarget= "https://www.seleniumeasy.com/test/";
	DemoHomePage demoHomePage;

	@Given("chrome browser is open")
	public void browser_is_open() {
		
	 //  Logger.logStepResult("Opening the browser", true);
	   DesiredCapabilities capabilities= DesiredCapabilities.chrome();
	   capabilities.setPlatform(Platform.MAC);
	   applyDriver("webdriver.chrome.driver", driverPath);
	   @SuppressWarnings("deprecation")
	ChromeDriver chromeDriver = new ChromeDriver(capabilities);
		setDriver(chromeDriver);

	}

	@And("user navigate to the website")
	public void navigate_to_website() 
 {
	    // Write code here that turns the phrase above into concrete actions
		getDriver().get(testTarget);
	}

	@When("user say No Thanks on the pop up")
	public void user_say_no_thank_you() 
      {
		try {
			Thread.sleep(1000L);

		AbstractPage.setCaptureMode(Boolean.FALSE);
		demoHomePage = new DemoHomePage(getDriver());
		BrowserLogger.logStepResult("Demo Home Page", this.getClass().getName());
		Thread.sleep(10L);
		demoHomePage.clickkNoThanks();
		}
		catch (Exception e) {
			e.printStackTrace();

		}
      }

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_homePage(){
	Assert.assertTrue(demoHomePage.isDemoHomeVisible(), "Demo Home is not visible");
	getDriver().close();
		
	}

	private static void applyDriver(final String driverProperty,
			final String driverPath) {
		if (driverPath != null && driverPath.trim().length() > 0) {
			File serverDriverFile = new File(driverPath);
			// the parameter was set
			if (serverDriverFile.exists()) {
				// can access the file
				System.setProperty(driverProperty, driverPath);
			} else {
				throw new RuntimeException("Cannot access driver '"
						+ driverProperty + "' with path ["
						+ serverDriverFile.getAbsolutePath() + "]");
			}
		}
		}
	
	public final void setDriver(final WebDriver driver) {
		this.fDriver = driver;
		
	}

	/**
	 * Get {@link #fDriver}.
	 * 
	 * @return driver
	 */
	public final WebDriver getDriver() {
		return this.fDriver;
	}

}

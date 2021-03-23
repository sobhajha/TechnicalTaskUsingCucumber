package StepDefinitions;
import java.io.File;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.burning.glass.selenium.pages.AbstractPage;
import com.burning.glass.selenium.pages.demotest.DemoHomePage;
import com.burning.glass.selenium.pages.demotest.Twitter;
import com.burning.glass.selenium.pages.demotest.WindowPopUpModelPage;
import com.burning.glass.selenium.test.BrowserLogger;

import io.cucumber.java.en.*;


public class CucumberTwitterTest {

	//final String operatingSystem = "mac";
		String driverPath="drivers/ChromeDriver/chromedriver";
		 WebDriver fDriver = null;
		 String testTarget= "https://www.seleniumeasy.com/test/window-popup-modal-demo.html";
		 WindowPopUpModelPage windowPopUpModelPage ;
		 Twitter  twitter;
	     String emailAdd = "sobha.jha@gmail.com";
	     String password = "Burningglass";
	     
		 
	@Given("browser is open")
	public void browser_is_open() {
		 //  Logger.logStepResult("Opening the browser", true);
		   DesiredCapabilities capabilities= DesiredCapabilities.chrome();
		   capabilities.setPlatform(Platform.MAC);
		   applyDriver("webdriver.chrome.driver", driverPath);
		   @SuppressWarnings("deprecation")
		ChromeDriver chromeDriver = new ChromeDriver(capabilities);
			setDriver(chromeDriver);
	}

	@Given("user is navigate to the website")
	public void user_is_navigate_to_the_website() {
		getDriver().get(testTarget);
		try {
			 windowPopUpModelPage = new WindowPopUpModelPage(getDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Given("user clicks on button Follow On Twitter")
	public void user_clicks_on_button_follow_on_twitter()  {
		 try {
			  twitter =windowPopUpModelPage.followOnTwitter();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		twitter.enterUsernameOrEmailOrPhone(emailAdd);
		twitter.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    twitter.login();
	}

	@Then("user is navigated to the twitter site.")
	public void user_is_navigated_to_the_twitter_site() {
		Assert.assertTrue(twitter.isWelcomeTwitterAvaiable(), "User didnt get navigated to twitter site");
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

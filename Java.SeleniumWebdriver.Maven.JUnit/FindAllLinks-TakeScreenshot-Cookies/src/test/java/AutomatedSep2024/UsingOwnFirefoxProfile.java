package AutomatedSep2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxOptions;

public class UsingOwnFirefoxProfile {
	WebDriver driver;
	String baseURL;
	
	@Before
	public void Initalize() {
		
		ProfilesIni myprofile = new ProfilesIni();
		FirefoxProfile uttamprofile = myprofile.getProfile("automationclass");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(uttamprofile);
		
		driver = new FirefoxDriver(options);
	}
	
	@Test
	public void TestInitialize() {
		baseURL = "https://www.hstyles.co.uk/";
		driver.manage().window().fullscreen();
		driver.navigate().to(baseURL);
	}
	
	@After
	public void TearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}

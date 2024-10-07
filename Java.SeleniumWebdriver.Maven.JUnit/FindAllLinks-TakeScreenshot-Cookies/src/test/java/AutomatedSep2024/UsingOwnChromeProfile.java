package AutomatedSep2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.chrome.ChromeOptions;

public class UsingOwnChromeProfile {
	WebDriver driver;
	String baseURL;
	
	@Before
	public void Intialize() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("user-data-dir=C:/Users/Acer/AppData/Local/Google/Chrome/User Data");
		option.addArguments("profile-directory=Profile 11");
		driver = new ChromeDriver(option);
	}
	
	@Test
	public void TestRun() {
		baseURL = "https://www.onlinekhabar.com/";
		driver.manage().window().fullscreen();
		driver.navigate().to(baseURL);
		
	}
	
	@After
	public void TearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}

}

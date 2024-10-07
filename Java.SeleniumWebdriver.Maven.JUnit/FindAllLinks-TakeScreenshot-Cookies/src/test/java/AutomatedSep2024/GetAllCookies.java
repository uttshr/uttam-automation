package AutomatedSep2024;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.Set;
import org.openqa.selenium.Cookie;


public class GetAllCookies {
	WebDriver driver;
	
	@Before
	public void Initialize() {
		driver = new ChromeDriver();	
	}
	
	@Test
	public void TestRun() throws InterruptedException {
		driver.get("https://www.ncell.com.np/");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Getting all cookies");
		
		for (Cookie cookie:cookies) {
			System.out.println(cookie.getName() +"--->"+cookie.getValue());
		}			
	}
	
	@After
	public void TearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}

}

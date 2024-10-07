package linksScreenshotCookies;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAllWebsiteLink {
	
			WebDriver driver;
			
			@Before
			public void Initialize() {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			
			@Test
			public void TestRun() {
					driver.get("https://easygenerator.com");
					List<WebElement> allURLs = driver.findElements(By.tagName("a"));
					System.out.println("Total links on the Wb Page: " + allURLs.size());
			}
			
			@After
			public void TearDown() {
				driver.quit();
					 }
			}

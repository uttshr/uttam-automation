package dropdownOwnChromeOwnFirefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.List;

import org.junit.After;

public class ListAllDropdownItems {
		
		WebDriver driver;
		String baseURL;

		@Before
		public void Initialize() {
			driver = new ChromeDriver();
			baseURL = "https://www.holidify.com/places/pokhara/packages.html";
		}
		
		@Test
		public void TestRun() throws InterruptedException {
			driver.navigate().to(baseURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().fullscreen();
			WebElement element = driver.findElement(By.xpath("//select[@id='sortPackages']"));
			Select sachin = new Select(element);
			sachin.selectByIndex(2);
			
			Thread.sleep(5000);
			sachin.selectByValue("durationHighLow");
			
			Thread.sleep(6000);
			sachin.selectByVisibleText("Lowest Price First");
			
			List<WebElement> options = sachin.getOptions();
			int size = options.size();
			
			for(int i=0;i<size;i++) {
				String optionname = options.get(i).getText();
				System.out.println(optionname);
			}
		}
		
		@After
		public void TearDown() throws InterruptedException {
			Thread.sleep(5000);
			driver.quit();
		}
	}
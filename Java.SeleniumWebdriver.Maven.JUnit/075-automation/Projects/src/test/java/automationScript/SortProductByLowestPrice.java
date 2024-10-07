package automationScript;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortProductByLowestPrice {
	
	private WebDriver driver;
	private String URL = "https://demo.opencart.com/admin/index.php";
	private WebDriverWait wait;

	@Before
	public void Initialize() {
		driver = new ChromeDriver();
		driver.navigate().to(URL);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set an explicit wait
	}
	
	@Test
	public void TestRun() throws InterruptedException {
		WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		WebElement password = driver.findElement(By.xpath(" //input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		//WebElement submit = driver.findElement(By.className("btn btn-primary"));
		submit.click();		
		
		Thread.sleep(2000);
       
		try {
			driver.manage().window().fullscreen();
			// Wait for the dashboard to load and total orders element to be visible
			WebElement catalog = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/nav/ul/li[2]/a")));
			catalog.click();
			
			driver.manage().window().fullscreen();
			// Click on "Products"
			WebElement products = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/nav/ul/li[2]/ul/li[2]/a")));
			products.click();
			System.out.println("Product page opened");
			
			driver.manage().window().fullscreen();
			WebElement sortprice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/table/thead/tr/td[5]/a")));
			sortprice.click();
			System.out.println("Price Sorted in Product page");
								
		}catch (Exception e) {
			System.out.println("Elements could not be loaded. Please execute test case again!");
		}
		
	}
	
	@After
	public void TearDown() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.quit();
	}

}

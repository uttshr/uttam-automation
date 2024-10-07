	package automationScript;

	import static org.junit.Assert.assertEquals;

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

public class ViewOrder {
	
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
				// Wait for the dashboard to load and total orders element to be visible
				
				// Click on "View More"
				WebElement viewMore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/a[1]")));
				viewMore.click();
				
				// Wait for the order details to load and get the total order value
				WebElement viewOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-order\"]/div[1]/table/tbody/tr[4]/td[9]/a/i")));
				viewOrder.click();				
						
			}catch (Exception e) {
				System.out.println("Elements could not be loaded. Please execute test case again!");
			}
			
		}
		
		@After
		public void TearDown() throws InterruptedException {
//			Thread.sleep(5000);
//			driver.quit();
		}
	}

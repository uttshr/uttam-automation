	package automationScript;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCustomers {
	
			WebDriver driver;
			String URL = "https://demo.opencart.com/admin/index.php";
			private WebDriverWait wait;
			
			@Before
			public void Initialize() {
				driver = new ChromeDriver();
				driver.navigate().to(URL);
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
				
				
		       
				try {
					driver.manage().window().fullscreen();
					Thread.sleep(6000);
					WebElement viewMore = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div/div[3]/a"));
					viewMore.click();
					WebElement editcustomer = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/table/tbody/tr[3]/td[6]/div/a/i"));
					editcustomer.click();
					driver.manage().window().fullscreen();
					WebElement editemail = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/form/div/div[1]/fieldset[1]/div[5]/div/input"));
					editemail.clear();
					editemail.sendKeys("iiyas@gmail.com");
					WebElement save = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/button"));
					save.click();
					System.out.println("Email Successfully changed but permission denied");
					
					
					
					
			       						
				}catch (Exception e) {
					System.out.println("Elements could not be loaded. Please execute test case again!");
				}
				
			}
			
			@After
			public void TearDown() {
				//driver.quit();
			}
		}


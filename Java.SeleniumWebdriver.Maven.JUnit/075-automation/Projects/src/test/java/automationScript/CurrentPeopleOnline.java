	package automationScript;

	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

public class CurrentPeopleOnline {

			WebDriver driver;
			String URL = "https://demo.opencart.com/admin/index.php";
			
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
				
				Thread.sleep(2000);
		       
				try {
					WebElement TotalPeopleOnline = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div/div[2]/h2"));
					String verifypeople = TotalPeopleOnline.getText();
			        LocalDateTime currentDate = LocalDateTime.now();
			        
			        // Format the date as a string (optional)
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			        String formattedDate = currentDate.format(formatter);
			        
			        System.out.println("Current People Online as of "+formattedDate+" is "+verifypeople);
			       						
				}catch (Exception e) {
					System.out.println("Elements could not be loaded. Please execute test case again!");
				}
				
			}
			
			@After
			public void TearDown() {
				driver.quit();
			}
		}

package automationScript;

//importing junit library class
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class VerifyDashboard {
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
        WebElement dashboardTitle = driver.findElement(By.xpath("//h1[text()='Dashboard']"));

		//WebElement dashboardtitle = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/h1"));
		String verifytitle = dashboardTitle.getText();
		System.out.println(verifytitle);
		assertEquals("Dashboard", verifytitle);
		System.out.println("Dashboard login is verified!");
		
	}
	
	@After
	public void TearDown() {
		driver.quit();
		
	}
	

}

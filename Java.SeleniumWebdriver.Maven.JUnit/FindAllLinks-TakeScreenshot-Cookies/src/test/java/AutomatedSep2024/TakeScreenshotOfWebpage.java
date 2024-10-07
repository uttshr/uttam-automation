package AutomatedSep2024;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class TakeScreenshotOfWebpage {
	WebDriver driver;
	
		@Before
		public void Initialize() {
	        driver = new ChromeDriver();
	        driver.get("https://www.youtube.com/watch?v=KloahKhSWTk");
		}
		
		@Test
		public void TestRun() {
			    // Capture screenshot
			 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
		        try {
		            // Save the screenshot to a specific location
		            FileHandler.copy(screenshot, new File("C:/Users/Acer/Downloads/screenshot.png"));
		            System.out.println("Screenshot saved successfully.");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}
		
		@After
		public void TearDown() {
		        // Close the browser
		        driver.quit();
		    }

}

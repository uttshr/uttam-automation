package Utilities;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks extends BaseUtil {
    private BaseUtil baseh;
            public Hooks (BaseUtil baseh){
        this.baseh = baseh;
            }

    @Before
    public void InitializeTest(){
        System.out.println("test");
      System.setProperty("webdriver.chrome.driver","chromedriver");
        baseh.Driver = new ChromeDriver();
    }

    @After
    public void TearDownTest(){
        //baseh.Driver.close();

    }

}

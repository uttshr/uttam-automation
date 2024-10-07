package Utilities;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends BaseUtil {

    private BaseUtil baseofh;

    public Hooks(BaseUtil baseofh){
        this.baseofh = baseofh;
    }

    @Before
    public void InitializeTest(){
        System.out.println("This initializes test");
        System.setProperty("webdriver.chrome.driver","F:/Official files/QA-05-15Sep21-Seva/Demo-Jan2023/drivers/chromedriver.exe");
        baseofh.Driver = new ChromeDriver();
    }

    @After
    public void TearDownTest(){
        System.out.println("This closes test");
        //baseofh.Driver.close();

    }

}

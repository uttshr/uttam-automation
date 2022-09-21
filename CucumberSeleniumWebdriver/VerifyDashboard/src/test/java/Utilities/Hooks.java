package Utilities;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends BaseUtil
{
    private BaseUtil baseh;
    public Hooks(BaseUtil baseh){
        this.baseh = baseh;
    }

    @Before
    public void InitializeTest(){
        System.out.println("Initializing test");
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
        baseh.Driver = new ChromeDriver();
    }

    @After
    public void TearDownTest(){
        System.out.println("Closing test");
        //baseh.Driver.close();

    }
}

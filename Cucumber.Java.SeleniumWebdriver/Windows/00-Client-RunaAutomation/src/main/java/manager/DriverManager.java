package manager;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public WebDriver driver;
    public Properties prop;
    public SoftAssert softAssert;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public DriverManager() {
        // init the prop file
        try {
            prop=new Properties();
            System.out.println(System.getProperty("user.dir"));
            String path = System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
            FileInputStream fs = new FileInputStream(path);
            prop.load(fs);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        softAssert = new SoftAssert();
        driverType = getBrowser();
        environmentType = getEnvironment();
    }

    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME :
                //System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        		WebDriverManager.chromedriver().version("102.0.5005.61").setup();
                //WebDriverManager.chromedriver().version("100.0.4896.60").setup();
                // WebDriverManager.chromedriver().version("96.0.4664.110").setup();
                driver = new ChromeDriver();
                break;
            //case INTERNETEXPLORER : driver = new InternetExplorerDriver();
            //break;
        }

        if(getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }
//    public void init(ExtentTest test) {
//        this.test=test;
//    }

    public void quit() {

        if(driver !=null)
            driver.quit();

        if(softAssert!=null)
            softAssert.assertAll();

    }
    /*************Utility Functions******************/

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

//    public void log(String msg) {
//        System.out.println(msg);
//        test.log(Status.INFO, msg);
//    }

    public String getTestDataResourcePath(){
        String testDataResourcePath = prop.getProperty("testDataResourcePath");
        if(testDataResourcePath!= null) return testDataResourcePath;
        else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.prop file for the Key:testDataResourcePath");
    }
    public String getDriverPath(){
        String driverPath = prop.getProperty("driverPath");
        //String driverPath = "src/main/resources/drivers/chromedriver.exe";
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Driver Path not specified in the Configuration.prop file for the Key:driverPath");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = prop.getProperty("implicitlyWait");
        if(implicitlyWait != null) {
            try{
                return Long.parseLong(implicitlyWait);
            }catch(NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }
    public DriverType getBrowser() {
        String browserName = prop.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
            //else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser Name Key value in Configuration.prop is not matched : " + browserName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = prop.getProperty("environment");
        if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else throw new RuntimeException("Environment Type Key value in Configuration.prop is not matched : " + environmentName);
    }
    public Boolean getBrowserWindowSize() {
        String windowSize = prop.getProperty("windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

   }

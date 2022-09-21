package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //NAME is reference, this will identify control txtUserName using name property
    @FindBy(how = How.NAME, using = "username")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    public WebElement txtLogin;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")
    public WebElement verify;

    public void Login1(String username) {
        txtUserName.sendKeys(username);
    }

    public void Login2(String password) {
        txtPassword.sendKeys(password);
    }

    public void txtLogin(){
        txtLogin.submit();
    }

    public void VerifyDashboard() {
        System.out.println("This will verify dashboard");
        verify.isDisplayed();
    }
}

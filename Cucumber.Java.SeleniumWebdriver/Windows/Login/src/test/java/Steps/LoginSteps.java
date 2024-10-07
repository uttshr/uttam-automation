package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends BaseUtil {
    private BaseUtil bases;
    public LoginSteps(BaseUtil bases){
        this.bases = bases;
    }
    @Given("^I navigate to website$")
    public void iNavigateToWebsite() {
        System.out.println("This will open website");
        bases.Driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @io.cucumber.java.en.And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        bases.Driver.findElement(By.name("username")).sendKeys("username");
        bases.Driver.findElement(By.name("password")).sendKeys("password");
    }

    @io.cucumber.java.en.And("^I click login button$")
    public void iClickLoginButton() throws InterruptedException {
        Thread.sleep(2000);
        bases.Driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

    }

    @io.cucumber.java.en.Then("^I should see dashboard$")
    public void iShouldSeeDashboard() {
    }
}

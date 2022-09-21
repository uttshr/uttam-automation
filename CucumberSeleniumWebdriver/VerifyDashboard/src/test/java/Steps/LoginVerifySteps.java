package Steps;

import Base.BaseUtil;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
//import org.openqa.selenium.ass

public class LoginVerifySteps extends BaseUtil
{

    private BaseUtil bases;
    public LoginVerifySteps(BaseUtil bases){
        this.bases = bases;
    }

        @Given("I navigate to login page")
        public void iNavigateToLoginPage() {
        bases.Driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        }

        @And("^I enter ([^\"]*) and ([^\"]*)$")
        public void iEnterUsernameAndPassword(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        bases.Driver.findElement(By.name("username")).sendKeys(username);
        bases.Driver.findElement(By.name("password")).sendKeys(password);

        }

        @And("I click login button")
        public void iClickLoginButton() throws InterruptedException {
        Thread.sleep(2000);
        bases.Driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).submit();
        }

        @Then("I should see dashboard")
        public void iShouldSeeDashboard() {
       // bases.Driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
        Assert.isTrue(true, "This is testing for assertion", bases.Driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed());

        }

}

package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class LoginVerifySteps extends BaseUtil {

    private BaseUtil bases;
    public LoginVerifySteps(BaseUtil bases){
        this.bases = bases;
    }

    @Given("I open website")
    public void iOpenWebsite() {
        bases.Driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        LoginPage page = new LoginPage(bases.Driver);
        page.Login1(username);
        page.Login2(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        LoginPage page = new LoginPage(bases.Driver);
        page.txtLogin();
    }

    @Then("I verify dashboard")
    public void iVerifyDashboard() {
        LoginPage page = new LoginPage(bases.Driver);
        page.VerifyDashboard();
    }


}

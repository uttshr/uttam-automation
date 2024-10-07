package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class LoginSteps extends BaseUtil {

    private BaseUtil baseofs;
    public LoginSteps(BaseUtil baseofs)
    {
        this.baseofs = baseofs;
    }
    @Given("I navigate to the website")
    public void iNavigateToTheWebsite() {
        System.out.println("I am opening a website");
        baseofs.Driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("I click login link")
    public void iClickLoginLink() {
        baseofs.Driver.findElement(By.className("ico-login")).click();
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterEmailAndPassword(String email, String password) throws Throwable {
        baseofs.Driver.findElement(By.className("email")).sendKeys(email);
        baseofs.Driver.findElement(By.className("password")).sendKeys(password);
        System.out.println("Email"+email);
        System.out.println("Password"+password);
    }

    @And("I click SignIn button")
    public void iClickSignInButton() {
        baseofs.Driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
    }

    @Then("I should see a dashboard")
    public void iShouldSeeADashboard() {
    }


}

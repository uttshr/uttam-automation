package Steps;

public class LoginSteps {
    @io.cucumber.java.en.Given("^I navigate to website$")
    public void iNavigateToWebsite() {
    }

    @io.cucumber.java.en.And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) {
        System.out.println("Username"+username);
        System.out.println("Password"+password);
    }

    @io.cucumber.java.en.And("^I click login button$")
    public void iClickLoginButton() {
    }

    @io.cucumber.java.en.Then("^I should see dashboard$")
    public void iShouldSeeDashboard() {
    }
}

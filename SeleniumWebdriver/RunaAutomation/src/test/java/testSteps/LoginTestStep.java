package testSteps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.LoginPage;

public class LoginTestStep{

    private TestContext context;
    private LoginPage loginPage;
    private JSONObject dataObject;
    public LoginTestStep(TestContext context) {
        this.context = context;
        loginPage = context.getPageObjectManager().getLoginPage();
    }

    @Given("^I navigate to runa")
    public void openRunaApp(){
        loginPage.gotorunaApp();
    }
    @When("^I enter email$")
    public void enterEmail () {
        System.out.println(dataObject.toJSONString());
        loginPage.enterEmail(dataObject.get("username").toString());
    }

    @When("^I enter password$")
    public void enterPassword() {
        loginPage.enterPassword(dataObject.get("password").toString());
    }

    @When("I click getInto button")
    public void clickOnLoginButton() {
        loginPage.clickGetIntoButton();                
    }

    @Then("^I validate login successful message$")
    public void validateLogin() {
        loginPage.verifyElement(dataObject.get("successfulMsg").toString());
    }
    @Then("^I validate login unsuccessful message$")
    public void validateUnSuccessfulLogin() {
        loginPage.verifyUnSuccessFulElement(dataObject.get("unsuccessfulMsg").toString());
    }
    @Given("I click Administrator")
    public void iClickAdministrator() {
        loginPage.clickAdministrator();
    }

    @And("I click Perfil de empresa")
    public void iClickPerfilDeEmpresa() {
        loginPage.clickPerfilDeEmpresa();
    }

    @And("I click Agregar empresa")
    public void iClickAgregarEmpresa() {
        loginPage.clickAgregarEmpresa();
    }

    @Given("I navigate to runa app")
    public void iNavigateToRuna() {
        context.getPageObjectManager().getWebDriverManager().getDriver();
        loginPage.gotorunaApp();
    }

    @When("I login to application")
    public void iLoginToApplication() {
        loginPage.defaultLogin();
    }

    @And("I get the data for login with {string} and {string}")
    public void iGetDataTheDataForLoginWithAnd(String fileName, String fieldName) {
        dataObject=context.readJsonFile(fileName,fieldName);
    }

    @Then("I validate login successful message {string}")
    public void iValidateLoginSuccessfulMessage(String msg) {
        loginPage.verifyElement(msg);
    }

    @And("I Click Configuracion")
    public void iClickConfiguracion() {
        loginPage.clickConfiguration();
    }

    @And("I Click Nominas")
    public void iClickNominas() {
        loginPage.clickNominas();
    }
    @And("I Click Politicas")
    public void iClickPoliticas() {
        loginPage.clickPoliticas();
    }
    @And("I Click Conceptos")
    public void iClickConceptos() {
        loginPage.clickConcepts();
    }
}

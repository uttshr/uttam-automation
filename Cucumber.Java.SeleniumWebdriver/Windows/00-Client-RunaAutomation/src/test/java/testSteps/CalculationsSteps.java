package testSteps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.CalculationsPage;

import java.util.HashMap;

public class CalculationsSteps {

    private TestContext context;
    private CalculationsPage calculationsPage;
    private JSONObject dataObject;
    private HashMap<String,String> previousValues;
    public CalculationsSteps(TestContext context) {
        this.context=context;
        this.calculationsPage=context.getPageObjectManager().getCalculationsPage();
    }

    @And("I get the data for calculations {string} and {string}")
    public void iGetTheDataForCalculationsAnd(String fileName, String fieldName) {
        dataObject=context.readJsonFile(fileName,fieldName);
        context.getScenarioContext().setContext("dataObject",dataObject);
    }

    @And("I click on Comenzar button")
    public void iClickOnComenzar() {
        calculationsPage.clickOnComenzar(dataObject.get("startDateIncident").toString(),dataObject.get("endDateIncident").toString());
    }

    @And("I click on Continuar button")
    public void iClickOnContinuarButton() {
        calculationsPage.clickOnContinuar();
    }

    @When("I Edit Sueldo value")
    public void iEditSueldoValue() {
        previousValues=calculationsPage.getValues();
        calculationsPage.enterSueldo(dataObject.get("sueldo").toString());
    }

    @Then("Validate changed values")
    public void validateChangedValues() {
        calculationsPage.compareValues(previousValues);
    }
    @When("I click on employee")
    public void iClickOnEmployee() {
        try {
            calculationsPage.clickOnEmployee();
        }catch(Exception e){
            calculationsPage.clickOnCalcular(dataObject.get("startDateIncident").toString(),dataObject.get("endDateIncident").toString());
            calculationsPage.clickOnEmployee();
        }
    }
}

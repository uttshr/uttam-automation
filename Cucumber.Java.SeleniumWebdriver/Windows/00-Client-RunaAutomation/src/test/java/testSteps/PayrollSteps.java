package testSteps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import pages.PayrollPage;

import java.io.IOException;

public class PayrollSteps {

    private TestContext context;
    private PayrollPage payrollPage;
    private JSONObject dataObject;
    public PayrollSteps(TestContext context) {
        this.context=context;
        this.payrollPage=context.getPageObjectManager().getPayrollPage();
    }
    
    @And("I navigate Nomina Activas")
    public void iNavigateNominaActivas() throws IOException, InterruptedException {
       payrollPage.gotoActivas();
    }

    @And("I click on Neuva Nomina")
    public void iClickOnNeuvaNomina() throws IOException {
        payrollPage.openNeuvaNomina();
    }

    @And("I click on Crear")
    public void iClickOnGuardar() throws IOException, InterruptedException {
        payrollPage.clickCrear();
    }

    @Then("I validate if the payroll was created")
    public void iValidateIfThePayrollWasCreated() throws IOException {
        payrollPage.validatePayroll();
    }

    @Then("I goto payroll Neuva and delete the created payroll")
    public void iGotoPayrollNeuvaAndDeleteTheCreatedPayroll() throws InterruptedException {
        payrollPage.gotoPayrollNeuvaList();
        Thread.sleep(3000);
        payrollPage.deletePayroll();
        Thread.sleep(3000);
    }

    @And("I select group")
    public void iSelectGroup() {
        payrollPage.clickSelectGroupo();
        if(dataObject==null)
            dataObject= (JSONObject) context.getScenarioContext().getContext("dataObject");
        payrollPage.selectGroup(dataObject.get("name").toString());
    }

    @And("I enter dates")
    public void iEnterDatesWithPeriodAs() throws InterruptedException {
        payrollPage.startDatePeriod(dataObject.get("startDatePeriod").toString());
        payrollPage.startDateIncidences(dataObject.get("startDateIncident").toString());
        Thread.sleep(1000);
        payrollPage.endDateIncidences(dataObject.get("endDateIncident").toString());
    }

    @Then("I should validate error message")
    public void iShouldValidate() {
        payrollPage.validateErrorMessage(dataObject.get("errorTitle").toString(),dataObject.get("errorReason").toString());
    }

    @And("I click on Aceptar")
    public void iClickOnAceptar() {
        payrollPage.clickAceptar();
    }

    @And("I delete if payroll is here with {string} and {string}")
    public void iDeleteIfPayrollIsHereWithAnd(String groupName, String period) {
        payrollPage.deletePayrollIfExist(groupName,period);
    }

    @And("I get the data for payroll creation {string} and {string}")
    public void iGetDataTheDataForPayrollCreationAnd(String fileName, String fieldName) {
        dataObject=context.readJsonFile(fileName,fieldName);
        System.out.println(dataObject.toJSONString());
    }

}

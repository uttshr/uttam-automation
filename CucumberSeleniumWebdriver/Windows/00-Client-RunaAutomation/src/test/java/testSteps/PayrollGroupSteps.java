package testSteps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import pages.PayrollGroupPage;

public class PayrollGroupSteps {

    private TestContext context;
    private PayrollGroupPage payrollGroupPage;
    private JSONObject dataObject;
    //private String groupName;
    public PayrollGroupSteps(TestContext context) {
        this.context=context;
        this.payrollGroupPage=context.getPageObjectManager().getPayrollGroupPage();
    }

    @And("I click on new group")
    public void iClickOnNewGroup() {
        payrollGroupPage.clickNewGroup();
    }

    @And("I Enter group name")
    public void iEnterGroupName() {
//        Random rand = new Random();
//        int rand_int1 = rand.nextInt(1000);
//        groupName=dataObject.get("groupNamePrefix").toString()+rand_int1;
        payrollGroupPage.enterGroupName(dataObject.get("groupName").toString());
    }
    @And("I Select company name")
    public void iSelectCompanyName() {
        payrollGroupPage.selectCompanyId(dataObject.get("companyId").toString());
    }

    @And("I Select company bank id")
    public void iSelectCompanyBankId() {
        payrollGroupPage.selectCompanyBankId(dataObject.get("companyBankId").toString());
    }

    @And("I Select payroll group frequency")
    public void iSelectPayrollGroupFrequency() {
        payrollGroupPage.selectPayrollGroupFrequency(dataObject.get("payrollGroupFrequency").toString());
    }

    @And("I Select payroll group calculation")
    public void iSelectPayrollGroupCalculation() {
        payrollGroupPage.selectPayrollGroupCalc(dataObject.get("payrollGroupCalculation").toString());
    }

    @And("I Select annual gratuity")
    public void iSelectAnnualGratuity() {
        payrollGroupPage.selectAnnualGratuity(dataObject.get("annualGratuity").toString());
    }

    @And("I Select subsidyType")
    public void iSelectSubsidyType() {
        payrollGroupPage.selectSubsidyType(dataObject.get("subsidyType").toString());
    }

    @Then("I validate if the payroll group is created")
    public void iValidateIfThePayrollGroupIsCreated() {
        payrollGroupPage.validatePayrollGroupPresence(dataObject.get("groupName").toString());
    }

    @And("I get the data for payroll group {string} and {string}")
    public void iGetTheDataForPayrollGroup(String fileName, String fieldName) {
        dataObject=context.readJsonFile(fileName,fieldName);
    }

    @And("I Click on edit payroll group")
    public void iClickOnEditPayrollGroup() {
        payrollGroupPage.clickEditPayrollGroup(dataObject.get("groupName").toString());
    }

    @And("I Update value of the field")
    public void iUpdateValueOfTheField() {
        payrollGroupPage.editPayrollGroupDetails(dataObject.get("Field").toString(),dataObject.get("Value").toString());
    }

    @Then("I validate if field value is updated with new value")
    public void iValidateIfFieldValueIsUpdatedWithNewValue() {
        payrollGroupPage.validateUpdatedFieldValue(dataObject.get("groupName").toString(),dataObject.get("Field").toString(),dataObject.get("Value").toString());
    }

    @Then("I validate payroll group should be deleted")
    public void iValidatePayrollGroupShouldBeDeleted() {
        payrollGroupPage.validatePayrollGroupIsDeleted(dataObject.get("groupName").toString());
    }

    @And("I click on Aceptar button")
    public void iClickOnAceptarButton() {
        payrollGroupPage.clickAceptarBtn();
    }

}

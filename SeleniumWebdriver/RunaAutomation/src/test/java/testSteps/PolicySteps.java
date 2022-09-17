package testSteps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import pages.PolicyPage;

import java.util.Random;

public class PolicySteps {
    private TestContext context;
    private PolicyPage policyPage;
    private JSONObject dataObject;
    //private String policyName;
    public PolicySteps(TestContext context) {
        this.context=context;
        this.policyPage=context.getPageObjectManager().getPolicyPage();
    }

    @And("I click on Neuva politica")
    public void iClickOnNeuvaPolitica() {
        policyPage.clickNewPolicBtn();
    }

    @And("I get the data for policy {string} and {string}")
    public void iGetTheDataForPolicyAnd(String fileName, String fieldName) {
        dataObject=context.readJsonFile(fileName,fieldName);
    }

    @And("I Enter policy name")
    public void iEnterPolicyName() {
//        Random rand = new Random();
//        int rand_int1 = rand.nextInt(1000);
//        policyName=dataObject.get("name").toString()+rand_int1;
        policyPage.enterPolicyName(dataObject.get("name").toString());
    }

    @And("I Enter economy days")
    public void iEnterEconomyDays() {
        policyPage.enterEconomyDays(dataObject.get("economyDays").toString());
    }

    @And("I Select vacation bonus to the anniversary")
    public void iSelectVacationBonusToTheAnniversary() {
        policyPage.selectVacationBonus(dataObject.get("vacationBonus").toString());
    }


    @And("I Select calculations based on")
    public void iSelectCalculationsBasedOn() {
        policyPage.selectCalculationsBased(dataObject.get("calculationsBasedOn").toString());
    }

    @Then("I validate if the policy group is created")
    public void iValidateIfThePolicyGroupIsCreated() {
        policyPage.validatePolicyCreated(dataObject.get("name").toString());
    }

    @And("I Update details in pantry vouchers")
    public void iUpdateDetailsInPantryVouchers() {
        policyPage.updatePantryVoucherDetails((JSONObject) dataObject.get("pantryVoucher"));
    }

    @And("I Update details in saving fund")
    public void iUpdateDetailsInSavingFund() {
        policyPage.updateSavingFundDetails((JSONObject) dataObject.get("savingFund"));
    }

    @And("I Update details restaurant voucher")
    public void iUpdateDetailsRestaurantVoucher() {
        policyPage.updateRestaurantVoucherDetails((JSONObject)dataObject.get("restaurantVoucher"));
    }

    @And("I Update discounts for calculations")
    public void iUpdateDiscountsForCalculations() {
        policyPage.updateDiscounts((JSONObject)dataObject.get("discounts"));
    }

    @And("I Click on edit policy")
    public void iClickOnEditPolicy() {
        policyPage.clickOnEditPolicyBtn(dataObject.get("name").toString());
    }

    @And("I Update value of the field in policy")
    public void iUpdateValueOfTheFieldInPolicy() {
        policyPage.editValueOfGivenField(dataObject.get("field").toString(),dataObject.get("value").toString());
    }

    @Then("I validate if policy field value is updated with new value")
    public void iValidateIfPolicyFieldValueIsUpdatedWithNewValue() {
        policyPage.validateUpdatedFieldValue(dataObject.get("name").toString(),dataObject.get("field").toString(),dataObject.get("value").toString());
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        policyPage.clickOnContinue();
    }

    @Then("I validate if policy should be deleted")
    public void iValidateIfPolicyShouldBeDeleted() {
        policyPage.validatePolicyIsDeleted(dataObject.get("name").toString());
    }

}

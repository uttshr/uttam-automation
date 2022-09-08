package testSteps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.CompanyPage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CompanyStep {
    private TestContext context;
    private CompanyPage companyPage;
    private JSONObject dataObject;
    public CompanyStep(TestContext context) {
        this.context = context;
        this.companyPage=context.getPageObjectManager().getCompanyPage();
    }


    @And("I enter Company name")
    public void iEnterCompanyName() {
        companyPage.enterCompanyName(dataObject.get("CompanyName").toString());
    }

    @And("I enter Business name")
    public void iEnterBusinessName() {
        companyPage.enterCompanyBusinessName(dataObject.get("BusinessName").toString());
    }
    @And("I upload logo")
    public void iUploadLogo() {
        companyPage.uploadLogoFile(dataObject.get("LogoFilePath").toString());
    }

    @And("I select Industry")
    public void iSelectIndustry() {
        companyPage.clickIndustryName();
        companyPage.enterIndustryName(dataObject.get("IndustryName").toString());
    }

    @And("I enter rfc")
    public void iEnter() {
        companyPage.enterRfc(dataObject.get("RFC").toString());
    }

    @And("I select Tax Regime")
    public void iSelectTaxRegime() {
        companyPage.clickTaxRegime();
        companyPage.enterTaxRegime(dataObject.get("TAXRegime").toString());
    }

//    @And("I enter Employer registration")
//    public void iEnterEmployerRegistration() {
//        Random rand = new Random();
//        int rand_int1 = rand.nextInt(1000000);
//        int rand_int2 = rand.nextInt(100000);
//        companyPage.enterEmployerRegistration(rand_int1+""+rand_int2+"");
//    }

    @Given("I enter Employer registration")
    public void i_enter_Employer_registration() {
        Random rand = new Random();
        int rand_int1 = ThreadLocalRandom.current().nextInt(100000, 1000000);
        int rand_int2 = ThreadLocalRandom.current().nextInt(10000, 100000);
        companyPage.enterEmployerRegistration(rand_int1+""+rand_int2+"");
    }

    @And("I enter Risk premium")
    public void iEnterRiskPremium() {
        companyPage.enterRiskLevel(dataObject.get("RiskPremium").toString());
    }

    @And("I select state")
    public void iSelectState() {
        companyPage.clickState();
        companyPage.enterState(dataObject.get("State").toString());
    }

    @And("I enter Direction")
    public void iEnterDirection() {
        companyPage.enterAddress(dataObject.get("Address").toString());
    }

    @And("I enter Postal Code")
    public void iEnterPostalCode() {
        companyPage.enterPostal(dataObject.get("PostalCode").toString());
    }

    @And("I select bank accounts")
    public void iSelectBankAccounts() {
        companyPage.clickCompanyBankId();
        companyPage.enterCompanyBankId(dataObject.get("BankAccount").toString());
    }

    @And("I enter IMSS subdelegation key")
    public void iEnterIMSSSubdelegationKey() {
        companyPage.enterBanchKey(dataObject.get("ImssKey").toString());
    }

    @And("I upload Digital Seal Certificate key")
    public void iEnterDigitalSealCertificateKey() {
        companyPage.uploadCsdKeyFile(dataObject.get("CdaKeyFilePath").toString());
    }

    @And("I upload Digital Seal Certificate")
    public void iUploadDigitalSealCertificate() {
        companyPage.uploadCsdCertFile(dataObject.get("CdaCertFilePath").toString());
    }

    @And("I enter Password for digital seal certificate")
    public void iEnterPasswordForDigitalSealCertificate() {
        companyPage.enterCsdPassword(dataObject.get("password").toString());
    }

    @When("I click GUARDER button")
    public void iClickGUARDERButton() {
        companyPage.clickSubmitBtn();
    }

    @Then("I validate company is added")
    public void iValidateCompanyIsAdded() {
        companyPage.validateCompanyPresence(dataObject.get("CompanyName").toString());
    }

    @And("I click edit Company")
    public void iClickEditCompany() {
        companyPage.clickEditCompany(dataObject.get("CompanyName").toString());
    }

    @And("I enter value to edit")
    public void iEnterValueToEditAnd() {
        companyPage.editCompanyDetails(dataObject.get("Field").toString(),dataObject.get("Value").toString());
    }

    @Then("I validate company field value updated to new value")
    public void iValidateCompanyFieldValueUpdatedToNewValue() {
        companyPage.validateUpdatedFieldValue(dataObject.get("CompanyName").toString(),dataObject.get("Field").toString(),dataObject.get("Value").toString());
    }

    @And("I click on delete button")
    public void iClickOnDeleteButton() {
        companyPage.clickDeleteBtn();
    }

    @And("I validate confirmation-dialog")
    public void iValidateConfirmationDialog() {
        companyPage.validateConfirmationDialog();
    }

    @When("I click on continue")
    public void iClickOnContinue() {
        companyPage.clickConfirmBtn();
    }

    @Then("I validate company should be deleted")
    public void iValidateCompanyShouldBeDeleted() {
        companyPage.validateCompanyPresence(dataObject.get("CompanyName").toString());
    }

    @And("I get the data for company creation {string} and {string}")
    public void iGetTheDataForCompanyCreationAnd(String fileName, String fieldName) {
        dataObject=context.readJsonFile(fileName,fieldName);
    }

}

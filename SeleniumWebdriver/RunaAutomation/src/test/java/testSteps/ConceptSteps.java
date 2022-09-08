package testSteps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import pages.ConceptPage;

public class ConceptSteps {

    private TestContext context;
    private ConceptPage conceptPage;
    private JSONObject dataObject;
    //private String perceptionName;
    public ConceptSteps(TestContext context) {
        this.context=context;
        this.conceptPage=context.getPageObjectManager().getConceptPage();
    }


    @And("I click on Neuva percepcion")
    public void iClickOnNeuvaPercepcion() {
        conceptPage.clickNeunaPercepcion();
    }



    @And("I get the data for concept {string} and {string}")
    public void iGetTheDataForConceptAnd(String fileName, String fieldName) {
        dataObject=context.readJsonFile(fileName,fieldName);
    }

    @And("I Enter perception name")
    public void iEnterPerceptionName() {
//        Random rand = new Random();
//        int rand_int1 = rand.nextInt(1000);
//        perceptionName=dataObject.get("namePrefix").toString()+rand_int1;
        conceptPage.enterPerceptionName(dataObject.get("name").toString());
    }

    @And("I Select type of perception")
    public void iSelectTypeOfPerception() {
        JSONObject perceptionType= (JSONObject) dataObject.get("perceptionType");
        conceptPage.selectTypeOfPerception(perceptionType.get("type").toString());
    }

    @And("I Select SAT catalog")
    public void iSelectSATCatalog() {
        JSONObject perceptionType= (JSONObject) dataObject.get("perceptionType");
        conceptPage.selectSATCatalog(perceptionType.get("satCatalog").toString());
    }

    @And("I Select type of concept")
    public void iSelectTypeOfConcept() {
        conceptPage.selectTypeOfConcept(dataObject.get("conceptType").toString());
    }

    @And("I Select ISR gravel")
    public void iSelectISRGravel() {
        conceptPage.selectIsrGravel(dataObject.get("isrGravel").toString());
    }

    @And("I Select ISN gravel")
    public void iSelectISNGravel() {
        conceptPage.selectIsnGravel(dataObject.get("isnGravel").toString());
    }

    @And("I Enter account number")
    public void iEnterAccountNumber() {
        conceptPage.enterAccountNumber(dataObject.get("accountNumber").toString());
    }

    @Then("I validate if the concept is created")
    public void iValidateIfTheConceptIsCreated() {
        conceptPage.validateConceptCreated(dataObject.get("name").toString());
    }

    @And("I click on edit concept")
    public void iClickEditConcept() {
        conceptPage.clickOnEditConceptBtn(dataObject.get("name").toString());
    }

    @And("I enter value to edit in concept")
    public void iEnterValueToEditInConcept() {
        conceptPage.editConceptDetails(dataObject);
    }

    @Then("I validate updated field value in concept")
    public void iValidateUpdatedFieldValueInConcept() {
        conceptPage.validateUpdatedFieldValue(dataObject);
    }

    @Then("I validate if concept is deleted")
    public void iValidateIfConceptIsDeleted() {
        conceptPage.validateConceptIsDeleted(dataObject.get("name").toString());
    }
}

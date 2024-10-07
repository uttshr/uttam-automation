package pages;

import manager.DriverManager;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConceptPage extends BasePage {

    public ConceptPage(DriverManager driverManager) {
        super(driverManager);
    }

    @FindBy(css = "button.add-item-right-container")
    WebElement nuevoConcept;
    @FindBy(id="perception_type_name")
    WebElement perceptionName;
    @FindBy(id="perception_type_type")
    WebElement perceptionType;
    @FindBy(id="react-select-perception_type[type]-input")
    WebElement perceptionTypeTxt;
    @FindBy(id="perception_type_key")
    WebElement satCatalog;
    @FindBy(id="react-select-perception_type[key]-input")
    WebElement satCatalogTxt;
    @FindBy(id="perception_type_payroll_complement_ordinary")
    WebElement ordinaryConcept;
    @FindBy(id="perception_type_payroll_complement_extraordinary")
    WebElement extraordinaryConcept;
    @FindBy(id="perception_type_isr_true")
    WebElement isrTrue;
    @FindBy(id="perception_type_isr_false")
    WebElement isrFalse;
    @FindBy(id="perception_type_isn_true")
    WebElement isnTrue;
    @FindBy(id="perception_type_isn_false")
    WebElement isnFalse;
    @FindBy(id="perception_type_perception_accounting_policy_catalog")
    WebElement accountNumberTxt;

    public void clickNeunaPercepcion() {
        nuevoConcept.click();
    }

    public void enterPerceptionName(String name) {
        perceptionName.clear();
        perceptionName.sendKeys(name);
    }

    public void selectTypeOfPerception(String type) {
        perceptionType.click();
        perceptionTypeTxt.clear();
        perceptionTypeTxt.sendKeys(type+ Keys.ENTER);
    }

    public void selectSATCatalog(String catalog) {
        satCatalog.click();
        satCatalogTxt.clear();
        satCatalogTxt.sendKeys(catalog+Keys.ENTER);
    }

    public void selectTypeOfConcept(String conceptType) {
        if(compareSpanishStrings(conceptType,"Ordinario"))
            ordinaryConcept.click();
        else
            extraordinaryConcept.click();
    }

    public void selectIsrGravel(String isrGravel) {
        if(!isrGravel.equalsIgnoreCase("NA")) {
            if (compareSpanishStrings(isrGravel, "Sí"))
                isrTrue.click();
            else
                isrFalse.click();
        }
    }

    public void selectIsnGravel(String isnGravel) {
        if(compareSpanishStrings(isnGravel,"Sí"))
            isnTrue.click();
        else
            isnFalse.click();
    }

    public void enterAccountNumber(String accountNumber) {
        accountNumberTxt.clear();
        accountNumberTxt.sendKeys(accountNumber);
    }
    public void validateConceptCreated(String perceptionName)
    {
        threadWait(1000);
        if(isElementPresent(By.cssSelector("button.button.is-submit ")))
            logFailure("Concept is not created",true);
        validateConceptPresence(perceptionName);
    }
    public void validateConceptPresence(String perceptionName)
    {
        threadWait(2000);
        if(!isElementPresent(By.xpath("//header[text()='"+perceptionName+"']")))
            logFailure("Concept is not present",true);
    }
    public void clickOnEditConceptBtn(String conceptName) {
        threadWait(2000);
        validateConceptPresence(conceptName);
        driver.findElement(By.xpath("//article[@class='card-container']/div[@class='section-inner-item-view']/header[text()='"+conceptName+"']/a")).click();

    }
    public void editConceptDetails(JSONObject dataObject){
        switch(dataObject.get("field").toString()){

            case "name":
                enterPerceptionName(dataObject.get("value").toString());
                break;
            case "perceptionType":
                JSONObject value= (JSONObject) dataObject.get("value");
                selectTypeOfPerception(value.get("type").toString());
                selectSATCatalog(value.get("satCatalog").toString());
                break;
            case "satCatalog":
                selectSATCatalog(dataObject.get("value").toString());
                break;
            case "isnGravel":
                selectIsnGravel(dataObject.get("value").toString());
                break;
            case "isrGravel":
                selectIsrGravel(dataObject.get("value").toString());
                break;
            case "conceptType":
                selectTypeOfConcept(dataObject.get("value").toString());
                break;
            case "accountNumber":
                enterAccountNumber(dataObject.get("value").toString());
                break;
        }

    }
    public void validateUpdatedFieldValue(JSONObject dataObject)
    {
        String field=dataObject.get("field").toString();
        threadWait(3000);
        if(field.equalsIgnoreCase("name"))
            validateConceptPresence(dataObject.get("name").toString());

//        WebElement parent=driver.findElement(By.xpath("//header[text()='"+dataObject.get("name").toString()+"']/following-sibling::div"));
        String actual;
        switch(field) {
            case "perceptionType":
                actual = driver.findElement(By.xpath("//header[text()='"+dataObject.get("name").toString()+"']/following-sibling::div/div[@class='field is-horizontal field-code']/div[2]/div/div/span")).getText();
                JSONObject value= (JSONObject) dataObject.get("value");
                String catalogStr=value.get("satCatalog").toString().split("-")[1].trim();
                if (!compareSpanishStrings(actual, catalogStr))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + catalogStr, false);
                break;
            case "satCatalog":
                actual = driver.findElement(By.xpath("//header[text()='"+dataObject.get("name").toString()+"']/following-sibling::div/div[@class='field is-horizontal field-code']/div[2]/div/div/span")).getText();
                String valueStr= dataObject.get("satCatalog").toString().split("-")[1].trim();
                if (!compareSpanishStrings(actual, valueStr))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + valueStr, false);
                break;
            case "isrGravel":
                actual = driver.findElement(By.xpath("//header[text()='"+dataObject.get("name").toString()+"']/following-sibling::div/div[@class='field is-horizontal field-isr']/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, dataObject.get("value").toString()))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + dataObject.get("value").toString(), false);
                break;
            case "isnGravel":
                actual = driver.findElement(By.xpath("//header[text()='"+dataObject.get("name").toString()+"']/following-sibling::div/div[@class='field is-horizontal field-isn']/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, dataObject.get("value").toString()))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + dataObject.get("value").toString(), false);
                break;
            case "conceptType":
                actual = driver.findElement(By.xpath("//header[text()='"+dataObject.get("name").toString()+"']/following-sibling::div/div[@class='field is-horizontal field-payroll_complement']/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, dataObject.get("value").toString()))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + dataObject.get("value").toString(), false);
                break;
            case "accountNumber":
                actual = driver.findElement(By.xpath("//header[text()='"+dataObject.get("name").toString()+"']/following-sibling::div/div[@class='field is-horizontal field-perception_accounting_policy_catalog']/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, dataObject.get("value").toString()))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + dataObject.get("value").toString(), false);
                break;

        }
    }
    public void validateConceptIsDeleted(String name) {
        threadWait(2000);
        if(isElementPresent(By.xpath("//header[text()='"+name+"']")))
            logFailure("Concept is not deleted",true);
    }
}

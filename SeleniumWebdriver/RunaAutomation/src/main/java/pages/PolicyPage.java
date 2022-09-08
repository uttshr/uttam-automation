package pages;

import manager.DriverManager;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolicyPage extends BasePage {
    public PolicyPage(DriverManager driverManager){
        super(driverManager);
    }

    @FindBy(css = "button.add-item-right-container")
    WebElement nuevoPolitica;
    @FindBy(css="#name")
    WebElement policyName;
    @FindBy(id="economic_days")
    WebElement economicDays;
    @FindBy(name="vacation_bonus_by_anniversary")
    WebElement vacationBonus;
    @FindBy(id="pantry_type")
    WebElement pantryType;
    @FindBy(id="react-select-pantry_type-input")
    WebElement pantryTypeTxt;
    @FindBy(id="pantry")
    WebElement pantryNum;
    @FindBy(name="pantry_packed")
    WebElement foodVoucherCap;
    @FindBy(id="saving_fund_type")
    WebElement savingFundType;
    @FindBy(id="react-select-saving_fund_type-input")
    WebElement savingFundTypeTxt;
    @FindBy(id="saving_fund")
    WebElement savingFundNum;
    @FindBy(name="saving_fund_packed")
    WebElement savingFundCap;
    @FindBy(id="restaurant_vouchers_type")
    WebElement restaurantVoucherType;
    @FindBy(id="react-select-restaurant_vouchers_type-input")
    WebElement restaurantVoucherTypeTxt;
    @FindBy(id="restaurant_vouchers")
    WebElement restaurantVoucherNum;
    @FindBy(name="restaurant_vouchers_packed")
    WebElement restaurantVoucherCap;
    @FindBy(id="calculated_by_antiquity_date")
    WebElement seniorityDate;
    @FindBy(id="calculated_by_contract_start_date")
    WebElement contractStartDate;
    @FindBy(name="discount_faults")
    WebElement faultsDiscount;
    @FindBy(name="discount_disabilities")
    WebElement disabilitiesDiscount;
    @FindBy(name="restaurant_vouchers_discount")
    WebElement restaurantDiscount;
    @FindBy(name="discount_seventh_day")
    WebElement seventhDayDiscount;
    @FindBy(css="div.confirmation-dialog button.button.is-submit")
    WebElement submitBtn;
    @FindBy(xpath="//button[@data-testid='pantry']")
    WebElement pantryButton;
    @FindBy(xpath="//button[@data-testid='saving-fund']")
    WebElement savingFundButton;
    @FindBy(xpath="//button[@data-testid='restaurant-vouchers']")
    WebElement restaurantVoucherButton;
    @FindBy(xpath="//button[@data-testid='discounts']")
    WebElement discountsButton;


    public void clickNewPolicBtn() {
        nuevoPolitica.click();
        threadWait(2000);
    }

    public void enterPolicyName(String name) {
        policyName.clear();
        policyName.sendKeys(name);
    }

    public void enterEconomyDays(String days) {
        economicDays.clear();
        economicDays.sendKeys(days);
    }

    public void selectVacationBonus(String bonus) {
        if(bonus.equalsIgnoreCase("yes")&&!vacationBonus.isSelected())
            vacationBonus.click();
        else if(bonus.equalsIgnoreCase("no")&&vacationBonus.isSelected())
            vacationBonus.click();
    }


    public void selectCalculationsBased(String calculationsBasedOn) {
        if(calculationsBasedOn.equalsIgnoreCase("seniority"))
            seniorityDate.click();
        else
            contractStartDate.click();
    }
    public void validatePolicyCreated(String policyName)
    {
        threadWait(1000);
        if(isElementPresent(By.cssSelector("button.button.is-submit ")))
            logFailure("Policy is not created",true);
        validatePolicyPresence(policyName);
    }
    public void validatePolicyPresence(String policyName)
    {
        threadWait(2000);
        if(!isElementPresent(By.xpath("//header[text()='"+policyName+"']")))
            logFailure("Policy is not present",true);
    }

    public void updatePantryVoucherDetails(JSONObject dataObject) {
        pantryType.click();
        pantryTypeTxt.clear();
        pantryTypeTxt.sendKeys(dataObject.get("type").toString()+ Keys.ENTER);
        pantryNum.clear();
        pantryNum.sendKeys(dataObject.get("number").toString());
        if(dataObject.get("cap").toString().equalsIgnoreCase("yes")&&!foodVoucherCap.isSelected())
            foodVoucherCap.click();
        else if(dataObject.get("cap").toString().equalsIgnoreCase("no")&&foodVoucherCap.isSelected())
            foodVoucherCap.click();
    }

    public void updateSavingFundDetails(JSONObject savingFund) {
        savingFundType.click();
        savingFundTypeTxt.clear();
        savingFundTypeTxt.sendKeys(savingFund.get("type").toString()+Keys.ENTER);
        savingFundNum.clear();
        savingFundNum.sendKeys(savingFund.get("number").toString());
        if(savingFund.get("cap").toString().equalsIgnoreCase("yes")&&!savingFundCap.isSelected())
            savingFundCap.click();
        else if(savingFund.get("cap").toString().equalsIgnoreCase("no")&&savingFundCap.isSelected())
            savingFundCap.click();

    }

    public void updateRestaurantVoucherDetails(JSONObject dataObject) {
        restaurantVoucherType.click();
        restaurantVoucherTypeTxt.clear();
        restaurantVoucherTypeTxt.sendKeys(dataObject.get("type").toString()+Keys.ENTER);
        restaurantVoucherNum.clear();
        restaurantVoucherNum.sendKeys(dataObject.get("number").toString());
        if(dataObject.get("cap").toString().equalsIgnoreCase("yes")&&!restaurantVoucherCap.isSelected())
            restaurantVoucherCap.click();
        else if(dataObject.get("cap").toString().equalsIgnoreCase("no")&&restaurantVoucherCap.isSelected())
            restaurantVoucherCap.click();
    }

    public void updateDiscounts(JSONObject discounts) {
        if(discounts.get("faultsDiscount").toString().equalsIgnoreCase("no"))
            faultsDiscount.click();
        if(discounts.get("disabilitiesDiscount").toString().equalsIgnoreCase("no"))
            disabilitiesDiscount.click();
        if(discounts.get("restaurantVoucherDiscount").toString().equalsIgnoreCase("no"))
            restaurantDiscount.click();
        if(discounts.get("seventhDayDiscount").toString().equalsIgnoreCase("no"))
            seventhDayDiscount.click();
    }

    public void clickOnEditPolicyBtn(String policyName) {
        threadWait(2000);
        validatePolicyPresence(policyName);
        driver.findElement(By.xpath("//article[@class='card-container']/div[@class='section-inner-item-view']/header[text()='"+policyName+"']/a")).click();

    }

    public void editValueOfGivenField(String field, String value) {
        String subField = null;
        if(field.contains(".")) {
            String[] fields = field.split("\\.");
            field=fields[0];
            subField=fields[1];
        }
        switch(field){
            case "name":
                enterPolicyName(value);
                break;
            case "economyDays":
                enterEconomyDays(value);
                break;
            case "vacationBonus":
                selectVacationBonus(value);
                break;
            case "pantryVoucher":
                pantryButton.click();
                if(subField.equalsIgnoreCase("type")) {
                    pantryType.click();
                    pantryTypeTxt.clear();
                    pantryTypeTxt.sendKeys(value + Keys.ENTER);
                }else if(subField.equalsIgnoreCase("number")) {
                    pantryNum.clear();
                    pantryNum.sendKeys(value.toString());
                }else {
                    if(value.equalsIgnoreCase("yes")&&!foodVoucherCap.isSelected())
                        foodVoucherCap.click();
                    else if(value.equalsIgnoreCase("no")&&foodVoucherCap.isSelected())
                        foodVoucherCap.click();
                }
                break;
            case "savingFund":
                savingFundButton.click();
                if(subField.equalsIgnoreCase("type")) {
                    savingFundType.click();
                    savingFundTypeTxt.clear();
                    savingFundTypeTxt.sendKeys(value+Keys.ENTER);
                }else if(subField.equalsIgnoreCase("number")) {
                    savingFundNum.clear();
                    savingFundNum.sendKeys(value);
                }else {
                    if(value.equalsIgnoreCase("yes")&&!savingFundCap.isSelected())
                        savingFundCap.click();
                    else if(value.equalsIgnoreCase("no")&&savingFundCap.isSelected())
                        savingFundCap.click();
                }
                break;
            case "restaurantVoucher":
                restaurantVoucherButton.click();
                if(subField.equalsIgnoreCase("type")) {
                    restaurantVoucherType.click();
                    restaurantVoucherTypeTxt.clear();
                    restaurantVoucherTypeTxt.sendKeys(value+Keys.ENTER);
                }else if(subField.equalsIgnoreCase("number")) {
                    restaurantVoucherNum.clear();
                    restaurantVoucherNum.sendKeys(value);
                }else {
                    if(value.equalsIgnoreCase("yes")&&!restaurantVoucherCap.isSelected())
                        restaurantVoucherCap.click();
                    else if(value.equalsIgnoreCase("no")&&restaurantVoucherCap.isSelected())
                        restaurantVoucherCap.click();
                }
                break;
            case "discounts":
                discountsButton.click();
                if(subField.equalsIgnoreCase("faultsDiscounts")) {
                    if(value.equalsIgnoreCase("yes")&&!faultsDiscount.isSelected())
                        faultsDiscount.click();
                    else if(value.equalsIgnoreCase("no")&&faultsDiscount.isSelected())
                        faultsDiscount.click();
                }else if(subField.equalsIgnoreCase("disabilitiesDiscount")) {
                    if(value.equalsIgnoreCase("yes")&&!disabilitiesDiscount.isSelected())
                        disabilitiesDiscount.click();
                    else if(value.equalsIgnoreCase("no")&&disabilitiesDiscount.isSelected())
                        disabilitiesDiscount.click();
                }else if(subField.equalsIgnoreCase("restaurantVoucherDiscount")){
                    if(value.equalsIgnoreCase("yes")&&!restaurantDiscount.isSelected())
                        restaurantDiscount.click();
                    else if(value.equalsIgnoreCase("no")&&restaurantDiscount.isSelected())
                        restaurantDiscount.click();
                }else {
                    if(value.equalsIgnoreCase("yes")&&!seventhDayDiscount.isSelected())
                        seventhDayDiscount.click();
                    else if(value.equalsIgnoreCase("no")&&seventhDayDiscount.isSelected())
                        seventhDayDiscount.click();
                }
                break;
            case "calculationsBasedOn":
                if(value.equalsIgnoreCase("seniority"))
                    seniorityDate.click();
                else
                    contractStartDate.click();
                break;
        }
    }
    public void validateUpdatedFieldValue(String policyName,String field,String value)
    {
        threadWait(3000);
        if(field.equalsIgnoreCase("name"))
            validatePolicyPresence(policyName);
        String subField = null;
        if(field.contains(".")) {
            String[] fields = field.split("\\.");
            field=fields[0];
            subField=fields[1];
        }
//        WebElement parent=driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div"));
        String actual;
        switch(field) {
            case "economyDays":
                actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-economic_days')]/div[2]/div/div/span")).getText();
                if (!actual.split(" ")[0].equals(value))
                    logFailure(field + " value is not updated. Actual: " + actual.split(" ")[0] + " , Expected: " + value, false);
                break;
            case "vacationBonus":
                actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-vacation_bonus_by_anniversary')]/div[2]/div/div/span")).getText();
                if(value.equalsIgnoreCase("yes")) {
                    if (!compareSpanishStrings(actual, "Sí"))
                        logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                }else {
                    if (!compareSpanishStrings(actual, "No"))
                        logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                }
                    break;
            case "pantryVoucher":
                if(subField.equalsIgnoreCase("type"))
                {
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[@class='field is-horizontal field-pantry']/div[2]/div/div/span")).getText();
                    if(value.equalsIgnoreCase("Fijo")) {
                        if (!actual.startsWith("$"))
                            logFailure(field + " value is not updated. Actual: Porcentual" + " , Expected: Fijo", false);
                    }else {
                        if (!actual.endsWith("%"))
                            logFailure(field + " value is not updated. Actual: Fijo" + " , Expected: Porcentual", false);
                    }
                }else if(subField.equalsIgnoreCase("number"))
                {
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[@class='field is-horizontal field-pantry']/div[2]/div/div/span")).getText();
                    if(!actual.startsWith(value))
                        logFailure(field + " value is not updated. Actual: "+actual + " , Expected: "+value, false);
                }else{
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[@class='field is-horizontal field-pantry_packed']/div[2]/div/div/span")).getText();
                    if(value.equalsIgnoreCase("yes")) {
                        if (!compareSpanishStrings(actual,"Sí"))
                            logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                    }else {
                        if (!actual.equalsIgnoreCase("No"))
                            logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                    }
                }
                break;
            case "savingFund":
                if(subField.equalsIgnoreCase("type"))
                {
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-saving_fund')]/div[2]/div/div/span")).getText();
                    if(value.equalsIgnoreCase("Fijo")) {
                        if (!actual.startsWith("$"))
                            logFailure(field + " value is not updated. Actual: Porcentual" + " , Expected: Fijo", false);
                    }else {
                        if (!actual.endsWith("%"))
                            logFailure(field + " value is not updated. Actual: Fijo" + " , Expected: Porcentual", false);
                    }
                }else if(subField.equalsIgnoreCase("number"))
                {
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[@class='field is-horizontal field-saving_fund']/div[2]/div/div/span")).getText();
                    if(!actual.startsWith(value))
                        logFailure(field + " value is not updated. Actual: "+actual + " , Expected: "+value, false);
                }else{
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[@class='field is-horizontal field-saving_fund']/div[2]/div/div/span")).getText();
                    if(value.equalsIgnoreCase("yes")) {
                        if (!compareSpanishStrings(actual,"Sí"))
                            logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                    }else {
                        if (!actual.equalsIgnoreCase("No"))
                            logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                    }
                }
                break;
            case "restaurantVoucher":
                if(subField.equalsIgnoreCase("type"))
                {
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[@class='field is-horizontal field-restaurant_vouchers']/div[2]/div/div/span")).getText();
                    if(value.equalsIgnoreCase("Fijo")) {
                        if (!actual.startsWith("$"))
                            logFailure(field + " value is not updated. Actual: Porcentual" + " , Expected: Fijo", false);
                    }else {
                        if (!actual.endsWith("%"))
                            logFailure(field + " value is not updated. Actual: Fijo" + " , Expected: Porcentual", false);
                    }
                }else if(subField.equalsIgnoreCase("number"))
                {
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[@class='field is-horizontal field-restaurant_vouchers']/div[2]/div/div/span")).getText();
                    if(!actual.startsWith(value))
                        logFailure(field + " value is not updated. Actual: "+actual + " , Expected: "+value, false);
                }else{
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-restaurant_vouchers_packed')]/div[2]/div/div/span")).getText();
                    if(value.equalsIgnoreCase("yes")) {
                        if (!compareSpanishStrings(actual,"Sí"))
                            logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                    }else {
                        if (!actual.equalsIgnoreCase("Do not"))
                            logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                    }
                }
                break;
            case "discounts":
                if(subField.equalsIgnoreCase("faultsDiscount"))
                {
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-discount_faults')]/div[2]/div/div/span")).getText();
                }else if(subField.equalsIgnoreCase("disabilitiesDiscount")){
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-discount_disabilities')]/div[2]/div/div/span")).getText();
                }else if(subField.equalsIgnoreCase("restaurantVoucherDiscount")){
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-restaurant_vouchers_discount')]/div[2]/div/div/span")).getText();
                }else{
                    actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-discount_seventh_day')]/div[2]/div/div/span")).getText();
                }
                if(value.equalsIgnoreCase("yes")) {
                    if (!compareSpanishStrings(actual,"Sí"))
                        logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                }else {
                    if (!actual.equalsIgnoreCase("No"))
                        logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                }
                break;

            case "calculationsBasedOn":
                actual = driver.findElement(By.xpath("//header[text()='"+policyName+"']/following-sibling::div/div/div[contains(@class,'field-calculated_by')]/div[2]/div/div/span")).getText();
                if(value.equalsIgnoreCase("seniority"))
                {
                    if(!actual.contains("seniority"))
                        logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                }else {
                    if(actual.contains("seniority"))
                        logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                }
                break;

        }
    }

    public void clickOnContinue() {
        threadWait(3000);
        submitBtn.click();
    }

    public void validatePolicyIsDeleted(String name) {
        threadWait(2000);
        if(isElementPresent(By.xpath("//header[text()='"+name+"']")))
            logFailure("Policy is not deleted",true);
    }
}

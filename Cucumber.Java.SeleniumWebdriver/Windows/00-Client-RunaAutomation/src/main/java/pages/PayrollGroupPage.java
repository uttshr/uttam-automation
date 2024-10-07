package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayrollGroupPage extends BasePage {
    public PayrollGroupPage(DriverManager driverManager){
        super(driverManager);
    }
    @FindBy(css = "a.add-item-right-container.add-button")
    WebElement nuevoGrupo;
    @FindBy(id = "payroll_group_name")
    WebElement payrollGroupName;
    @FindBy(id = "payroll_group_sub_company_id")
    WebElement companyId;
    @FindBy(id = "react-select-payroll_group[sub_company_id]-input")
    WebElement companyIdTxt;
    @FindBy(id = "payroll_group_company_bank_id")
    WebElement companyBankId;
    @FindBy(id = "react-select-payroll_group[company_bank_id]-input")
    WebElement companyBankIdTxt;
    @FindBy(id = "payroll_group_payroll_frequency")
    WebElement payrollGroupFrequency;
    @FindBy(id = "react-select-payroll_group[payroll_frequency]-input")
    WebElement payrollGroupFrequencyTxt;
    @FindBy(id = "payroll_group_calculation_based_on")
    WebElement payrollGroupCalculation;
    @FindBy(id = "react-select-payroll_group[calculation_based_on]-input")
    WebElement payrollGroupCalculationTxt;
    @FindBy(id = "payroll_group_extraordinary.annual_gratuity")
    WebElement annualGratuity;
    @FindBy(id = "react-select-payroll_group[extraordinary.annual_gratuity]-input")
    WebElement annualGratuityTxt;
    @FindBy(css="div.field.checkbox-field input")
    WebElement annualGratuityChkBox;
    @FindBy(css = "input#payroll_group_subsidy_type_periodic")
    WebElement periodicSubsidy;
    @FindBy(css = "input#payroll_group_subsidy_type_daily")
    WebElement dailySubsidy;
    @FindBy(css = "input[name='payroll_group[social_security_monthly]']")
    WebElement socialScurityMonthlyChkBox;
    @FindBy(css = "input[name='payroll_group[monthly_isr_adjustment]']")
    WebElement monthlyIsrAdjustmentChkBox;
    @FindBy(css="button.is-submit")
    WebElement aceptarBtn;


    public void clickNewGroup()
    {
        nuevoGrupo.click();
    }
    public void enterGroupName(String value)
    {
        payrollGroupName.sendKeys(value);
    }
    public void selectCompanyId(String value)
    {
        companyId.click();
        companyIdTxt.clear();
        companyIdTxt.sendKeys(value+ Keys.ENTER);
        //threadWait(5000);
       // driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void selectCompanyBankId(String value)
    {
        companyBankId.click();
        companyBankIdTxt.clear();
        companyBankIdTxt.sendKeys(value+ Keys.ENTER);
//        threadWait(3000);
//        driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void selectPayrollGroupFrequency(String value)
    {
        payrollGroupFrequency.click();
        payrollGroupFrequencyTxt.clear();
        payrollGroupFrequencyTxt.sendKeys(value+ Keys.ENTER);
//        threadWait(3000);
//        driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void selectPayrollGroupCalc(String value)
    {
        payrollGroupCalculation.click();
        payrollGroupCalculationTxt.clear();
        payrollGroupCalculationTxt.sendKeys(value+ Keys.ENTER);
//        threadWait(3000);
//        driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void selectAnnualGratuity(String value)
    {
        annualGratuity.click();
        annualGratuityTxt.clear();
        annualGratuityTxt.sendKeys(value+ Keys.ENTER);
//        threadWait(5000);
//        driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void selectSubsidyType(String value)
    {
        if(value.equalsIgnoreCase("periodic"))
            periodicSubsidy.click();
        else
            dailySubsidy.click();
    }
    public void validatePayrollGroupCreated(String payrollGroupName) {
        threadWait(1000);
        if(isElementPresent(By.cssSelector("button.button.is-submit ")))
            logFailure("Payroll group is not created",true);
        validatePayrollGroupPresence(payrollGroupName);
    }
    public void validatePayrollGroupPresence(String payrollGroupName)
    {
        threadWait(2000);
        if(!isElementPresent(By.xpath("//header[text()='"+payrollGroupName+"']")))
            logFailure("Payroll group is not present",true);
    }
    public void validatePayrollGroupIsDeleted(String payrollGroupName)
    {
        threadWait(2000);
        if(isElementPresent(By.xpath("//header[text()='"+payrollGroupName+"']")))
            logFailure("Payroll group is not deleted",true);

    }
    public void clickEditPayrollGroup(String payrollGroupName)
    {
        threadWait(2000);
        validatePayrollGroupPresence(payrollGroupName);
        driver.findElement(By.xpath("//div[@class='card-container']/div[@class='section-inner-item-view']/header[text()='"+payrollGroupName+"']/a")).click();
    }
    public void editPayrollGroupDetails(String field,String value){
         switch(field){

            case "groupName":
                enterGroupName(value);
                break;
            case "companyId":
                selectCompanyId(value);
                break;
            case "CompanyBankId":
                selectCompanyBankId(value);
                break;
            case "payrollGroupFrequency":
                String calc=payrollGroupFrequencyTxt.getText();
                String gratuity=annualGratuityTxt.getText();
                selectPayrollGroupFrequency(value);
                selectPayrollGroupCalc(calc);
                selectAnnualGratuity(gratuity);
                break;
            case "payrollGroupCalculation":
                selectPayrollGroupCalc(value);
                break;
            case "annualGratuity":
                selectAnnualGratuity(value);
                break;
            case "subsidyType":
                selectSubsidyType(value);
                break;
        }

    }
    public void validateUpdatedFieldValue(String payrollGroupName,String field,String value)
    {
        threadWait(3000);
        if(field.equalsIgnoreCase("GroupName"))
            validatePayrollGroupPresence(payrollGroupName);

        WebElement parent=driver.findElement(By.xpath("//header[text()='"+payrollGroupName+"']/following-sibling::div"));
        String actual;
        switch(field) {
            case "companyId":
                actual = parent.findElement(By.xpath("//div[contains(@class,'sub_company')]/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, value))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                break;
            case "companyBankId":
                actual = parent.findElement(By.xpath("//div[contains(@class,'company_bank')]/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, value))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                break;
            case "payrollGroupFrequency":
                actual = parent.findElement(By.xpath("//div[contains(@class,'payroll_frequency')]/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, value))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                break;
            case "payrollGroupCalculation":
                actual = parent.findElement(By.xpath("//div[contains(@class,'calculation_based_on')]/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, value))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                break;
            case "annualGratuity":
                actual = parent.findElement(By.xpath("//div[contains(@class,'isr_annual_gratuity')]/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, value))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                break;
            case "subsidyType":
                actual = parent.findElement(By.xpath("//div[contains(@class,'subsidy_type')]/div[2]/div/div/span")).getText();
                if (!compareSpanishStrings(actual, value))
                    logFailure(field + " value is not updated. Actual: " + actual + " , Expected: " + value, false);
                break;

        }
    }
    public void clickAceptarBtn()
    {
        threadWait(2000);
        aceptarBtn.click();
    }
}

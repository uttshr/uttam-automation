package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CompanyPage extends BasePage{
    public CompanyPage(DriverManager driverManager){
        super(driverManager);
    }

    //WebElements
    @FindBy(id="sub_company_name")
    WebElement companyNameTxt;
    @FindBy(id="sub_company_business_name")
    WebElement companyBusinessNameTxt;
    @FindBy(xpath="//div[contains(@class,'field-sub_company[logo]')]//input[@type='file']")
    WebElement logoFile;
    @FindBy(id="react-select-sub_company[industry_id]-input")
    WebElement industryTxt;
    @FindBy(id="sub_company[industry_id]")
    WebElement industryDiv;
    @FindBy(id="sub_company_rfc")
    WebElement rfcTxt;
    @FindBy(id="react-select-sub_company[tax_regime]-input")
    WebElement taxRegimeTxt;
    @FindBy(id="sub_company_tax_regime")
    WebElement taxRegimeBtn;
    @FindBy(id="sub_company_employer_registration")
    WebElement employerRegistrationTxt;
    @FindBy(id="sub_company_risk_level")
    WebElement riskLevel;
    @FindBy(id="react-select-sub_company[state]-input")
    WebElement stateTxt;
    @FindBy(id="sub_company_state")
    WebElement stateBtn;
    @FindBy(id="sub_company_address")
    WebElement addressTxt;
    @FindBy(id="sub_company_zip_code")
    WebElement postalTxt;
    @FindBy(id="react-select-sub_company[company_bank_ids]-input")
    WebElement companyBankIdTxt;
    @FindBy(id="sub_company_company_bank_ids")
    WebElement companyBankIdDiv;
    @FindBy(id="sub_company_imss_subbranch_key")
    WebElement subBranchKeyTxt;
    @FindBy(xpath="//div[contains(@class,'field-sub_company[csd_key]')]//input[@type='file']")
    WebElement csdKeyFile;
    @FindBy(xpath="//div[contains(@class,'field-sub_company[csd_cer]')]//input[@type='file']")
    WebElement csdCertFile;
    @FindBy(id="sub_company_csd_password")
    WebElement csdPasswordTxt;
    @FindBy(css="button.button.is-submit ")
    WebElement submitBtn;
    @FindBy(id="sub_company_automatic_extra_hours_reading_true")
    WebElement extraHoursReadingChkBox;
    @FindBy(id="sub_company_imss_variable_automatic_false")
    WebElement imssVariableChkBox;
    @FindBy(id="sub_company_use_stp_for_payment_false")
    WebElement useStepPaymentChkBox;
    @FindBy(id="sub_company_imss_minimum_wage_false")
    WebElement imssCompanyWageChkBox;
    @FindBy(id="sub_company_send_imss_movements_false")
    WebElement imssMovementsChkBox;
    @FindBy(id="sub_company_stp_username")
    WebElement subCompanyStpTxt;
    @FindBy(id="sub_company_stp_clabe_account")
    WebElement ubCompanyStpClabeTxt;
    @FindBy(id="sub_company_desereti_imss_method_imss_file")
    WebElement imssFileRadioBtn;
    @FindBy(id="sub_company_desereti_imss_method_imss_fiel")
    WebElement imssFielRadioBtn;
    @FindBy(id="sub_company_imss_username")
    WebElement imssUsername;
    @FindBy(id="sub_company_imss_password")
    WebElement imssPassword;
    @FindBy(xpath="//div[contains(@class,'field-sub_company[imss_file]')]//input[@type='file']")
    WebElement imssFile;
    @FindBy(xpath="//div[contains(@class,'field-sub_company[imss_fiel_cer]')]//input[@type='file']")
    WebElement imssFielCertFile;
    @FindBy(xpath="//div[contains(@class,'field-sub_company[imss_fiel_key]')]//input[@type='file']")
    WebElement imssFielKeyFile;
    @FindBy(id="sub_company_imss_fiel_password")
    WebElement imssFielPassword;
    @FindBy(css="button.delete-icon-text-container")
    WebElement deleteBtn;
    @FindBy(xpath="(//div[contains(@class,'confirmation-dialog')])[3]")
    WebElement confirmationDialog;
    @FindBy(xpath="//button[@data-testid='confirm-modal']")
    WebElement confirmationBtn;


    public void enterCompanyName(String value)
    {
        companyNameTxt.clear();
        companyNameTxt.sendKeys(value);
    }
    public void enterCompanyBusinessName(String value)
    {
        companyBusinessNameTxt.clear();
        companyBusinessNameTxt.sendKeys(value);
    }
    public void uploadLogoFile(String value)
    {
        logoFile.clear();
        logoFile.sendKeys(value);
    }
    public void enterIndustryName(String value)
    {
        industryTxt.sendKeys(value.split(" ")[0]);
        threadWait(5000);
        driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void clickIndustryName()
    {
        industryDiv.click();
    }
    public void enterRfc(String value)
    {
        rfcTxt.clear();
        rfcTxt.sendKeys(value);
    }
    public void enterTaxRegime(String value)
    {
        taxRegimeTxt.sendKeys(value.split(" ")[0]);
        threadWait(5000);
        driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void clickTaxRegime()
    {
        taxRegimeBtn.click();
    }
    public void enterEmployerRegistration(String value)
    {
        employerRegistrationTxt.clear();
        employerRegistrationTxt.sendKeys(value);
    }
    public void enterRiskLevel(String value)
    {
        riskLevel.clear();
        riskLevel.sendKeys(value);
    }
    public void enterState(String value)
    {
        stateTxt.sendKeys(value.split(" ")[0]);
        threadWait(5000);
        driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void clickState()
    {
        stateBtn.click();
    }
    public void enterAddress(String value)
    {
        addressTxt.clear();
        addressTxt.sendKeys(value);
    }
    public void enterPostal(String value)
    {
        postalTxt.clear();
        postalTxt.sendKeys(value);
    }
    public void enterCompanyBankId(String value)
    {
        companyBankIdTxt.sendKeys(value.split(" ")[0]);
        threadWait(5000);
        driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
    public void clickCompanyBankId()
    {
        companyBankIdDiv.click();
    }
    public void enterBanchKey(String value)
    {
        subBranchKeyTxt.clear();
        subBranchKeyTxt.sendKeys(value);
    }
    public void uploadCsdKeyFile(String value)
    {
        csdKeyFile.clear();
        csdKeyFile.sendKeys(value);
    }
    public void uploadCsdCertFile(String value)
    {
        csdCertFile.clear();
        csdCertFile.sendKeys(value);
    }
    public void enterCsdPassword(String value)
    {
        csdPasswordTxt.clear();
        csdPasswordTxt.sendKeys(value);
    }
    public void clickExtraHoursReadingChkBox()
    {
        extraHoursReadingChkBox.click();
    }
    public void clickImssVariableChkBox()
    {
        imssVariableChkBox.click();
    }
    public void clickUseStepPaymentChkBox()
    {
        useStepPaymentChkBox.click();
    }
    public void clickImssFileRadioBtn()
    {
        imssFileRadioBtn.click();
    }
    public void clickImssFielRadioBtn()
    {
        imssFielRadioBtn.click();
    }
    public void enterSubCompanyStp(String value)
    {
        subCompanyStpTxt.clear();
        subCompanyStpTxt.sendKeys(value);
    }
    public void enterUbCompanyStpClabe(String value)
    {
        ubCompanyStpClabeTxt.clear();
        ubCompanyStpClabeTxt.sendKeys(value);
    }
    public void enterImssUsername(String value)
    {
        imssUsername.clear();
        imssUsername.sendKeys(value);
    }
    public void enterImssPassword(String value)
    {
        imssPassword.clear();
        imssPassword.sendKeys(value);
    }
    public void clickImssCompanyWageChkBox()
    {
        imssCompanyWageChkBox.click();
    }
    public void clickImssMovementsChkBox()
    {
        imssMovementsChkBox.click();
    }
    public void uploadImssFile(String value)
    {
        imssFile.clear();
        imssFile.sendKeys(value);
    }
    public void uploadImssFielCertFile(String value)
    {
        imssFielCertFile.clear();
        imssFielCertFile.sendKeys(value);
    }
    public void uploadImssFielKeyFile(String value)
    {
        imssFielKeyFile.clear();
        imssFielKeyFile.sendKeys(value);
    }
    public void enterImssFielPassword(String value)
    {
        imssFielPassword.clear();
        imssFielPassword.sendKeys(value);
    }
    public void clickSubmitBtn()
    {
        threadWait(2000);
        submitBtn.click();
    }
    public void clickDeleteBtn()
    {
        deleteBtn.click();
    }
    public void editCompanyDetails(String field,String value){
          //CompanyName | BusinessName | LogoFilePath    | IndustryName                       | RFC          | TAXRegime                        | EmployerRegistration | RiskPremium | Condition | Direction   | PostalCode | BankAccount | ImssKey | CdaKeyFilePath | CdaCertFilePath | Password
        switch(field){

            case "CompanyName":
                enterCompanyName(value);
                break;
            case "BusinessName":
                enterCompanyBusinessName(value);
                break;
            case "LogoFilePath":
                uploadLogoFile(value);
                break;
            case "IndustryName":
                clickIndustryName();
                enterIndustryName(value);
                break;
            case "RFC":
                enterRfc(value);
                break;
            case "TAXRegime":
                clickTaxRegime();
                enterTaxRegime(value);
                break;
            case "EmployerRegistration":
                enterEmployerRegistration(value);
                break;
            case "RiskPremium":
                enterRiskLevel(value);
                break;
            case "State":
                clickState();
                enterState(value);
                break;
            case "Address":
                enterAddress(value);
                break;
            case "PostalCode":
                enterPostal(value);
                break;
            case "BankAccount":
                clickCompanyBankId();
                enterCompanyBankId(value);
                break;
            case "ImssKey":
                enterBanchKey(value);
                break;
            case "CdaKeyFilePath":
                uploadCsdKeyFile(value);
                break;
            case "CdaCertFilePath":
                uploadCsdCertFile(value);
                break;
            case "Password":
                enterCsdPassword(value);
                break;
        }

    }

    public void clickEditCompany(String companyName)
    {
        validateCompanyPresence(companyName);
        driver.findElement(By.xpath("//article[@class='card-container']/div[@class='section-inner-item-view']/header[text()='"+companyName+"']/a")).click();
    }
    public void validateUpdatedFieldValue(String companyName,String field,String value)
    {
        if(field.equals("CompanyName"))
            validateCompanyPresence(companyName);

        WebElement parent=driver.findElement(By.xpath("//header[text()='"+companyName+"']/following-sibling::div"));
        String actual;
        switch(field){
            case "BusinessName":
                actual=parent.findElement(By.cssSelector("div.field-business_name div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "LogoFilePath":
                actual=parent.findElement(By.cssSelector("div.field-logo div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "IndustryName":
                actual=parent.findElement(By.cssSelector("div.field-industry div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "RFC":
                actual=parent.findElement(By.cssSelector("div.field-rfc div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "TAXRegime":
                actual=parent.findElement(By.cssSelector("div.field-tax_regime div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "EmployerRegistration":
                actual=parent.findElement(By.cssSelector("div.field-employer_registration div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "RiskPremium":
                actual=parent.findElement(By.cssSelector("div.field-risk_level div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "State":
                actual=parent.findElement(By.cssSelector("div.field-state div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "Address":
                actual=parent.findElement(By.cssSelector("div.field-address div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "PostalCode":
                actual=parent.findElement(By.cssSelector("div.field-zip_code div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "BankAccount":
                actual=parent.findElement(By.cssSelector("div.field-company_bank_ids div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "ImssKey":
                actual=parent.findElement(By.cssSelector("div.field-imss_subbranch_key div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "CdaKeyFilePath":
                actual=parent.findElement(By.cssSelector("div.field-csd_key div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "CdaCertFilePath":
                actual=parent.findElement(By.cssSelector("div.field-csd_cer div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
            case "Password":
                actual=parent.findElement(By.cssSelector("div.field-csd_password div span.inputBorderless")).getText();
                if(!compareSpanishStrings(actual,value))
                   logFailure(field+" value is not updated. Actual: "+actual+" , Expected: "+value,false);
                break;
        }
    }

    public void validateCompanyPresence(String companyName) {
        if(!isElementPresent(By.xpath("//header[text()='"+companyName+"']")))
           logFailure("Company is not present",true);
    }

    public void validateConfirmationDialog()
    {
        if(!confirmationDialog.isDisplayed())
           logFailure("Confirmation Dialog is not populated",true);
    }
    public void clickConfirmBtn()
    {
        confirmationBtn.click();
    }









}
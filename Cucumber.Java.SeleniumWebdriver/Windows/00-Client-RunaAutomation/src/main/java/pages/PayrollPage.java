package pages;


import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDate;

public class PayrollPage extends BasePage {

    public PayrollPage(DriverManager driverManager){
        super(driverManager);
    }
    @FindBy(xpath = "//*[contains(text(),'Nóminas')]")
    WebElement nominas;

    @FindBy(xpath = "//button[@data-testid='new-payroll-modal']")
    WebElement neuvaNomina;

    @FindBy(xpath = "//div[@id='payroll_group_id']")
    WebElement selectGroupo;

    @FindBy(xpath = "//*[contains(text(),'Grupo 1)]")
    WebElement selectGroupOne;

    @FindBy(xpath = "//*[contains(text(),'Grupo 2')]")
    WebElement selectGroupTwo;

    @FindBy(xpath = "//*[contains(text(),'Grupo 3')]")
    WebElement selectGroupThree;

    @FindBy(xpath = "//*[contains(text(),'Grupo 4')]")
    WebElement selectGroupFour;

    @FindBy(xpath = "//input[@id='start_date']")
    WebElement startDatePeriod;

    @FindBy(css = "div.react-datepicker__day--today")
    WebElement todayDate;

    @FindBy(xpath = "//input[@id=\"endDatePeriod\"]")
    WebElement endDatePeriod;

    @FindBy(id = "start_date_incidence")
    WebElement startDateIncidences;

    @FindBy(id = "end_date_incidence")
    WebElement endDateIncidences;

    @FindBy(xpath = "//form[@id='new-payroll']/div/button[2]")
    WebElement crearButton;

    @FindBy(xpath = "//h6[contains(text(),'Grupo 1')]")
    WebElement payrollText;

    @FindBy(xpath = "//a[contains(text(),'Payroll (nueva)')]")
    WebElement payrollNeuva;

    @FindBy(xpath = "(//p[contains(text(),'Eliminar')])[1]")
    WebElement deleteFirstPayroll;

    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    WebElement continuar;

    @FindBy(css = "div.error-message")
    WebElement errorMessage;
    @FindBy(css = "span.error-message-title")
    WebElement errorTitle;
    @FindBy(css = "span.error-message-reason")
    WebElement errorReason;

    @FindBy(css = "button.react-datepicker__navigation--next")
    WebElement datePickerNextBtn;

    @FindBy(xpath="//button[text()='Aceptar']/preceding-sibling::div/p")
    WebElement errorMsg;
    @FindBy(xpath="//button[text()='Aceptar']")
    WebElement aceptarBrn;
    @FindBy(xpath="//div/h2[text()='Activo']")
    WebElement activoNominas;
    @FindBy(xpath="//div/h2[text()='Nuevo']")
    WebElement nuevoNominas;


    public PayrollPage gotoActivas() throws IOException, InterruptedException {
        nominas.click();
        return this;
    }
    public PayrollPage openNeuvaNomina()throws IOException{
        threadWait(2000);
        By videoClose= By.xpath("//div[@class='video-close-icon']");
        if(isElementPresent(videoClose))
            driver.findElement(videoClose).click();
        threadWait(3000);
        neuvaNomina.click();
        return this;
    }
    public PayrollPage clickSelectGroupo(){
        selectGroupo.click();
        return this;
    }
    public PayrollPage selectGroupOne()throws IOException{
        selectGroupOne.click();
        return this;
    }
    public PayrollPage selectGroupTwo()throws IOException{
        selectGroupTwo.click();
        return this;
    }
    public PayrollPage selectGroupThree()throws IOException{
        selectGroupThree.click();
        return this;
    }
    public PayrollPage selectGroupFour()throws IOException{
        selectGroupFour.click();
        return this;
    }
    public PayrollPage selectGroup(String groupName){
       driver.findElement(By.xpath("//*[contains(text(),'"+groupName.trim()+"')]")).click();
        return this;
    }
    public PayrollPage startDatePeriod(String date) {
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(startDatePeriod));
        startDatePeriod.click();
        threadWait(1000);
        selectDateFromCalendar(date);
        threadWait(1000);
        return this;
    }
    public PayrollPage endDatePeriod(int days) {
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(endDatePeriod));
        endDatePeriod.click();
        LocalDate future = LocalDate.now().plusDays(days);
        if(LocalDate.now().getMonth().getValue()!=future.getMonth().getValue())
            datePickerNextBtn.click();
        int day=future.getDayOfMonth();
        if(driver.findElements(By.xpath("//div[text()='"+day+"']")).size()>1)
            driver.findElements(By.xpath("//div[text()='"+day+"']")).get(1).click();
        else
            driver.findElements(By.xpath("//div[text()='"+day+"']")).get(0).click();
        return this;
    }
    public PayrollPage startDateIncidences(String date){
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(startDateIncidences));
        startDateIncidences.click();
        threadWait(1000);
        selectDateFromCalendar2(date,true);
        threadWait(1000);
        return this;
    }
    public PayrollPage endDateIncidences(String date){
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(endDateIncidences));
        endDateIncidences.click();
        threadWait(1000);
        selectDateFromCalendar2(date,false);
        threadWait(1000);
        return this;
    }
    public PayrollPage validateErrorMessage(String errTitle, String errReason)
    {
        if(!compareSpanishStrings(errorTitle.getText().trim(),errTitle)||!compareSpanishStrings(errorReason.getText().trim(),errReason))
            throw new RuntimeException("Error messages not matched. Expected:"+errTitle +","+errReason+",Actual:"+errorTitle.getText().trim()+","+errorReason.getText().trim());
        return this;
    }
    public PayrollPage clickCrear() throws IOException, InterruptedException {
        Thread.sleep(3000);
        crearButton.click();
        Thread.sleep(15000);
        return this;
    }
    public PayrollPage validatePayroll()throws IOException{
        if(driver.findElements(By.cssSelector("div.error-message")).size()>0)
            Assert.fail("Payroll not created : "+errorTitle.getText()+", "+errorReason.getText());
        return this;
    }
    public PayrollPage gotoPayrollNeuvaList(){
        payrollNeuva.click();
        return  this;
    }
    public PayrollPage deletePayroll(){
        deleteFirstPayroll.click();
        continuar.click();
        return  this;
    }
    public PayrollPage getErrorMessage(){
        String errMsg = errorMessage.getText();
        try{
            Assert.assertTrue(errMsg.contains("GroupId"));
        }catch (AssertionError err){
            Assert.fail("GroupID already exists... ");
        }
        return this;
    }

    public PayrollPage clickAceptar() {
        aceptarBrn.click();
        return this;
    }

    public void deletePayrollIfExist(String groupName, String period) {
        switch (groupName.toUpperCase()){
            case "GRUPO1":
                WebElement element1=driver.findElement(By.xpath("//div[@class='card-container payroll-card']/div/div/h4[contains(text(),'Semanal')]"));
                break;
            case "GRUPO2":
                WebElement element2=driver.findElement(By.xpath("//div[@class='card-container payroll-card']/div/div/h4[contains(text(),'Mensual')]"));
                break;
            case "GRUPO3":

                break;
            case "GRUPO4":

                break;
            case "GRUPO5":

                break;
            case "GRUPO6":

                break;
            case "GRUPO7":

                break;
            case "GRUPO8":

                break;
        }
    }
}

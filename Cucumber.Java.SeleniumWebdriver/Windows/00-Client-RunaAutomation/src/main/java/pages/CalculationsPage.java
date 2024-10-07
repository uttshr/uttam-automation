package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class CalculationsPage extends BasePage{

    public CalculationsPage(DriverManager driverManager){
        super(driverManager);
    }
    @FindBy(xpath="//h2[text()='Nuevo']/following-sibling::div")
    List<WebElement> nuevoPayrolls;
    @FindBy(xpath="//h2[text()='Activo']/following-sibling::div")
    List<WebElement> activePayrolls;
    @FindBy(xpath="//div[@class='validate-buttons']/button[2]")
    WebElement continuarBtn;
    @FindBy(xpath="//h5[text()='Sueldo']/following-sibling::div/div")
    WebElement sueldoBtn;
    @FindBy(css="div.inline-edit-input-container")
    WebElement sueldoEdit;
    @FindBy(xpath="//h5[text()='ISR']/following-sibling::div/div/span")
    WebElement isrBtn;
    @FindBy(xpath="//h5[text()='IMSS']/following-sibling::div/div/span")
    WebElement imssBtn;
    @FindBy(xpath="//h6[text()='Percepciones']/following-sibling::h4")
    WebElement percepcionesTxt;
    @FindBy(xpath="//h6[text()='Deducciones']/following-sibling::h4")
    WebElement deduccionesTxt;
    @FindBy(xpath="//h6[text()='Total neto']/following-sibling::h4")
    WebElement totalNetoTxt;
    @FindBy(css="table.payroll-table tbody tr td:nth-child(1)")
    WebElement firstEmployee;


    public void clickOnComenzar(String startDate,String endDate)
    {
        String d1=getSpanishDate(startDate);
        String d2=getSpanishDate(endDate);
        for(int i=0;i<nuevoPayrolls.size();i++)
        {
            String incidentDate=driver.findElement(By.xpath("//h2[text()='Nuevo']/following-sibling::div["+(i+1)+"]/div[@class='payroll-card-header']/div[1]/span")).getText();
            System.out.println(incidentDate);
            if(incidentDate.contains(d1)&&incidentDate.contains(d2)) {
                driver.findElement(By.xpath("//h2[text()='Nuevo']/following-sibling::div[" + (i + 1) + "]/div[@class='payroll-card-body']/div[2]/button")).click();
                break;
            }
        }
    }
    public void clickOnCalcular(String startDate,String endDate)
    {
        String d1=getSpanishDate(startDate);
        String d2=getSpanishDate(endDate);
        for(int i=0;i<activePayrolls.size();i++)
        {
            String incidentDate=driver.findElement(By.xpath("//h2[text()='Activo']/following-sibling::div["+(i+1)+"]/div[@class='payroll-card-header']/div[1]/span")).getText();
            System.out.println(incidentDate);
            if(incidentDate.contains(d1)&&incidentDate.contains(d2)) {
                driver.findElement(By.xpath("//h2[text()='Activo']/following-sibling::div[" + (i + 1) + "]/div[@class='payroll-card-body']/div[1]/article[1]")).click();
                break;
            }
        }
        threadWait(2000);
    }
    public void clickOnContinuar()
    {
        continuarBtn.click();
    }

    public HashMap<String, String> getValues() {

        HashMap<String,String> values=new HashMap<>();
        values.put("isr",isrBtn.getText());
        //values.put("imss",imssBtn.getText());
        values.put("percepciones",percepcionesTxt.getText());
        values.put("deducciones",deduccionesTxt.getText());
        values.put("totalNeto",totalNetoTxt.getText());
        return  values;
    }

    public HashMap<String, String> getCurrentValues() {

        HashMap<String,String> values=new HashMap<>();
        values.put("isr",driver.findElement(By.xpath("//h5[text()='ISR']/following-sibling::div/div/span")).getText());
        //values.put("imss",driver.findElement(By.xpath("//h5[text()='IMSS']/following-sibling::div/div/span")).getText());
        values.put("percepciones",driver.findElement(By.xpath("//h6[text()='Percepciones']/following-sibling::h4")).getText());
        values.put("deducciones",driver.findElement(By.xpath("//h6[text()='Total neto']/following-sibling::h4")).getText());
        values.put("totalNeto",driver.findElement(By.xpath("//h6[text()='Total neto']/following-sibling::h4")).getText());
        return  values;
    }
    public void enterSueldo(String sueldo) {
        threadWait(2000);
        sueldoBtn.click();
        threadWait(2000);
        Actions action=new Actions(driver);
        action.moveToElement(sueldoEdit).doubleClick().sendKeys(Keys.DELETE+sueldo+Keys.ENTER).build().perform();
        threadWait(5000);
    }

    public void compareValues(HashMap<String,String> previousValues)
    {
        HashMap<String,String> currentValues=getCurrentValues();
        System.out.println(previousValues);
        System.out.println(currentValues);
        for(String key:currentValues.keySet()){
            if(currentValues.get(key).equals(previousValues.get(key)))
                logFailure(key+" value not changed",false);
        }
    }

    public void clickOnEmployee() {
        threadWait(5000);
        firstEmployee.click();
    }
}

package pages;

import com.aventstack.extentreports.Status;
import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.internal.EclipseInterface;

import java.io.IOException;
import java.text.Collator;
import java.util.Locale;

public class LoginPage extends BasePage{

    public LoginPage(DriverManager driverManager){
        super(driverManager);
    }

     @FindBy(xpath = "//input[@id='email']")
     WebElement email;
     @FindBy(css = "#password")
     WebElement password;
     @FindBy(xpath = "//span[contains(@class, 'runa-ds-text--button')]")
     WebElement getIntoButton;
     @FindBy(xpath = "//div[@class ='header-dropdown-trigger']")
     WebElement administrator;
     @FindBy(xpath = "//h1[@data-testid='header-title']")
     WebElement successMsg;
     @FindBy(xpath = "//span[@class='hintError']/span")
     WebElement unSuccessFulMessage;
     @FindBy(css="div.header-dropdown-container div a")
     WebElement perfilDeEmpresa;
     @FindBy(css="div.header-dropdown-container div a:nth-child(2)")
     WebElement config;
     @FindBy(xpath="//a[@href='/company/information/subcompanies/new']")
     WebElement agregarEmpresa;
     @FindBy(css="a[href='/settings/payroll']")
     WebElement nominas;
     @FindBy(css="a[href='/settings/policies']")
     WebElement politicas;
     @FindBy(css="a[href='/settings/concepts']")
     WebElement concepts;
 
    public void gotorunaApp(String url) {
        driver.get(url);
    }
    public void gotorunaApp()  {
        try{
            driver.get(driverManager.prop.getProperty("url"));
        }catch (Exception e)
        {
            logFailure(e.getMessage(),true);
        }
        
    }
    public void enterEmail(String value)  {
        try {
            email.sendKeys(value);
        }catch(Exception e){
            logFailure(e.getMessage(),true);
        }
        
    }
    public void enterPassword(String value)  {
        try {
            password.sendKeys(value);
        }catch (Exception e)
        {
            logFailure(e.getMessage(),true);
        }
        threadWait(20);
        
    }
    public void clickGetIntoButton()  {
        try {
            getIntoButton.click();
        }catch (Exception e){
            logFailure(e.getMessage(),true);
        }
        threadWait(20);
        
    }
    public void verifyElement(String expectedText)  {
        String actual = null;
        try{
            actual=successMsg.getText();
        }catch (Exception e)
        {
            logFailure(e.getMessage(),true);
        }

        if (!compareSpanishStrings(actual,expectedText))
            logFailure("Login Validation is failed. Actual : " + actual + " , Expected : " + expectedText, true);

    }
    public void verifyUnSuccessFulElement(String expectedText)  {
        String actual = null;
        try{
            actual=unSuccessFulMessage.getText();
        }catch (Exception e)
        {
            logFailure(e.getMessage(),true);
        }

        if (!compareSpanishStrings(actual,expectedText))
            logFailure("Login Validation is failed. Actual " + actual + " , Expected : " + expectedText, true);
    }

    public void clickPerfilDeEmpresa()
    {
        perfilDeEmpresa.click();
    }
    public void clickAgregarEmpresa()
    {
        agregarEmpresa.click();
    }
    public void clickAdministrator()
    {
        administrator.click();
    }
    public void defaultLogin()
    {
        enterEmail(driverManager.getProperty("username"));
        enterPassword(driverManager.getProperty("password"));
        clickGetIntoButton();
    }

    public void clickConfiguration()
    {
        config.click();
        threadWait(1000);
        By videoClose= By.xpath("//div[@class='video-close-icon']");
        if(isElementPresent(videoClose))
            driver.findElement(videoClose).click();
    }
    public void clickNominas()
    {
        nominas.click();
    }
    public void clickPoliticas()
    {
        politicas.click();
    }
    public void clickConcepts()
    {
        concepts.click();
    }
}

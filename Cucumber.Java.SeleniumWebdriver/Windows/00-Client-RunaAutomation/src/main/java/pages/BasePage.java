package pages;

import com.aventstack.extentreports.Status;
import manager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// reusable methods
public class BasePage {
    DriverManager driverManager;
    WebDriver driver;
    public BasePage(DriverManager driverManager) {
        this.driverManager=driverManager;
        this.driver=driverManager.getDriver();
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public void threadWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
        }
    }
    public boolean isElementPresent(By by) {

        try {
            // present and visible
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        }catch(Exception ex) {
            return false;
        }
        return true;
    }

    /********************Validation Functions***************************/
    public boolean verifyTitle(String expectedTitleKey) {
        String expectedTitle = driverManager.getProperty(expectedTitleKey);
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle))
            return true;
        else
            return false;
    }

    public boolean verifyElementDisplayed(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }


    public void logFailure(String msg, boolean stopExecution) {
        System.out.println("FAILURE---- "+ msg);
        // fail in testng-cucumber
        //	Assert.fail(msg);// hard assertion
        driverManager.softAssert.fail(msg);

        if(stopExecution)
            driverManager.softAssert.assertAll();
    }

    public void selectDateFromCalendar(String date) {

        try {
            Date currentDate = new Date();
            String str1 = new SimpleDateFormat("dd/MM/yyyy").format(currentDate);
            String currMonth=new SimpleDateFormat("MM").format(currentDate);
            SimpleDateFormat sdformat=new SimpleDateFormat("dd/MM/yyyy");
            Date d1 = sdformat.parse(str1);
            Date d2 = sdformat.parse(date);
            Date dateToSel=new SimpleDateFormat("d/MM/yyyy").parse(date);
            String day=new SimpleDateFormat("d").format(dateToSel);
            String month=new SimpleDateFormat("MM").format(dateToSel);
            String year=new SimpleDateFormat("yyyy").format(dateToSel);
            if(currMonth.equals(month)) {
                driver.findElement(By.xpath("//div[text()='" + day + "']")).click();
                return;
            }
            LocalDate localDate= LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
            Locale spanishLocale=new Locale("es", "ES");
            month=localDate.format(DateTimeFormatter.ofPattern("MMMM",spanishLocale));
            year=localDate.format(DateTimeFormatter.ofPattern("yyyy",spanishLocale));
            String monthYearToBeSelected=month+" "+year;
            System.out.println(monthYearToBeSelected);
            String monthYearDisplayed=driver.findElement(By.cssSelector("div.react-datepicker__current-month")).getText().toLowerCase();
            System.out.println(monthYearDisplayed);
            if(d1.compareTo(d2) > 0)
            {
                while(!monthYearToBeSelected.equals(monthYearDisplayed)) {
                    driver.findElement(By.cssSelector("button.react-datepicker__navigation--previous")).click();
                    monthYearDisplayed=driver.findElement(By.cssSelector("div.react-datepicker__current-month")).getText().toLowerCase();
                    System.out.println(monthYearDisplayed);
                    threadWait(1000);
                }
            }
            else if(d1.compareTo(d2) < 0)
            {
                while(!monthYearToBeSelected.equals(monthYearDisplayed)) {
                    driver.findElement(By.cssSelector("button.react-datepicker__navigation--next")).click();
                    monthYearDisplayed=driver.findElement(By.cssSelector("div.react-datepicker__current-month")).getText().toLowerCase();
                    threadWait(1000);
                }
            }
            driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void selectDateFromCalendar2(String date,boolean doubleClick) {

        try {
            Date dateToSel=new SimpleDateFormat("d/MM/yyyy").parse(date);
            String day=new SimpleDateFormat("d").format(dateToSel);
            String month=new SimpleDateFormat("MM").format(dateToSel);
            String year=new SimpleDateFormat("yyyy").format(dateToSel);
            LocalDate localDate= LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
            Locale spanishLocale=new Locale("es", "ES");
            String monthSpa=localDate.format(DateTimeFormatter.ofPattern("MMMM",spanishLocale));
            String monthYearToBeSelected=monthSpa+" "+year;
            System.out.println(monthYearToBeSelected);
            String monthYearDisplayed = driver.findElements(By.cssSelector("div.CalendarMonth_caption_1 Strong")).get(1).getText();
            System.out.println(monthYearDisplayed);
            Date monthInt = new SimpleDateFormat("MMMM", spanishLocale).parse(monthYearDisplayed.split(" ")[0].trim());//put your month name in english here
            Calendar cal = Calendar.getInstance();
            cal.setTime(monthInt);
            System.out.println((cal.get(Calendar.MONTH))+" "+Integer.parseInt(month));
            if (cal.get(Calendar.MONTH)+1 > Integer.parseInt(month)) {
                while (!monthYearToBeSelected.equals(monthYearDisplayed)) {
                    driver.findElement(By.xpath("//div[@aria-label='Move backward to switch to the previous month.']")).click();
                    monthYearDisplayed = driver.findElements(By.cssSelector("div.CalendarMonth_caption_1 Strong")).get(1).getText();
                    System.out.println("First Index:"+monthYearDisplayed);
                    System.out.println("Second Index:"+driver.findElements(By.cssSelector("div.CalendarMonth_caption_1 Strong")).get(2).getText());
                    threadWait(1000);
                }
                driver.findElement(By.xpath("//div[@aria-label='Move forward to switch to the next month.']")).click();
                threadWait(1000);
            } else if (cal.get(Calendar.MONTH)+1 < Integer.parseInt(month)) {
                while (!monthYearToBeSelected.equals(monthYearDisplayed)) {
                    driver.findElement(By.xpath("//div[@aria-label='Move forward to switch to the next month.']")).click();
                    monthYearDisplayed = driver.findElements(By.cssSelector("div.CalendarMonth_caption_1 Strong")).get(1).getText();
                    threadWait(1000);
                }
                driver.findElement(By.xpath("//div[@aria-label='Move backward to switch to the previous month.']")).click();
                threadWait(2000);
            }
            if(driver.findElements(By.xpath("//td[text()='" + day + "']")).size()>2 ){
                driver.findElements(By.xpath("//td[text()='" + day + "']")).get(1).click();
                if(doubleClick)
                    driver.findElements(By.xpath("//td[text()='" + day + "']")).get(1).click();
            }
            else {
                driver.findElements(By.xpath("//td[text()='" + day + "']")).get(0).click();
                if(doubleClick)
                    driver.findElements(By.xpath("//td[text()='" + day + "']")).get(0).click();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public boolean compareSpanishStrings(String actual,String expectedText)
    {
        Collator collator = Collator.getInstance(new Locale("es", "ES"));
        collator.setStrength(Collator.PRIMARY);
        if (collator.compare(actual, expectedText) != 0)
            return false;
        return true;
    }
    public String getSpanishDate(String date)
    {
        Date dateToSel= null;
        try {
            dateToSel = new SimpleDateFormat("d/MM/yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String day=new SimpleDateFormat("d").format(dateToSel);
        String month=new SimpleDateFormat("MM").format(dateToSel);
        String year=new SimpleDateFormat("yyyy").format(dateToSel);
        LocalDate localDate= LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        Locale spanishLocale=new Locale("es", "ES");
        String monthSpa=localDate.format(DateTimeFormatter.ofPattern("MMM",spanishLocale));
        return day+" "+monthSpa;
    }
}
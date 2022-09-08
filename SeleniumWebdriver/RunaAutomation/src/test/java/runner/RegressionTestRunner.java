package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/Features/Login.feature",
        plugin = {"pretty", "html:./results/report.html", "json:./results/cucumber.json","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        //tags = "@payrollCreation",
        glue = {"java", "Util","java", "testSteps"})

 public class RegressionTestRunner extends AbstractTestNGCucumberTests{        
}
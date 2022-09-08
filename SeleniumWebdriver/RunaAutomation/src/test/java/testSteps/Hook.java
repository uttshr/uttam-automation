package testSteps;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testrail.APIException;
import testrail.TestRailManager;

import java.io.IOException;
import java.util.Date;

public class Hook {
    TestContext context;
    public Hook(TestContext context)
    {
        this.context=context;
    }
//    @Before
//    public void before(Scenario scenario) {
//        context.createScenario(scenario.getName());
//        context.log("Starting scenario "+ scenario.getName());
//    }

    @After
    public void after(Scenario scenario) throws APIException, IOException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) context.getPageObjectManager().getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            Date d=new Date();
            String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
            scenario.attach(screenshot, "image/png", scenario.getName()+"_"+screenshotFile);
        }
        String name=scenario.getName().split("_")[0].substring(1);
        if(!scenario.isFailed())
            TestRailManager.addResultForTestCase(name,TestRailManager.TEST_CASE_PASSED_STATUS,scenario.getStatus().name());
        else
            TestRailManager.addResultForTestCase(name,TestRailManager.TEST_CASE_FAILED_STATUS,scenario.getStatus().name());
        context.endScenario();
    }

}

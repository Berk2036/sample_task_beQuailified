package beQualified.steps;

import beQualified.utilities.BrowserUtils;
import beQualified.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    //import the @Before coming from io.cucumber.java

    /**
     * import the @Before coming from io.cucumber.java will be executed before every scenario
     */
    @Before(order = 1)
    public void setupMethod(){
        Driver.getDriver().manage().window().maximize();
    }

    /**
     * @After will be executed automatically after EVERY scenario in the project.
     * @param scenario
     */
    @After
    public void teardownMethod(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }



}

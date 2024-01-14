package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import utilities.Driver;


public class Hooks {


    @After
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed())   {
            try {
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot name");
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
        }
        }
}



/*
    @After
    public void tearDown(Scenario scenario){
//        System.out.println("This is after method");
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshots");
    }}*/

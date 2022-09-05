package testRunner;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/alanliew/Desktop/Selenium Java Practise/Cucumber/Features/Login.feature",
        glue = "stepsDefinitions",
        dryRun = false,
        monochrome = true, //to make output clean
        plugin = {"pretty", "html:test-output"}

)
public class TestRun {


}

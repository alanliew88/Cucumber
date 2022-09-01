package testRunner;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Login.feature",
        glue = "stepsDefinitions",
        dryRun = false,
        monochrome = true, //to make output clean
        plugin = {"pretty", "html:test-output"} // to create clean and html report

)
public class TestRun {


}

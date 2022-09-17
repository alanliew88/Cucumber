package testRunner;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/alanliew/Desktop/Selenium Java Practise/Cucumber/Features/Customers.feature",
        glue = "stepsDefinitions",
        dryRun = false,
        monochrome = false, //to make output clean
        plugin = {"pretty", "html:target/cucumber-reports.html"}

)
public class TestRun {


}

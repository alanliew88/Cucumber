package stepsDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;

    public AddCustomerPage ap;

    public static String randomstring(){
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return(generatedString1);
    }

}

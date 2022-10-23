package stepsDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import org.apache.log4j.Logger;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage ap;
    public SearchCustomerPage sp;
    public static Logger logger;

    public static String randomstring(){
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return(generatedString1);
    }

}

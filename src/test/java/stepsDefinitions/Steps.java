package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class Steps {

    public WebDriver driver;
    public LoginPage lp;



    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);

        // Write code here that turns the phrase above into concrete actions


    }
    @When("User opens url {string}")
    public void user_opens_url(String url) {
        // Write code here that turns the phrase above into concrete actions

        driver.get(url);
        driver.manage().window().maximize();


    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        lp.setUserName(email);
        lp.setPassword(password);


    }
    @When("Click on Login")
    public void click_on_login() {
        // Write code here that turns the phrase above into concrete actions
        lp.clickLogin();

    }
    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        if (driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }
        else {
            Assert.assertEquals(title, driver.getTitle());
        }
        Thread.sleep(2000);



    }
    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        lp.clickLogout();
        Thread.sleep(3000);

    }
    @Then("Close browser")
    public void close_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();

    }


}

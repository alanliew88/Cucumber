package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import static org.junit.Assert.assertEquals;

public class Steps extends BaseClass {


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

    //add new customers feature steps definition...............

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {

        ap = new AddCustomerPage(driver);

        Assert.assertEquals("Dashboard / nopCommerce administration", ap.getPageTitle());

    }
    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        ap.clickOnCustomersMenu();

    }
    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {
        // Write code here that turns the phrase above into concrete actions
        ap.clickOnCustomerMenuItem();

    }
    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        ap.clickOnAddNewButton();
        Thread.sleep(3000);
    }
    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Add a new customer / nopCommerce administration",ap.getPageTitle());

    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String email = randomstring()+"@gmail.com";
        ap.setEmail(email);
        ap.setPassword("abc123");

        ap.setCustomerRoles("Guest");
        Thread.sleep(3000);



        ap.SetFirstName("Paven");
        ap.SetLastName("Kumar");
        ap.setGender("Male");
        ap.SetDob("7/10/1985"); //d/m/yyyy
        ap.SetCompanyName("busyQA");
        ap.setAdminContent("This is for testing...only");


    }
    @When("click on Save button")
    public void click_on_save_button() {
        // Write code here that turns the phrase above into concrete actions

        ap.clickOnSave();

    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String confirmationmessage) {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));



    }


    //customer searching customer using emailid



    @When("Enter customer Email")
    public void enter_customer_email() {
        sp = new SearchCustomerPage(driver);
        sp.setEmail("steve_gates@nopCommerce.com");


    }
    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        sp.clicksearch();
        Thread.sleep(3000);
    }
    @Then("User should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
        Boolean status = sp.checktable("steve_gates@nopCommerce.com");
        Assert.assertEquals(true, status);

    }



}

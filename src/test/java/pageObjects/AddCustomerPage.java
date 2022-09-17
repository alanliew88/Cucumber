package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver)
    {
     ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }


    By lnkCustomers_menu= By.xpath("//a[@class='nav-link']//p[contains(text(),'Customers')]");
    By lnkCustomers_menuitem=By.xpath("//li[@class='nav-item']//p[contains(text(), 'Customers')]");

    By btnAddnew= By.xpath("//a[@class='btn btn-primary']");

    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");

    By txtcustomerRoles= By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

    By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
    By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')");
    By lstitemGuests = By.xpath("//li[contains(text(),'Guests')");
    By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')");

    By drpmgrOfVendor = By.xpath("//select[@id='VendorId']");
    By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
    By rdFemaleGender = By.xpath("//input[@id='Gender_Female']");

    By txtFirstName = By.xpath("//input[@id='FirstName']");
    By txtLastName = By.xpath("//input[@id='LastName']");

    By txtDob = By.xpath("//input[@id='DateOfBirth']");

    By txtCompanyName = By.xpath("//input[@id='Company']");

    By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");

    By btnSave = By.xpath("//button[@name='save']");

    //Actions Methods

    public void clickOnCustomersMenu() throws InterruptedException {
        ldriver.findElement(lnkCustomers_menu).click();
        Thread.sleep(3000);
    }

    public void clickOnCustomerMenuItem(){
        ldriver.findElement(lnkCustomers_menuitem).click();
    }

    public void clickOnAddNewButton(){
        ldriver.findElement(btnAddnew).click();
    }

    public void setEmail(String email){
        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password){
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setCustomerRoles(String role) throws InterruptedException{

        /*f (!role.equals("Vendors"))
        {
            ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]//li//span[@class='k-select']")).click();
        }*/
        ldriver.findElement(txtcustomerRoles).click();
        WebElement listitem;

        Thread.sleep(3000);

        if(role.equals("Administrators"))
        {
            listitem=ldriver.findElement(lstitemAdministrators);
            listitem.click();

        } else if (role.equals("Guests"))
        {
            listitem=ldriver.findElement(lstitemGuests);
            listitem.click();

        } else if (role.equals("Registered"))
        {
            listitem=ldriver.findElement(lstitemRegistered);
            listitem.click();

        } else if (role.equals("Vendors"))
        {
            listitem=ldriver.findElement(lstitemVendors);
            listitem.click();

        }
        //listitem.click();

        //JavascriptExecutor js = (JavascriptExecutor) ldriver;
        //js.executeScript("arguments[0].click();",listitem);
    }

    public void setManagerVendor (String value)
    {
        Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender)
    {
        if (gender.equals("Male"))
        {
            ldriver.findElement(rdMaleGender).click();
        }
        else if(gender.equals("Female"))
        {
          ldriver.findElement(rdFemaleGender).click();
        }else
        {
            ldriver.findElement(rdMaleGender).click();
        }
    }

    public void SetFirstName (String fname){
        ldriver.findElement(txtFirstName).sendKeys(fname);
    }

    public void SetLastName (String lname){
        ldriver.findElement(txtLastName).sendKeys(lname);
    }

    public void SetCompanyName (String comname){
        ldriver.findElement(txtCompanyName).sendKeys(comname);
    }

    public void setAdminContent (String content){
        ldriver.findElement(txtAdminContent).sendKeys(content);
    }

    public void clickOnSave(){
        ldriver.findElement(btnSave).click();
    }

    public String getPageTitle(){
       return ldriver.getTitle();
    }

    public void SetDob (String dob)
    {
        ldriver.findElement(txtDob).sendKeys(dob);
    }




}

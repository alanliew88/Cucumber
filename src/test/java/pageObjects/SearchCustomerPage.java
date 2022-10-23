package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {

    public WebDriver ldriver;

    WaitHelper waithelper;

    public SearchCustomerPage (WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
        waithelper = new WaitHelper(ldriver);
    }


    @FindBy(id="SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(id="SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(id="SearchMonthOfBirth")
    @CacheLookup
    WebElement dropDownMonth;

    @FindBy(id="SearchDayOfBirth")
    @CacheLookup
    WebElement dropDownDay;

    @FindBy(id="SearchCompany")
    @CacheLookup
    WebElement txtCompany;

    @FindBy(xpath = "//div[@class ='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    WebElement txtCustomerRoles;


    @FindBy(id="search-customers")
    @CacheLookup
    WebElement searchButton;

    @FindBy(xpath = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;

    public void setEmail ( String email){
        waithelper.WaitForElement(txtEmail, 10);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstname(String fname){
        waithelper.WaitForElement(txtFirstName, 10);
        txtFirstName.clear();
        txtFirstName.sendKeys(fname);
    }
    public void setLastname(String lname){
        waithelper.WaitForElement(txtLastName, 10);
        txtLastName.clear();
        txtLastName.sendKeys(lname);
    }

    public void clicksearch(){
        waithelper.WaitForElement(txtLastName, 10);
        searchButton.click();
    }

    public int getNoOfRows(){
        return(tableRows.size());
    }

    public int getNoOfColumns(){
        return(tableColumns.size());
    }

    public boolean checktable (String email){

        boolean flag = false;

        for (int i=1; i<=getNoOfRows();i++){

            String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();

            System.out.println(emailid);

            if( emailid.equalsIgnoreCase("steve_gates@nopCommerce.com")){
                flag = true;
            }

        }
        return flag;
    }





































}

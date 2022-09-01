Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your Store. Login"
    And Close browser


package stepDefinitions;

import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import driverFactory.Factory1;


public class LoginStepDefinitions {

   WebDriver driver;
   private LoginPage loginPage;
   private AccountPage accountPage;
    
    @Given("User is on Login page")
    public void user_is_on_login_page() {
    	
    	driver = Factory1.getDriver();
    	HomePage homePage = new HomePage(driver);
    	homePage.clickOnMyAccount();
    	loginPage = homePage.clickOnLoginButton();
    }
    

    @When("^User enters valid email address (.+) field$")
    public void user_enters_valid_email_address_field(String userEmail) {
        loginPage.enterEmailAddress(userEmail);
    }

    @And("^User enters password (.+) field$")
    public void user_enters_password_field(String password) {
        loginPage.enterPassword(password);
    }

    @When("User enters username {string}")
    public void user_enters_username(String wrongEmail) {

    	loginPage.enterEmailAddress(CommonUtils.GetEmailWithTimeStamp());
    }

    @When("User enters password {string}")
    public void user_enters_password(String passwordText) {

    	loginPage.enterPassword(passwordText);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {

    	accountPage = loginPage.clickOnLoginButton();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
    	
    	Assert.assertTrue(accountPage.displatStatusOfEditAccountInfo());
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {

    	Assert.assertTrue(loginPage.getErrorMessage());
    }
    }
    










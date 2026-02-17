package stepDefinitions;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driverFactory.Factory1;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterAccountPage;
import utils.CommonUtils;

public class RegistrationStepDefinitions {

	WebDriver driver;
	private RegisterAccountPage registerAccountPage;
	private AccountSuccessPage accountSuccessPage;

	@Given("User is on Registration page")
	public void user_is_on_registration_page() {

		driver = Factory1.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerAccountPage = homepage.clickOnRegisterButton();

	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerAccountPage.enterFirstNameField(dataMap.get("FirstName"));
		registerAccountPage.enterLastNameField(dataMap.get("lastName"));
		registerAccountPage.enterEmailTextField(CommonUtils.GetEmailWithTimeStamp());
		registerAccountPage.enterTelephoneTextField(dataMap.get("Telephone"));
		registerAccountPage.enterPasswordTextField(dataMap.get("password"));
		registerAccountPage.enterConPasswordTextField(dataMap.get("password"));

	}

	@When("User selects Yes for news letter")
	public void user_selects_yes_for_news_letter() {

		registerAccountPage.clickonYesButtonField();
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {

		registerAccountPage.clickonPrivacyButton();
	}

	@When("User clicks on Coutinue button")
	public void user_clicks_on_coutinue_button() {

		accountSuccessPage = registerAccountPage.clickonContinueButton();
	}

	@Then("Registration should be successful")
	public void registration_should_be_successful() {

		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getSuccessPage());
	}

	@When("User enters the duplecate details into below fields")
	public void user_enters_the_duplecate_details_into_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerAccountPage.enterFirstNameField(dataMap.get("FirstName"));
		registerAccountPage.enterLastNameField(dataMap.get("lastName"));
		registerAccountPage.enterEmailTextField(dataMap.get("email"));
		registerAccountPage.enterTelephoneTextField(dataMap.get("Telephone"));
		registerAccountPage.enterPasswordTextField(dataMap.get("password"));
		registerAccountPage.enterConPasswordTextField(dataMap.get("password"));

	}

	@Then("User should get a proper duplicate worning message")
	public void user_should_get_duplicate_warning_message() {

		Assert.assertEquals("Warning: E-Mail Address is already registered!",
				registerAccountPage.enterDuplicateEmail());
	}
	
	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {

		registerAccountPage.enterFirstNameField("");
		registerAccountPage.enterLastNameField("");
		registerAccountPage.enterEmailTextField("");
		registerAccountPage.enterTelephoneTextField("");
		registerAccountPage.enterPasswordTextField("");
		registerAccountPage.enterConPasswordTextField("");

		
	}

	@Then("User should get a proper worning message for every mandatory field")
	public void user_should_get_warning_message_for_every_mandatory_field() {

		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", registerAccountPage.emptyFillField());
		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				registerAccountPage.emptyMandatoryFirestNameField());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
				registerAccountPage.emptyMandatoryLastNameField());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",
				registerAccountPage.emptyMandatoryEmailNameField());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registerAccountPage.emptyMandatoryTelephoneField());
		Assert.assertEquals("Password must be between 4 and 20 characters!",
				registerAccountPage.emptyMandatoryPasseordField());
	}

	
}
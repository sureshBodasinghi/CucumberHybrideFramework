package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

	WebDriver driver;

	public RegisterAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastnameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath="//label[text()='Yes']")
	private WebElement yesButtonField;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[text()='Warning: E-Mail Address is already registered!']")
	private WebElement duplecateAccount;
	
	@FindBy(xpath="//div[text()='Warning: You must agree to the Privacy Policy!']")
	private WebElement emptyFields;
	
	@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement fillMandatoryFirstName;
	
	@FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement fillMandatoryLastName;
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement fillMandatoryEmail;
	
	@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement fillMandatoryTelephone;
	
	@FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement fillMandatortPassword;

	public void enterFirstNameField(String firstNameText) {

		firstNameField.sendKeys(firstNameText);

	}

	public void enterLastNameField(String lastNameText) {

		lastnameField.sendKeys(lastNameText);

	}

	public void enterEmailTextField(String emailText) {

		emailField.sendKeys(emailText);

	}

	public void enterTelephoneTextField(String telephoneText) {

		telephoneField.sendKeys(telephoneText);

	}

	public void enterPasswordTextField(String passwordText) {

		passwordField.sendKeys(passwordText);

	}

	public void enterConPasswordTextField(String conPasswordText) {

		passwordConfirmField.sendKeys(conPasswordText);

	}
	
	public void clickonYesButtonField() {

		yesButtonField.click();

	}
	
	public void clickonPrivacyButton() {

		privacyPolicy.click();

	}
	
	public AccountSuccessPage clickonContinueButton() {

		continueButton.click();
		return new AccountSuccessPage(driver);

	}
	
	public String enterDuplicateEmail() {
		return duplecateAccount.getText();
	}
	
	
	public String emptyFillField() {
		return emptyFields.getText();
	}
	
	public String emptyMandatoryFirestNameField() {
		return fillMandatoryFirstName.getText();
	}
	
	public String emptyMandatoryLastNameField() {
		return fillMandatoryLastName.getText();
	}
	
	public String emptyMandatoryEmailNameField() {
		return fillMandatoryEmail.getText();
	}
	
	public String emptyMandatoryTelephoneField() {
		return fillMandatoryTelephone.getText();
	}
	
	public String emptyMandatoryPasseordField() {
		return fillMandatortPassword.getText();
	}
	

}

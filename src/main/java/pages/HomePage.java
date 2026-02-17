package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerButton;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchItemName;

	@FindBy(xpath = "//span[@class='input-group-btn']")
	private WebElement SearchButton;

	public void clickOnMyAccount() {

		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public LoginPage clickOnLoginButton() {

		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}

	public RegisterAccountPage clickOnRegisterButton() {

		elementUtils.clickOnElement(registerButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterAccountPage(driver);
	}

	public void sendsearchItemName(String keywords) {

		elementUtils.typeTextIntoElement(searchItemName, keywords, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public SearchResultsPage clicksearchButton() {

		elementUtils.clickOnElement(SearchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultsPage(driver);
	}

}

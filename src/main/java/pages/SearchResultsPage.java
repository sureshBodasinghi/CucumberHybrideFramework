package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;

	public SearchResultsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='HP LP3065']")
	private WebElement SuccessMsg;
	
	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement noProductMatchMsg;

	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement NoResultsMsg;
	
	public String getSuccessmsg() {
		return SuccessMsg.getText();
	}
	
	public String getNoProductMatchMsg() {
		return noProductMatchMsg.getText();
	}

	public String getNoresultMatchMsg() {
		return NoResultsMsg.getText();
	}
	
	
	
	
	
	
	
	

}

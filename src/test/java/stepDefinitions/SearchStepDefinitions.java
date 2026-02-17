package stepDefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import driverFactory.Factory1;

public class SearchStepDefinitions {

	WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage serchResult;
	
	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {

		driver = Factory1.getDriver();

	}

	@When("User enters search keyword {string}")
	public void user_enters_search_keyword(String keyword) {

		homePage = new HomePage(driver);
		homePage.sendsearchItemName(keyword);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {

		serchResult = homePage.clicksearchButton();
	}

	@Then("Results should contain related items")
	public void results_should_contain_related_items() {

		Assert.assertEquals("HP LP3065", serchResult.getSuccessmsg());
	}

	@Then("No results message should be displayed")
	public void no_results_message_should_be_displayed() {
		
		Assert.assertEquals("There is no product that matches the search criteria.", serchResult.getNoProductMatchMsg());
	}
	
	@When("User dont enter any product name into the search box field")
	public void User_dont_enter_any_product_name_into_the_search_box_field() {
		
		homePage = new HomePage(driver);
	}

	@Then("Validation message should be displayed")
	public void validation_message_should_be_displayed_as() {

		Assert.assertEquals("There is no product that matches the search criteria.", serchResult.getNoresultMatchMsg());
	}
}

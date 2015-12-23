package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helperClasses.HelperClass;
import pageObjects.PageObjects;
import utilities.StartupTearDown;
import utilities.Utilities;

public class StepDefs {
	
	private HelperClass helperClass;
	private WebDriver _driver;
	private Utilities utilities;
	
	//Variables shared between step defs
	private String webpageTitle;
	
	
	public StepDefs() throws Exception {
		
		_driver = new StartupTearDown().setUp();
		helperClass = new HelperClass(_driver);	
		utilities = new Utilities(_driver);	
	}	
	
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {
		
		helperClass.goToHomePage();
		webpageTitle = new PageObjects(_driver).getPageTitle();
	}
	
	@When("^I search for pillows$")
	public void i_search_for_pillows() throws Throwable {
		helperClass.searchForPillows();
	}
	
	@Then("^the page title is as expected$")
	public void the_page_title_is_as_expected() throws Throwable {
		utilities.waitForWebPageTitleToChangeFromOriginal(webpageTitle);
		helperClass.checkPageTitle();
	}	
}

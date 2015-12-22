package stepDefinitions;

import cucumber.api.java.en.*;
import helperClasses.SeleniumTest;
import training.WebdriverMavenProject.StartupTearDown;
import org.openqa.selenium.WebDriver;

public class StepDefs {
	
	private SeleniumTest script;
	private WebDriver _driver;
	
	public StepDefs() throws Exception {
		
		_driver = StartupTearDown.setUp();
		script = new SeleniumTest(_driver);
		
	}
	
	
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {
		
		script.goToHomePage();
	}
	
	@When("^I search for pillows$")
	public void i_search_for_pillows() throws Throwable {
		script.searchForPillows();
	}
	
	@Then("^the page title is as expected$")
	public void the_page_title_is_as_expected() throws Throwable {
		script.checkPageTitle();
	}
	
	
}

package training.WebdriverMavenProject;

import cucumber.api.java.en.*;
import cucumber.api.java.After;

public class StepDefs {
	
	private SeleniumTest script;

	public void setUpWebDriver() throws Exception {

	   script = new SeleniumTest();

	   script.setUp();

	   script.goToHomePage();
	}

	public void tidyUp() {

	script.tearDown();

	}
	
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {
		setUpWebDriver();
	}
	
	@When("^I search for pillows$")
	public void i_search_for_pillows() throws Throwable {
		script.searchForPillows();
	}
	
	@Then("^the page title is as expected$")
	public void the_page_title_is_as_expected() throws Throwable {
		script.checkPageTitle();
	}
	
	@After

	public void tearDown() throws Exception {

	   script.tearDown();

	}	
}

package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helperClasses.HelperClass;
import pageObjects.BasicAuthPage;
import pageObjects.CheckboxPage;
import pageObjects.GooglePage;
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
		utilities = new Utilities(_driver);
		helperClass = new HelperClass(_driver);

	}	
	
	@Given("^I am on the google homepage$")
	public void i_am_on_the_google_homepage() throws Throwable {

		helperClass.goToGoogleHomePage();
		webpageTitle = new GooglePage(_driver).getPageTitle();
	}

	@When("^I search for webdriver$")
	public void i_search_for_webdriver() throws Throwable {
		helperClass.searchFor("webdriver");
	}
	
	@Then("^the page title is as expected$")
	public void the_page_title_is_as_expected() throws Throwable {
		utilities.waitForWebPageTitleToChangeFromOriginal(webpageTitle);
		helperClass.checkPageTitle();
	}

	@Given("^I successfully reach a page behind basic HTTP authentication$")
	public void i_successfully_reach_a_page_behind_basic_HTTP_authentication() throws Throwable {
		helperClass.goToBasicAuthUrlAndLogIn();
	}

	@Then("^I see the page content as expected$")
	public void i_see_the_page_content_as_expected() throws Throwable {
        BasicAuthPage basicAuthPage = new BasicAuthPage(_driver);
        Assert.assertTrue(basicAuthPage.getAuthenticationSuccessMessage().toUpperCase().contains("CONGRATULATIONS!"));
	}

    @Given("^I attempt to access a page behind HTTP authentication$")
    public void i_attempt_to_access_a_page_behind_HTTP_authentication() throws Throwable {
        helperClass.goToBasicAuthUrl();
    }

    @When("^I cancel the authentication dialog$")
    public void i_cancel_the_authentication_dialog() throws Throwable {
        BasicAuthPage basicAuthPage = new BasicAuthPage(_driver);
        basicAuthPage.cancelAuthPopup();
    }

    @Then("^I see the appropriate not authorised message$")
    public void i_see_the_appropriate_not_authorised_message() throws Throwable {
        Utilities.waitforTextToAppear("Not authorized");
    }

	@Given("^I am on the checkbox test page$")
	public void i_am_on_the_checkbox_test_page() throws Throwable {
		helperClass.goToCheckboxesPage();
		Utilities.waitforTextToAppear("Checkboxes");
	}

	@When("^I click on both checkboxes$")
	public void i_click_on_both_checkboxes() throws Throwable {
		CheckboxPage checkboxPage = new CheckboxPage(_driver);
		checkboxPage.setCheckbox1();
		checkboxPage.clearCheckbox2();
	}

	@Then("^I see the appropriate checkboxes are checked and unchecked$")
	public void i_see_the_appropriate_checkboxes_are_checked_and_unchecked() throws Throwable {
		helperClass.checkCheckboxStates();
	}

	//Deliberately incomplete step def, ignore.
    @Then("^this step def is incomplete$")
	public void this_step_def_is_incomplete() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new Exception("This step def is incomplete");
	}
}

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
import pageObjects.LoginPage;
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

	@Given("^I am on the dropdown list page$")
	public void i_am_on_the_dropdown_list_page() throws Throwable {
		helperClass.goToDropdownListPage();
	}

	@Then("^I see that all the expected dropdown options are present$")
	public void i_see_all_the_expected_options_are_present() throws Throwable {
		helperClass.checkForExpectedDropDownOptions();
	}

	@Then("^I can check a specific drop down list option is present$")
	public void i_can_check_a_specific_drop_down_list_option_is_present() throws Throwable {
		helperClass.checkForSpecificDropdownOption();
	}

	@When("^I select a specific drop down list option$")
	public void i_select_a_specific_drop_down_list_option() throws Throwable {
		throw new Exception("Not yet implemented");
	}

	@Then("^the required option is selected$")
	public void the_required_option_is_selected() throws Throwable {
		throw new Exception("Not yet implemented");
	}

	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() throws Throwable {
		helperClass.goToLogInPage();
	}

	@When("^I log into the application with the correct credentials$")
	public void i_log_into_the_application_with_the_correct_credentials() throws Throwable {
		LoginPage loginPage = new LoginPage(_driver);
		loginPage.enterUsername("tomsmith");
		loginPage.enterPassword("SuperSecretPassword!");
		loginPage.clickLoginButton();
	}

	@Then("^the welcome screen is shown$")
	public void the_welcome_screen_is_shown() throws Throwable {
		LoginPage loginPage = new LoginPage(_driver);
		Assert.assertTrue(loginPage.getLoginSuccessMessage().toUpperCase().contains("YOU LOGGED INTO A SECURE AREA"));
	}

	/////////////////////////////////////////////////////////
	//Deliberately incomplete step def, ignore.
	/////////////////////////////////////////////////////////
    @Then("^this step def is incomplete$")
	public void this_step_def_is_incomplete() throws Throwable {
		throw new Exception("Not yet implemented");
	}
}

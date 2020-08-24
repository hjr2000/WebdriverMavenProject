package helperClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import pageObjects.CheckboxPage;
import pageObjects.DropdownListPage;
import pageObjects.GooglePage;

import java.util.ArrayList;
import java.util.List;

public class HelperClass {
	
	private String sanityTestUrl = "http://www.google.com/";
	private String baseUrl = "the-internet.herokuapp.com/";
    private String standardUrlPrefix = "http://";
	private WebDriver _driver;
	private GooglePage googlePage;
	
	public HelperClass(WebDriver driver)
	{
		_driver = driver;
		googlePage = new GooglePage(_driver);
	}

	public void goToGoogleHomePage(){

		_driver.get(sanityTestUrl);
	}

    public void goToBasicAuthUrlAndLogIn(){

        _driver.get("http://admin:admin@" + baseUrl + "basic_auth");
    }
	
	public void checkPageTitle(){

		assertEquals("webdriver - Google Search", googlePage.getPageTitle());
	}

	public void searchFor(String searchTerm) {
		
		googlePage.populateSearchTextbox(searchTerm);
		googlePage.clickSearchButton();
	}

    public void goToBasicAuthUrl() {
        _driver.get("http://" + baseUrl + "basic_auth");
    }

	public void goToCheckboxesPage() {
		_driver.get("http://" + baseUrl + "checkboxes");
	}

	public void checkCheckboxStates() throws Exception {

		CheckboxPage checkboxPage = new CheckboxPage(_driver);
		if (!checkboxPage.getCheckbox1State())
			throw new Exception("Checkbox1 should be checked but is not checked");
		if (checkboxPage.getCheckbox2State())
			throw new Exception("Checkbox2 should be unchecked but it is checked");
	}

	public void goToDropdownListPage()  {
		_driver.get("http://" + baseUrl + "dropdown");
	}

	public void checkForExpectedDropDownOptions() throws Exception {

		DropdownListPage dropDownListPage = new DropdownListPage(_driver);

		List<String> expectedOptions = new ArrayList<String>();

		expectedOptions.add("Please select an option");
		expectedOptions.add("Option 1");
		expectedOptions.add("Option 2");

		dropDownListPage.checkActualDropdownOptionsAgainstExpected_DropdownListPage(expectedOptions);
	}

	public void checkForSpecificDropdownOption() throws Exception {

		DropdownListPage dropDownListPage = new DropdownListPage(_driver);
		dropDownListPage.checkSpecificDropdownListOptionExists_DropdownListPage("Option 1");

	}

	public void goToLogInPage()  {
		_driver.get("http://" + baseUrl + "login");
	}

	public void goToDragAndDropPage() {_driver.get("http://" + baseUrl + "drag_and_drop");	}

	public void goToTablesPage()   {
		_driver.get("http://" + baseUrl + "tables");
	}

	public void goToDynamicLoadingPage1()    {
		_driver.get("http://" + baseUrl + "dynamic_loading/1");
	}

	public void goToHoversTestPage()     {
		_driver.get("http://" + baseUrl + "hovers");
	}
}

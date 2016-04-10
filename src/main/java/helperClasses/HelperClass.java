package helperClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import pageObjects.GooglePage;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;

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
}

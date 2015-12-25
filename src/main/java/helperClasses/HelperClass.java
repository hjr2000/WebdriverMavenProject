package helperClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjects;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;

public class HelperClass {
	
	private String baseUrl = "http://www.google.com/";
	private WebDriver _driver;
	private PageObjects pageObjects;
	
	public HelperClass(WebDriver driver)
	{
		_driver = driver;
		pageObjects = new PageObjects(_driver);
	}

	public void goToHomePage(){

		_driver.get(baseUrl);

	}
	
	public void checkPageTitle(){

		assertEquals("webdriver - Google Search", pageObjects.getPageTitle());
	}

	public void searchFor(String searchTerm) {
		
		pageObjects.populateSearchTextbox(searchTerm);
		pageObjects.clickSearchButton();
		
	}	
}

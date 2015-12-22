package helperClasses;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
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
	public void searchForPillows() throws InterruptedException{

		String searchTerm = "webdriver";
		pageObjects.populateSearchTextbox(searchTerm);
		pageObjects.clickSearchButton();		
	}

	public void checkPageTitle(){

		assertEquals("webdriver - Google Search", pageObjects.getPageTitle());
	}	
}

package helperClasses;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObjects.PageObjects;

import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;

public class SeleniumTest {
	
	private String baseUrl = "http://www.dunelm.com/";
	private WebDriver _driver;
	
	public SeleniumTest(WebDriver driver)
	{
		_driver = driver;
	}

	public void goToHomePage(){

		_driver.get(baseUrl);

	}
	public void searchForPillows() throws InterruptedException{

		PageObjects pageObjects = new PageObjects(_driver);
		String searchTerm = "pillows";
		pageObjects.populateSearchTextbox(searchTerm);
		pageObjects.clickSearchButton();		
	}

	public void checkPageTitle(){

		assertEquals("Pillows | Feather Pillow & Memory Foam Pillows | Dunelm", _driver.getTitle());

	}
}

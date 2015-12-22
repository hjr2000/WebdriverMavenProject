package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjects;

public class Utilities {
	
	private WebDriver _driver;
	private PageObjects pageObjects;
	
	public Utilities(WebDriver driver)
	{
		_driver = driver;
		pageObjects = new PageObjects(_driver);
	}
	
	public void waitForWebPageTitleToChangeFromOriginal(String webpageTitle) throws Exception {
		
		boolean pageChanged = false;
		for (int i = 1; i < 20; i++) {
			
			String currentWebPageTitle = pageObjects.getPageTitle();
			if (!currentWebPageTitle.equals(webpageTitle))
			{
				pageChanged = true;
				break;
			}
			Thread.sleep(250);
		}
		if (!pageChanged)
			throw new Exception ("The title of the web page is not changing");
		
	}	

}

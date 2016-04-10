package utilities;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.GooglePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Utilities {
	
	private static WebDriver driver;
    private static Wait<WebDriver> wait;
    private static final long DEFAULT_WAIT_TIMEOUT_SECS = 10;
    private static final long WAIT_FOR_PAGE_LOADED_DELAY = 3000;
    private static final long DEFAULT_SLEEP_TIMEOUT_MILLIS = 250;

	private GooglePage googlePage;
	
	public Utilities(WebDriver _driver)
	{
		driver = _driver;
        wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT_SECS, DEFAULT_SLEEP_TIMEOUT_MILLIS);
	}
	
	public void waitForWebPageTitleToChangeFromOriginal(String webpageTitle) throws Exception {

        googlePage = new GooglePage(driver);

        boolean pageChanged = false;
		for (int i = 1; i < 20; i++) {
			
			String currentWebPageTitle = googlePage.getPageTitle();
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

    public  void WaitForElementToBeClickableSafe(WebElement element) throws Exception {
        WaitForElementToBeClickableSafe(element, 10);
    }

    public static void WaitForElementToBeClickableSafe(WebElement element, int waitTimeInSeconds) throws Exception
    {
        int count = 0;
        boolean continueOn = false;
        while (!continueOn)
        {
            try
            {
                //log.info(("*** About to perform wait. Count =  " + count));
                waitForWebElementToBeClickable(element, waitTimeInSeconds);

                //log.info(("*** Wait successful. Count =  " + count));
                continueOn = true;
            }
            catch (org.openqa.selenium.StaleElementReferenceException e)
            {
                System.out.println("*********** StaleElementReferenceException caught, will try again.");
                count++;
                if (count == 16)
                    throw new Exception("StaleElementReferenceException not going away when waiting for element to become clickable.");
                // Do not remove
                Thread.sleep(250);
            }
        }
    }

    public static void waitForElementVisible(WebElement webElement) {
        wait.until(visibilityOf(webElement));
    }

    private static void waitForWebElementToBeClickable(WebElement webElement, int waitTimeInSeconds){
        Wait<WebDriver> wait_local;
        int sleepTimeOutMillis = 250;
        wait_local = new WebDriverWait(driver, waitTimeInSeconds, sleepTimeOutMillis);
        wait_local.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}

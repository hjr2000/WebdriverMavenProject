package training.WebdriverMavenProject;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.safari.SafariDriver;

public class SeleniumTest {
	
	private WebDriver driver;

	private String baseUrl;

	private String browserName;

	private String browserVersion;

	public void setUp() throws Exception {

	//driver = new HtmlUnitDriver();

	driver = new FirefoxDriver();

	//driver = new ChromeDriver();

	//driver = new  InternetExplorerDriver ();

	//driver = new  SafariDriver();

	baseUrl = "http://www.dunelm-mill.com/";

	//note due to issue in wordpress the URL does not display properly above. The URL should end with a forward slash, then quote marks, then a semi colon.

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	driver.manage().window().maximize();

	Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

	browserName = caps.getBrowserName();

	browserVersion = caps.getVersion();

	System.out.println("Automated test run. We're running on "+browserName+" "+browserVersion);

	 }

	 public void tearDown() {

	 driver.quit();

	 }

	public void goToHomePage(){

	 driver.get(baseUrl);

	 }
	public void searchForPillows(){

		driver.findElement(By.id("searchbox")).clear();

		driver.findElement(By.id("searchbox")).sendKeys("pillows");

		driver.findElement(By.cssSelector("button.buttonSearch.color1")).click();

		}
	
	public void checkPageTitle(){

		assertEquals("Pillows & V Shaped Pillows | Feather Pillows & More | Dunelm", driver.getTitle());

		}
}

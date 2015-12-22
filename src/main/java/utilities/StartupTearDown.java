package training.WebdriverMavenProject;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class StartupTearDown {
	
	private static WebDriver driver;
	private static String browserName;
	private static String browserVersion;
	private static String baseUrl;
	
	public static WebDriver setUp() throws Exception {

		//driver = new FirefoxDriver();

		driver = new ChromeDriver();

		//driver = new  InternetExplorerDriver ();

		//driver = new  SafariDriver();

		baseUrl = "http://www.dunelm-mill.com/";

		//note due to issue in wordpress, on the blog the URL does not display properly above. The URL should end with a forward slash, then quote marks, then a semi colon.

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

		browserName = caps.getBrowserName();

		browserVersion = caps.getVersion();

		System.out.println("Automated test run. We're running on " + browserName + " " + browserVersion);

		return driver;
	}	
	
	@After
	public void tearDown() throws Exception {

		System.out.println("teardown");
		driver.quit();

	}	

}

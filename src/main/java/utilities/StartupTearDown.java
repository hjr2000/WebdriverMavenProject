package utilities;

import io.cucumber.java.After;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class StartupTearDown {
	
	private WebDriver driver;
	private String browserName;
	private String browserVersion;	
	
	public WebDriver setUp() throws Exception {

		//driver = new FirefoxDriver();

		driver = new ChromeDriver();

		//driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), DesiredCapabilities.chrome());

		//driver = new  InternetExplorerDriver ();

		//driver = new  SafariDriver();
		
		//note due to issue in wordpress, on the blog the URL does not display properly above. The URL should end with a forward slash, then quote marks, then a semi colon.

		//driver.manage().window().maximize();

		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

		browserName = caps.getBrowserName();

		browserVersion = caps.getVersion();

		System.out.println("Automated test run. We're running on " + browserName + " " + browserVersion);

		return driver;
	}	
	

}

package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	
	@FindBy(id = "lst-ib")
	private WebElement searchTextbox;
	
	@FindBy(className = "lsb")
	private WebElement searchButton;
	
	private WebDriver _driver;
	
	public GooglePage(WebDriver driver) {
		
		_driver = driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void populateSearchTextbox(String searchTerm) {
		
		searchTextbox.clear();
		searchTextbox.sendKeys(searchTerm);
	}
	
	public void clickSearchButton() {
		
		 WebDriverWait wait = new WebDriverWait(_driver, 10);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lsb")));
	        
		searchButton.click();		
	}
	
	public String getPageTitle() {
		
		return _driver.getTitle();
	}
}

package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	
	@FindBy(id = "search")
	private WebElement searchTextbox;
	
	@FindBy(id = "search_submit")
	private WebElement searchButton;
	
	public PageObjects(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void populateSearchTextbox(String searchTerm) {
		
		searchTextbox.clear();
		searchTextbox.sendKeys(searchTerm);
	}
	
	public void clickSearchButton() {
		
		searchButton.click();
		
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

/**
 * Created by Admin on 10/04/2016.
 */
public class BasicAuthPage {

    private WebDriver _driver;

    public BasicAuthPage(WebDriver driver) {

        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(className = "example")
    private WebElement basicAuthSuccessText;

    public String getAuthenticationSuccessMessage() throws Exception {
        Utilities.waitForElementVisible(basicAuthSuccessText);
        return basicAuthSuccessText.getText();
    }

}

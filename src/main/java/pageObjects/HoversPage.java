package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

public class HoversPage {

    private WebDriver _driver;

    public HoversPage(WebDriver driver) {

        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(css = ".figure")
    private WebElement image1;

    @FindBy(css = ".figcaption")
    private WebElement image1Caption;

    public boolean isImage1TextVisible() throws Exception {

        Utilities.waitForElementToBeClickableSafe(image1);
        return image1Caption.isDisplayed();
    }

    public void hoverOverImage1() {

        new Actions(_driver).moveToElement(image1).build()
                .perform();
    }
}

package pageObjects;

import com.google.common.io.Files;
import org.apache.commons.codec.Charsets;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utilities;

import java.io.File;

/**
 * Created by Admin on 22/05/2016.
 */
public class DynamicLoadingPage1 {

    private WebDriver _driver;

    public DynamicLoadingPage1(WebDriver driver) {

        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(css = "#finish")
    private WebElement finishMessage;


    public void clickStartButton() throws Exception {

        Utilities.waitForElementToBeClickableSafe(startButton);
        startButton.click();
    }

    public void waitForFinishMessageToAppearWithSpecifiedTimeframe(int timeToWaitInSeconds) throws Exception {

        boolean emptyStyleAttributeFound = false;
        for (int count = 0; count < timeToWaitInSeconds * 4; count++){
            String styleAttributeValue = finishMessage.getAttribute("style");
            //System.out.println(styleAttributeValue);
            if (styleAttributeValue.equals("")){
                emptyStyleAttributeFound = true;
                break;
            }
            Thread.sleep(250);
        }
        if (!emptyStyleAttributeFound)
            throw new Exception("Finish message 'Hello World!' is not being displayed");
    }

    public void waitForFinishMessageToAppearUsingExplicitWait(int timeToWaitInSeconds) {

        WebDriverWait wait = new WebDriverWait(_driver, timeToWaitInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
    }
}

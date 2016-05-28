package pageObjects;

import com.google.common.io.Files;
import org.apache.commons.codec.Charsets;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

import java.io.File;

/**
 * Created by Admin on 22/05/2016.
 */
public class DragAndDropPage {

    private WebDriver _driver;

    public DragAndDropPage(WebDriver driver) {

        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public void dragFromColumnAtoColumnB() throws Exception {

        // Note that at the time of writing, we cannot use a Webdriver action builder to drag and drop due to a known issue with Webdriver and HTML5.
        // To undertake more elaborate drag and drop actions see https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/6315

        Utilities.waitForElementToBeClickableSafe(columnA);

        String fileContents = Files.toString(new File( System.getProperty("user.dir") + "\\src\\main\\javascript\\drag_and_drop_helper.js"), Charsets.UTF_8);
        JavascriptExecutor jse = (JavascriptExecutor) _driver;
        jse.executeScript(fileContents + "$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});");
    }

    public String getColumnAText() {

        return columnA.getText();
    }

    public String getColumnBText() {

        return columnB.getText();
    }


}

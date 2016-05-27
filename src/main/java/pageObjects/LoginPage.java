package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Admin on 10/04/2016.
 */
public class LoginPage {

    private WebDriver _driver;

    public LoginPage(WebDriver driver) {

        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(css = ".radius")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement loginMessage;

    public void enterUsername(String username) throws Exception {

        Utilities.enterTextIntoTextbox(usernameTextBox, username);
    }

    public void enterPassword(String password) throws Exception {

        Utilities.enterTextIntoTextbox(passwordTextBox, password);
    }

    public void clickLoginButton() throws Exception {

        Utilities.waitForElementToBeClickableSafe(loginButton);
        Utilities.elementClickSafe(loginButton);
    }

    public String getLoginSuccessMessage() throws Exception {
        Utilities.waitForElementToBeClickableSafe(loginMessage);
        return loginMessage.getText();

    }
}

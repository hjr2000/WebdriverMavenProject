package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 22/05/2016.
 */
public class TablesPage {

    private WebDriver _driver;

    public TablesPage(WebDriver driver) {

        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(css = "#table2 .email")
    private List<WebElement> emailAddresses;

    @FindBy(css = "#table2 .dues")
    private List<WebElement> dues;

    public String returnDueAmountTableExampleTwo(String emailAddressSought) throws Exception {
        // Find the row index for the row containing the target email address

        int index = 0;
        boolean emailAddressFound = false;
        for (WebElement emailElement : emailAddresses) {
            if (emailElement.getText().toUpperCase().equals(emailAddressSought.toUpperCase())){
                emailAddressFound = true;
                break;
            }
            index++;
        }

        if (!emailAddressFound)
            throw new Exception("The email address '" + emailAddressSought + "' was not found in the table Example 2");

        // Find the associated due amount

        String duesText = "";
        int duesIndex = 0;
        for (WebElement duesElement : dues) {
            duesText = duesElement.getText();
            if (duesIndex == index)
                break;
            duesIndex++;
        }

        System.out.println("Due amount : " + duesText);

        return duesText;
    }
}

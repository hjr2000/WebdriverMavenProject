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

    public String returnDueAmountTableExampleTwo(String emailAddressSought)
    {
        // Find the row index for the row containing the target email address

        List<String> emailAddressList = new ArrayList<String>();
        int index = 0;
        for (WebElement emailElement : emailAddresses) {
            if (emailElement.getText().toUpperCase().equals(emailAddressSought.toUpperCase())){
                break;
            }
            index++;
        }

        // Find the associated due amount

        List<String> duesList = new ArrayList<String>();
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

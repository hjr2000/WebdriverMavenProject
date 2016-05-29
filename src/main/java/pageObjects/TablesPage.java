package pageObjects;

import org.openqa.selenium.By;
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

    @FindBy(css = "#table1 tbody tr")
    private List<WebElement> table1rows;

    public void checkDueAmountForSpecificCustomer_TableExampleTwo(String emailAddressSought, String dueValueExpected) throws Exception {

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

        String dueValueInTargetRow = "";
        int duesIndex = 0;
        for (WebElement duesElement : dues) {
            dueValueInTargetRow = duesElement.getText();
            if (duesIndex == index)
                break;
            duesIndex++;
        }

        if (!dueValueExpected.equals(dueValueInTargetRow))
            throw new Exception("In table Example 2, for the customer with email address '" + emailAddressSought + "', the due value expected was " + dueValueExpected + " but the value " + dueValueInTargetRow + " was found.");

    }

    public void checkDueAmountForSpecificCustomer_TableExampleOne(String emailAddressSought, String dueValueExpected) throws Exception {

        // Find out how many rows there are in the table.
        int tableRows = table1rows.size();
        System.out.println("Rows in table 'Example 1' : " + tableRows);

        // Find the target email address, if it's there
        boolean emailAddressFound = false;
        int targetRowIndex = 0;
        for (int rowCount = 1; rowCount < tableRows + 1; rowCount++){
            if(_driver.findElement(By.cssSelector("#table1 tr:nth-of-type(" + rowCount + ") td:nth-of-type(3)")).getText().toUpperCase().equals(emailAddressSought.toUpperCase())){
                emailAddressFound = true;
                targetRowIndex = rowCount;
                System.out.println("Target email address '" + emailAddressSought + "' found in row " + targetRowIndex);
                break;
            }
        }

        if (!emailAddressFound)
            if (!emailAddressFound)
                throw new Exception("The email address '" + emailAddressSought + "' was not found in the table 'Example 1'");

        String dueValueInTargetRow = _driver.findElement(By.cssSelector("#table1 tr:nth-of-type(" + targetRowIndex + ") td:nth-of-type(4)")).getText();
        System.out.println("Due value in target row is " + dueValueInTargetRow);

        if (!dueValueExpected.equals(dueValueInTargetRow))
            throw new Exception("In table Example 1, for the customer with email address '" + emailAddressSought + "', the due value expected was " + dueValueExpected + " but the value " + dueValueInTargetRow + " was found.");

    }
}

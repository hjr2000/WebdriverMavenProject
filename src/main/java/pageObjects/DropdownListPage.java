package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class DropdownListPage {

    private WebDriver _driver;

    public DropdownListPage(WebDriver driver) {

        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(id = "dropdown")
    private WebElement dropdownListElement;


    public void checkActualDropdownOptionsAgainstExpected_DropdownListPage(List<String> expectedOptions) throws Exception {

        Utilities.checkActualDropdownOptionsAgainstExpected(dropdownListElement, expectedOptions);
    }

    public void checkSpecificDropdownListOptionExists_DropdownListPage(String expectedOption) throws Exception {

        Utilities.checkSpecificDropdownOptionAgainstActualOptions(dropdownListElement, expectedOption);
    }
}

package com.uk.gov.pages;

import com.uk.gov.utility.Utility;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class NationalityPage extends Utility {
    private static final Logger log = LogManager.getLogger(NationalityPage.class.getName());


    @CacheLookup
    @FindBy(id = "response")
    WebElement nationalityDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;


    public void selectNationality(String nationality) {
        selectByVisibleTextFromDropDown(nationalityDropDown, nationality);
        log.info("Click on '" + nationalityDropDown + "' tab");
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
        log.info("Click on '" + continueButton + "' tab");
    }

    public void isCountryListAvailableInDropdown(DataTable dataTable) {

        Select dropdown = new Select(nationalityDropDown);

        // Extract the list of expected country values from the feature file
        List<String> expectedCountries = dataTable.asList();

        // Retrieve all options from the dropdown
        List<WebElement> actualOptions = dropdown.getOptions();

        // Verify each expected country exists in the dropdown
        for (String country : expectedCountries) {
            boolean isCountryPresent = actualOptions.stream()
                    .anyMatch(option -> option.getText().equalsIgnoreCase(country));
            if (!isCountryPresent)
                System.out.println("Country '" + country + "' not found in the dropdown!");

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(isCountryPresent, "Country '" + country + "' not found in the dropdown!");
            softAssert.assertAll();

        }
    }

}

package com.uk.gov.pages;

import com.uk.gov.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ReasonForTravelPage extends Utility {
    private static final Logger log = LogManager.getLogger(ReasonForTravelPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    public void clickOnYourReasonRadioButton(String reason) {
        String path = "//label[contains(text(), '" + reason + "')]/preceding-sibling::input[@type='radio']";
        By element = By.xpath(path);
        clickOnElement(element);
        log.info("Click on '" + reason + "' button");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Click on '" + continueButton + "' button");
    }


}

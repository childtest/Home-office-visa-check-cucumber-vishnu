package com.uk.gov.pages;

import com.uk.gov.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class DurationOfStayPage extends Utility {
    private static final Logger log = LogManager.getLogger(DurationOfStayPage.class.getName());

    public void selectLengthOfStay(String durationOfStay){
        String path = "//label[contains(text(), '" + durationOfStay + "')]/preceding-sibling::input[@type='radio']";
        By element = By.xpath(path);
        clickOnElement(element);
        log.info("Click on '" + durationOfStay + "' button");
    }

}

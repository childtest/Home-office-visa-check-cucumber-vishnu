package com.uk.gov.pages;

import com.uk.gov.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class WorkTypePage extends Utility {
    private static final Logger log = LogManager.getLogger(WorkTypePage.class.getName());

    public void selectWorkType(String wType) {
        String path = "//label[contains(text(), '" + wType + "')]/preceding-sibling::input[@type='radio']";
        By element = By.xpath(path);
        clickOnElement(element);
        log.info("Click on '" + wType + "' button");
    }

}

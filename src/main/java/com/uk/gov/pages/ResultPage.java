package com.uk.gov.pages;

import com.uk.gov.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ResultPage extends Utility {
    private static final Logger log = LogManager.getLogger(ResultPage.class.getName());

    public String getResultMessage(String msg) {
        log.info("Check text is Displayed");
        By by = By.xpath("//h2[normalize-space()='" + msg + "']");
        return getTextFromElement(by);
    }

}

package com.uk.gov.steps;

import com.uk.gov.propertyreader.PropertyReader;
import com.uk.gov.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {

    @Before
    public void setUp() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenShot = getScreenShot();
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        closeBrowser();
    }

}

package com.uk.gov.steps;

import com.uk.gov.pages.NationalityPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class CountryDropdownSteps {
    @Then("I can see following country into dropdown")
    public void iCanSeeFollowingCountryIntoDropdown(DataTable dataTable) {
        new NationalityPage().isCountryListAvailableInDropdown(dataTable);
    }
}

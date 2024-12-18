package com.uk.gov.steps;

import com.uk.gov.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class VisaConfirmationSteps {

    @When("I click on start button")
    public void iClickOnStartButton() {
        new StartPage().clickOnStartNowButton();
    }

    @And("I select a Nationality {string}")
    public void iSelectANationality(String countryName) {
        new NationalityPage().selectNationality(countryName);
    }

    @And("I click On Continue button")
    public void iClickOnContinueButton() {
        new NationalityPage().clickOnContinue();
    }

    @And("I select reason {string}")
    public void iSelectReason(String reason) {
        new ReasonForTravelPage().clickOnYourReasonRadioButton(reason);
    }

    @And("I Click on Continue button after reason")
    public void iClickOnContinueButtonAfterReason() {
        new ReasonForTravelPage().clickOnContinueButton();
    }

    @Then("I should get result that {string}")
    public void iShouldGetResultThat(String msg) {
        Assert.assertEquals(new ResultPage().getResultMessage(msg), msg);
    }

    @And("I  Select intended to stay for {string}")
    public void iSelectIntendedToStayFor(String stayingTime) {
        new DurationOfStayPage().selectLengthOfStay(stayingTime);
    }

    @And("I Select have planning to work for {string}")
    public void iSelectHavePlanningToWorkFor(String workType) {
        new WorkTypePage().selectWorkType(workType);
    }

    @And("I Select state My partner of family member have uk immigration status {string}")
    public void iSelectStateMyPartnerOfFamilyMemberHaveUkImmigrationStatus(String status) {
        new FamilyImmigrationStatusPage().clickOnImmigrationStatus(status);
    }
}

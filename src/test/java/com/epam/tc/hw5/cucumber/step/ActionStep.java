package com.epam.tc.hw5.cucumber.step;

import static com.epam.tc.hw5.cucumber.FileDataUtils.JDI_URL;
import static com.epam.tc.hw5.cucumber.FileDataUtils.USER_NAME;
import static com.epam.tc.hw5.cucumber.FileDataUtils.USER_PASSWORD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.open(JDI_URL);
    }

    @Given("I login as user 'Roman Iovlev'")
    public void loginAsRomanIovlev() {
        homePage.loginUser(USER_NAME, USER_PASSWORD);
    }

    @When("I click on 'Service' button in Header")
    public void clickServiceInHeader() {
        homePage.getHeaderMenu().openServiceMenu();
    }

    @When("I click on {string} button in Header Service dropdown")
    public void clickHeaderServiceItem(String itemName) {
        homePage.getHeaderMenu().clickServiceElementItem(itemName);
    }

    @When("I select {string} checkbox on Checkbox row on Different Element page")
    public void selectDifferentElementPageCheckbox(String checkboxName) {
        differentElementsPage.clickCheckbox(checkboxName);
    }

    @When("I select {string} radio on Checkbox row on Different Element page")
    public void selectRadio(String radioName) {
        differentElementsPage.clickRadio(radioName);
    }

    @When("I select {string} dropdown on Checkbox row on Different Element page")
    public void selectDropdown(String dropdownName) {
        differentElementsPage.clickDropdown(dropdownName);
    }

    @When("I select 'vip' checkbox for {string} on Users Table on User Table Page")
    public void selectUserTableVipCheckbox(String userName) {
        userTablePage.clickOnSergeyIvanVipCheckbox();
    }
}

package com.epam.tc.hw6.steps;

import static com.epam.tc.hw4.FileUtils.JDI_URL;
import static com.epam.tc.hw4.FileUtils.USER_NAME;
import static com.epam.tc.hw4.FileUtils.USER_PASSWORD;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open JDI Home Page")
    public void openHomePage() {
        homePage.open(JDI_URL);
    }

    @Step("Open 'Different elements' page from homepage")
    public void openDifferentElementPage() {
        homePage.getDifferentElementPage();
    }

    @Step("Login user to site")
    public void login() {
        homePage.loginUser(USER_NAME, USER_PASSWORD);
    }

    @Step("Switch to 'iFrame with button' on homepage")
    public void switchToIframeWithButton() {
        homePage.switchToIframeWithButton();
    }

    @Step("Switch from iframe to homepage")
    public void switchToHomepage() {
        homePage.switchToHomePage();
    }

    @Step("Select '{checkbox}' checkbox")
    public void selectCheckbox(String checkbox) {
        differentElementsPage.clickCheckbox(checkbox);
    }

    @Step("Select '{radio}' radio")
    public void selectRadio(String radio) {
        differentElementsPage.clickRadio(radio);
    }

    @Step("Select '{dropdown}' dropdown")
    public void selectDropdown(String dropdown) {
        differentElementsPage.clickDropdown(dropdown);
    }
}

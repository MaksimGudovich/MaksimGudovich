package com.epam.tc.hw4.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertBaseStep extends AbstractStep {

    public AssertBaseStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Checking the display of the '{expectedPage}'")
    public void checkPageTitle(String expectedPage) {
        String actualTitle = basePage.getTitle();
        assertThat(actualTitle).isEqualToIgnoringCase(expectedPage);
    }

    @Step("Check user is loggined")
    public void checkUserIsLoggined(String expectedName) {
        String actualName = basePage.getUserName();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Step("Checking displaying header menu elements")
    public void checkHeaderElementsDisplayed(int expectedNumber) {
        List<WebElement> actualHeaderMenuElementList = basePage.getHeaderElementList();
        assertThat(actualHeaderMenuElementList.size()).isEqualTo(expectedNumber);
    }

    @Step("Checking header elements names")
    public void checkHeaderElementsName(List<String> expectedElementsNames) {
        List<String> actualHeaderElementNameList = basePage.getHeaderMenuElementNameList();
        assertThat(actualHeaderElementNameList).isEqualTo(expectedElementsNames);
    }

    @Step("Checking displaying left menu elements")
    public void checkLeftElementDisplayed(int expectedNumber) {
        List<WebElement> actualLeftMenuElementList = basePage.getLeftMenuElementList();
        assertThat(actualLeftMenuElementList.size()).isEqualTo(expectedNumber);
    }

    @Step("Checking left menu elements names")
    public void checkLeftMenuElementsNames(List<String> expectedElementsNames) {
        List<String> actualLeftMenuElementNamesList = basePage.getLeftMenuElementNameList();
        assertThat(actualLeftMenuElementNamesList).isEqualTo(expectedElementsNames);
    }
}

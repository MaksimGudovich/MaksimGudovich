package com.epam.tc.hw4.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertHomepageStep extends AssertBaseStep {

    public AssertHomepageStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Checking images on homepage")
    public void checkImagesDisplayed(int expectedNumber) {
        List<WebElement> imageList = homePage.getImagesList();
        assertThat(imageList.size()).isEqualTo(expectedNumber);
    }

    @Step("Checking text under images on homepage")
    public void chekImagesTextDisplayed(List<String> expectedList) {
        List<String> actualImagesTextList = homePage.getImagesTextList();
        assertThat(actualImagesTextList).isEqualTo(expectedList);
    }

    @Step("Checking \"iFrame with button\" on homepage")
    public void checkIframeWithButton(int expectedNumber) {
        List<WebElement> actualIframeWithButtonList = homePage.getIframeWithButtonList();
        assertThat(actualIframeWithButtonList.size()).isEqualTo(expectedNumber);
    }

    @Step("Checking button in \"iFrame with button\" on homepage")
    public void checkButtonInIframe(int expectedNumber) {
        List<WebElement> actualIframeButtonList = homePage.getIframeButtonList();
        assertThat(actualIframeButtonList.size()).isEqualTo(expectedNumber);
    }
}

package com.epam.tc.hw4.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AssertDifferentElementsPageStep extends AssertBaseStep {

    public AssertDifferentElementsPageStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Checking that the last log matches the selected checkbox")
    public void checkLastLog(String expectedLog) {
        String lastLog = differentElementsPage.getLastLog();
        assertThat(lastLog).contains(expectedLog);
    }
}

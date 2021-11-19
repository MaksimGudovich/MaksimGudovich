package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.service.webdriver.WebDriverProvider;
import com.epam.tc.hw6.steps.ActionStep;
import com.epam.tc.hw6.steps.AssertDifferentElementsPageStep;
import com.epam.tc.hw6.steps.AssertHomepageStep;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;
    protected ActionStep actionStep;
    protected AssertHomepageStep assertHomepageStep;
    protected AssertDifferentElementsPageStep assertDifferentElementsPageStep;

    @BeforeMethod
    public void setupMethod() {
        webDriver = WebDriverProvider.getWebDriver();
        //        context.setAttribute("driver", webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        actionStep = new ActionStep(webDriver);
        assertHomepageStep = new AssertHomepageStep(webDriver);
        assertDifferentElementsPageStep = new AssertDifferentElementsPageStep(webDriver);

        actionStep.openHomePage();
    }

    @AfterMethod
    public void clear() {
        WebDriverProvider.closeDriver();
    }
}

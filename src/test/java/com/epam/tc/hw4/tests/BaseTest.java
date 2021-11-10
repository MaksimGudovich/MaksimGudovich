package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertDifferentElementsPageStep;
import com.epam.tc.hw4.steps.AssertHomepageStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver webDriver;
    protected ActionStep actionStep;
    protected AssertHomepageStep assertHomepageStep;
    protected AssertDifferentElementsPageStep assertDifferentElementsPageStep;


    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupMethod(ITestContext context) {
        webDriver = new ChromeDriver();
        context.setAttribute("driver", webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        actionStep = new ActionStep(webDriver);
        assertHomepageStep = new AssertHomepageStep(webDriver);
        assertDifferentElementsPageStep = new AssertDifferentElementsPageStep(webDriver);

        actionStep.openHomePage();
    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }
}

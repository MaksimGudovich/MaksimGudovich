package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.JdiTestData;
import com.epam.tc.hw4.page.BasePage;
import com.epam.tc.hw4.page.DifferentElementsPage;
import com.epam.tc.hw4.page.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected BasePage basePage;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected JdiTestData jdiTestData;

    public AbstractStep(WebDriver webDriver) {
        basePage = new BasePage(webDriver);
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        jdiTestData = new JdiTestData();
    }
}

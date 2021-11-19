package com.epam.tc.hw5.cucumber.step;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.page.BasePage;
import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.HomePage;
import com.epam.tc.hw5.page.UserTablePage;
import com.epam.tc.hw5.page.component.LogList;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected BasePage basePage;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected LogList logList;

    public AbstractStep() {
        WebDriver webDriver = TestContext.getInstance().getObject("webDriver");
        webDriver.manage().window().maximize();
        basePage = new BasePage(webDriver);
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
        logList = new LogList(webDriver);
    }
}

package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.SiteJdi.homePage;
import static com.epam.tc.hw7.page.HomePage.userName;
import static com.epam.tc.hw7.states.States.loggedIn;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public interface TestInit {

    @BeforeClass
    static void setUp() {
        initSite(SiteJdi.class);
        loggedIn();
        userName.is().text("ROMAN IOVLEV");
        homePage.shouldBeOpened();
    }

    @AfterClass
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}

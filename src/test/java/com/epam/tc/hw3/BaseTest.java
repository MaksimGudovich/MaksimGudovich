package com.epam.tc.hw3;

import static com.epam.tc.hw3.JdiTestData.getTestJdiURL;

import com.epam.tc.hw3.page.DifferentElementsPage;
import com.epam.tc.hw3.page.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static WebDriver webDriver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void setupSuit() {
        WebDriverManager.chromedriver().setup();
        new JdiTestData();
    }

    @BeforeMethod
    public void setupClass() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        homePage.open(getTestJdiURL());
    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }
}

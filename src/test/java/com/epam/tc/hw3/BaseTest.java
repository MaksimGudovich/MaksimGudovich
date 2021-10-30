package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    static WebDriver webDriver;
    protected String userName;
    protected String userPassword;

    @BeforeClass
    public void setupSuit() {
        WebDriverManager.chromedriver().setup();

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/com/epam/tc/hw3/testData.properties")) {
            properties.load(fis);
            userName = properties.getProperty("userName");
            userPassword = properties.getProperty("userPassword");
        } catch (IOException e) {
            System.err.println("File don't exist");
        }
    }

    @BeforeMethod
    public void setupClass() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }
}

package com.epam.tc.hw6.service.webdriver;

import com.epam.tc.hw6.service.exeption.IllegalBrowserException;
import com.epam.tc.hw6.service.exeption.IllegalDriverLaunchException;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    private static final String LOCAL_LAUNCH = "local";
    private static final String REMOTE_LAUNCH = "remote";

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(final String launchType, final Browser browser) {
        WebDriver webDriver;
        if (launchType.equalsIgnoreCase(LOCAL_LAUNCH)) {
            webDriver = createLocalWebDriver(browser);
        } else if (launchType.equalsIgnoreCase(REMOTE_LAUNCH)) {
            webDriver = createRemoteWebDriver(browser);
        } else {
            throw new IllegalDriverLaunchException();
        }
        return webDriver;
    }

    //LOCAL
    private static WebDriver createLocalWebDriver(Browser browser) {
        WebDriver webDriver;
        switch (browser) {
            case CHROME:
                webDriver = createChromeDriver();
                break;
            case FIREFOX:
                webDriver = createFirefoxDriver();
                break;
            default:
                throw new IllegalBrowserException();
        }
        return webDriver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    //REMOTE
    private static WebDriver createRemoteWebDriver(final Browser browser) {
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = createChromeCapabilities();
                break;
            case FIREFOX:
                capabilities = createFirefoxCapabilities();
                break;
            default:
                throw new IllegalBrowserException();
        }

        WebDriver webDriver;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
        return webDriver;
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }
}

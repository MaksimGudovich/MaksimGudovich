package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest {

    private WebDriver webDriver;
    private String indexHandle;

    private static final String HOME_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void jdiHomePageTest() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));

        // 1. Open test site by URL
        webDriver.get(HOME_URL);
        SoftAssert softAssert = new SoftAssert();

        //2. Assert Browser title
        softAssert.assertEquals("Home Page", webDriver.getTitle());

        // 3. Perform login
        WebElement loginCaret = isElementVisible(webDriver, By.cssSelector(".profile-photo + .caret"));
        loginCaret.click();
        WebElement nameField = isElementVisible(webDriver, By.id("name"));
        nameField.sendKeys("Roman");
        WebElement passwordField = isElementVisible(webDriver, By.id("password"));
        passwordField.sendKeys("Jdi1234");
        WebElement loginEnterButton = isElementVisible(webDriver, By.xpath("//span[text()='Enter']"));
        loginEnterButton.click();

        // 4. Assert Username is loggined
        WebElement actualUserName = isElementVisible(webDriver, By.id("user-name"));
        softAssert.assertEquals("ROMAN IOVLEV", actualUserName.getText());

        // 5.  Assert that there are 4 items on the header section are displayed, and they have proper texts
        boolean isHeaderItemsDisplayed = isAllDisplayed(By
            .cssSelector("[class^='uui-navigation nav navbar'] > li > a"));
        softAssert.assertTrue(isHeaderItemsDisplayed);

        List<WebElement> headerElements = webDriver
            .findElements(By.cssSelector("[class^='uui-navigation nav navbar'] > li > a"));
        softAssert.assertEquals(getTextList(headerElements), Arrays
            .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        boolean isImagesDisplayed = isAllDisplayed(By.className("icons-benefit"));
        softAssert.assertTrue(isImagesDisplayed);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        boolean isImagesTextDisplayed = isAllDisplayed(By.className("benefit-txt"));
        softAssert.assertTrue(isImagesTextDisplayed);

        List<WebElement> imagesTextElements = webDriver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(getTextList(imagesTextElements), Arrays
            .asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));

        // 8. Assert that there is the iframe with “Frame Button” exist
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("frame")));
        boolean hasIframe = webDriver.findElements(By.id("frame")).size() > 0;
        softAssert.assertTrue(hasIframe);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexHandle = webDriver.getWindowHandle();
        webDriver.switchTo().frame("frame");
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("frame-button")));
        boolean hasIframeButton = webDriver.findElements(By.id("frame-button")).size() > 0;
        softAssert.assertTrue(hasIframeButton);

        // 10. Switch to original window back
        webDriver.switchTo().window(indexHandle);
        softAssert.assertEquals("Home Page", webDriver.getTitle());

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        boolean isLeftMenuElementDisplayed = isAllDisplayed(By
            .cssSelector("[class='sidebar-menu left'] > li > a >  span:first-child"));
        softAssert.assertTrue(isLeftMenuElementDisplayed);

        List<WebElement> leftMenuElements = webDriver
            .findElements(By.cssSelector("[class='sidebar-menu left'] > li > a >  span:first-child"));
        softAssert.assertEquals(getTextList(leftMenuElements), Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));

        softAssert.assertAll();

        // 12. Close Browser
        webDriver.quit();
    }

    private WebElement isElementVisible(WebDriver webDriver, By by) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(4))
            .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private boolean isAllDisplayed(By by) {
        boolean isAllDisplayed = true;
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (TimeoutException timeoutException) {
            isAllDisplayed = false;
        }
        return isAllDisplayed;
    }

    private List<String> getTextList(List<WebElement> elementList) {
        ArrayList<String> elementsTextList = new ArrayList<>();
        for (WebElement element : elementList
        ) {
            elementsTextList.add(element.getText());
        }
        return elementsTextList;
    }

    @AfterClass
    public void clear() {
        webDriver.quit();
    }
}

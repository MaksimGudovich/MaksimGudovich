package com.epam.tc.hw2;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected JdiTestData testData;

    @BeforeSuite
    public void suitSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupClass() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        testData = new JdiTestData();
        openHomePage();
    }

    @AfterMethod
    public void close() {
        webDriver.close();
    }

    public void openHomePage() {
        webDriver.get(testData.jdiURL);
    }

    public void loginUser() {
        WebElement loginCaret = isElementVisible(By.cssSelector(".dropdown.uui-profile-menu span.caret"));
        loginCaret.click();
        WebElement nameField = isElementVisible(By.id("name"));
        nameField.sendKeys(testData.userName);
        WebElement passwordField = isElementVisible(By.id("password"));
        passwordField.sendKeys(testData.userPassword);
        WebElement loginEnterButton = isElementVisible(By.xpath("//span[text()='Enter']"));
        loginEnterButton.click();
    }

    protected WebElement isElementVisible(By by) {
        return wait.until(visibilityOfElementLocated(by));
    }

    protected List<WebElement> getElementList(By by) {
        return wait.until(visibilityOfAllElementsLocatedBy(by));
    }

    protected List<String> getTextList(List<WebElement> elementList) {
        ArrayList<String> elementsTextList = new ArrayList<>();
        for (WebElement element : elementList) {
            elementsTextList.add(element.getText());
        }
        return elementsTextList;
    }

    protected boolean isThisHomePage() {
        return webDriver.getTitle().equals("Home Page");
    }

    protected void openDifferentPage() {
        webDriver.findElement(By.cssSelector(".uui-navigation.nav span")).click();
        webDriver.findElement(By.xpath("//a[text()='Different elements']")).click();
    }
}

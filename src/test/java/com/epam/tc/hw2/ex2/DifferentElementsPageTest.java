package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DifferentElementsPageTest {

    private WebDriver webDriver;

    private static final String INDEX_JDI_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
    }

    // 1. Open test site by URL
    // 2. Assert Browser title
    @Test
    public void openIndexPageTest() {
        webDriver.get(INDEX_JDI_URL);
        assertThat(webDriver.getTitle()).isEqualTo("Home Page");
    }

    // 3. Perform login
    // 4. Assert User name in the right-top side of screen that user is loggined
    @Test(priority = 1)
    public void userLoginTest() {
        WebElement loginCaret = isElementVisible(webDriver, By.cssSelector(".profile-photo + .caret"));
        loginCaret.click();
        WebElement nameField = isElementVisible(webDriver, By.id("name"));
        nameField.sendKeys("Roman");
        WebElement passwordField = isElementVisible(webDriver, By.id("password"));
        passwordField.sendKeys("Jdi1234");
        WebElement loginEnterButton = isElementVisible(webDriver, By.xpath("//span[text()='Enter']"));
        loginEnterButton.click();
        WebElement actualUserName = isElementVisible(webDriver, By.id("user-name"));
        assertThat(actualUserName.getText()).isEqualTo("ROMAN IOVLEV");
    }

    // 5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 2)
    public void openDifferentElementPageTest() {
        WebElement headerServiseButton = webDriver.findElement(By.cssSelector("a.dropdown-toggle :only-child"));
        headerServiseButton.click();
        WebElement diffrentElementButton = webDriver.findElement(By.xpath("//a[text()='Different elements']"));
        diffrentElementButton.click();
        assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
    }

    // 6. Select checkboxes (Water)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test(priority = 3)
    public void selectWaterCheckboxTest() {
        WebElement waterCheckbox = isElementVisible(webDriver, By.xpath("//div[@class='checkbox-row']"
            + "/label[@class='label-checkbox'][1]/child::text()/parent::label"));
        waterCheckbox.click();
        String waterChangeLog = webDriver.findElement(By.xpath("//li[contains(text(), 'Water')]")).getText();
        assertThat(waterChangeLog).contains("Water: condition changed to true");
    }

    // 6. Select checkboxes (Wind)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test(priority = 3)
    public void selectWindCheckboxTest() {
        WebElement windCheckbox = isElementVisible(webDriver, By.xpath("//div[@class='checkbox-row']"
            + "/label[@class='label-checkbox'][3]/child::text()/parent::label"));
        windCheckbox.click();
        String windChangeLog = webDriver.findElement(By.xpath("//li[contains(text(), 'Wind')]")).getText();
        assertThat(windChangeLog).contains("Wind: condition changed to true");
    }

    // 7. Select radio (Selen)
    // 9. Assert that: for radio button there is a log row and value is corresponded to the status of radio button
    @Test(priority = 3)
    public void selectSelenRadioTest() {
        WebElement selenRadioButton = webDriver.findElement(By.xpath("//div[@class='checkbox-row']"
            + "/label[@class='label-radio'][4]/child::text()/parent::label"));
        selenRadioButton.click();
        String selenChangeLog = webDriver.findElement(By.xpath("//li[contains(text(), 'Selen')]")).getText();
        assertThat(selenChangeLog).contains("metal: value changed to Selen");
    }

    // 8. Select dropdown (Yellow)
    // 9. Assert that: for dropdown there is a log row and value is corresponded to the selected value
    @Test(priority = 3)
    public void selectYellowDropdownTest() {
        WebElement yellowDropdownButton = webDriver.findElement(By.xpath("//option[text()='Yellow']"));
        yellowDropdownButton.click();
        String collorChangeLog = webDriver.findElement(By.xpath("//li[contains(text(), 'Yellow')]")).getText();
        assertThat(collorChangeLog).contains("Colors: value changed to Yellow");
    }

    private WebElement isElementVisible(WebDriver webDriver, By by) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(4))
            .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @AfterClass
    public void clear() {
        webDriver.quit();
    }
}

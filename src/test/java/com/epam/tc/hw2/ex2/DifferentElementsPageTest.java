package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    // 1. Open test site by URL
    // 2. Assert Browser title
    @Test
    public void openIndexPageTest() {
        openHomePage();
        boolean isHomePage = isThisHomePage();
        assertThat(isHomePage).isTrue();
    }

    // 3. Perform login
    // 4. Assert User name in the right-top side of screen that user is loggined
    @Test
    public void userLoginTest() {
        openHomePage();
        loginUser();
        WebElement actualUserName = isElementVisible(By.id("user-name"));
        assertThat(actualUserName.getText()).isEqualTo("ROMAN IOVLEV");
    }

    // 5. Open through the header menu Service -> Different Elements Page
    @Test
    public void openDifferentElementPageTest() {
        openHomePage();
        loginUser();
        openDifferentPage();
        assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
    }

    // 6. Select checkboxes (Water)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test
    public void selectWaterCheckboxTest() {
        openHomePage();
        loginUser();
        openDifferentPage();
        WebElement waterCheckbox = isElementVisible(By.cssSelector(".label-checkbox:nth-child(1)"));
        waterCheckbox.click();
        String waterChangeLog = webDriver.findElement(By.xpath("//li[contains(text(), 'Water')]")).getText();
        assertThat(waterChangeLog).contains("Water: condition changed to true");
    }

    // 6. Select checkboxes (Wind)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test
    public void selectWindCheckboxTest() {
        openHomePage();
        loginUser();
        openDifferentPage();
        WebElement windCheckbox = isElementVisible(By.cssSelector(".label-checkbox:nth-child(3)"));
        windCheckbox.click();
        String windChangeLog = webDriver.findElement(By.xpath("//li[contains(text(), 'Wind')]")).getText();
        assertThat(windChangeLog).contains("Wind: condition changed to true");
    }

    // 7. Select radio (Selen)
    // 9. Assert that: for radio button there is a log row and value is corresponded to the status of radio button
    @Test
    public void selectSelenRadioTest() {
        openHomePage();
        loginUser();
        openDifferentPage();
        WebElement selenRadioButton = webDriver.findElement(By.cssSelector(".label-radio:nth-child(4)"));
        selenRadioButton.click();
        String selenChangeLog = webDriver.findElement(By.xpath("//li[contains(text(), 'Selen')]")).getText();
        assertThat(selenChangeLog).contains("metal: value changed to Selen");
    }

    // 8. Select dropdown (Yellow)
    // 9. Assert that: for dropdown there is a log row and value is corresponded to the selected value
    @Test
    public void selectYellowDropdownTest() {
        openHomePage();
        loginUser();
        openDifferentPage();
        WebElement yellowDropdownButton = webDriver.findElement(By.xpath("//option[text()='Yellow']"));
        yellowDropdownButton.click();
        String collorChangeLog = webDriver.findElement(By.xpath("//li[contains(text(), 'Yellow')]")).getText();
        assertThat(collorChangeLog).contains("Colors: value changed to Yellow");
    }
}

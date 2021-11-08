package com.epam.tc.hw3;

import static com.epam.tc.hw3.FileUtils.USER_NAME;
import static com.epam.tc.hw3.FileUtils.USER_PASSWORD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    // 1. Open test site by URL
    // 2. Assert Browser title
    @Test
    public void openHomePageTest() {
        String title = homePage.getTitle();

        assertThat(title).isEqualTo("Home Page");
    }

    // 3. Perform login
    // 4. Assert User name in the right-top side of screen that user is loggined
    @Test
    public void userLoginTest() {
        String actualUserName = homePage
            .loginUser(USER_NAME, USER_PASSWORD)
            .getUserName();

        assertThat(actualUserName).isEqualTo("ROMAN IOVLEV");
    }

    // 5. Open through the header menu Service -> Different Elements Page
    @Test
    public void openDifferentElementPageTest() {
        homePage.loginUser(USER_NAME, USER_PASSWORD);

        String actualTitle = homePage
            .getDifferentElementPage()
            .getTitle();

        assertThat(actualTitle).isEqualTo("Different Elements");
    }

    // 6. Select checkboxes (Water)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test
    public void selectWaterCheckboxTest() {
        homePage.loginUser(USER_NAME, USER_PASSWORD);

        String waterChangeLog = homePage
            .getDifferentElementPage()
            .clickCheckbox("Water")
            .getLastLog();

        assertThat(waterChangeLog).contains("Water: condition changed to true");
    }

    // 6. Select checkboxes (Wind)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test
    public void selectWindCheckboxTest() {
        homePage.loginUser(USER_NAME, USER_PASSWORD);

        String windChangeLog = homePage
            .getDifferentElementPage()
            .clickCheckbox("Wind")
            .getLastLog();

        assertThat(windChangeLog).contains("Wind: condition changed to true");
    }

    // 7. Select radio (Selen)
    // 9. Assert that: for radio button there is a log row and value is corresponded to the status of radio button
    @Test
    public void selectSelenRadioTest() {
        homePage.loginUser(USER_NAME, USER_PASSWORD);

        String selenChangeLog = homePage
            .getDifferentElementPage()
            .clickRadio("Selen")
            .getLastLog();

        assertThat(selenChangeLog).contains("metal: value changed to Selen");
    }

    // 8. Select dropdown (Yellow)
    // 9. Assert that: for dropdown there is a log row and value is corresponded to the selected value
    @Test
    public void selectYellowDropdownTest() {
        homePage.loginUser(USER_NAME, USER_PASSWORD);

        String colorChangeLog = homePage
            .getDifferentElementPage()
            .clickDropdown("Yellow")
            .getLastLog();

        assertThat(colorChangeLog).contains("Colors: value changed to Yellow");
    }
}

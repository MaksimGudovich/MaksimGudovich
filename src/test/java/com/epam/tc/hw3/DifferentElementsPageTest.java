package com.epam.tc.hw3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.page.DifferentElementsPage;
import com.epam.tc.hw3.page.HomePage;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    // 1. Open test site by URL
    // 2. Assert Browser title
    @Test
    public void openHomePageTest() {
        String title = new HomePage(webDriver)
            .open()
            .getTitle();

        assertThat(title).isEqualTo("Home Page");
    }

    // 3. Perform login
    // 4. Assert User name in the right-top side of screen that user is loggined
    @Test
    public void userLoginTest() {
        String actualUserName = new HomePage(webDriver)
            .open()
            .loginUser(userName, userPassword)
            .getUserName();

        assertThat(actualUserName).isEqualTo("ROMAN IOVLEV");
    }

    // 5. Open through the header menu Service -> Different Elements Page
    @Test
    public void openDifferentElementPageTest() {
        new HomePage(webDriver).open().loginUser(userName, userPassword);

        String actualTitle = new DifferentElementsPage(webDriver)
            .getDifferentElementPage()
            .getTitle();

        assertThat(actualTitle).isEqualTo("Different Elements");
    }

    // 6. Select checkboxes (Water)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test
    public void selectWaterCheckboxTest() {
        new HomePage(webDriver).open().loginUser(userName, userPassword);

        String waterChangeLog = new DifferentElementsPage(webDriver)
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
        new HomePage(webDriver).open().loginUser(userName, userPassword);

        String windChangeLog = new DifferentElementsPage(webDriver)
            .getDifferentElementPage()
            .clickCheckbox("Wind")
            .getLastLog();

        assertThat(windChangeLog).contains("Wind: condition changed to true");
    }

    // 7. Select radio (Selen)
    // 9. Assert that: for radio button there is a log row and value is corresponded to the status of radio button
    @Test
    public void selectSelenRadioTest() {
        new HomePage(webDriver).open().loginUser(userName, userPassword);

        String selenChangeLog = new DifferentElementsPage(webDriver)
            .getDifferentElementPage()
            .clickRadio("Selen")
            .getLastLog();

        assertThat(selenChangeLog).contains("metal: value changed to Selen");
    }

    // 8. Select dropdown (Yellow)
    // 9. Assert that: for dropdown there is a log row and value is corresponded to the selected value
    @Test(priority = 3)
    public void selectYellowDropdownTest() {
        new HomePage(webDriver).open().loginUser(userName, userPassword);

        String colorChangeLog = new DifferentElementsPage(webDriver)
            .getDifferentElementPage()
            .clickDropdown("Yellow")
            .getLastLog();

        assertThat(colorChangeLog).contains("Colors: value changed to Yellow");
    }
}

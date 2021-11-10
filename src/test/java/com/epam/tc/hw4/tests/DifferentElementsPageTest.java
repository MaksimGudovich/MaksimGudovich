package com.epam.tc.hw4.tests;

import static com.epam.tc.hw4.JdiTestData.HOME_PAGE_TITLE;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Different elements page")
@Story("Check Different elements page")
public class DifferentElementsPageTest extends BaseTest {

    // 1. Open test site by URL
    // 2. Assert Browser title
    @Test
    public void openHomePageTest() {

        assertHomepageStep.checkPageTitle(HOME_PAGE_TITLE);
    }

    // 3. Perform login
    // 4. Assert User name in the right-top side of screen that user is loggined
    @Test
    public void userLoginTest() {
        actionStep.login();
        assertHomepageStep.checkUserIsLoggined("ROMAN IOVLEV");
    }

    // 5. Open through the header menu Service -> Different Elements Page
    @Test
    public void openDifferentElementPageTest() {
        actionStep.login();
        actionStep.openDifferentElementPage();
        assertDifferentElementsPageStep.checkPageTitle("Different Elements");
    }

    // 6. Select checkboxes (Water)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test
    public void selectWaterCheckboxTest() {
        actionStep.login();
        actionStep.openDifferentElementPage();
        actionStep.selectCheckbox("Water");
        assertDifferentElementsPageStep.checkLastLog("Water: condition changed to true");
    }

    // 6. Select checkboxes (Wind)
    // 9. Assert that: for each checkbox there is an individual log row and value is corresponded
    //    to the status of checkbox
    @Test
    public void selectWindCheckboxTest() {
        actionStep.login();
        actionStep.openDifferentElementPage();
        actionStep.selectCheckbox("Wind");
        assertDifferentElementsPageStep.checkLastLog("Wind: condition changed to true");
    }

    // 7. Select radio (Selen)
    // 9. Assert that: for radio button there is a log row and value is corresponded to the status of radio button
    @Test
    public void selectSelenRadioTest() {
        actionStep.login();
        actionStep.openDifferentElementPage();
        actionStep.selectRadio("Selen");
        assertDifferentElementsPageStep.checkLastLog("metal: value changed to Selen");
    }

    // 8. Select dropdown (Yellow)
    // 9. Assert that: for dropdown there is a log row and value is corresponded to the selected value
    @Test
    public void selectYellowDropdownTest() {

        actionStep.login();
        actionStep.openDifferentElementPage();
        actionStep.selectDropdown("Yellow");
        assertDifferentElementsPageStep.checkLastLog("Colors: value changed to Yellow");
    }
}

package com.epam.tc.hw6.tests;

import static com.epam.tc.hw4.JdiTestData.HEADER_ITEM_NAME_LIST;
import static com.epam.tc.hw4.JdiTestData.HOME_PAGE_TITLE;
import static com.epam.tc.hw4.JdiTestData.IMAGE_TEXT_LIST;
import static com.epam.tc.hw4.JdiTestData.LEFT_MENU_ELEMENT_LIST;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Home page")
@Story("Check Home page")
public class HomePageTest extends BaseTest {

    @Test
    public void jdiHomePageTest() {

        //2. Assert Browser title
        assertHomepageStep.checkPageTitle(HOME_PAGE_TITLE);

        // 3. Perform login
        actionStep.login();

        // 4. Assert Username is loggined
        assertHomepageStep.checkUserIsLoggined("ROMAN IOVLEV");

        // 5.  Assert that there are 4 items on the header section are displayed, and they have proper texts
        assertHomepageStep.checkHeaderElementsDisplayed(4);

        assertHomepageStep.checkHeaderElementsName(HEADER_ITEM_NAME_LIST);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        assertHomepageStep.checkImagesDisplayed(4);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        assertHomepageStep.chekImagesTextDisplayed(IMAGE_TEXT_LIST);

        // 8. Assert that there is the iframe with “Frame Button” exist
        assertHomepageStep.checkIframeWithButton(1);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToIframeWithButton();
        assertHomepageStep.checkButtonInIframe(1);

        // 10. Switch to original window back
        actionStep.switchToHomepage();
        assertHomepageStep.checkPageTitle(HOME_PAGE_TITLE);

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        assertHomepageStep.checkLeftElementDisplayed(5);
        assertHomepageStep.checkLeftMenuElementsNames(LEFT_MENU_ELEMENT_LIST);
    }
}

package com.epam.tc.hw3;

import com.epam.tc.hw3.page.HomePage;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {

    @Test
    public void jdiHomePageTest() {
        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        //2. Assert Browser title
        String title = new HomePage(webDriver)
            .open()
            .getTitle();

        softAssert.assertEquals(title, "Home Page");

        // 3. Perform login
        // 4. Assert Username is loggined
        String actualUserName = new HomePage(webDriver)
            .loginUser(userName, userPassword)
            .getUserName();

        softAssert.assertEquals(actualUserName, "ROMAN IOVLEV");

        // 5.  Assert that there are 4 items on the header section are displayed, and they have proper texts
        boolean isHeaderElementsDisplayed = new HomePage(webDriver)
            .isHeaderElementsDisplayed();

        softAssert.assertTrue(isHeaderElementsDisplayed);

        List<String> headerMenuElementNames = new HomePage(webDriver)
            .getHeaderMenuElementNameList();

        softAssert.assertEquals(headerMenuElementNames, Arrays
            .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        boolean isImagesDisplayed = new HomePage(webDriver)
            .isImagesDisplayed();

        softAssert.assertTrue(isImagesDisplayed);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<String> imagesTextList = new HomePage(webDriver)
            .getImagesTextList();

        softAssert.assertEquals(imagesTextList, Arrays
            .asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));

        // 8. Assert that there is the iframe with “Frame Button” exist
        boolean isIframeDisplayed = new HomePage(webDriver)
            .isIframeDisplayed();

        softAssert.assertTrue(isIframeDisplayed);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        boolean isIframeButtonDisplayed = new HomePage(webDriver)
            .switchToIframe()
            .isIframeButtonDisplayed();

        softAssert.assertTrue(isIframeButtonDisplayed);

        // 10. Switch to original window back
        String actualTitle = new HomePage(webDriver)
            .switchToHomePage()
            .getTitle();

        softAssert.assertEquals(actualTitle, "Home Page");

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        boolean isLeftMenuElementDisplayed = new HomePage(webDriver)
            .isLeftMenuElementDisplayed();

        softAssert.assertTrue(isLeftMenuElementDisplayed);

        List<String> leftMenuElementsTextList = new HomePage(webDriver)
            .getLeftMenuElementNameList();

        softAssert.assertEquals(leftMenuElementsTextList, Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));

        softAssert.assertAll();

        // 12. Close Browser
        webDriver.quit();
    }
}

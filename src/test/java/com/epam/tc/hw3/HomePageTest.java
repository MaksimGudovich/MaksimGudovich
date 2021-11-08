package com.epam.tc.hw3;

import static com.epam.tc.hw3.FileUtils.JDI_URL;
import static com.epam.tc.hw3.FileUtils.USER_NAME;
import static com.epam.tc.hw3.FileUtils.USER_PASSWORD;
import static com.epam.tc.hw3.JdiTestData.HEADER_ITEM_NAME_LIST;
import static com.epam.tc.hw3.JdiTestData.HOME_PAGE_TITLE;
import static com.epam.tc.hw3.JdiTestData.IMAGE_TEXT_LIST;
import static com.epam.tc.hw3.JdiTestData.LEFT_MENU_ELEMENT_LIST;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {

    @Test
    public void jdiHomePageTest() {
        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        //2. Assert Browser title
        String title = homePage.open(JDI_URL).getTitle();

        softAssert.assertEquals(title, HOME_PAGE_TITLE);

        // 3. Perform login
        // 4. Assert Username is loggined
        String actualUserName = homePage.loginUser(USER_NAME, USER_PASSWORD).getUserName();

        softAssert.assertEquals(actualUserName, "ROMAN IOVLEV");

        // 5.  Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<WebElement> headerElements = homePage.getVisibleHeaderElements();

        softAssert.assertEquals(headerElements.size(), 4);

        List<String> actualHeaderMenuElementNames = homePage.getHeaderMenuElementNameList();

        softAssert.assertEquals(actualHeaderMenuElementNames, HEADER_ITEM_NAME_LIST);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> actualVisibleImages = homePage.getVisibleImagesDisplayed();

        softAssert.assertEquals(actualVisibleImages.size(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<String> imagesTextList = homePage.getImagesTextList();

        softAssert.assertEquals(imagesTextList, IMAGE_TEXT_LIST);

        // 8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> iframeWithButtonList = homePage.getVisibleIframeWithButton();

        softAssert.assertEquals(iframeWithButtonList.size(), 1);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        List<WebElement> iframeButtonList = homePage
            .switchToIframeWithButton()
            .getVisibleIframeButton();

        softAssert.assertEquals(iframeButtonList.size(), 1);

        // 10. Switch to original window back
        String actualTitle = homePage.switchToHomePage().getTitle();

        softAssert.assertEquals(actualTitle, HOME_PAGE_TITLE);

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> leftVisibleMenuElement = homePage.getLeftVisibleMenuElement();

        softAssert.assertEquals(leftVisibleMenuElement.size(), 5);

        List<String> leftMenuElementsTextList = homePage.getLeftMenuElementNameList();

        softAssert.assertEquals(leftMenuElementsTextList, LEFT_MENU_ELEMENT_LIST);

        softAssert.assertAll();
    }
}

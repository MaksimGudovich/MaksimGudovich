package com.epam.tc.hw3;

import static com.epam.tc.hw3.JdiTestData.getExpectedHeaderItemNameList;
import static com.epam.tc.hw3.JdiTestData.getExpectedHomePageTitle;
import static com.epam.tc.hw3.JdiTestData.getExpectedImageTextList;
import static com.epam.tc.hw3.JdiTestData.getExpectedLeftMenuElementList;
import static com.epam.tc.hw3.JdiTestData.getTestJdiURL;
import static com.epam.tc.hw3.JdiTestData.getTestUserName;
import static com.epam.tc.hw3.JdiTestData.getTestUserPassword;

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
        String title = homePage.open(getTestJdiURL()).getTitle();

        softAssert.assertEquals(title, getExpectedHomePageTitle());

        // 3. Perform login
        // 4. Assert Username is loggined
        String actualUserName = homePage.loginUser(getTestUserName(), getTestUserPassword()).getUserName();

        softAssert.assertEquals(actualUserName, "ROMAN IOVLEV");

        // 5.  Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<WebElement> headerElements = homePage.getVisibleHeaderElements();

        softAssert.assertEquals(headerElements.size(), 4);

        List<String> actualHeaderMenuElementNames = homePage.getHeaderMenuElementNameList();

        softAssert.assertEquals(actualHeaderMenuElementNames, getExpectedHeaderItemNameList());

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> actualVisibleImages = homePage.getVisibleImagesDisplayed();

        softAssert.assertEquals(actualVisibleImages.size(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<String> imagesTextList = homePage.getImagesTextList();

        softAssert.assertEquals(imagesTextList, getExpectedImageTextList());

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

        softAssert.assertEquals(actualTitle, getExpectedHomePageTitle());

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> leftVisibleMenuElement = homePage.getLeftVisibleMenuElement();

        softAssert.assertEquals(leftVisibleMenuElement.size(), 5);

        List<String> leftMenuElementsTextList = homePage.getLeftMenuElementNameList();

        softAssert.assertEquals(leftMenuElementsTextList, getExpectedLeftMenuElementList());

        softAssert.assertAll();
    }
}

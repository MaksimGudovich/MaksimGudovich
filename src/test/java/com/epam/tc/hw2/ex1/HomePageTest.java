package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    protected boolean isHomePage;

    @Test
    public void jdiHomePageTest() {

        // 1. Open test site by URL
        openHomePage();

        //2. Assert Browser title
        isHomePage = isThisHomePage();
        softAssert.assertTrue(isHomePage);

        // 3. Perform login
        loginUser();

        // 4. Assert Username is loggined
        WebElement actualUserName = isElementVisible(By.id("user-name"));
        softAssert.assertEquals("ROMAN IOVLEV", actualUserName.getText());

        // 5.  Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<WebElement> headerElements = getElementList(By
            .cssSelector("[class^='uui-navigation nav navbar'] > li > a"));
        boolean isAllHeaderItemsDisplayed = headerElements.size() == 4;
        softAssert.assertTrue(isAllHeaderItemsDisplayed);

        List<String> headerItemsNameList = getTextList(headerElements);
        softAssert.assertEquals(testData.headerItemNameList, headerItemsNameList);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        boolean isImagesDisplayed = getElementList(By.className("icons-benefit")).size() == 4;
        softAssert.assertTrue(isImagesDisplayed);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> imageTextList = getElementList(By.className("benefit-txt"));
        boolean isImagesTextDisplayed = imageTextList.size() == 4;
        softAssert.assertTrue(isImagesTextDisplayed);

        List<String> imagesElementsTextList = getTextList(imageTextList);
        softAssert.assertEquals(testData.imageTextList, imagesElementsTextList);

        // 8. Assert that there is the iframe with “Frame Button” exist
        boolean hasIframe = isElementExist(By.id("frame"));
        softAssert.assertTrue(hasIframe);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");

        boolean hasIframeButton = isElementExist(By.id("frame-button"));
        softAssert.assertTrue(hasIframeButton);

        // 10. Switch to original window back
        webDriver.switchTo().parentFrame();
        isHomePage = isThisHomePage();
        softAssert.assertTrue(isHomePage);

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> leftMenuElementList = getElementList(By
            .cssSelector("[class='sidebar-menu left'] > li > a >  span:first-child"));

        boolean isLeftMenuElementDisplayed = leftMenuElementList.size() == 5;
        softAssert.assertTrue(isLeftMenuElementDisplayed);

        List<String> leftMenuElements = getTextList(leftMenuElementList);
        softAssert.assertEquals(testData.leftMenuElementList, leftMenuElements);

        softAssert.assertAll();
    }
}

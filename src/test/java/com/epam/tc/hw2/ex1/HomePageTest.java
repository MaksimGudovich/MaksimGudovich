package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void jdiHomePageTest() {

        // 1. Open test site by URL

        //2. Assert Browser title
        softAssert.assertTrue(isThisHomePage());

        // 3. Perform login
        loginUser();

        // 4. Assert Username is loggined
        WebElement actualUserName = isElementVisible(By.id("user-name"));
        softAssert.assertEquals("ROMAN IOVLEV", actualUserName.getText());

        // 5.  Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<WebElement> headerElements = getElementList(By
            .cssSelector("[class^='uui-navigation nav navbar'] > li > a"));

        softAssert.assertEquals(headerElements.size(), 4);

        List<String> headerItemsNameList = getTextList(headerElements);
        softAssert.assertEquals(testData.headerItemNameList, headerItemsNameList);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> imageElementList = getElementList(By.className("icons-benefit"));
        softAssert.assertEquals(imageElementList.size(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> imageTextList = getElementList(By.className("benefit-txt"));

        softAssert.assertEquals(imageTextList.size(), 4);

        List<String> imagesElementsTextList = getTextList(imageTextList);
        softAssert.assertEquals(testData.imageTextList, imagesElementsTextList);

        // 8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> iframeWithButtonList = getElementList(By.id("frame"));
        softAssert.assertEquals(iframeWithButtonList.size(), 1);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");

        List<WebElement> iframeButtonList = getElementList(By.id("frame-button"));
        softAssert.assertEquals(iframeButtonList.size(), 1);

        // 10. Switch to original window back
        webDriver.switchTo().parentFrame();
        softAssert.assertTrue(isThisHomePage());

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> leftMenuElementList = getElementList(By
            .cssSelector("[class='sidebar-menu left'] > li > a >  span:first-child"));


        softAssert.assertEquals(leftMenuElementList.size(), 5);

        List<String> leftMenuElements = getTextList(leftMenuElementList);
        softAssert.assertEquals(testData.leftMenuElementList, leftMenuElements);

        softAssert.assertAll();
    }
}

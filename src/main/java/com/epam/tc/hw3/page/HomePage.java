package com.epam.tc.hw3.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.epam.tc.hw3.util.ElementListHandler;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage<HomePage> {

    @FindBy(className = "icons-benefit")
    List<WebElement> imagesList;

    @FindBy(className = "benefit-txt")
    List<WebElement> imagesTextList;

    @FindBy(id = "frame")
    WebElement iframe;

    @FindBy(id = "frame-button")
    WebElement iframeButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage loginUser(String userName, String userPassword) {
        loginWindow.openLoginWindow();
        loginWindow.login(userName, userPassword);
        handle = webDriver.getWindowHandle();
        return this;
    }

    public boolean isImagesDisplayed() {
        return ElementListHandler.isAllDisplayed(wait, imagesList);
    }

    public List<String> getImagesTextList() {
        return ElementListHandler.getTextList(wait, imagesTextList);
    }

    public boolean isIframeDisplayed() {
        return wait.until(visibilityOf(iframe)).isDisplayed();
    }

    public HomePage switchToIframe() {
        webDriver = webDriver.switchTo().frame(iframe);
        return this;
    }

    public HomePage switchToHomePage() {
        webDriver = webDriver.switchTo().window(handle);
        return this;
    }

    public boolean isIframeButtonDisplayed() {
        return wait.until(visibilityOf(iframeButton)).isDisplayed();
    }
}

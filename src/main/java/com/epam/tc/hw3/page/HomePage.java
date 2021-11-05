package com.epam.tc.hw3.page;

import static com.epam.tc.hw3.util.ElementListHandler.getTextList;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "icons-benefit")
    private List<WebElement> imagesList;

    @FindBy(className = "benefit-txt")
    private List<WebElement> imagesTextList;

    @FindBy(id = "frame")
    private List<WebElement> iframe;

    @FindBy(id = "frame-button")
    private List<WebElement> iframeButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage loginUser(String userName, String userPassword) {
        loginWindow.openLoginWindow();
        loginWindow.login(userName, userPassword);
        return this;
    }

    public HomePage open(String url) {
        webDriver.get(url);
        return this;
    }

    public List<WebElement> getVisibleImagesDisplayed() {
        return  imagesList;
    }

    public List<String> getImagesTextList() {
        return getTextList(imagesTextList);
    }

    public List<WebElement> getVisibleIframeWithButton() {
        return iframe;
    }

    public HomePage switchToIframeWithButton() {
        webDriver.switchTo().frame(iframe.get(0));
        return this;
    }

    public HomePage switchToHomePage() {
        webDriver.switchTo().window(handle);
        return this;
    }

    public List<WebElement> getVisibleIframeButton() {
        return iframeButton;
    }

    public DifferentElementsPage getDifferentElementPage() {
        headerMenu.clickServiceElementItem("Different elements");
        return new DifferentElementsPage(webDriver);
    }
}

package com.epam.tc.hw3.page.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWindow extends AbstractComponent {

    @FindBy(css = ".profile-photo + .caret")
    private WebElement loginCaret;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//span[text()='Enter']")
    private WebElement loginEnterButton;

    @FindBy(id = "user-name")
    private WebElement userNameElement;

    public LoginWindow(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginWindow() {
        wait.until(visibilityOf(loginCaret)).click();
    }

    public void login(String userName, String userPassword) {
        wait.until(visibilityOf(loginField)).sendKeys(userName);
        passwordField.sendKeys(userPassword);
        loginEnterButton.click();
    }

    public String getUserName() {
        return userNameElement.getText();
    }
}


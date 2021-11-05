package com.epam.tc.hw3.page;

import com.epam.tc.hw3.page.component.AbstractComponent;
import com.epam.tc.hw3.page.component.HeaderMenu;
import com.epam.tc.hw3.page.component.LeftMenu;
import com.epam.tc.hw3.page.component.LoginWindow;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends AbstractComponent {

    protected LoginWindow loginWindow;
    protected HeaderMenu headerMenu;
    protected LeftMenu leftMenu;
    protected String handle;

    protected BasePage(WebDriver webDriver) {
        super(webDriver);
        loginWindow = new LoginWindow(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        leftMenu = new LeftMenu(webDriver);
        handle = webDriver.getWindowHandle();
        PageFactory.initElements(webDriver, this);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getUserName() {
        return loginWindow.getUserName();
    }

    public List<WebElement> getVisibleHeaderElements() {
        return headerMenu.getVisibleElements();
    }

    public List<String> getHeaderMenuElementNameList() {
        return headerMenu.getMenuElementNameList();
    }

    public List<WebElement> getLeftVisibleMenuElement() {
        return leftMenu.getLeftVisibleMenuElement();
    }

    public List<String> getLeftMenuElementNameList() {
        return leftMenu.getMenuElementNameList();
    }
}

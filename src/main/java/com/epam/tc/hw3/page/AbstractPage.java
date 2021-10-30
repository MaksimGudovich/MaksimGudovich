package com.epam.tc.hw3.page;

import com.epam.tc.hw3.page.component.AbstractComponent;
import com.epam.tc.hw3.page.component.HeaderMenu;
import com.epam.tc.hw3.page.component.LeftMenu;
import com.epam.tc.hw3.page.component.LoginWindow;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage<T> extends AbstractComponent {

    protected static final String BASE_URL = "https://jdi-testing.github.io";

    protected LoginWindow loginWindow;
    protected HeaderMenu headerMenu;
    protected LeftMenu leftMenu;
    protected String handle;

    protected AbstractPage(WebDriver webDriver) {
        super(webDriver);
        loginWindow = new LoginWindow(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        leftMenu = new LeftMenu(webDriver);
        handle = webDriver.getWindowHandle();
        PageFactory.initElements(webDriver, this);
    }

    public T open() {
        webDriver.get(BASE_URL);
        return (T) this;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getUserName() {
        return loginWindow.getUserName();
    }

    public boolean isHeaderElementsDisplayed() {
        return headerMenu.isAllElementsDisplayed();
    }

    public List<String> getHeaderMenuElementNameList() {
        return headerMenu.getMenuElementNameList();
    }

    public boolean isLeftMenuElementDisplayed() {
        return leftMenu.isMenuElementDisplayed();
    }

    public List<String> getLeftMenuElementNameList() {
        return leftMenu.getMenuElementNameList();
    }

    public T getDifferentElementPage() {
        headerMenu.clickServiceElementItem("Different elements");
        return (T) this;
    }
}

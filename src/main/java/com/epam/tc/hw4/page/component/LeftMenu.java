package com.epam.tc.hw4.page.component;

import static com.epam.tc.hw4.util.ElementListHandler.getTextList;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu extends AbstractComponent {

    @FindBy(css = "[class='sidebar-menu left'] > li > a span:first-child")
    private List<WebElement> leftMenuElements;

    public LeftMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getLeftVisibleMenuElement() {
        return leftMenuElements;
    }

    public List<String> getMenuElementNameList() {
        return getTextList(leftMenuElements);
    }
}

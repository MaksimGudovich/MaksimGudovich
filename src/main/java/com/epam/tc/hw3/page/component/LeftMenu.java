package com.epam.tc.hw3.page.component;

import com.epam.tc.hw3.util.ElementListHandler;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu extends AbstractComponent {

    @FindBy(css = "[class='sidebar-menu left'] > li > a span:first-child")
    List<WebElement> leftMenuElements;

    public LeftMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isMenuElementDisplayed() {
        return ElementListHandler.isAllDisplayed(wait, leftMenuElements);
    }

    public List<String> getMenuElementNameList() {
        return ElementListHandler.getTextList(wait, leftMenuElements);
    }
}

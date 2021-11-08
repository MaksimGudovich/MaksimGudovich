package com.epam.tc.hw3.page.component;

import static com.epam.tc.hw3.util.ElementListHandler.clickOnElementInList;
import static com.epam.tc.hw3.util.ElementListHandler.getTextList;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractComponent {

    @FindBy(css = "a.dropdown-toggle :only-child")
    private WebElement serviceButton;

    @FindBy(css = "[class^='uui-navigation nav navbar'] > li > a")
    private List<WebElement> headerMenuElementsList;

    @FindBy(css = "ul.dropdown-menu a:first-child")
    private List<WebElement> serviceItemList;

    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement differentElementsButton;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getVisibleElements() {
        return headerMenuElementsList;
    }

    public List<String> getMenuElementNameList() {
        return getTextList(headerMenuElementsList);
    }

    public void openServiceMenu() {
        serviceButton.click();
    }

    public void clickServiceElementItem(String buttonName) {
        openServiceMenu();
        clickOnElementInList(serviceItemList, buttonName);
    }
}

package com.epam.tc.hw3.page.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw3.util.ElementListHandler;
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

    public boolean isAllElementsDisplayed() {
        return ElementListHandler.isAllDisplayed(wait, headerMenuElementsList);
    }

    public List<String> getMenuElementNameList() {
        return ElementListHandler.getTextList(wait, headerMenuElementsList);
    }

    public void openServiceMenu() {
        wait.until(visibilityOf(serviceButton)).click();
    }

    public void clickServiceElementItem(String buttonName) {
        openServiceMenu();
        wait.until(visibilityOfAllElements(serviceItemList));

        for (WebElement serviceItem : serviceItemList
        ) {
            if (serviceItem.getText().equalsIgnoreCase(buttonName)) {
                serviceItem.click();
                break;
            }
        }
    }
}

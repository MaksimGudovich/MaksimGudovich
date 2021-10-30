package com.epam.tc.hw3.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.epam.tc.hw3.util.ElementListHandler;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends AbstractPage<DifferentElementsPage> {

    @FindBy(css = ".label-checkbox")
    List<WebElement> checkboxList;

    @FindBy(css = ".label-radio")
    List<WebElement> radioList;

    @FindBy(css = ".uui-form-element option")
    List<WebElement> dropdownList;

    @FindBy(css = "ul.panel-body-list.logs:first-child")
    WebElement lastLog;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DifferentElementsPage clickCheckbox(String checkboxName) {
        ElementListHandler.clickOnElementInList(wait, checkboxList, checkboxName);
        return this;
    }

    public DifferentElementsPage clickRadio(String radioName) {
        ElementListHandler.clickOnElementInList(wait, radioList, radioName);
        return this;
    }

    public DifferentElementsPage clickDropdown(String dropdownName) {
        ElementListHandler.clickOnElementInList(wait, dropdownList, dropdownName);
        return this;
    }

    public String getLastLog() {
        return wait.until(visibilityOf(lastLog)).getText();
    }
}

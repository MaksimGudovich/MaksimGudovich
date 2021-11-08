package com.epam.tc.hw4.page;

import static com.epam.tc.hw4.util.ElementListHandler.clickOnElementInList;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends BasePage {

    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxList;

    @FindBy(css = ".label-radio")
    private List<WebElement> radioList;

    @FindBy(css = ".uui-form-element option")
    private List<WebElement> dropdownList;

    @FindBy(css = "ul.panel-body-list.logs:first-child")
    private WebElement lastLog;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DifferentElementsPage clickCheckbox(String checkboxName) {
        clickOnElementInList(checkboxList, checkboxName);
        return this;
    }

    public DifferentElementsPage clickRadio(String radioName) {
        clickOnElementInList(radioList, radioName);
        return this;
    }

    public DifferentElementsPage clickDropdown(String dropdownName) {
        clickOnElementInList(dropdownList, dropdownName);
        return this;
    }

    public String getLastLog() {
        return lastLog.getText();
    }
}

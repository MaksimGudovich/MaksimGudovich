package com.epam.tc.hw5.page;

import static com.epam.tc.hw5.util.ElementListHandler.clickOnElementInList;

import com.epam.tc.hw5.util.ElementListHandler;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends BasePage {

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "tr td:first-child")
    List<WebElement> numberList;

    @FindBy(css = "td select")
    List<WebElement> typeList;

    @FindBy(css = "td a")
    List<WebElement> userList;

    @FindBy(css = "td span")
    List<WebElement> descriptionList;

    @FindBy(css = "td input")
    List<WebElement> checkboxList;

    @FindBy(xpath = "//*[text()='Roman']/ancestor::td/preceding-sibling::td/select/option")
    List<WebElement> droplistList;

    @FindBy(id = "ivan")
    WebElement sergeyIvanVipCheckbox;

    public List<WebElement> getNumberList() {
        return numberList;
    }

    public List<WebElement> getTypeList() {
        return typeList;
    }

    public List<WebElement> getUserList() {
        return userList;
    }

    public List<WebElement> getDescriptionList() {
        return descriptionList;
    }

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }

    public List<WebElement> getDroplistList() {
        return droplistList;
    }

    public void clickOnSergeyIvanVipCheckbox() {
        sergeyIvanVipCheckbox.click();
    }
}

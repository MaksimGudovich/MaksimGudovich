package com.epam.tc.hw5.page;

import static com.epam.tc.hw5.util.ElementListHandler.getTextList;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends BasePage {

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "tr td:first-child")
    private List<WebElement> numberList;

    @FindBy(css = "td select")
    private List<WebElement> typeList;

    @FindBy(css = "td a")
    private List<WebElement> userList;

    @FindBy(css = "td span")
    private List<WebElement> descriptionList;

    @FindBy(css = "td input")
    private List<WebElement> checkboxList;

    @FindBy(xpath = "//*[text()='Roman']/ancestor::td/preceding-sibling::td/select/option")
    private List<WebElement> droplistList;

    @FindBy(id = "ivan")
    private WebElement sergeyIvanVipCheckbox;

    public List<String> getNumberList() {
        return getTextList(numberList);
    }

    public List<WebElement> getTypeList() {
        return typeList;
    }

    public List<String> getUserList() {
        return getTextList(userList);
    }

    public List<String> getDescriptionList() {
        return getTextList(descriptionList);
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

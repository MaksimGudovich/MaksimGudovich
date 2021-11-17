package com.epam.tc.hw5.cucumber.step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class AssertionStep extends AbstractStep {

    @Then("1 log row has {string} text in Log section")
    public void checkLogInDifferentElementPageLogList(String log) {
        List<String> result = logList.getLogList()
                                     .stream()
                                     .filter(string -> string.contains(log))
                                     .collect(Collectors.toList());
        assertThat(result.size()).isEqualTo(1);
    }

    @Then("{string} page should be opened")
    public void checkPageTitle(String expectedTitle) {
        assertThat(basePage.getTitle()).isEqualToIgnoringCase(expectedTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkCountOfNumberTypeOnTablePage(int expectedNumber) {
        assertThat(userTablePage.getTypeList().size()).isEqualTo(expectedNumber);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkCountOfUsernamesOnTablePage(int expectedNumber) {
        assertThat(userTablePage.getUserList().size()).isEqualTo(expectedNumber);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkCountOfDescriptionsOnTablePage(int expectedNumber) {
        assertThat(userTablePage.getDescriptionList().size()).isEqualTo(expectedNumber);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkCountOfCheckboxOnTablePage(int expectedNumber) {
        assertThat(userTablePage.getCheckboxList().size()).isEqualTo(expectedNumber);
    }

    @Then("^User table should contain following values:$")
    public void checkUserTableData(DataTable tableData) {
        SoftAssert softAssert = new SoftAssert();
        List<Map<String, String>> expectedTableData = tableData.asMaps(String.class, String.class);

        softAssert.assertEquals(userTablePage.getNumberList(), getTableColumnList(expectedTableData, "Number"));
        softAssert.assertEquals(userTablePage.getUserList(), getTableColumnList(expectedTableData, "User"));
        softAssert.assertEquals(userTablePage
            .getDescriptionList(), getTableColumnList(expectedTableData, "Description"));

        softAssert.assertAll();
    }

    private List<String> getTableColumnList(List<Map<String, String>> table, String key) {
        List<String> tableColumn = new ArrayList<>();
        table.forEach(element -> tableColumn.add(element.get(key)));
        return tableColumn;
    }

    @Then("^droplist should contain value in column Type for user Roman$")
    public void checkDroplistOnTablePage(DataTable droplist) {
        List<String> expectedDroplistList = new ArrayList<>();
        droplist.asMaps(String.class, String.class)
                .forEach(s -> expectedDroplistList.add(s.get("Dropdown Values")));

        List<String> actualDroplistList = userTablePage.getDroplistList()
                                                       .stream()
                                                       .map(WebElement::getText)
                                                       .collect(Collectors.toList());
        assertThat(expectedDroplistList).isEqualTo(actualDroplistList);
    }
}

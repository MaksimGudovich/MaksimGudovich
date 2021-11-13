package com.epam.tc.hw5.cucumber.step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

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
        List<Map<String, String>> expectedTableData = tableData.asMaps(String.class, String.class);
        List<WebElement> numberList = userTablePage.getNumberList();
        List<WebElement> userList = userTablePage.getUserList();
        List<WebElement> descriptionList = userTablePage.getDescriptionList();
        boolean isTablesEquals = true;
        int counter = 0;
        try {
            for (Map<String, String> expectedRow : expectedTableData) {
                System.out.println(expectedRow);
                if (!expectedRow.get("Number").equals(numberList.get(counter).getText())
                    || !expectedRow.get("User").equals(userList.get(counter).getText())
                    || !expectedRow.get("Description").equals(descriptionList.get(counter).getText()
                                                                             .replaceAll("\n", " "))) {
                    isTablesEquals = false;
                    break;
                } else {
                    counter++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        assertThat(isTablesEquals).isTrue();
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

package com.epam.tc.hw3.util;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementListHandler {

    public static boolean isAllDisplayed(WebDriverWait wait, List<WebElement> elementList) {
        return wait.until(visibilityOfAllElements(elementList))
                   .stream()
                   .allMatch(WebElement::isDisplayed);
    }

    public static List<String> getTextList(WebDriverWait wait, List<WebElement> elementList) {
        return wait.until(visibilityOfAllElements(elementList))
                   .stream()
                   .map(WebElement::getText)
                   .collect(Collectors.toList());
    }

    public static void clickOnElementInList(WebDriverWait wait, List<WebElement> elementList, String checkboxName) {
        wait.until(visibilityOfAllElements(elementList));

        for (WebElement serviceItem : elementList
        ) {
            if (serviceItem.getText().equalsIgnoreCase(checkboxName)) {
                serviceItem.click();
                break;
            }
        }
    }
}

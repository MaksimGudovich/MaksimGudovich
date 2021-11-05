package com.epam.tc.hw3.util;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class ElementListHandler {

    public static List<String> getTextList(List<WebElement> elementList) {
        return elementList
                   .stream()
                   .map(WebElement::getText)
                   .collect(Collectors.toList());
    }

    public static void clickOnElementInList(List<WebElement> elementList, String elementName) {
        try {
            for (WebElement element : elementList) {
                if (element.getText().equalsIgnoreCase(elementName)) {
                    element.click();
                    break;
                }
            }
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException(String.format("Item '%s' is not acceptable", elementName));
        }
    }
}

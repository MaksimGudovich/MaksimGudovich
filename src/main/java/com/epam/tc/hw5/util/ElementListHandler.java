package com.epam.tc.hw5.util;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class ElementListHandler {

    public static List<String> getTextList(List<WebElement> elementList) {
        return elementList
            .stream()
            .map(webElement -> webElement.getText().replaceAll("\n", " "))
            .collect(Collectors.toList());
    }

    public static void clickOnElementInList(List<WebElement> elementList, String elementName) {
        WebElement requestElement = elementList.stream()
                                               .filter(element -> element.getText().equalsIgnoreCase(elementName))
                                               .findFirst()
                                               .orElseThrow(() -> new IllegalArgumentException(
                                                   String.format("Item '%s' is not acceptable", elementName)));
        requestElement.click();
    }
}

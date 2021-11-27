package com.epam.tc.hw7.custom;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;

public class VegetablesMultiDropdown extends UIElement {

    @UI("#vegetables .caret")
    private static WebElement expandCaret;

    @UI("#vegetables label")
    private static List<WebElement> valuesList;

    @UI("#vegetables .btn")
    private static Button selectedField;

    private static void expand() {
        expandCaret.click();
    }

    public static void select(List<String> values) {
        clean();
        selectList(values);
    }

    private static void clean() {
        List<String> selectedElements = Arrays.asList(selectedField.getText().split(", "));
        selectList(selectedElements);
    }

    private static void selectList(List<String> valuesToSelect) {
        expand();
        valuesList.stream()
                  .filter(element -> valuesToSelect.contains(element.getText()))
                  .forEach(WebElement::click);
    }
}


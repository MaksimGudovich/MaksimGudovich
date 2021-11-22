package com.epam.tc.hw7.section;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.entities.MetalsAndColorsData;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class ResultSection extends Section {

    @UI(".panel-body-list.results li")
    public static List<WebElement> results;

    private static String getResultString() {
        return results.stream()
            .map(element -> element.getText())
            .collect(Collectors.joining(" "));
    }

    public static boolean checkResult(MetalsAndColorsData data) {
        String expectedResults = String.format("Summary: %d Elements: %s Color: %s Metal: %s Vegetables: %s",
            Integer.parseInt(data.summary.get(0)) + Integer.parseInt(data.summary.get(1)),
            String.join(", ", data.elements),
            data.color,
            data.metals,
            String.join(", ", data.vegetables)
        );

        return getResultString().equals(expectedResults);
    }
}

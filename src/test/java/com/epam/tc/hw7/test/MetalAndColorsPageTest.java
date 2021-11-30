package com.epam.tc.hw7.test;

import static com.epam.tc.hw7.entities.HeaderMenu.MetalsAndColors;
import static com.epam.tc.hw7.page.HomePage.headerMenu;
import static com.epam.tc.hw7.page.MetalsAndColorsPage.metalAndColorForm;
import static com.epam.tc.hw7.step.MetalColorAssertionStep.validateResultsOnMetalAndColorPage;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.TestInit;
import com.epam.tc.hw7.dataprovider.MetalColorDataProvider;
import com.epam.tc.hw7.entities.MetalsAndColorsData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MetalAndColorsPageTest implements TestInit {

    @BeforeMethod
    public void setup() {
        headerMenu.select(MetalsAndColors);
        WebPage.checkUrl("https://jdi-testing.github.io/jdi-light/metals-colors.html");
    }

    @Test(dataProviderClass = MetalColorDataProvider.class, dataProvider = "Metals & Colors Data Provider From json")
    public void submitMetalsAndColorsFormTest(MetalsAndColorsData metalsAndColorsData) {
        metalAndColorForm.submit(metalsAndColorsData);
        validateResultsOnMetalAndColorPage(metalsAndColorsData);
    }
}

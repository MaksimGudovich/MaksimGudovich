package com.epam.tc.hw7.section;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.custom.VegetablesMultiDropdown;
import com.epam.tc.hw7.entities.MetalsAndColorsData;

public class MetalAndColorForm extends Form<MetalsAndColorsData> {

    @Css("#summary-block input")
    public static RadioButtons summary;

    @JDropdown(root = "#colors",
               list = "li",
               expand = ".caret")
    public static Dropdown colors;

    @UI("#metals input")
    public static DataListOptions metals;

    public static VegetablesMultiDropdown vegetables;

    @UI(".checkbox input")
    public static Checklist elements;

    @UI("['Submit']")
    public static Button submitMetalColor;

    @Override
    public void submit(MetalsAndColorsData data) {
        summary.select(data.summary.get(0), data.summary.get(1));
        elements.select(data.elements.toArray(new String[] {}));
        colors.select(data.color);
        metals.select(data.metals);
        VegetablesMultiDropdown.select(data.vegetables);
        submitMetalColor.click();
    }

}

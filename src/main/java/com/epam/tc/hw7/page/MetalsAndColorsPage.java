package com.epam.tc.hw7.page;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.section.MetalAndColorForm;
import com.epam.tc.hw7.section.ResultSection;

@Url("/metals-colors.html")
@Title("Metals & Colors")
public class MetalsAndColorsPage extends WebPage {

    @UI(".main-content-hg")
    public static MetalAndColorForm metalAndColorForm;


    public static ResultSection results;

}

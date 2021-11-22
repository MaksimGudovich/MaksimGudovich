package com.epam.tc.hw7;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.page.HomePage;
import com.epam.tc.hw7.page.MetalsAndColorsPage;
import com.epam.tc.hw7.section.UserLoginForm;

public class SiteJdi {

    public static HomePage homePage;


    public static MetalsAndColorsPage metalsAndColorsPage;

    public static UserLoginForm loginForm;

    @UI(".uui-navigation.nav li")
    public static Menu headerMenu;

    @UI("#user-icon")
    public static UIElement userIcon;

    @UI("#user-name")
    public static UIElement userName;
}

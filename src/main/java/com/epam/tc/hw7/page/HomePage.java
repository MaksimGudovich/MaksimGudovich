package com.epam.tc.hw7.page;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.section.UserLoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    public static UserLoginForm loginForm;

    @UI(".uui-navigation.nav li")
    public static Menu headerMenu;

    @UI("#user-icon")
    public static UIElement userIcon;

    @UI("#user-name")
    public static UIElement userName;
}

package com.epam.tc.hw7.section;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.User;

public class UserLoginForm extends Form<User> {

    @UI("#name")
    public static TextField name;

    @UI("#password")
    public static TextField password;

    @UI("#login-button")
    public static Button loginButton;
}

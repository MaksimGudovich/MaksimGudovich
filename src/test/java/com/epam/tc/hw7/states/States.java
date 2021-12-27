package com.epam.tc.hw7.states;

import static com.epam.tc.hw7.SiteJdi.homePage;
import static com.epam.tc.hw7.page.HomePage.loginForm;
import static com.epam.tc.hw7.page.HomePage.userIcon;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.entities.User;

public class States {

    public static void loggedIn() {
        onSite();
        userIcon.click();
        loginForm.submit(new User(), "enter");
    }

    private static void onSite() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/")) {
            homePage.open();
        }
    }

}

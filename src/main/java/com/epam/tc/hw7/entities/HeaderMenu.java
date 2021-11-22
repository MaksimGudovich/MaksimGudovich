package com.epam.tc.hw7.entities;

public enum HeaderMenu {
    Home("Home"),
    ContactForm("Contact Form"),
    Service("Service"),
    MetalsAndColors("Metals & Colors");

    public String value;

    HeaderMenu(String value) {
        this.value = value;
    }
}

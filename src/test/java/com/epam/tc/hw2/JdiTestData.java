package com.epam.tc.hw2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class JdiTestData {

    public String jdiURL;
    public String userName;
    public String userPassword;
    public List<String> headerItemNameList = Arrays
        .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    public List<String> imageTextList =
        Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    public List<String> leftMenuElementList = Arrays
        .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

    public JdiTestData() {
        setup();
    }

    private void setup() {
        Properties properties = new Properties();
        try (
            FileInputStream fis = new FileInputStream("src/test/resources/testDada.properties")) {
            properties.load(fis);
            jdiURL = properties.getProperty("jdiURL");
            userName = properties.getProperty("userName");
            userPassword = properties.getProperty("userPassword");
        } catch (IOException e) {
            System.err.println("File don't exist");
        }
    }
}

package com.epam.tc.hw3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class JdiTestData {

    private static String jdiURL;
    private static String userName;
    private static String userPassword;

    private static String homePageTitle;
    private static List<String> headerItemNameList;
    private static List<String> imageTextList;
    private static List<String> leftMenuElementList;

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
        homePageTitle = "Home Page";
        headerItemNameList = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        imageTextList =
            Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        leftMenuElementList = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    }

    public static String getTestJdiURL() {
        return jdiURL;
    }

    public static String getTestUserName() {
        return userName;
    }

    public static String getTestUserPassword() {
        return userPassword;
    }

    public static String getExpectedHomePageTitle() {
        return homePageTitle;
    }

    public static List<String> getExpectedHeaderItemNameList() {
        return headerItemNameList;
    }

    public static List<String> getExpectedImageTextList() {
        return imageTextList;
    }

    public static List<String> getExpectedLeftMenuElementList() {
        return leftMenuElementList;
    }
}

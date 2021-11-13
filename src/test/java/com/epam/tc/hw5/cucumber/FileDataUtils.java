package com.epam.tc.hw5.cucumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileDataUtils {

    public static final String JDI_URL;
    public static final String USER_NAME;
    public static final String USER_PASSWORD;

    static {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/testDada.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("File don't exist");
        }
        JDI_URL = properties.getProperty("jdiURL");
        USER_NAME = properties.getProperty("userName");
        USER_PASSWORD = properties.getProperty("userPassword");
    }
}

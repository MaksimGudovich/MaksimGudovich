package com.epam.tc.hw9api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/trello.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("File don't exist");
        }
    }
}

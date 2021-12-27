package com.epam.tc.hw9api.constants;

import static com.epam.tc.hw9api.utils.PropertiesReader.properties;

public class Constants {

    public static final String BOARDS_URI = "1/boards/";
    public static final String ALL_BOARDS_URI = "1/members/me/boards";
    public static final String LISTS_URI = "1/lists/";

    public static final String BASE_URI = properties.getProperty("baseUrl");
    public static final String API_KEY_VALUE = properties.getProperty("apiKey");
    public static final String API_TOKEN_VALUE = properties.getProperty("token");


    public static final String KEY = "key";
    public static final String TOKEN = "token";

    public static final String NAME = "name";
    public static final String ID = "id";
    public static String BOARD_ID = "idBoard";


}

package com.epam.tc.hw9petstore.constants;

import com.epam.tc.hw9petstore.utils.PropertiesReader;

public class Constants {

    public static final String BASE_PETSHOP_URI = PropertiesReader.properties.getProperty("petstoreUrl");

    public static final String PET_URI = "/pet";
    public static final String ORDER_URI = "/store/order";

    public static final String ID = "id";


}

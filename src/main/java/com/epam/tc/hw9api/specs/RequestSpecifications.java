package com.epam.tc.hw9api.specs;

import static com.epam.tc.hw9api.constants.Constants.API_KEY_VALUE;
import static com.epam.tc.hw9api.constants.Constants.API_TOKEN_VALUE;
import static com.epam.tc.hw9api.constants.Constants.BASE_URI;
import static com.epam.tc.hw9api.constants.Constants.KEY;
import static com.epam.tc.hw9api.constants.Constants.TOKEN;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .addQueryParam(KEY, API_KEY_VALUE)
            .addQueryParam(TOKEN, API_TOKEN_VALUE)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build();
    }




}

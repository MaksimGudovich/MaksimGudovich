package com.epam.tc.hw9petstore.core.serviseobject;

import static com.epam.tc.hw9petstore.constants.Constants.BASE_PETSHOP_URI;
import static io.restassured.RestAssured.given;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Map;

public class BasePetstoreServiceObject {

    protected Method requestMethod;
    protected Map<String, String> pathParams;

    public BasePetstoreServiceObject(Method requestMethod,
                                     Map<String, String> pathParams) {
        this.requestMethod = requestMethod;
        this.pathParams = pathParams;
    }

    public static RequestSpecification requestSpecification() {
        return given()
            .baseUri(BASE_PETSHOP_URI)
            .accept(ContentType.JSON);
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    }

    public String getPathParamString() {
        String pathParamString = "";
        for (String value : pathParams.keySet()) {
            pathParamString += "{" + value + "}/";
        }
        return pathParamString;
    }
}

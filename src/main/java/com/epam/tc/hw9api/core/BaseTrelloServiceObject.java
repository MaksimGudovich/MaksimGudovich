package com.epam.tc.hw9api.core;

import static com.epam.tc.hw9api.specs.RequestSpecifications.requestSpecification;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;

public class BaseTrelloServiceObject {

    protected Method requestMethod;
    protected Map<String, String> queryParams;
    protected Map<String, String> pathParams;

    public BaseTrelloServiceObject(Method requestMethod, Map<String, String> queryParams,
                                   Map<String, String> pathParams) {
        this.requestMethod = requestMethod;
        this.queryParams = queryParams;
        this.pathParams = pathParams;
    }

    public Response sendRequest(String basePath) {
        return RestAssured
            .given(requestSpecification())
            .log().all()
            .basePath(basePath)
            .pathParams(pathParams)
            .queryParams(queryParams)
            .request(requestMethod, getPathParamString())
            .prettyPeek();
    }

    public String getPathParamString() {
        String pathParamString = "";
        for (String value : pathParams.keySet()) {
            pathParamString += "{" + value + "}/";
        }
        return pathParamString;
    }
}

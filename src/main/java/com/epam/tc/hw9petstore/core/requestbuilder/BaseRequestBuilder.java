package com.epam.tc.hw9petstore.core.requestbuilder;

import io.restassured.http.Method;
import java.util.HashMap;
import java.util.Map;

public class BaseRequestBuilder {

    protected Method requestMethod = Method.GET;
    protected Map<String, String> pathParams = new HashMap<>();

}

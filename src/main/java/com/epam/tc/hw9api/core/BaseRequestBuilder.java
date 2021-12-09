package com.epam.tc.hw9api.core;

import static com.epam.tc.hw9api.constants.Constants.ID;
import static com.epam.tc.hw9api.constants.Constants.NAME;

import io.restassured.http.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequestBuilder<T extends BaseTrelloServiceObject, B extends BaseRequestBuilder> {

    protected Method requestMethod = Method.GET;
    protected Map<String, String> queryParams = new HashMap<>();
    protected Map<String, String> pathParams = new HashMap<>();

    public B setMethod(Method method) {
        requestMethod = method;
        return (B) this;
    }

    public B setId(String id) {
        pathParams.put(ID, id);
        return (B) this;
    }

    public B setName(String name) {
        queryParams.put(NAME, name);
        return (B) this;
    }

    public abstract T buildRequest();
}

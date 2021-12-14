package com.epam.tc.hw9petstore.core.requestbuilder;

import static com.epam.tc.hw9petstore.constants.Constants.ID;

import com.epam.tc.hw9petstore.core.serviseobject.OrderServiceObject;
import io.restassured.http.Method;

public class OrderRequestBuilder extends BaseRequestBuilder {

    public OrderRequestBuilder setMethod(Method method) {
        requestMethod = method;
        return this;
    }

    public OrderRequestBuilder setId(String id) {
        pathParams.put(ID, id);
        return this;
    }

    public OrderServiceObject buildRequest() {
        return new OrderServiceObject(requestMethod, pathParams);
    }
}

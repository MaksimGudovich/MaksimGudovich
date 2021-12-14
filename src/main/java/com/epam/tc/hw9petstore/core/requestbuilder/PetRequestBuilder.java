package com.epam.tc.hw9petstore.core.requestbuilder;

import static com.epam.tc.hw9petstore.constants.Constants.ID;

import com.epam.tc.hw9petstore.core.serviseobject.PetServiceObject;
import io.restassured.http.Method;

public class PetRequestBuilder extends BaseRequestBuilder {

    public PetRequestBuilder setMethod(Method method) {
        requestMethod = method;
        return this;
    }

    public PetRequestBuilder setId(String id) {
        pathParams.put(ID, id);
        return this;
    }


    public PetServiceObject buildRequest() {
        return new PetServiceObject(requestMethod, pathParams);
    }


}

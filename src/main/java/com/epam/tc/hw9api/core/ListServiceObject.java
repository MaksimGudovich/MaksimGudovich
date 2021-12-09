package com.epam.tc.hw9api.core;

import static com.epam.tc.hw9api.constants.Constants.BOARD_ID;
import static com.epam.tc.hw9api.constants.Constants.LISTS_URI;

import com.epam.tc.hw9api.beans.ListTrello;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

public class ListServiceObject extends BaseTrelloServiceObject {

    public ListServiceObject(Method requestMethod,
                             Map<String, String> queryParams,
                             Map<String, String> pathParams) {
        super(requestMethod, queryParams, pathParams);
    }

    public static ListRequestBuilder requestBuilder() {
        return new ListRequestBuilder();
    }

    public static ListTrello getListInstance(ValidatableResponse response) {
        return response.extract().body().as(ListTrello.class);
    }

    public Response sendListRequest() {
        return sendRequest(LISTS_URI);
    }

    public static class ListRequestBuilder extends BaseRequestBuilder<ListServiceObject, ListRequestBuilder> {

        public ListRequestBuilder setBoardId(String id) {
            queryParams.put(BOARD_ID, id);
            return this;
        }

        @Override
        public ListServiceObject buildRequest() {
            return new ListServiceObject(requestMethod, queryParams, pathParams);
        }
    }
}

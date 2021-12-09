package com.epam.tc.hw9api.step;

import static com.epam.tc.hw9api.constants.Constants.LISTS_URI;
import static com.epam.tc.hw9api.core.ListServiceObject.getListInstance;
import static com.epam.tc.hw9api.core.ListServiceObject.requestBuilder;
import static com.epam.tc.hw9api.specs.ResponseSpecifications.goodResponseSpecification;

import com.epam.tc.hw9api.beans.BoardTrello;
import com.epam.tc.hw9api.beans.ListTrello;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;

public class ListStep {

    @Step("Create list")
    public static ListTrello createList(ListTrello list, BoardTrello board) {
        ValidatableResponse response = requestBuilder()
            .setMethod(Method.POST)
            .setName(list.getName())
            .setBoardId(board.getId())
            .buildRequest()
            .sendListRequest()
            .then();

        response.assertThat().spec(goodResponseSpecification());

        return getListInstance(response);
    }

    @Step("Change list name")
    public static ListTrello changeListName(ListTrello list, String name) {
        ValidatableResponse response = requestBuilder()
            .setMethod(Method.PUT)
            .setId(list.getId())
            .setName(name)
            .buildRequest()
            .sendRequest(LISTS_URI)
            .then();

        response.assertThat().spec(goodResponseSpecification());

        return getListInstance(response);
    }

}

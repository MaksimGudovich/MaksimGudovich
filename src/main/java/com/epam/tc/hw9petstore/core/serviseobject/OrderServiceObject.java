package com.epam.tc.hw9petstore.core.serviseobject;

import static com.epam.tc.hw9petstore.constants.Constants.ORDER_URI;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9petstore.bean.Order;
import com.epam.tc.hw9petstore.core.requestbuilder.OrderRequestBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

public class OrderServiceObject extends BasePetstoreServiceObject {

    public OrderServiceObject(Method requestMethod,
                              Map<String, String> pathParams) {
        super(requestMethod, pathParams);
    }

    public static OrderRequestBuilder requestOrderBuilder() {
        return new OrderRequestBuilder();
    }

    public Response sendOrderIdRequest() {
        return given()
            .spec(requestSpecification())
            .contentType(ContentType.JSON)
            .log().all()
            .basePath(ORDER_URI)
            .pathParams(pathParams)
            .request(requestMethod, getPathParamString())
            .prettyPeek();
    }

    public Response sendOrderJsonRequest(Order order) {
        return given()
            .spec(requestSpecification())
            .contentType(ContentType.JSON)
            .body(order)
            .log().all()
            .basePath(ORDER_URI)
            .request(requestMethod, getPathParamString())
            .prettyPeek();
    }

    public static Order getOrderInstance(ValidatableResponse response) {
        return response.extract().as(Order.class);
    }
}

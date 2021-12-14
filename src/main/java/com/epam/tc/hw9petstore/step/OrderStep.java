package com.epam.tc.hw9petstore.step;

import static com.epam.tc.hw9petstore.core.serviseobject.BasePetstoreServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9petstore.core.serviseobject.OrderServiceObject.requestOrderBuilder;

import com.epam.tc.hw9petstore.bean.Order;
import com.epam.tc.hw9petstore.constants.OrderStatus;
import com.epam.tc.hw9petstore.core.serviseobject.OrderServiceObject;
import io.qameta.allure.Step;
import io.restassured.http.Method;

public class OrderStep {

    @Step("Create order")
    public static Order createOrder(String petId) {

        Order order = new Order();
        order.setPetId(petId);
        order.setQuantity(((int) (Math.random() * 99)) + "");
        order.setStatus(OrderStatus.PLACED.value);

        return OrderServiceObject.getOrderInstance(
            requestOrderBuilder()
                .setMethod(Method.POST)
                .buildRequest()
                .sendOrderJsonRequest(order)
                .then()
                .spec(goodResponseSpecification()));
    }
}

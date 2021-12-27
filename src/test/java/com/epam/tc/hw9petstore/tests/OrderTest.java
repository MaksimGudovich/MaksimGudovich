package com.epam.tc.hw9petstore.tests;

import static com.epam.tc.hw9petstore.core.serviseobject.BasePetstoreServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9petstore.core.serviseobject.OrderServiceObject.requestOrderBuilder;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.epam.tc.hw9petstore.bean.Order;
import com.epam.tc.hw9petstore.bean.Pet;
import com.epam.tc.hw9petstore.constants.OrderStatus;
import com.epam.tc.hw9petstore.core.serviseobject.OrderServiceObject;
import com.epam.tc.hw9petstore.step.OrderStep;
import com.epam.tc.hw9petstore.step.PetStep;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.testng.annotations.Test;

public class OrderTest {

    @Test(description = "Add new order test")
    public void createOrderTest() {
        Order order = new Order();
        order.setPetId(((int) (Math.random() * 999999)) + "");
        order.setQuantity(((int) (Math.random() * 99)) + "");
        order.setStatus(OrderStatus.PLACED.value);

        Order receivedOrder = OrderServiceObject.getOrderInstance(
            requestOrderBuilder()
                .setMethod(Method.POST)
                .buildRequest()
                .sendOrderJsonRequest(order)
                .then()
                .spec(goodResponseSpecification()));

        assertThat(Arrays.asList(receivedOrder.getPetId(), receivedOrder.getStatus(), receivedOrder.getQuantity()),
            equalTo(Arrays.asList(order.getPetId(), order.getStatus(), order.getQuantity())));
    }

    @Test(description = "Find order by id test")
    public void findOrderByIdTest() {
        Pet testPet = PetStep.createPet();
        Order testOrder = OrderStep.createOrder(testPet.getId());

        Awaitility.await().atMost(60, TimeUnit.SECONDS).pollInterval(5, TimeUnit.SECONDS)
                  .untilAsserted(() -> {
                      Order receivedOrder = OrderServiceObject.getOrderInstance(
                          requestOrderBuilder()
                              .setMethod(Method.GET)
                              .setId(testOrder.getId())
                              .buildRequest()
                              .sendOrderIdRequest()
                              .then()
                              .spec(goodResponseSpecification()));

                      assertThat(receivedOrder.getPetId()).isEqualTo(testPet.getId());
                  });
    }

    @Test(description = "Delete order by id test")
    public void deleteTest() {
        Order order = OrderStep.createOrder(((int) (Math.random() * 9)) + "");

        Awaitility.await().atMost(60, TimeUnit.SECONDS).pollInterval(5, TimeUnit.SECONDS)
                  .untilAsserted(() -> {
                      OrderServiceObject.getOrderInstance(
                          requestOrderBuilder()
                              .setMethod(Method.DELETE)
                              .setId(order.getId())
                              .buildRequest()
                              .sendOrderIdRequest()
                              .then()
                              .contentType(ContentType.JSON)
                              .body("message", equalTo(order.getId())));
                  });
    }
}

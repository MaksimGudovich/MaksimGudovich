package com.epam.tc.hw9petstore.tests;

import static com.epam.tc.hw9petstore.core.serviseobject.BasePetstoreServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9petstore.core.serviseobject.OrderServiceObject.requestOrderBuilder;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTest {

    private Pet pet;

    @BeforeMethod
    public void setup() {
        pet = PetStep.createPet();
    }

    @Test(description = "Add new order test")
    public void createOrderTest() {
        Order order = new Order();
        order.setPetId(pet.getId());
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

    // Petstore only returns a random object, not a created one
    @Test(description = "Find order by id test")
    public void findOrderByIdTest() {
        Order order = OrderStep.createOrder(pet.getId());

        OrderServiceObject.getOrderInstance(
            requestOrderBuilder()
                .setMethod(Method.GET)
                .setId(order.getId())
                .buildRequest()
                .sendOrderIdRequest()
                .then()
                .contentType(ContentType.JSON));
    }

    @Test(description = "Delete order by id test")
    public void deleteTest() {
        Order order = OrderStep.createOrder(pet.getId());

        OrderServiceObject.getOrderInstance(
            requestOrderBuilder()
                .setMethod(Method.DELETE)
                .setId(order.getId())
                .buildRequest()
                .sendOrderIdRequest()
                .then()
                .contentType(ContentType.JSON)
                .body("message", equalTo(order.getId())));
    }
}

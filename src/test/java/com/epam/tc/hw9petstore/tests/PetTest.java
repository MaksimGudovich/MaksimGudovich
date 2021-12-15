package com.epam.tc.hw9petstore.tests;

import static com.epam.tc.hw9petstore.core.serviseobject.BasePetstoreServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9petstore.core.serviseobject.PetServiceObject.requestPetBuilder;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.epam.tc.hw9petstore.bean.Pet;
import com.epam.tc.hw9petstore.constants.PetStatus;
import com.epam.tc.hw9petstore.core.serviseobject.PetServiceObject;
import com.epam.tc.hw9petstore.step.PetStep;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.RandomStringUtils;
import org.awaitility.Awaitility;
import org.testng.annotations.Test;

public class PetTest {

    @Test(description = "Pet creation test")
    public void createPetTest() {

        Pet pet = new Pet();
        pet.setName(RandomStringUtils.randomAlphabetic(10));
        pet.setStatus(PetStatus.AVAILABLE.value);

        Pet receivedPet = PetServiceObject.getPetInstance(
            requestPetBuilder()
                .setMethod(Method.POST)
                .buildRequest()
                .sendPetJsonRequest(pet)
                .then()
                .spec(goodResponseSpecification()));

        assertThat(Arrays.asList(receivedPet.getName(), receivedPet.getStatus()),
            equalTo(Arrays.asList(pet.getName(), pet.getStatus())));
    }

    @Test(description = "Change pet name test")
    public void changeNameTest() {

        Pet testPet = PetStep.createPet();

        Pet updatePet = new Pet();
        updatePet.setId(testPet.getId());
        updatePet.setName(RandomStringUtils.randomAlphabetic(10));

        Pet receivedPet = PetServiceObject.getPetInstance(
            requestPetBuilder()
                .setMethod(Method.PUT)
                .buildRequest()
                .sendPetJsonRequest(updatePet)
                .then()
                .spec(goodResponseSpecification()));

        assertThat(updatePet.getName()).isEqualTo(receivedPet.getName());
    }

    @Test(description = "Change pet status test")
    public void changeStatusTest() {

        Pet testPet = PetStep.createPet();

        Pet updatedPet = new Pet();
        updatedPet.setId(testPet.getId());
        updatedPet.setStatus(PetStatus.SOLD.value);

        Pet receivedPet = PetServiceObject.getPetInstance(
            requestPetBuilder()
                .setMethod(Method.PUT)
                .buildRequest()
                .sendPetJsonRequest(updatedPet)
                .then()
                .spec(goodResponseSpecification()));

        assertThat(receivedPet.getStatus()).isEqualTo(PetStatus.SOLD.value);
    }

    @Test(description = "Get pet test")
    public void getPetTest() {
        Pet testPet = PetStep.createPet();
        //        Waiter.wait(60000);

        Awaitility.await().atMost(60, TimeUnit.SECONDS).pollInterval(5, TimeUnit.SECONDS)
                  .untilAsserted(() -> {
                      final Pet receivedPet = PetServiceObject.getPetInstance(
                          requestPetBuilder()
                              .setMethod(Method.GET)
                              .setId(testPet.getId())
                              .buildRequest()
                              .sendPetIdRequest()
                              .then()
                              .spec(goodResponseSpecification()));

                      assertThat(receivedPet.getName()).isEqualTo(testPet.getName());
                  });
    }
}

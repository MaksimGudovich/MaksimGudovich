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
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import java.util.Arrays;
import org.apache.commons.lang.RandomStringUtils;
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

        Pet updatePet = new Pet();
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

        Pet updatedPet = new Pet();
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

    // Petstore only returns a random object, not a created one
    @Test(description = "Change pet status test")
    public void getPetTest() {
        Pet createdPet = PetStep.createPet();

        PetServiceObject.getPetInstance(
            requestPetBuilder()
                .setMethod(Method.GET)
                .setId(createdPet.getId())
                .buildRequest()
                .sendPetIdRequest()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON));
    }
}

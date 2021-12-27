package com.epam.tc.hw9petstore.step;

import static com.epam.tc.hw9petstore.core.serviseobject.BasePetstoreServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9petstore.core.serviseobject.PetServiceObject.requestPetBuilder;

import com.epam.tc.hw9petstore.bean.Pet;
import com.epam.tc.hw9petstore.constants.PetStatus;
import com.epam.tc.hw9petstore.core.serviseobject.PetServiceObject;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import org.apache.commons.lang.RandomStringUtils;

public class PetStep {

    @Step("Creation pet")
    public static Pet createPet() {
        Pet pet = new Pet();
        pet.setId(((int) (Math.random() * 999999)) + "");
        pet.setName(RandomStringUtils.randomAlphabetic(10));
        pet.setStatus(PetStatus.AVAILABLE.value);

        return PetServiceObject.getPetInstance(
            requestPetBuilder()
                .setMethod(Method.POST)
                .buildRequest()
                .sendPetJsonRequest(pet)
                .then()
                .spec(goodResponseSpecification()));
    }
}

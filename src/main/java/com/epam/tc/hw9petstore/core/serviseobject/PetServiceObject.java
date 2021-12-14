package com.epam.tc.hw9petstore.core.serviseobject;

import static com.epam.tc.hw9petstore.constants.Constants.PET_URI;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9petstore.bean.Pet;
import com.epam.tc.hw9petstore.core.requestbuilder.PetRequestBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

public class PetServiceObject extends BasePetstoreServiceObject {

    public PetServiceObject(Method requestMethod,
                            Map<String, String> pathParams) {
        super(requestMethod, pathParams);
    }

    public static PetRequestBuilder requestPetBuilder() {
        return new PetRequestBuilder();
    }

    public Response sendPetIdRequest() {
        return given()
            .spec(requestSpecification())
            .contentType(ContentType.JSON)
            .log().all()
            .basePath(PET_URI)
            .pathParams(pathParams)
            .request(requestMethod, getPathParamString())
            .prettyPeek();
    }

    public Response sendPetJsonRequest(Pet pet) {
        return given()
            .spec(requestSpecification())
            .contentType(ContentType.JSON)
            .body(pet)
            .log().all()
            .basePath(PET_URI)
            .request(requestMethod, getPathParamString())
            .prettyPeek();
    }

    public static Pet getPetInstance(ValidatableResponse response) {
        return response.extract().as(Pet.class);
    }
}

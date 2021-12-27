package com.epam.tc.hw9petstore.constants;

public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    public String value;

    PetStatus(String value) {
        this.value = value;
    }
}

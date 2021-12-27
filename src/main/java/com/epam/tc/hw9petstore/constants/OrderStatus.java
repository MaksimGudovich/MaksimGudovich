package com.epam.tc.hw9petstore.constants;

public enum OrderStatus {

    PLACED("placed"),
    CLOSED("closed");

    public String value;

    OrderStatus(String value) {
        this.value = value;
    }
}

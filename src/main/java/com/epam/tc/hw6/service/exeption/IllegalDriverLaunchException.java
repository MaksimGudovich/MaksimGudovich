package com.epam.tc.hw6.service.exeption;

public class IllegalDriverLaunchException extends IllegalArgumentException {

    public IllegalDriverLaunchException() {
        super("Illegal launch type. Supported launch types are local or remote");
    }
}

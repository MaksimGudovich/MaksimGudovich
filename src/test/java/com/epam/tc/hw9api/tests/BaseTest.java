package com.epam.tc.hw9api.tests;

import static com.epam.tc.hw9api.step.BoardStep.deleteAllBoards;

import org.testng.annotations.AfterMethod;

public class BaseTest {

    @AfterMethod
    public void tearDown() {
        deleteAllBoards();
    }
}

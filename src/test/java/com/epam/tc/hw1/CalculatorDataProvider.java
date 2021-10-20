package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider(name = "Sum Test Data")
    public static Object[][] sumDataProvider() {
        return new Object[][] {
            {0, 5, 5},
            {-2, 3, 1},
            {300, 6000, 6300}
        };
    }

    @DataProvider(name = "Subtract Test Data")
    public static Object[][] subtractDataProvider() {
        return new Object[][] {
            {5, 5, 0},
            {111, 120, -9},
            {3000, 2500, 500}
        };
    }

    @DataProvider(name = "Multiply Test Data")
    public static Object[][] multiplyDataProvider() {
        return new Object[][] {
            {5, 5, 25},
            {0, 120, 0},
            {-2, 9, -18},
            {3000, 100, 300000}
        };
    }

    @DataProvider(name = "Divide Test Data")
    public static Object[][] divideDataProvider() {
        return new Object[][] {
            {5, 5, 1},
            {10, 5, 2},
            {3000, 100, 30}
        };
    }
}

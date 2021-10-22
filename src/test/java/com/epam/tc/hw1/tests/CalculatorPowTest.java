package com.epam.tc.hw1.tests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.testdata.CalculatorDataProvider;
import org.testng.annotations.Test;

public class CalculatorPowTest extends CalculatorBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Pow Test Data")
    public void powTest(long a, long b, long expected) {
        double actual = calculator.pow(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

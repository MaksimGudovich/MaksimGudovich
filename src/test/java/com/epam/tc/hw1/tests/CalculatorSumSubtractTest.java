package com.epam.tc.hw1.tests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.testdata.CalculatorDataProvider;
import org.testng.annotations.Test;

public class CalculatorSumSubtractTest extends CalculatorBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Sum Test Data")
    public void sumTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Subtract Test Data")
    public void subtractTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

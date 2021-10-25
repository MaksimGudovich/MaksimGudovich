package com.epam.tc.hw1.tests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.testdata.CalculatorDataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyDivideTest extends CalculatorBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Multiply Test Data")
    public void multiplyTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Divide Test Data")
    public void divideTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(expectedExceptions = NumberFormatException.class,
          expectedExceptionsMessageRegExp = "Attempt to divide by zero")
    public void divideByNullTest() {
        calculator.div(1, 0);
    }
}

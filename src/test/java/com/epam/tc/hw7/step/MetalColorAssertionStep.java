package com.epam.tc.hw7.step;

import static com.epam.tc.hw7.section.ResultSection.validateResult;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw7.entities.MetalsAndColorsData;

public class MetalColorAssertionStep {

    public static void validateResultsOnMetalAndColorPage(MetalsAndColorsData data) {
        assertTrue(validateResult(data));
    }

}

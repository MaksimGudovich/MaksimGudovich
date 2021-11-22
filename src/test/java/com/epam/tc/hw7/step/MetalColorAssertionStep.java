package com.epam.tc.hw7.step;

import static com.epam.tc.hw7.section.ResultSection.checkResult;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw7.entities.MetalsAndColorsData;

public class MetalColorAssertionStep {

    public static void checkMetalAndColorResult(MetalsAndColorsData data) {
        assertTrue(checkResult(data));
    }

}

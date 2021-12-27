package com.epam.tc.hw7.dataprovider;

import com.epam.tc.hw7.entities.MetalsAndColorsData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;

public class MetalColorDataProvider {

    @DataProvider(name = "Metals & Colors Data Provider From json")
    public static Object[][] getMetalColorData() {
        String jsonData = null;
        try {
            jsonData = Files.readString(Path.of("src/test/resources/com/epam/tc/hw7/JDI_ex8_metalsColorsDataSet.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] testData = null;
        try {
            testData = new ObjectMapper()
                .readValue(jsonData, new TypeReference<Map<String, MetalsAndColorsData>>() {
                })
                .values().stream()
                .map(metalsAndColorsData -> new Object[] {metalsAndColorsData})
                .collect(Collectors.toList())
                .toArray(new Object[][] {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return testData;
    }
}

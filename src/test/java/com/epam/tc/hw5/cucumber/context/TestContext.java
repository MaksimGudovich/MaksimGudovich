package com.epam.tc.hw5.cucumber.context;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {

    private static TestContext instance;

    private Map<String, Object> context = new HashMap<>();

    private TestContext() {
    }

    public <T> T getObject(String key) {
        return (T) context.get(key);
    }

    public void addObject(String key, Object object) {
        context.put(key, object);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}

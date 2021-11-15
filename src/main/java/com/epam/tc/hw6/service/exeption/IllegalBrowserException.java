package com.epam.tc.hw6.service.exeption;

import com.epam.tc.hw6.service.webdriver.Browser;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class IllegalBrowserException extends IllegalArgumentException {
    public IllegalBrowserException() {
        super(String.format("Unsupported browser. Supported browsers are %s", Arrays
            .stream(Browser.values())
            .map(browser -> browser.name().toLowerCase(Locale.ROOT))
            .collect(Collectors.joining(", "))));
    }
}


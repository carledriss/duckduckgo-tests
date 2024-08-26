package org.example.core.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

public final class BrowserFactory {

    private static final Map<String, Supplier<Browser>> BROWSERS = new HashMap<>();
    static {
        BROWSERS.put("chrome", Chrome::new);
        BROWSERS.put("firefox", Firefox::new);
        BROWSERS.put("headless", Headless::new);
    }

    private BrowserFactory() {
    }

    public static WebDriver getBrowser(final String browser) {
        return BROWSERS.getOrDefault(browser, Chrome::new).get().init();
    }

}

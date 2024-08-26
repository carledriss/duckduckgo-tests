package org.example.core.ui;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final DriverManager INSTANCE = new DriverManager();

    private final WebDriver driver;

    private DriverManager() {
        driver = BrowserFactory.getBrowser("chrome");
    }

    public static DriverManager getInstance() {
        return INSTANCE;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

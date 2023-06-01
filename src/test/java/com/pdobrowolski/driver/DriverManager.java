package com.pdobrowolski.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static void createInstance(String browser,String profile,String deviceName,String headless) {
        setWebDriver(DriverFactory.createWebDriverInstance(browser,profile,deviceName,headless));
    }
}
package com.pdobrowolski.tests;

import com.pdobrowolski.driver.DriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "chromeProfile", "deviceName", "headless"})
    protected void setUp(@Optional("firefox") String browser, @Optional String profile, @Optional String deviceName
            , @Optional("true") String headless) {
        DriverManager.createInstance(browser,profile,deviceName,headless);
        driver = DriverManager.getDriver();
        driver.manage().window().setPosition(new Point(-1000,200));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        driver.quit();
    }
}

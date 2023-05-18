package com.pdobrowolski.tests;

import com.pdobrowolski.driver.DriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    protected void setUp(@Optional("chrome") String browser) {
        DriverManager.createInstance(browser);
        driver = DriverManager.getDriver();
        driver.manage().window().setPosition(new Point(-1000,200));
        driver.manage().window().maximize();
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }
}

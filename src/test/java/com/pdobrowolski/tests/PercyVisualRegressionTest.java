package com.pdobrowolski.tests;

import io.percy.selenium.Percy;
import org.testng.annotations.Test;

public class PercyVisualRegressionTest extends BaseTest{

    @Test
    public void testVisualRegression() {
        Percy percy = new Percy(driver);
        driver.get("http://example.com");
        percy.snapshot("Example.com Homepage");
    }
}
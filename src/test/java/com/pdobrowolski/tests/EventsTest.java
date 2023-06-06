package com.pdobrowolski.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventsTest extends BaseTest{

    @Test
    public void testVisualRegression() {
        driver.get("https://www.ergo.com/pl-PL/Microsites/ETS/Start/Contact");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Boolean eventFound = (Boolean) jsExecutor.executeScript(
                "const appEventData = window.appEventData;\n" +
                        "return appEventData.some(item => " +
                        "item.eventdetails.clickedElement.startsWith(arguments[0]) && " +
                        "item.eventdetails.clickedElement.endsWith(arguments[1]));", "firstPart", "secondPart");
        Assert.assertFalse(eventFound, "Event not found.");
    }
}
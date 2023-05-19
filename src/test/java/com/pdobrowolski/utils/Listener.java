package com.pdobrowolski.utils;

import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    @Override
    @Description("onTestStart")
    public void onTestStart(final ITestResult result) {
        logger.info("Started test");
    }

    @Override
    @Description("onTestSuccess")
    public void onTestSuccess(final ITestResult result) {
        logger.info("Test ended with a success");
    }

    @Override
    @Description("onTestFailure")
    public void onTestFailure(final ITestResult result) {
        logger.info("Test ended with a failure");
    }

    @Override
    @Description("onTestSkipped")
    public void onTestSkipped(final ITestResult result) {

    }

    @Override
    @Description("onTestFailedButWithinSuccessPercentage")
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {

    }

    @Override
    @Description("onTestFailedWithTimeout")
    public void onTestFailedWithTimeout(final ITestResult result) {

    }

    @Override
    @Description("onStart")
    public void onStart(final ITestContext context) {

    }

    @Override
    @Description("onFinish")
    public void onFinish(final ITestContext context) {

    }
}

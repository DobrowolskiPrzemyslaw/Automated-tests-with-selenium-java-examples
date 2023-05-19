package com.pdobrowolski.pages;

import com.pdobrowolski.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

public class BasePage {

    protected BasePage(Logger logger) {
        BasePage.logger = logger;
    }

    protected static Logger logger;
    protected WebDriver driver = DriverManager.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    protected void openPage(String url){
        logger.info("Opening page: " + url);
        driver.get(url);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    protected WebElement waitUntilPresentedBase(By locator){
        logger.info("Waiting until presented: "+ locator.toString());
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitUntilVisibleBase(By locator){
        logger.info("Waiting until visible: "+ locator.toString());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator){
        logger.info("Click: "+ locator.toString());
        waitUntilVisibleBase(locator).click();
    }

    protected void clear(By locator){
        logger.info("Clear: "+ locator.toString());
        waitUntilVisibleBase(locator).clear();
    }

    protected void sendText(By locator, String text){
        logger.info("Sending test to: "+ locator.toString());
        waitUntilVisibleBase(locator).sendKeys(text);
    }

    protected void clearAndSendText(By locator, String text){
        clear(locator);
        sendText(locator, text);
    }

    protected boolean isVisible(By locator){
        logger.info("WebElement is visible: "+ locator.toString());
        return waitUntilVisibleBase(locator).isDisplayed();
    }

    protected String getText(By locator){
        return waitUntilPresentedBase(locator).getText();
    }

    protected  void switchToFrame(By locator){
        logger.info("Switching to frame: "+ locator.toString());
        driver.switchTo().frame(waitUntilPresentedBase(locator));
    }

    protected void switchToDefaultFrame(){
        logger.info("Switching to default content");
        driver.switchTo().defaultContent();
    }

    protected Select getSelect(By locator){
        logger.info("Geting select: " + locator);
        return new Select(waitUntilPresentedBase(locator));
    }

    protected void selectByVisibleText(By locator, String visibleText){
        logger.info("Selecting form select: " + locator + "by visible test: " + visibleText);
        getSelect(locator).selectByVisibleText(visibleText);
    }

    protected boolean isSelected (By locator){
        logger.info("WebElement is selected: "+ locator.toString());
        return waitUntilVisibleBase(locator).isSelected();
    }

    protected void checkUncheckCheckbox(By locator, boolean check) {
        if (check) {
            if (!isSelected(locator))
                click(locator);
        } else {
            if (isSelected(locator))
                click(locator);
        }
    }

}

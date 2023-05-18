package com.pdobrowolski.pages;

import com.pdobrowolski.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    protected void openPage(String url){
        driver.get(url);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    protected WebElement waitUntilPresentedBase(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitUntilVisibleBase(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilClickableBase(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator){
        waitUntilVisibleBase(locator).click();
    }

    public void clear(By locator){
        waitUntilVisibleBase(locator).clear();
    }

    public void sendText(By locator, String text){
        clear(locator);
        waitUntilVisibleBase(locator).sendKeys(text);
    }
}

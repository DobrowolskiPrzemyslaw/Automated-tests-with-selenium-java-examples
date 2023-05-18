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

    protected void openPageBase(String url){
        driver.get(url);
    }

    protected String getUrlBase(){
        return driver.getCurrentUrl();
    }

    protected WebElement waitUnilPresentedBase(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitUnilVisibeBase(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator){
        waitUnilVisibeBase(locator).click();
    }

    protected void clear(By locator){
        waitUnilVisibeBase(locator).clear();
    }

    protected void sendText(By locator, String text){
        clear(locator);
        waitUnilVisibeBase(locator).sendKeys(text);
    }
}

package com.pdobrowolski.pages;

import com.pdobrowolski.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver = DriverManager.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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

    protected void click(By locator){
        waitUntilVisibleBase(locator).click();
    }

    protected void clear(By locator){
        waitUntilVisibleBase(locator).clear();
    }

    protected void clearAndSendText(By locator, String text){
        clear(locator);
        waitUntilVisibleBase(locator).sendKeys(text);
    }

    protected void sendText(By locator, String text){
        waitUntilVisibleBase(locator).sendKeys(text);
    }

    protected boolean isVisible(By locator){
        return waitUntilVisibleBase(locator).isDisplayed();
    }

    protected String getTextNotice(By locator){
        return waitUntilPresentedBase(locator).getText();
    }

    protected  void switchToFrame(By locator){
        driver.switchTo().frame(waitUntilPresentedBase(locator));
    }

    protected void switchToDefaultFrame(){
        driver.switchTo().defaultContent();
    }

    protected Select getSelect(By locator){
        return new Select(waitUntilPresentedBase(locator));
    }

    protected void selectByVisibleText(By locator, String visibleText){
        getSelect(locator).selectByVisibleText(visibleText);
    }

    protected boolean isSelected (By locator){
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

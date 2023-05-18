package com.pdobrowolski.elements;

import com.pdobrowolski.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseElements {

    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    By locator;

    protected BaseElements(By locator) {
        this.locator = locator;
    }

    protected WebElement waitUntilVisibleBase(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilPresentedBase(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void clearAndSendTextBase(String text){
        waitUntilVisibleBase().clear();
        waitUntilVisibleBase().sendKeys(text);
    }

    protected void sendTextBase(String text){
        waitUntilVisibleBase().sendKeys(text);
    }

    protected void clickOnElementBase(){
        waitUntilVisibleBase().click();
    }

    protected Select getSelectBase(){
        return new Select(waitUntilPresentedBase());
    }

    protected void selectByVisibleTextBase (String visibleText){
        getSelectBase().selectByVisibleText(visibleText);
    }

    protected boolean isSelectedBase (){
        return waitUntilVisibleBase().isSelected();
    }

    protected  void switchToFrameBase(){
        driver.switchTo().frame(waitUntilPresentedBase());
    }

    protected void switchToDefaultBase(){
        driver.switchTo().defaultContent();
    }
}

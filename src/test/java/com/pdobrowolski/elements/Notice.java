package com.pdobrowolski.elements;

import org.openqa.selenium.By;

public class Notice  extends BaseElements{

    public Notice(By locator){
        super(locator);
    }

    public String getTextNotice(){
        return waitUntilPresentedBase().getText();
    }

    public boolean isVisible(){
        return waitUntilVisibleBase().isDisplayed();
    }
}


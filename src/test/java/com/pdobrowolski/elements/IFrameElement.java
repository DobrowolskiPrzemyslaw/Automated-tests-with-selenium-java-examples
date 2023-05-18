package com.pdobrowolski.elements;

import org.openqa.selenium.By;

public class IFrameElement extends BaseElements{

    public IFrameElement(By locator){
        super(locator);
    }

    public void switchToFrame(){
        switchToDefaultBase();
        switchToFrameBase();
    }
}
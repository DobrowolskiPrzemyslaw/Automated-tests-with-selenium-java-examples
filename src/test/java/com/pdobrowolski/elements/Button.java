package com.pdobrowolski.elements;

import org.openqa.selenium.By;

public class Button extends BaseElements{

    public Button(By locator){
        super(locator);
    }

    public void click(){
        clickOnElementBase();
    }
}

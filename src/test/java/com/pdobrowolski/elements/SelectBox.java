package com.pdobrowolski.elements;

import org.openqa.selenium.By;

public class SelectBox extends BaseElements{

    public SelectBox(By locator){
        super(locator);
    }

    public void selectByVisibleText(String text){
        selectByVisibleTextBase(text);
    }
}

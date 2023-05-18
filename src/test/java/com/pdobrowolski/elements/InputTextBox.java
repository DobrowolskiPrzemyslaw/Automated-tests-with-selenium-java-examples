package com.pdobrowolski.elements;

import org.openqa.selenium.By;

public class InputTextBox extends BaseElements {

    public InputTextBox(By locator){
        super(locator);
    }

    public void clearAndSendText(String text){
        clearAndSendTextBase(text);
    }

    public void sendText(String text){
        sendTextBase(text);
    }
}

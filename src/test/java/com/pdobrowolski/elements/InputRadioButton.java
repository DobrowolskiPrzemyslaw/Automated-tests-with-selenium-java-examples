package com.pdobrowolski.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InputRadioButton extends BaseElements{

    public InputRadioButton(By locator){
        super(locator);
    }

    public void selectRadioButton() {
        WebElement radio = waitUnilVisibeBase();
        if (!radio.isSelected()) {
            radio.click();
        }
    }
}

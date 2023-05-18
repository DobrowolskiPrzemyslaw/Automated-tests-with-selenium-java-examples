package com.pdobrowolski.elements;

import org.openqa.selenium.By;

public class InputCheckbox extends BaseElements{

    public InputCheckbox(By locator){
        super(locator);
    }

    public boolean isChecked(){
        return isSelectedBase();
    }

    public void uncheckbox(){
        if (isSelectedBase())
           clickOnElementBase();
    }

    public void checkbox() {
        if(!isSelectedBase())
            clickOnElementBase();
    }

    public void checkUncheckCheckbox(boolean check) {
        if (check) {
            if (!isSelectedBase())
                clickOnElementBase();
        } else {
            if (isSelectedBase())
                clickOnElementBase();
        }
    }
}
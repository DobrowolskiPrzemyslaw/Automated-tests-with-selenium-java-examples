package com.pdobrowolski.elements;

import org.openqa.selenium.By;

public class Button extends BaseElements{

    public Button(By locator){
        super(locator);
    }

    public void click(){
        clickOnElementBase();
    }

    public void klikajAzPojawiSieWebelemnet(By coMamKlikac, By coMaBycwidoczne ){
        int i = 1;
        int iMax = 5;
        do {
            driver.findElement(coMamKlikac).click();
            czekaj(2000);
            if (driver.findElement(coMaBycwidoczne).isEnabled() && driver.findElement(coMaBycwidoczne).isDisplayed())
                break;
        }while (i<iMax);
    }

    public void czekaj(int ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}

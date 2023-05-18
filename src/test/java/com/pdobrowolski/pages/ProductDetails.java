package com.pdobrowolski.pages;

import com.pdobrowolski.elements.Button;
import com.pdobrowolski.elements.SelectBox;
import org.openqa.selenium.By;

public class ProductDetails {
    SelectBox selectColor;
    SelectBox selectSize;
    Button buyButton;

    public ProductDetails(){
        selectColor = new SelectBox(By.id("ProductSelect-product-template-option-0"));
        selectSize = new SelectBox(By.id("ProductSelect-product-template-option-1"));
        buyButton = new Button(By.xpath("//button[@data-testid='Checkout-button']"));
    }

    public ProductDetails changeColor(String color){
        selectColor.selectByVisibleText(color);
        return this;
    }

    public ProductDetails changeSize (String size){
        selectSize.selectByVisibleText(size);
        return this;
    }

    public PurchasePage clickOnBuyButton (){
        buyButton.click();
        return new PurchasePage();
    }
}

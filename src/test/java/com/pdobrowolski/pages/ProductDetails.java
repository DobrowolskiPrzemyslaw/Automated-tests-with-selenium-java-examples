package com.pdobrowolski.pages;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

public class ProductDetails extends BasePage {

    public ProductDetails(){
        super(LoggerFactory.getLogger(ProductDetails.class));
    }

    private final By selectColor = By.id("ProductSelect-product-template-option-0");
    private final By selectSize = By.id("ProductSelect-product-template-option-1");
    private final By buyButton = By.xpath("//button[@data-testid='Checkout-button']");

    public ProductDetails changeColor(String color){
        selectByVisibleText(selectColor,color);
        return this;
    }

    public ProductDetails changeSize (String size){
        selectByVisibleText(selectSize, size);
        return this;
    }

    public PurchasePage clickOnBuyButton (){
        click(buyButton);
        return new PurchasePage();
    }
}

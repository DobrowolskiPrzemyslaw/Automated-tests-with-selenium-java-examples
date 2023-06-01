package com.pdobrowolski.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

public class ProductDetails extends BasePage {

    public ProductDetails(){
        super(LoggerFactory.getLogger(ProductDetails.class));
    }

    private final By selectColor = By.id("ProductSelect-product-template-option-0");
    private final By selectSize = By.id("ProductSelect-product-template-option-1");
    private final By buyButton = By.xpath("//button[@data-testid='Checkout-button']");

    @Step("Changing color")
    public ProductDetails changeColor(String color){
        selectByVisibleText(selectColor,color);
        return this;
    }

    @Step("Changing size")
    public ProductDetails changeSize (String size){
        selectByVisibleText(selectSize, size);
        return this;
    }

    @Step("Clicking on Buy button")
    public PurchasePage clickOnBuyButton (){
        click(buyButton);
        return new PurchasePage();
    }
}

package com.pdobrowolski.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By searchField = By.className("search-bar__input");
    private final By searchButton = By.className("search-bar__submit");
    private final By productDetailLink = By.xpath("//a[@title='Goran Zip Boot - Rust']");

    public void openHomePage(){
        openPage("https://simpletheme.myshopify.com/");
    }

    public HomePage searchItem(String item){
        sendText(searchField, item);
        click(searchButton);
        return this;
    }

    public ProductDetails clickOnItemLink() {
        click(productDetailLink);
        return new ProductDetails();
    }
}

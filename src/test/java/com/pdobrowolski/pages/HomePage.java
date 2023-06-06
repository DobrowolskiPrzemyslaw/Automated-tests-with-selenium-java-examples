package com.pdobrowolski.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

    public HomePage(){
        super(LoggerFactory.getLogger(HomePage.class));
    }

    private final By searchField = By.className("search-bar__input");
    private final By searchButton = By.className("search-bar__submit");
    private final By productDetailLink = By.xpath("//a[@title='Goran Zip Boot - Rust']");
    private final By homeButton = By.xpath("//a[text()='Home']");

    public void openHomePage(){
//        openPage("https://simpletheme.myshopify.com/");
        openPage("https://www.ergo.com/pl-PL/Microsites/ETS/Start/Contact");
    }

    public void clickHomeButton(){
        click(homeButton);
    }

    public void checkEvent(String firstPart, String secondPart) {
        checkEventBase(driver, firstPart, secondPart);
    }

    @Step("Searching item")
    public HomePage searchItem(String item){
        sendText(searchField, item);
        click(searchButton);
        return this;
    }

    @Step("Clicking on item link")
    public ProductDetails clickOnItemLink() {
        click(productDetailLink);
        return new ProductDetails();
    }
}

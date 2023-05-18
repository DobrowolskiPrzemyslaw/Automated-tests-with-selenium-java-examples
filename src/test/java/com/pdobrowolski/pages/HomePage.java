package com.pdobrowolski.pages;

import com.pdobrowolski.elements.Button;
import com.pdobrowolski.elements.InputTextBox;
import com.pdobrowolski.elements.Link;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    InputTextBox searchField;
    Button searchButton;
    Link productDetialLink;

    public HomePage(){
        searchField = new InputTextBox(By.className("search-bar__input"));
        searchButton = new Button(By.className("search-bar__submit"));
        productDetialLink = new Link(By.xpath("//a[@title='Goran Zip Boot - Rust']"));
    }

    public void openHomePage(){
        openPage("https://simpletheme.myshopify.com/");
    }

    public HomePage searchItem(String item){
        searchField.clearAndSendText(item);
        searchButton.click();
        return this;
    }

    public ProductDetails clickOnItemLink() {
        productDetialLink.click();
        return new ProductDetails();
    }
}

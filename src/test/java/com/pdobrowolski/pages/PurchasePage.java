package com.pdobrowolski.pages;

import com.pdobrowolski.elements.Button;
import com.pdobrowolski.elements.InputCheckbox;
import com.pdobrowolski.elements.InputTextBox;
import com.pdobrowolski.elements.SelectBox;
import org.openqa.selenium.By;

public class PurchasePage  {

    InputTextBox emailField;
    InputTextBox firstnameField;
    InputTextBox lastnameField;
    InputTextBox company;
    InputTextBox addressField;
    InputTextBox postalCodeField;
    InputTextBox cityField;
    InputTextBox phoneNumberField;
    SelectBox selectCountry;
    Button continueToShipping;
    InputCheckbox saveMe;

    public PurchasePage(){
        emailField = new InputTextBox(By.xpath("//input[@id='email']"));
        firstnameField = new InputTextBox(By.xpath("//input[@id='TextField1']"));
        lastnameField = new InputTextBox(By.xpath("//input[@id='TextField2']"));
        company = new InputTextBox(By.xpath("//input[@id='TextField3']"));
        addressField = new InputTextBox(By.xpath("//input[@id='TextField8']"));
        postalCodeField = new InputTextBox(By.xpath("//input[@id='TextField9']"));
        cityField = new InputTextBox(By.xpath("//input[@id='TextField10']"));
        phoneNumberField = new InputTextBox(By.xpath("//input[@id='phone_field']"));
        selectCountry = new SelectBox(By.xpath("//select[@id='Select0']"));
        saveMe = new InputCheckbox(By.xpath("//input[@id='save_shipping_information']"));
        continueToShipping = new Button(By.xpath("//button[./span[text()='Continue to shipping']]"));

    }
    public ShippingPage fillInContactForm (String email, String firstName, String lastName,
                                           String companyName, String address, String postalCode, String cityName,
                                           String phoneNumber, boolean saveCheckbox, String countryName){
        emailField.clearAndSendText(email);
        selectCountry.selectByVisibleText(countryName);
        firstnameField.clearAndSendText(firstName);
        lastnameField.clearAndSendText(lastName);
        company.clearAndSendText(companyName);
        addressField.clearAndSendText(address);
        postalCodeField.clearAndSendText(postalCode);
        cityField.clearAndSendText(cityName);
        phoneNumberField.clearAndSendText(phoneNumber);
        saveMe.checkUncheckCheckbox(saveCheckbox);
        continueToShipping.click();
        return new ShippingPage();
    }
}

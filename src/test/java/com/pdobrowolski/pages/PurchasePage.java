package com.pdobrowolski.pages;

import org.openqa.selenium.By;

public class PurchasePage extends BasePage {

    private final By emailField = By.xpath("//input[@id='email']");
    private final By firstnameField = By.xpath("//input[@id='TextField1']");
    private final By lastnameField = By.xpath("//input[@id='TextField2']");
    private final By company = By.xpath("//input[@id='TextField3']");
    private final By addressField = By.xpath("//input[@placeholder='Address']");
    private final By postalCodeField = By.xpath("//input[@placeholder='Postal code']");
    private final By cityField = By.xpath("//input[@placeholder='City']");
    private final By phoneNumberField = By.xpath("//input[@placeholder='Phone (optional)']");
    private final By selectCountry = By.xpath("//select[@id='Select0']");
    private final By continueToShipping = By.xpath("//button[./span[text()='Continue to shipping']]");
    private final By saveMe = By.xpath("//input[@id='save_shipping_information']");

    public ShippingPage fillInContactForm (String email, String firstName, String lastName, String companyName,
                                           String address, String postalCode, String cityName, String phoneNumber,
                                           boolean saveCheckbox, String countryName){
        clearAndSendText(emailField, email);
        selectByVisibleText(selectCountry, countryName);
        clearAndSendText(firstnameField, firstName);
        clearAndSendText(lastnameField, lastName);
        clearAndSendText(company, companyName);
        clearAndSendText(addressField, address);
        clearAndSendText(postalCodeField, postalCode);
        clearAndSendText(cityField, cityName);
        clearAndSendText(phoneNumberField, phoneNumber);
        checkUncheckCheckbox(saveMe, saveCheckbox);
        click(continueToShipping);
        return new ShippingPage();
    }
}

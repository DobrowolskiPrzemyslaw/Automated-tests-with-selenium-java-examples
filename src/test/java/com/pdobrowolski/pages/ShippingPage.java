package com.pdobrowolski.pages;

import org.openqa.selenium.By;

public class ShippingPage extends BasePage{

    private final By continueToPayment = By.xpath("//button[./span[text()='Continue to payment']]");

    public PaymentPage shipping (){
        click(continueToPayment);
        return new PaymentPage();
    }
}

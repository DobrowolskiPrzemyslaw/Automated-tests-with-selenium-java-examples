package com.pdobrowolski.pages;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

public class ShippingPage extends BasePage{

    public ShippingPage(){
        super(LoggerFactory.getLogger(ShippingPage.class));
    }

    private final By continueToPayment = By.xpath("//button[./span[text()='Continue to payment']]");

    public PaymentPage shipping (){
        click(continueToPayment);
        return new PaymentPage();
    }
}

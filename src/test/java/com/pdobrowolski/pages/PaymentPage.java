package com.pdobrowolski.pages;

import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private final By cardNumberField = By.id("number");
    private final By nameCardField = By.id("name");
    private final By expirationDateField = By.id("expiry");
    private final By securityCodeField = By.id("verification_value");
    private final By payButton = By.xpath("//button[./span[text()='Pay now']]");
    private final By cardNumberFrame = By.xpath("//iframe[starts-with(@id, 'card-fields-number-')]");
    private final By nameCardFrame = By.xpath("//iframe[starts-with(@id, 'card-fields-name-')]");
    private final By expirationDateFrame = By.xpath("//iframe[starts-with(@id, 'card-fields-expiry-')]");
    private final By securityCodeFrame = By.xpath("//iframe[starts-with(@id, 'card-fields-verification_value-')]");
    private final By errorMassage = By.className("sdr03sa");

    public PaymentPage fillInPaymentInformation (String cardNumber1, String cardNumber2, String cardNumber3,
                                                 String cardNumber4, String nameCard, String expirationDate1,
                                                 String expirationDate2, String securityCode)  {
        switchToFrame(cardNumberFrame);
        sendText(cardNumberField, cardNumber1);
        sendText(cardNumberField, cardNumber2);
        sendText(cardNumberField, cardNumber3);
        sendText(cardNumberField, cardNumber4);
        switchToDefaultFrame();
        switchToFrame(nameCardFrame);
        clearAndSendText(nameCardField, nameCard);
        switchToDefaultFrame();
        switchToFrame(expirationDateFrame);
        sendText(expirationDateField, expirationDate1);
        sendText(expirationDateField, expirationDate2);
        switchToDefaultFrame();
        switchToFrame(securityCodeFrame);
        clearAndSendText(securityCodeField, securityCode);
        switchToDefaultFrame();
        click(payButton);
        return this;
    }

    public String getErrorMessage(){
        if(isVisible(errorMassage)){
            return getTextNotice(errorMassage);
        }else {
            return null;
        }
    }
}
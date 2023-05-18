package com.pdobrowolski.pages;

import com.pdobrowolski.elements.Button;
import com.pdobrowolski.elements.IFrameElement;
import com.pdobrowolski.elements.InputTextBox;
import com.pdobrowolski.elements.Notice;
import org.openqa.selenium.By;

public class PaymentPage {

    InputTextBox cardNumberField;
    InputTextBox nameCardField;
    InputTextBox expirationDateField;
    InputTextBox securityCodeField;
    Button payButton;
    IFrameElement cardNumberFrame;
    IFrameElement nameCardFrame;
    IFrameElement expirationDateFrame;
    IFrameElement securityCodeFrame;
    Notice errorMassage;

    public PaymentPage(){
        cardNumberField = new InputTextBox(By.id("number"));
        nameCardField = new InputTextBox(By.id("name"));
        expirationDateField = new InputTextBox(By.id("expiry"));
        securityCodeField = new InputTextBox(By.id("verification_value"));
        payButton = new Button(By.xpath("//button[./span[text()='Pay now']]"));
        cardNumberFrame = new IFrameElement(By.xpath("//iframe[starts-with(@id, 'card-fields-number-')]"));
        nameCardFrame = new IFrameElement(By.xpath("//iframe[starts-with(@id, 'card-fields-name-')]"));
        expirationDateFrame = new IFrameElement(By.xpath("//iframe[starts-with(@id, 'card-fields-expiry-')]"));
        securityCodeFrame = new IFrameElement(By.xpath("//iframe[starts-with(@id, 'card-fields-verification_value-')]"));
        errorMassage = new Notice(By.className("sdr03sa"));
    }

    public PaymentPage fillInPaymentInformation (String cardNumber1, String cardNumber2, String cardNumber3, String cardNumber4, String nameCard, String expirationDate1, String expirationDate2, String securityCode)  {
        cardNumberFrame.switchToFrame();
        cardNumberField.sendText2(cardNumber1);
        cardNumberField.sendText2(cardNumber2);
        cardNumberField.sendText2(cardNumber3);
        cardNumberField.sendText2(cardNumber4);
        nameCardFrame.switchToFrame();
        nameCardField.sendText(nameCard);
        expirationDateFrame.switchToFrame();
        expirationDateField.sendText2(expirationDate1);
        expirationDateField.sendText2(expirationDate2);
        securityCodeFrame.switchToFrame();
        securityCodeField.sendText(securityCode);
        securityCodeField.switchToDefaultBase();
        payButton.click();
        return this;
    }

    public String getErrorMessage(){
        if(errorMassage.isVisble()){
            return errorMassage.getTextNotice();
        }else {
            return null;
        }
    }
}
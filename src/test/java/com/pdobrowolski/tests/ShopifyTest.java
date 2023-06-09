package com.pdobrowolski.tests;

import com.pdobrowolski.utils.Listener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pdobrowolski.pages.HomePage;

@Listeners(value = {Listener.class})
public class ShopifyTest extends BaseTest {

    @Test(groups = {"positiveTests"})
    @Parameters({"Item2"})
    @Feature("Buying item")
    @Story("Payment features")
    @Description("Functional buying item test")
    public void shopifyFirstTest(@Optional("Boot") String item) {
        Reporter.log("Zaczynam test shopifyFirstTest");
        String expectedText = "Your payment details couldn’t be verified. Check your card details and try again.";
        HomePage page = new HomePage();
        page.openHomePage();
        String actualError = page
                .searchItem(item)
                .clickOnItemLink()
                .changeColor("Rust")
                .changeSize("11")
                .clickOnBuyButton()
                .fillInContactForm("przeme@wp.pl", "Przemyslaw", "Kowalski",
                        "Finture","Targowa 5/39", "09-500", "Warszawa",
                        "888-442-444", true, "Poland")
                .shipping()
                .fillInPaymentInformation("4108", "6526", "1018", "1217",
                        "Danica Killough", "12", "2024", "846")
                .getErrorMessage();
        Assert.assertEquals(actualError, expectedText);
    }

    @Test(groups = {"positiveTests"})
    @Parameters({"Item2"})
    @Feature("Buying item")
    @Story("Payment features")
    @Description("Functional buying item test")
    public void shopifyRownolegle(@Optional("Boot") String item) {
        Reporter.log("Zaczynam test shopifyFirstTest");
        String expectedText = "Your payment details couldn’t be verified. Check your card details and try again.";
        HomePage page = new HomePage();
        String actualError = page
                .searchItem(item)
                .clickOnItemLink()
                .changeColor("Rust")
                .changeSize("11")
                .clickOnBuyButton()
                .fillInContactForm("przeme@wp.pl", "Przemyslaw", "Kowalski",
                        "Finture","Targowa 5/39", "09-500", "Warszawa",
                        "888-442-444", true, "Poland")
                .shipping()
                .fillInPaymentInformation("4108", "6526", "1018", "1217",
                        "Danica Killough", "12", "2024", "846")
                .getErrorMessage();
        Assert.assertEquals(actualError, expectedText);
    }

    @Test(groups = {"positiveTests"})
    @Parameters({"Item2"})
    @Feature("Buying item")
    @Story("Payment features")
    @Description("Functional buying item test")
    public void shopifyRownolegle2(@Optional("Boot") String item) {
        Reporter.log("Zaczynam test shopifyFirstTest");
        String expectedText = "Your payment details couldn’t be verified. Check your card details and try again.";
        HomePage page = new HomePage();
        String actualError = page
                .searchItem(item)
                .clickOnItemLink()
                .changeColor("Rust")
                .changeSize("11")
                .clickOnBuyButton()
                .fillInContactForm("przeme@wp.pl", "Przemyslaw", "Kowalski",
                        "Finture","Targowa 5/39", "09-500", "Warszawa",
                        "888-442-444", true, "Poland")
                .shipping()
                .fillInPaymentInformation("4108", "6526", "1018", "1217",
                        "Danica Killough", "12", "2024", "846")
                .getErrorMessage();
        Assert.assertEquals(actualError, expectedText);
    }

    @Test(groups = {"positiveTests"})
    @Parameters({"Item2"})
    @Feature("Buying item")
    @Story("Payment features")
    @Description("Functional buying item test")
    public void shopifyFirstTest2(@Optional("Boot") String item) {
        Reporter.log("Zaczynam test shopifyFirstTest2");
        Reporter.log("Tworze HomePage");
        HomePage page2 = new HomePage();
        Reporter.log("Wyszukuje produkt o nazwie: " + item);
        page2.searchItem(item);
    }
}

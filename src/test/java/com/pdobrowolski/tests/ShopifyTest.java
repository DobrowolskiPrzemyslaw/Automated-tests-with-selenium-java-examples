package com.pdobrowolski.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pdobrowolski.pages.HomePage;

public class ShopifyTest extends BaseTest {

    @Test
    @Parameters({"Item2"})
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

    @Test
    @Parameters({"Item2"})
    public void shopifyRownolegle(String item){
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

    @Test
    @Parameters({"Item2"})
    public void shopifyRownolegle2(String item) {
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

    @Test
    @Parameters({"Item"})
    public void shopifyFirstTest2(String item) {
        Reporter.log("Zaczynam test shopifyFirstTest2");
        Reporter.log("Tworze HomePage");
        HomePage page2 = new HomePage();
        Reporter.log("Wyszukuje produkt o nazwie: " + item);
        page2.searchItem(item);
    }
}

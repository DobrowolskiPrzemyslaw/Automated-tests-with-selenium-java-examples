package com.pdobrowolski.tests;

import com.pdobrowolski.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest extends DataTest {

    @Test(priority = 1, dataProvider = "urls", groups = {"positiveTests", "smokeTests" })
    @Feature("We can check more options than one in one test")
    @Story("Story")
    @Description("Soft assert test")
    public void smokeTest(@Optional("https://simpletheme.myshopify.com/") String url) {
        HomePage page = new HomePage();
        page.openHomePage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getUrl(), url);
        softAssert.assertEquals(page.getTitle(), "Simple ecommerce theme demo store – Shopify Shirts");
        softAssert.assertAll();
    }
}

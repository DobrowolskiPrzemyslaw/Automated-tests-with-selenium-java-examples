package com.pdobrowolski.tests;

import com.pdobrowolski.pages.HomePage;
import com.pdobrowolski.utils.Listener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

@Listeners(value = {Listener.class})
public class DataProviderTests extends DataTest {

    @Test(priority = 1, dataProvider = "urls", groups = {"positiveTests", "smokeTests" })
    @Feature("Opening all pages")
    @Story("Main features")
    @Description("Smoke tests")
    public void smokeTest(@Optional("https://simpletheme.myshopify.com/") String url) {
        HomePage page = new HomePage();
        page.openHomePage();
        Assert.assertEquals(page.getUrl(), url);
    }

//    @Test(priority = 2, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
//    public void smokeTest(Map<String, String> testData) {
//        String url = testData.get("url");
//        HomePage page = new HomePage();
//        page.openHomePage();
//        Assert.assertEquals(page.getUrl(), url);
//    }
}

package com.pdobrowolski.tests;

import com.pdobrowolski.pages.HomePage;
import com.pdobrowolski.utils.Listener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(value = {Listener.class})
public class OpenPageTestsWithDataProvider extends BaseTest {

    @Test(dataProvider = "data", groups = {"positiveTests", "smokeTests" })
    @Feature("Opening all pages")
    @Story("Main features")
    @Description("Smoke tests")
    public void smokeTest(@Optional("https://simpletheme.myshopify.com/") String url) {
        HomePage page = new HomePage();
        page.openHomePage();
        Assert.assertEquals(page.getUrl(), url);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider(){
        return new Object[][] {
                {"https://simpletheme.myshopify.com/"},
                {"https://simpletheme.myshopify.com/"},
                {"https://simpletheme.myshopify.com/"}};
    }
}

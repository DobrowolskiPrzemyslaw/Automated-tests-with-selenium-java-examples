package com.pdobrowolski.tests;

import com.pdobrowolski.pages.HomePage;
import com.pdobrowolski.utils.Listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(value = {Listener.class})
public class OpenPageTests extends BaseTest {

    @Test(groups = {"positiveTests", "smokeTests" })
    @Parameters({"url"})
    public void smokeTest(@Optional("https://simpletheme.myshopify.com/") String url) {
        HomePage page = new HomePage();
        page.openHomePage();
        Assert.assertEquals(page.getUrl(), url);
    }

    @Test(groups = {"positiveTests", "smokeTests" })
    @Parameters({"url"})
    public void smokeTest2(@Optional("https://simpletheme.myshopify.com/") String url) {
        HomePage page = new HomePage();
        page.openHomePage();
        Assert.assertEquals(page.getUrl(), url);
    }

    @Test(groups = {"positiveTests", "smokeTests" })
    @Parameters({"url"})
    public void smokeTest3(@Optional("https://simpletheme.myshopify.com/") String url) {
        HomePage page = new HomePage();
        page.openHomePage();
        Assert.assertEquals(page.getUrl(), url);
    }
}

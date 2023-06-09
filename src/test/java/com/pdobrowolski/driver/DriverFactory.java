package com.pdobrowolski.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createWebDriverInstance(String browser,String profile,String deviceName, String headless){
        WebDriver driver;
        if(browser.equalsIgnoreCase("chrome")){
            if(System.getProperty("webdriver.chrome.driver") == null) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
            }
            driver = new ChromeDriver(OptionManager.getChromeOptions(profile,deviceName,headless));
        } else if(browser.equalsIgnoreCase("firefox")) {
            if(System.getProperty("webdriver.gecko.driver") == null) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver.exe");
            }
            driver = new FirefoxDriver(OptionManager.getFirefoxOptions(headless));
        } else{
            System.out.println("Do not know how to start " + browser + ", starting chrome instead");
            if(System.getProperty("webdriver.chrome.driver") == null) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
            }
            driver = new ChromeDriver(OptionManager.getChromeOptions(profile,deviceName,headless));
        }
        return driver;
    }
}


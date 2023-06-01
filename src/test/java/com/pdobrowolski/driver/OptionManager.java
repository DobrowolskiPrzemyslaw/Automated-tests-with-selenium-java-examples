package com.pdobrowolski.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class OptionManager {

    public static ChromeOptions getChromeOptions(String profile,String deviceName, String headless){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        if(profile != null){
            options.addArguments("user-data-dir=src/main/resources/Profiles/" + profile);
        }
        if(deviceName != null){
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", deviceName);
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
        }
        if(headless.equalsIgnoreCase("true")){
            options.addArguments("--headless");
        }
        return options;
    }

    public static FirefoxOptions getFirefoxOptions(String headless){
        FirefoxOptions options = new FirefoxOptions();
        if(headless.equalsIgnoreCase("true")){
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            options.setBinary(firefoxBinary);
        }
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        return options;
    }
}

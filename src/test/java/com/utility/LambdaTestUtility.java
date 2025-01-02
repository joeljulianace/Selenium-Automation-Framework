package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtility {
    public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<DesiredCapabilities> desiredCapabilities = new ThreadLocal<>();

    public static WebDriver initializeLambdaTestSession(String browser, String testName){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "joeljulianace");
        ltOptions.put("accessKey", "WzvkknOYb4B34C5bVNpMhJamnym4ZXb75jUrMmccJzkpZ7iHGq");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        desiredCapabilities.set(capabilities);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL), desiredCapabilities.get());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        webDriver.set(driver);
        return webDriver.get();
    }

    public static void quitSession(){
        if(webDriver.get() != null){
            webDriver.get().quit();
        }
    }
}

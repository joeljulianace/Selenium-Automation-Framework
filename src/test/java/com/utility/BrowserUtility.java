package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public BrowserUtility(WebDriver webDriver) {
        this.webDriver.set(webDriver); //initialize the instance variable webDriver!!!
    }

    public BrowserUtility(String browserName){
        logger.info("Launching browser: " + browserName);
        if(browserName.equalsIgnoreCase("chrome")){
            webDriver.set(new ChromeDriver());
        }else if(browserName.equalsIgnoreCase("edge")){
            webDriver.set(new EdgeDriver());
        }else{
            logger.error("Invalid Browser Name...Please select Chrome or Edge Only.");
            System.err.println("Invalid Browser Name...Please select Chrome or Edge Only.");
        }
    }

    public BrowserUtility(Browser browserName){
        logger.info("Launching browser: " + browserName);
        if(browserName == Browser.CHROME){
            webDriver.set(new ChromeDriver());
        }else if(browserName == Browser.EDGE){
            webDriver.set(new EdgeDriver());
        }else if(browserName == Browser.FIREFOX){
            webDriver.set(new FirefoxDriver());
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadless){
        logger.info("Launching browser: " + browserName);
        if(browserName == Browser.CHROME){
            if(isHeadless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=old");
                chromeOptions.addArguments("--window-size=1920,1080");
                webDriver.set(new ChromeDriver(chromeOptions));
            }else {
                webDriver.set(new ChromeDriver());
            }
        }else if(browserName == Browser.EDGE){
            if(isHeadless){
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=old");
                edgeOptions.addArguments("disable-gpu");
                webDriver.set(new EdgeDriver(edgeOptions));
            }else {
                webDriver.set(new EdgeDriver());
            }
        }else if(browserName == Browser.FIREFOX){
            if(isHeadless){
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=old");
                webDriver.set(new FirefoxDriver(firefoxOptions));
            }
            webDriver.set(new FirefoxDriver());
        }
    }
    public void goToWebsite(String url){
        logger.info("Visiting the website: " + url);
        webDriver.get().get(url);
    }

    public void maximizeWindow(){
        logger.info("Maximizing window");
        webDriver.get().manage().window().maximize();
    }
    public void clickOn(By locator){
        logger.info("Finding element with locator: " + locator);
        WebElement webElement = webDriver.get().findElement(locator);
        logger.info("Element found and performing click action");
        webElement.click();
    }

    public void enterText(By locator, String textToEnter){
        logger.info("Finding element with locator: " + locator);
        WebElement txtEmailAddressWebElement = webDriver.get().findElement(locator);
        logger.info("Element found and entering text: " + textToEnter);
        txtEmailAddressWebElement.sendKeys(textToEnter);
    }
    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    public String getVisibleText(By locator){
        logger.info("Finding element with locator: " + locator);
        WebElement webElement = webDriver.get().findElement(locator);
        logger.info("Element found now returning the visible text: " + webElement.getText());
        return webElement.getText();
    }

    public String takeScreenShot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot)webDriver.get();
        File screenshotData = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = simpleDateFormat.format(date);
        String path = "./screenshots/" + name + "-" + timeStamp + ".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    public void quit(){
        webDriver.get().quit();
    }
}

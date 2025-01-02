package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtility {
    private static final By USERNAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }
    public String getUserName(){
        return getVisibleText(USERNAME_LOCATOR);
    }
}

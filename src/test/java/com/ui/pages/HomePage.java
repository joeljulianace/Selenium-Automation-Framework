package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;

import static com.utility.JSONUtility.*;

import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LOCATOR = By.xpath("//a[normalize-space()='Sign in']");
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public HomePage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
//        goToWebsite(readProperty(QA, "URL"));
        goToWebsite(readJSON(QA).getUrl());
        maximizeWindow();
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
//        goToWebsite(readProperty(QA, "URL"));
        goToWebsite(readJSON(QA).getUrl());
        maximizeWindow();
    }

    public LoginPage goToLoginPage(){
        logger.info("Navigating to login page");
        clickOn(SIGN_IN_LOCATOR);
        LoginPage loginPage = new LoginPage(getWebDriver());
        return loginPage;
    }
}

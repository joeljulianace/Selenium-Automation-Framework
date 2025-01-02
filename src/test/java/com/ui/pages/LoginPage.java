package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    private static final By TXT_EMAIL_ADDRESS_LOCATOR = By.id("email");
    private static final By TXT_PASSWORD_LOCATOR = By.id("passwd");
    private static final By BTN_SIGN_IN_LOCATOR = By.id("SubmitLogin");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyAccountPage doLoginWith(String username, String password){
        enterText(TXT_EMAIL_ADDRESS_LOCATOR, username);
        enterText(TXT_PASSWORD_LOCATOR, password);
        clickOn(BTN_SIGN_IN_LOCATOR);
        MyAccountPage myAccountPage = new MyAccountPage(getWebDriver());
        return myAccountPage;
    }
}

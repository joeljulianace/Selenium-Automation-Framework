package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    private static final By TXT_EMAIL_ADDRESS_LOCATOR = By.id("email");
    private static final By TXT_PASSWORD_LOCATOR = By.id("passwd");
    private static final By BTN_SIGN_IN_LOCATOR = By.id("SubmitLogin");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[@class='alert alert-danger']/ol/li");

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

    public LoginPage doLoginWithInvalidCredentials(String username, String password){
        enterText(TXT_EMAIL_ADDRESS_LOCATOR, username);
        enterText(TXT_PASSWORD_LOCATOR, password);
        clickOn(BTN_SIGN_IN_LOCATOR);
        LoginPage loginPage = new LoginPage(getWebDriver());
        return loginPage;
    }

    public String getErrorMessage(){
        return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }
}

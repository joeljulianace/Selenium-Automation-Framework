package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmAddressPage extends BrowserUtility {

    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processAddress");

    public ConfirmAddressPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ShippingPage goToShippingPage(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new ShippingPage(getWebDriver());
    }
}

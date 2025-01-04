package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BrowserUtility {

    private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.id("uniform-cgv");
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processCarrier");

    public ShippingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentPage goToPaymentPage(){
        clickOnCheckbox(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new PaymentPage(getWebDriver());
    }
}

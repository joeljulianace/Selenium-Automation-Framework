package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PaymentPage extends BrowserUtility {

    private static final By PAY_BY_BANK_WIRE_BUTTON_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
    private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR = By.xpath("//p[@id='cart_navigation']/button");
    private static final By ALERT_SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[contains(@class, 'success')]");

    public PaymentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String makePaymentByWire(){
        clickOn(PAY_BY_BANK_WIRE_BUTTON_LOCATOR);
        clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
        return getVisibleText(ALERT_SUCCESS_MESSAGE_LOCATOR);
    }
}

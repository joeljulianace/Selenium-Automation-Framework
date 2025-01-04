package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BrowserUtility {

    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");

    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ConfirmAddressPage goToConfirmAddressPage(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON);
        return new ConfirmAddressPage(getWebDriver());
    }
}

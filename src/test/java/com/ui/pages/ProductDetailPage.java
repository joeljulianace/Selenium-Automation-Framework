package com.ui.pages;

import com.constants.Size;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BrowserUtility {
    private static final By SIZE_DROPDOWN_LOCATOR = By.id("group_1");
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");

    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductDetailPage changeSize(Size size){
        selectFromDropDown(SIZE_DROPDOWN_LOCATOR, size.toString());
        return new ProductDetailPage(getWebDriver());
    }

    public ProductDetailPage addProductToCart(){
        clickOn(ADD_TO_CART_BUTTON_LOCATOR);
        return new ProductDetailPage(getWebDriver());
    }

    public ShoppingCartPage proceedToCheckOut(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new ShoppingCartPage(getWebDriver());
    }
}

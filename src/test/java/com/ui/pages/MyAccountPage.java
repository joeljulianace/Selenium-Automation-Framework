package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtility {
    private static final By USERNAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
    private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
    private static final By ADD_NEW_ADDRESS_LOCATOR = By.xpath("//a[@title='Add my first address']");

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserName(){
        return getVisibleText(USERNAME_LOCATOR);
    }

    public SearchResultPage searchForProduct(String productName){
        enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
        enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
        SearchResultPage searchResultPage = new SearchResultPage(getWebDriver());
        return searchResultPage;
    }

    public AddressPage goToAddressPage(){
        clickOn(ADD_NEW_ADDRESS_LOCATOR);
        AddressPage addressPage = new AddressPage(getWebDriver());
        return addressPage;
    }
}

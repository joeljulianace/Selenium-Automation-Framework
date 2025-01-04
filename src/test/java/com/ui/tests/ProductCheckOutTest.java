package com.ui.tests;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckOutTest extends TestBase {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final String VALID_USERAME = "bakomam596@skrak.com";
    private static final String VALID_PASSWORD = "password";
    private static final String SEARCH_TEXT = "Printed Summer Dress";
    private SearchResultPage searchResultPage;

    @BeforeMethod(description = "User logs into the application and searches for a product")
    public void setup(){
        searchResultPage = homePage.goToLoginPage().doLoginWith(VALID_USERAME, VALID_PASSWORD).searchForProduct(SEARCH_TEXT);
    }

    @Test(description = "Verify if logged in user can purchase a product",
    groups = {"e2e", "smoke", "sanity"})
    public void checkOutTest(){
        String result = searchResultPage.clickOnProductAtIndex(0).changeSize(L).addProductToCart().
                proceedToCheckOut().goToConfirmAddressPage()
                .goToShippingPage()
                .goToPaymentPage()
                .makePaymentByWire();
        System.out.println(result);
        Assert.assertTrue(result.contains("complete"));
    }
}

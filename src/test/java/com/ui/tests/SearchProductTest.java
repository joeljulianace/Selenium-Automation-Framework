package com.ui.tests;


import com.ui.pages.MyAccountPage;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final String VALID_USERAME = "bakomam596@skrak.com";
    private static final String VALID_PASSWORD = "password";
    private static final String SEARCH_TEXT = "T-shirts";
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void setup(){
        myAccountPage = homePage.goToLoginPage().doLoginWith(VALID_USERAME, VALID_PASSWORD);
    }

    @Test(description = "Verify product search functionality for a logged in user",
            groups = {"e2e", "sanity", "smoke"})
    public void verifySearchProductTest(){
        boolean actualResult = myAccountPage.searchForProduct(SEARCH_TEXT).isSearchTermPresentInProductList(SEARCH_TEXT);
        Assert.assertEquals(actualResult, true);
    }
}

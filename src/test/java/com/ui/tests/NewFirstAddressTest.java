package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.Address;
import com.utility.FakeAddressUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewFirstAddressTest extends TestBase{
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final String VALID_USERAME = "bakomam596@skrak.com";
    private static final String VALID_PASSWORD = "password";
    private MyAccountPage myAccountPage;
    private Address address;

    @BeforeMethod(description = "Valid First Time user logs into the application")
    public void setup(){
        myAccountPage = homePage.goToLoginPage().doLoginWith(VALID_USERAME, VALID_PASSWORD);
        address = FakeAddressUtility.getFakeAddress();
    }

    @Test
    public void addNewFirstAddress(){
        String newAddress = myAccountPage.goToAddressPage().saveAddress(address);
        Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
    }
}

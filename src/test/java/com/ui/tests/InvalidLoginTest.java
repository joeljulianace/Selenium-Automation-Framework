package com.ui.tests;

import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({com.ui.listeners.TestListener.class})
public class InvalidLoginTest extends TestBase {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final String INVALID_EMAIL_ADDRESS = "randomuser@gmail.com";
    private static final String INVALID_PASSWORD = "Qwerty1234!";


    @Test(description = "Verify proper error message is displayed when user enters invalid credentials",
            groups = {"e2e", "sanity"})
    public void invalidLoginTest() {
        assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
                        .getErrorMessage(),
                "Authentication failed.");
    }
}

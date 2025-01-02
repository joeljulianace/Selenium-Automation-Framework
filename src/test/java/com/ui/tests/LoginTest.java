package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;

import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase {

    /**
     * 1. Test Script should be small!!!
     * 2. Test methods should not have conditional statements, loops, try-catch exception handling
     * 3. TestScripts should execute the test steps
     * 4. Reduce usage of local variables
     * 5. At least one assertion
     */
    @Test(description = "Verify valid login functionality",
            groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestDataProvider",
            retryAnalyzer = com.ui.listeners.CustomRetryAnalyzer.class)
    public void loginTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Jatin Sharma");
    }

    @Test(description = "Verify valid login functionality",
            groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "loginTestCSVDataProvider",
            retryAnalyzer = com.ui.listeners.CustomRetryAnalyzer.class)  
    public void loginCSVTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Jatin Sharma");
    }

    @Test(description = "Verify valid login functionality",
            groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "loginTestExcelDataProvider",
            retryAnalyzer = com.ui.listeners.CustomRetryAnalyzer.class)
    public void loginExcelTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Jatin Sharma1");
    }
}

package com.ui.pages;

import com.ui.pojo.Address;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BrowserUtility {

    private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
    private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
    private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
    private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
    private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
    private static final By POST_CODE_TEXTBOX_LOCATOR = By.id("postcode");
    private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.id("phone");
    private static final By MOBILE_PHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
    private static final By ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR = By.id("other");
    private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
    private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
    private static final By ADDRESS_HEADING = By.tagName("h3");

    public AddressPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String saveAddress(Address address){
        enterText(COMPANY_TEXTBOX_LOCATOR, address.getCompany());
        enterText(ADDRESS1_TEXTBOX_LOCATOR, address.getAddressLine1());
        enterText(ADDRESS2_TEXTBOX_LOCATOR, address.getAddressLine2());
        enterText(CITY_TEXTBOX_LOCATOR, address.getCity());
        enterText(POST_CODE_TEXTBOX_LOCATOR, address.getPostCode());
        enterText(HOME_PHONE_TEXTBOX_LOCATOR, address.getHomePhoneNumber());
        enterText(MOBILE_PHONE_TEXTBOX_LOCATOR, address.getMobileNumber());
        enterText(ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR, address.getOtherInformation());
        clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
        enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, address.getAddressAlias());
        selectFromDropDown(STATE_DROPDOWN_LOCATOR, address.getState());
        clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
        String heading = getVisibleText(ADDRESS_HEADING);
        return heading;
    }
}

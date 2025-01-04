package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {

    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
    private static final By ALL_PRODUCT_NAMES_LOCATOR = By.xpath("//h5[@itemprop='name']/a");

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getSearchResultTitle(){
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchText){
        List<String> keywords = Arrays.asList(searchText.toLowerCase().split(" "));
        List<String> allProductNames = getAllVisibleText(ALL_PRODUCT_NAMES_LOCATOR);
        boolean result = allProductNames.stream()
                .anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
        return result;
    }

    public ProductDetailPage clickOnProductAtIndex(int index){
        WebElement productElement = getAllElements(ALL_PRODUCT_NAMES_LOCATOR).get(index);
        clickOn(productElement);
        ProductDetailPage productDetailPage = new ProductDetailPage(getWebDriver());
        return productDetailPage;
    }
}

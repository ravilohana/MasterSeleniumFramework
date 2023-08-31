package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    private final By searchFld = By.cssSelector("input.search-field");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector("header > h1");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");


    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterTextSearchFld(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(text);
        return this;
    }

    private StorePage clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }

    public StorePage search(String text){
        enterTextSearchFld(text).clickSearchBtn();
        return this;
    }

    public String getTitle(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    private By getAddToCartEle(String productName){
        return By.cssSelector("div.astra-shop-summary-wrap > a[aria-label='Add “"+productName+"” to your cart']");
    }
    public StorePage clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartEle(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }

    public CartPage clickViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartPage(driver);
    }

}

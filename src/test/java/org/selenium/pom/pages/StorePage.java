package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.findElement(searchFld).sendKeys(text);
        return this;
    }

    private StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }

    public StorePage search(String text){
        enterTextSearchFld(text).clickSearchBtn();
        return this;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    private By getAddToCartEle(String productName){
        return By.cssSelector("div.astra-shop-summary-wrap > a[aria-label='Add “"+productName+"” to your cart']");
    }
    public StorePage clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartEle(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }

    public CartPage clickViewCart(){
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }

}

package org.selenium.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;

public class ProductThumbnail extends BasePage {

    private final By viewCartLink = By.cssSelector("a[title='View cart']");
    public ProductThumbnail(WebDriver driver) {
        super(driver);

    }



    private By getAddToCartEle(String productName){
        return By.cssSelector("div.astra-shop-summary-wrap > a[aria-label='Add “"+productName+"” to your cart']");
    }
    public ProductThumbnail clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartEle(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }

    public CartPage clickViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartPage(driver);
    }

}

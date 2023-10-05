package org.selenium.pom.pages;

import objects.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

import java.io.IOException;

public class HomePage extends BasePage {


    private final By storeMenuLink = By.cssSelector("#primary-site-navigation > div  > ul > li:nth-child(2)  > a");

    private final By viewCartLink = By.cssSelector("a[title='View cart']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public StorePage clickStoreMenuLink(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }

    public ProductPage navigateToTheProduct(Integer id) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[normalize-space()='"+ new Products(id).getName() + "']"))).click();
        return new ProductPage(driver);
    }

    private By getAddToCartEle(String productName){
        return By.cssSelector("div.astra-shop-summary-wrap > a[aria-label='Add “"+productName+"” to your cart']");
    }
    public HomePage clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartEle(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }

    public CartPage clickViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartPage(driver);
    }
}

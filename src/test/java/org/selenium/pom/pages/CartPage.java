package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td.product-name > a");
    private final By checkoutBtn = By.cssSelector(" div.wc-proceed-to-checkout > a");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
            return  wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
//        return driver.findElement(productName).getText();
    }

    public CheckoutPage clickCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
//        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}

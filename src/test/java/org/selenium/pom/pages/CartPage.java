package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

//    private final By productName = By.cssSelector("td.product-name > a");
//    private final By checkoutBtn = By.cssSelector(" div.wc-proceed-to-checkout > a");


    @FindBy(css = "td.product-name > a")
    WebElement productName;

    @FindBy(how = How.CSS, using = "div.wc-proceed-to-checkout > a")
    WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getProductName(){
            return  wait.until(ExpectedConditions.visibilityOf(productName)).getText();
//        return driver.findElement(productName).getText();
    }

    public CheckoutPage clickCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
//        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}

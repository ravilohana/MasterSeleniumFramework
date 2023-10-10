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

    @FindBy(id = "coupon_code")
    WebElement couponCodeText;

    @FindBy(name = "apply_coupon")
    WebElement applyCouponBtn;

    @FindBy(id = "shipping_method_0_free_shipping2")
    WebElement freeShippingRadioBtn;


    @FindBy(css = "#shipping_method > li > label > span > bdi")
    WebElement cartShippingPrice;

    @FindBy(css = "tr.order-total  > td > strong > span > bdi")
    WebElement cartTotalPrice;

    @FindBy(xpath = "//td[@data-title='CA State Tax']/span")
    WebElement cartCAStateTaxPrice;

    @FindBy(xpath = "//td[@data-title='Coupon: offcart5']/span")
    WebElement couponCodeOffCart5;

    @FindBy(xpath = "//td[@data-title='Coupon: off25']/span")
    WebElement couponCodeOff25;


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

    public CartPage enterCouponCode(String couponCode){
        wait.until(ExpectedConditions.visibilityOf(couponCodeText)).sendKeys(couponCode);
        return this;
    }

    public CartPage clickApplyCouponBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(applyCouponBtn)).click();
        return this;
    }


    public boolean isFreeShippingEnable(){
        wait.until(ExpectedConditions.visibilityOf(freeShippingRadioBtn));
        return freeShippingRadioBtn.isSelected();
    }

    public String getCartShippingPrice() {
        return wait.until(ExpectedConditions.visibilityOf(cartShippingPrice)).getText();
    }


    public String getCartTotalPrice() {
        return wait.until(ExpectedConditions.visibilityOf(cartTotalPrice)).getText();
    }

    public String getCartCAStateTaxPrice() {
        return wait.until(ExpectedConditions.visibilityOf(cartCAStateTaxPrice)).getText();
    }

    public String getCouponCodeOffCart5() {
        return wait.until(ExpectedConditions.visibilityOf(couponCodeOffCart5)).getText();
    }

    public String getCouponCodeOff25() {
        return wait.until(ExpectedConditions.visibilityOf(couponCodeOff25)).getText();
    }

    public  float convertStrToFloat(String str){
        return Float.parseFloat(str.substring(1));
    }

}

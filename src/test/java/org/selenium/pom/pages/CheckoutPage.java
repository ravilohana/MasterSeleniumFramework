package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;


public class CheckoutPage extends BasePage {

    private final By firstName = By.id("billing_first_name");
    private final By lastName = By.id("billing_last_name");
    private final By billing_company = By.id("billing_company");
//    private final By billing_country = By.id("billing_country");
    private final By billing_address_1 = By.id("billing_address_1");
    private final By billing_address_2 = By.id("billing_address_2");
    private final By billing_city = By.id("billing_city");
//    private final By billing_state = By.id("billing_state");
    private final By billing_postcode = By.id("billing_postcode");
    private final By billing_phone = By.id("billing_phone");
    private final By billing_email = By.id("billing_email");

    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.cssSelector("div.woocommerce-order > p");

    private final By loginLinkFromCheckout = By.cssSelector(".woocommerce-form-login-toggle > div > a");
    private final By usernameFromCheckout = By.id("username");
    private final By passwordFromCheckout = By.id("password");
    private final By loginBtnFromCheckout = By.name("login");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }



    public void selectOptions(WebElement element,  String txt){
        Select select = new Select(element);
        select.selectByVisibleText(txt);
    }



    public CheckoutPage billingDetailsForm(String fName,
                                           String lName,
                                           String compName,
                                           String countryName,
                                           String streetAddress_1,
                                           String streetAddress_2,
                                           String city,
                                           String state,
                                           String zipCode,
                                           String phone_no,
                                           String email_id) throws InterruptedException {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);

        driver.findElement(billing_company).clear();
        driver.findElement(billing_company).sendKeys(compName);

//          driver.findElement(billing_country).sendKeys(countryName);
        selectOptions(driver.findElement(By.id("billing_country")),countryName);
        Thread.sleep(3000);
        driver.findElement(billing_address_1).clear();
        driver.findElement(billing_address_1).sendKeys(streetAddress_1);
        driver.findElement(billing_address_2).clear();
        driver.findElement(billing_address_2).sendKeys(streetAddress_2);
        driver.findElement(billing_city).clear();
        driver.findElement(billing_city).sendKeys(city);

//        driver.findElement(billing_state).sendKeys(state);
        selectOptions(driver.findElement(By.id("billing_state")),state);
        Thread.sleep(3000);
        driver.findElement(billing_postcode).clear();
        driver.findElement(billing_postcode).sendKeys(zipCode);
        driver.findElement(billing_phone).clear();
        driver.findElement(billing_phone).sendKeys(phone_no);
        driver.findElement(billing_email).clear();
        driver.findElement(billing_email).sendKeys(email_id);
        return this;
    }

    public CheckoutPage clickPlaceOrderBtn(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        return  driver.findElement(successNotice).getText();
    }

    public CheckoutPage loginFromCheckoutPage() throws InterruptedException {
        driver.findElement(loginLinkFromCheckout).click();
        Thread.sleep(3000);
        driver.findElement(usernameFromCheckout).sendKeys("seleniumFramework");
        driver.findElement(passwordFromCheckout).sendKeys("$Framework$@2023");
        driver.findElement(loginBtnFromCheckout).click();
        Thread.sleep(2000);
        return this;
    }


}

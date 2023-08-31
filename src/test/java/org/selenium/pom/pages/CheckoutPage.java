package org.selenium.pom.pages;

import objects.BillingAddress;
import objects.LoginCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private final By overlays = By.cssSelector(".blockUI.blockOverlay");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }



    public void selectOptions(WebElement element,  String txt){
        Select select = new Select(element);
        select.selectByVisibleText(txt);
    }


/*
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
*/

    public CheckoutPage enterFirstName(String fName){
        WebElement eleFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        eleFirstName.clear();
        eleFirstName.sendKeys(fName);
        return this;
    }

    public CheckoutPage enterLastName(String lName){
        WebElement eleLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        eleLastName.clear();
        eleLastName.sendKeys(lName);
        return this;
    }


    public CheckoutPage enterBillingCompany(String billing_Comp){
        WebElement eleBillingComp = wait.until(ExpectedConditions.visibilityOfElementLocated(billing_company));
        eleBillingComp.clear();
        eleBillingComp.sendKeys(billing_Comp);
        return this;
    }

    public CheckoutPage enterBillingCountry(String bill_country){
        selectOptions(driver.findElement(By.id("billing_country")),bill_country);
        return this;
    }

    public CheckoutPage enterBillingAddressOne(String bill_address_one){
        WebElement eleBillAddressOne = wait.until(ExpectedConditions.visibilityOfElementLocated(billing_address_1));
        eleBillAddressOne.clear();
        eleBillAddressOne.sendKeys(bill_address_one);
        return this;
    }

    public CheckoutPage enterBillingAddressTwo(String bill_address_two){
        WebElement eleBillAddressTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(billing_address_2));
        eleBillAddressTwo.clear();
        eleBillAddressTwo.sendKeys(bill_address_two);
        return this;
    }


    public CheckoutPage enterBillingCity(String bill_city){
        WebElement eleBillingCity = wait.until(ExpectedConditions.visibilityOfElementLocated(billing_city));
        eleBillingCity.clear();
        eleBillingCity.sendKeys(bill_city);
        return this;
    }

    public CheckoutPage enterBillingState(String bill_state){
        selectOptions(driver.findElement(By.id("billing_state")),bill_state);
        return this;
    }

    public CheckoutPage enterPostalCode(String postal_code){
        WebElement eleBillingPostcode = wait.until(ExpectedConditions.visibilityOfElementLocated(billing_postcode));
        eleBillingPostcode.clear();
        eleBillingPostcode.sendKeys(postal_code);
        return this;
    }


    public CheckoutPage enterBillingPhoneNo(String bill_ph_no){
        WebElement eleBillingPhoneNo = wait.until(ExpectedConditions.visibilityOfElementLocated(billing_phone));
        eleBillingPhoneNo.clear();
        eleBillingPhoneNo.sendKeys(bill_ph_no);
        return this;
    }

    public CheckoutPage enterBillingEmailId(String bill_email_id){
        WebElement eleBillingEmailId = wait.until(ExpectedConditions.visibilityOfElementLocated(billing_email));
        eleBillingEmailId.clear();
        eleBillingEmailId.sendKeys(bill_email_id);
        return this;
    }

    public CheckoutPage clickLoginLinkFromCheckout(){
       wait.until(ExpectedConditions.elementToBeClickable(loginLinkFromCheckout)).click();
       return this;
    }


    public CheckoutPage enterUsername(String username){
        WebElement eleUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFromCheckout));
        eleUsername.clear();
        eleUsername.sendKeys(username);
        return this;
    }


    public CheckoutPage enterPassword(String password){
        WebElement elePassword= wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFromCheckout));
        elePassword.clear();
        elePassword.sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginBtnFromCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtnFromCheckout)).click();
        return this;
    }

    public CheckoutPage setBillingEmailIDOnLogin(LoginCredentials loginCredentials){
        enterBillingEmailId(loginCredentials.getEmail_id());
        return this;
    }




    public CheckoutPage setBillingAddressFields(BillingAddress billingAddress) throws InterruptedException {

        enterFirstName(billingAddress.getFirstname());
        enterLastName(billingAddress.getLastname());
        enterBillingCompany(billingAddress.getCompanyName());

//          driver.findElement(billing_country).sendKeys(countryName);
        enterBillingCountry(billingAddress.getCountryName());
//        Thread.sleep(3000);
        enterBillingAddressOne(billingAddress.getStreetAddressOne());
        enterBillingAddressTwo(billingAddress.getStreetAddressTwo());
        enterBillingCity(billingAddress.getCity());
        enterBillingState(billingAddress.getState());
//        Thread.sleep(3000);
        enterPostalCode(billingAddress.getZipCode());
        enterBillingPhoneNo(billingAddress.getPhone_no());
        enterBillingEmailId(billingAddress.getEmail_id());
        return this;
    }

    public CheckoutPage clickPlaceOrderBtn(){
        waitForOverlaysToDisappear(overlays);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }

    public CheckoutPage loginFromCheckoutPage(LoginCredentials loginCredentials) throws InterruptedException {
        clickLoginLinkFromCheckout();
        enterUsername(loginCredentials.getUsername());
        enterPassword(loginCredentials.getPassword());
        clickLoginBtnFromCheckout();
        return this;
    }


}

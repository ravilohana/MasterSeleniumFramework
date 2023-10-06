package org.selenium.pom.tests;

import objects.BillingAddress;
import objects.BillingCountries;
import objects.LoginCredentials;
import objects.Products;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProviders.AppDataProviders;
import org.selenium.pom.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FakerUtils;
import utils.JacksonUtils;
import webAPI.actions.CartAPI;
import webAPI.actions.SignUpAPI;

import java.io.IOException;

public class CheckoutTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("./json_files/billing_address_checkout_page_fields.json"
                ,BillingAddress.class);
        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();


        CartAPI cartAPI = new CartAPI();
        cartAPI.addToCartAPI(1215,1);
        injectCookiesToBrowser(cartAPI.getCookies());

        checkoutPage.load()
                .setBillingAddressFields(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderBtn();


        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }


    @Test
    public void LoginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("./json_files/billing_address_checkout_page_fields.json"
                ,BillingAddress.class);
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        String email_id = "demouser"+ new FakerUtils().generateRandomNumber()+"@gmail.com";
        String password = "demouser"+ new FakerUtils().generateRandomNumber();
        LoginCredentials userRegister = new LoginCredentials()
                .setUsername(username)
                .setEmail_id(email_id)
                .setPassword(password);
        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(userRegister);

        CartAPI cartAPI = new CartAPI(signUpAPI.getCookies());
        Products products = new Products(1215);
        cartAPI.addToCartAPI(products.getId(), 1);


        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(signUpAPI.getCookies());
        checkoutPage.load()
                .setBillingAddressFields(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderBtn();
    }

    @Test(dataProvider = "getCountryNames", dataProviderClass = AppDataProviders.class)
    public void guestCheckoutUsingDirectBankTransferDiffCountries(BillingCountries billingCountry) throws IOException, InterruptedException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("./json_files/billing_address_checkout_page_fields.json"
                ,BillingAddress.class);
        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();


        CartAPI cartAPI = new CartAPI();
        cartAPI.addToCartAPI(1215,1);
        injectCookiesToBrowser(cartAPI.getCookies());
        checkoutPage.load();
        if (billingCountry.getCountryName().equals("United Kingdom (UK)")){
            checkoutPage
                    .enterBillingCountry(billingCountry.getCountryName())
                    .enterTextBillingState(billingCountry.getStateName());
        }else {
            checkoutPage
                    .enterBillingCountry(billingCountry.getCountryName())
                    .enterBillingState(billingCountry.getStateName());
        }


        checkoutPage
                .enterPostalCode(billingCountry.getZipCode())
                .setBillingAddressFields(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderBtn();



        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }



    @Test(dataProvider = "getCountryNames", dataProviderClass = AppDataProviders.class)
    public void LoginAndCheckoutUsingDirectBankTransferDiffCountries(BillingCountries billingCountry) throws IOException, InterruptedException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("./json_files/billing_address_checkout_page_fields.json"
                ,BillingAddress.class);
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        String email_id = "demouser"+ new FakerUtils().generateRandomNumber()+"@gmail.com";
        String password = "demouser"+ new FakerUtils().generateRandomNumber();
        LoginCredentials userRegister = new LoginCredentials()
                .setUsername(username)
                .setEmail_id(email_id)
                .setPassword(password);
        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(userRegister);

        CartAPI cartAPI = new CartAPI(signUpAPI.getCookies());
        Products products = new Products(1215);
        cartAPI.addToCartAPI(products.getId(), 1);


        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(signUpAPI.getCookies());
        checkoutPage.load();
        if (billingCountry.getCountryName().equals("United Kingdom (UK)")){
            checkoutPage
                    .enterBillingCountry(billingCountry.getCountryName())
                    .enterTextBillingState(billingCountry.getStateName());
        }else {
            checkoutPage
                    .enterBillingCountry(billingCountry.getCountryName())
                    .enterBillingState(billingCountry.getStateName());
        }


        checkoutPage
                .enterPostalCode(billingCountry.getZipCode())
                .setBillingAddressFields(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderBtn();



        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

}

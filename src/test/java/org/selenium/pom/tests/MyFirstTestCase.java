package org.selenium.pom.tests;


import objects.BillingAddress;
import objects.LoginCredentials;
import objects.Products;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JacksonUtils;

import java.io.IOException;
import java.io.InputStream;


public class MyFirstTestCase extends BaseTest {


  //  @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

/*
        // ************* We can do in this way also *************
        // Parameterized Constructor
        // Billing address fields values pass as parameters
        BillingAddress billingAddress = new BillingAddress("Ankit","Tewari",
                "AT Comapny","India","Laxmi Nagar",
                "Street View 1","New Delhi","Delhi","110111",
                "9874563210","at@gmail.com");
        /*
        // Default Constructor
        // Billing address fields values set using setter of billing address class
        // Billing Address Builder pattern
        BillingAddress billingAddress = new BillingAddress()
                .setFirstname("Ankit")
                .setLastname("Tewari")
                .setCompanyName("AT Company")
                .setCountryName("India")
                .setStreetAddressOne("Laxmi Nagar")
                .setStreetAddressTwo("Street view 1")
                .setCity("New Delhi")
                .setState("Delhi")
                .setZipCode("110111")
                .setPhone_no("9874563210")
                .setEmail_id("at@gmail.com");
        */

        // Get the Billing address fields values of checkout page from JSON file

        /*
        BillingAddress billingAddress = new BillingAddress();
        InputStream inputStream = getClass().
                getClassLoader().
                getResourceAsStream("./json_files/billing_address_checkout_page_fields.json");
        billingAddress = JacksonUtils.deserializeJson(inputStream,billingAddress.getClass());
        */

        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("./json_files/billing_address_checkout_page_fields.json"
                ,BillingAddress.class);

        Products products = new Products(1215);

        StorePage storePage = new HomePage(getDriver())
                .load().clickStoreMenuLink()
                .search(searchFor);


        // Functional


        // Structural
//        storePage
//                .enterTextSearchFld("Blue")
//                .clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(), "Search results: “ "+ searchFor+ " ”");
        storePage.clickAddToCartBtn(products.getName());
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), products.getName());
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn()
                .setBillingAddressFields(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderBtn();


        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }


 //   @Test
    public void loginUserFromCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        Products products = new Products(1215);
        BillingAddress billingAddress = JacksonUtils.deserializeJson("./json_files/billing_address_checkout_page_fields.json"
                ,BillingAddress.class);

//        LoginCredentials loginCredentials = JacksonUtils.deserializeJson("./json_files/login_credentials.json"
//                ,LoginCredentials.class);
        StorePage storePage = new HomePage(getDriver())
                .load().clickStoreMenuLink()
                .search("Blue");

//        Thread.sleep(4000);

        // Functional

//        storePage.search("Blue");

        // Structural
//        storePage
//                .enterTextSearchFld("Blue")
//                .clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn(products.getName());
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), products.getName());




        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn()
                .loginFromCheckoutPage()
                .setBillingAddressFields(billingAddress)
                .setBillingEmailIDOnLogin()
                .selectDirectBankTransfer()
                .clickPlaceOrderBtn();



        /*
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.loginFromCheckoutPage();
//        checkoutPage.billingDetailsForm("Ankit","Tewari","AT Company",
        //         "India","Laxmi Nagar","Street view 1",
        //        "New Delhi","Delhi","110111","9874563210","framework@selenium.com");

        checkoutPage.clickPlaceOrderBtn();
        Thread.sleep(5000);
*/
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }


}

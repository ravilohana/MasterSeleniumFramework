package org.selenium.pom.tests;


import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class MyFirstTestCase extends BaseTest {


    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        StorePage storePage = new HomePage(driver)
                .load().clickStoreMenuLink()
                .search("Blue");


        // Functional

   

        // Structural
//        storePage
//                .enterTextSearchFld("Blue")
//                .clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.billingDetailsForm("Ankit","Tewari","AT Company",
                "India","Laxmi Nagar","Street view 1",
                "New Delhi","Delhi","110111","9874563210","at@gmail.com");

        checkoutPage.clickPlaceOrderBtn();
        Thread.sleep(5000);

        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }



    @Test
    public void loginUserFromCheckoutUsingDirectBankTransfer() throws InterruptedException {
        StorePage storePage = new HomePage(driver)
                .load().clickStoreMenuLink()
                .search("Blue");

        // Functional

//        storePage.search("Blue");

        // Structural
//        storePage
//                .enterTextSearchFld("Blue")
//                .clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.loginFromCheckoutPage();
        checkoutPage.billingDetailsForm("Ankit","Tewari","AT Company",
                "India","Laxmi Nagar","Street view 1",
                "New Delhi","Delhi","110111","9874563210","framework@selenium.com");

        checkoutPage.clickPlaceOrderBtn();
        Thread.sleep(5000);

        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }



}

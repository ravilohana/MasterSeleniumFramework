package org.selenium.pom.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ThreadExecutorMap;
import objects.Products;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProviders.AppDataProviders;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.JacksonUtils;
import webAPI.actions.CartAPI;

import java.io.IOException;
import java.util.Properties;

public class AddToCartTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addToCartFromStorePage() throws IOException {
        Products products = new Products(1215);
        CartPage cartPage = new StorePage(getDriver())
                .load().getProductThumbnail()
                .clickAddToCartBtn(products.getName())
                .clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), products.getName());
    }

    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = AppDataProviders.class)
    public void addToCartMultipleProductsFromStorePage(Products products) throws IOException {
       // Products products = new Products();
//        System.out.println("--------" + products.getName());
        StorePage storePage = new StorePage(getDriver()).load();
//        System.out.println("---------" + storePage.getStorePageProductNameList());
        if (storePage.getStorePageProductNameList().contains(products.getName())){
            CartPage cartPage = new StorePage(getDriver())
                    .load().getProductThumbnail()
                    .clickAddToCartBtn(products.getName())
                    .clickViewCart();
            Assert.assertEquals(cartPage.getProductName(), products.getName());
        }
    }

    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = AppDataProviders.class)
    public void addToCartOnlyFeaturedProducts(Products products){
        if (products.isFeatured()){
            CartPage cartPage = new HomePage(getDriver()).load()
                    .getProductThumbnail()
                    .clickAddToCartBtn(products.getName())
                    .clickViewCart();
            Assert.assertEquals(cartPage.getProductName(), products.getName());
            Assert.assertTrue(products.isFeatured());
        }
        else {
            System.out.println(" **** Product:" + products.getName() + " is not listed as featured " + products.isFeatured() + " ******* ");
            Assert.assertFalse(products.isFeatured());
        }

    }

    @Test
    public void validateFreeShippingCouponCode() throws IOException {
        Products products = new Products(1215);
        CartPage cartPage = new StorePage(getDriver())
                .load().getProductThumbnail()
                .clickAddToCartBtn(products.getName())
                .clickViewCart();

        float cartTotalPriceWithoutCoupon = cartPage.convertStrToFloat(cartPage.getCartTotalPrice());
        float cartCAStateTaxPrice = cartPage.convertStrToFloat(cartPage.getCartCAStateTaxPrice());
        System.out.println("CA State Tax: " + cartCAStateTaxPrice);
        System.out.println("Total Price Before Applying Coupon Code: " + cartTotalPriceWithoutCoupon);
        cartPage
                .enterCouponCode("freeship")
                .clickApplyCouponBtn();

        Assert.assertTrue(cartPage.isFreeShippingEnable());

        float cartShipPrice = cartPage.convertStrToFloat(cartPage.getCartShippingPrice());
        float cartTotalPriceWithCoupon = cartPage.convertStrToFloat(cartPage.getCartTotalPrice());

        System.out.println("Shipping Price: " + cartShipPrice);
        System.out.println("Total Price After applying Coupon Code : " + cartTotalPriceWithCoupon);



        Assert.assertEquals(cartTotalPriceWithCoupon,(cartTotalPriceWithoutCoupon - cartShipPrice));


    }


    @Test
    public void validateCouponCodeOffCart5() throws IOException {
        String couponCode = "offcart5";
        Products products = new Products(1215);
        CartPage cartPage = new StorePage(getDriver())
                .load().getProductThumbnail()
                .clickAddToCartBtn(products.getName())
                .clickViewCart();
        float cartTotalPriceWithoutCoupon = cartPage.convertStrToFloat(cartPage.getCartTotalPrice());
        float cartCAStateTaxPrice = cartPage.convertStrToFloat(cartPage.getCartCAStateTaxPrice());
        System.out.println("CA State Tax: " + cartCAStateTaxPrice);
        System.out.println("Total Price Before Applying Coupon Code: " + cartTotalPriceWithoutCoupon);
        cartPage
                .enterCouponCode(couponCode)
                .clickApplyCouponBtn();

        float couponOffCart5 = cartPage.convertStrToFloat(cartPage.getCouponCodeOffCart5());

        float cartTotalPriceWithCouponOffCart5 = cartPage.convertStrToFloat(cartPage.getCartTotalPrice());


        Assert.assertEquals(cartTotalPriceWithCouponOffCart5,(Math.round(cartTotalPriceWithoutCoupon - couponOffCart5)));

    }


    @Test
    public void validateCouponCodeOff25() throws IOException {
        String couponCode = "off25";
        Products products = new Products(1215);
        CartPage cartPage = new StorePage(getDriver())
                .load().getProductThumbnail()
                .clickAddToCartBtn(products.getName())
                .clickViewCart();
        float cartTotalPriceWithoutCoupon = cartPage.convertStrToFloat(cartPage.getCartTotalPrice());
        float cartCAStateTaxPrice = cartPage.convertStrToFloat(cartPage.getCartCAStateTaxPrice());
        System.out.println("CA State Tax: " + cartCAStateTaxPrice);
        System.out.println("Total Price Before Applying Coupon Code: " + cartTotalPriceWithoutCoupon);
        cartPage
                .enterCouponCode(couponCode)
                .clickApplyCouponBtn();

        float couponOff25 = cartPage.convertStrToFloat(cartPage.getCouponCodeOff25());

        float cartTotalPriceWithCouponOff25 = cartPage.convertStrToFloat(cartPage.getCartTotalPrice());


        System.out.println("Coupon 25% Applied: " + couponOff25 );

        System.out.println("Cart Total Price After 25% coupon applied: " + cartTotalPriceWithCouponOff25);

        // 25 % if total price


        softAssert.assertEquals(cartTotalPriceWithCouponOff25,(cartTotalPriceWithoutCoupon - couponOff25),"BUG: Calculation is not done proper.");
        softAssert.assertAll();
    }


    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = AppDataProviders.class)
    public void addToCartMultipleProductsFromStorePageFreeShipping(Products products) throws IOException {
        // Products products = new Products();
//        System.out.println("--------" + products.getName());
        StorePage storePage = new StorePage(getDriver()).load();
//        System.out.println("---------" + storePage.getStorePageProductNameList());
        if (storePage.getStorePageProductNameList().contains(products.getName())){
            CartPage cartPage = new StorePage(getDriver())
                    .load().getProductThumbnail()
                    .clickAddToCartBtn(products.getName())
                    .clickViewCart();
            Assert.assertEquals(cartPage.getProductName(), products.getName());
            float cartTotalPriceWithoutCoupon = cartPage.convertStrToFloat(cartPage.getCartTotalPrice());
            float cartCAStateTaxPrice = cartPage.convertStrToFloat(cartPage.getCartCAStateTaxPrice());
            System.out.println("CA State Tax: " + cartCAStateTaxPrice);
            System.out.println("Total Price Before Applying Coupon Code: " + cartTotalPriceWithoutCoupon);
            cartPage
                    .enterCouponCode("freeship")
                    .clickApplyCouponBtn();

            Assert.assertTrue(cartPage.isFreeShippingEnable());

            float cartShipPrice = cartPage.convertStrToFloat(cartPage.getCartShippingPrice());
            float cartTotalPriceWithCoupon = cartPage.convertStrToFloat(cartPage.getCartTotalPrice());

            System.out.println("Shipping Price: " + cartShipPrice);
            System.out.println("Total Price After applying Coupon Code : " + cartTotalPriceWithCoupon);



            Assert.assertEquals(cartTotalPriceWithCoupon,(cartTotalPriceWithoutCoupon - cartShipPrice));
        }



    }








}

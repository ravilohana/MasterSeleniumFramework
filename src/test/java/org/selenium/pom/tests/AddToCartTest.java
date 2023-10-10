package org.selenium.pom.tests;

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
import utils.JacksonUtils;
import webAPI.actions.CartAPI;

import java.io.IOException;
import java.util.Properties;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage() throws IOException {
        Products products = new Products(121511);
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


}

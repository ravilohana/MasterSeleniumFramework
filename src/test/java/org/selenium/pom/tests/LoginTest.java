package org.selenium.pom.tests;

import objects.LoginCredentials;
import objects.Products;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FakerUtils;
import webAPI.actions.CartAPI;
import webAPI.actions.SignUpAPI;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout() throws IOException, InterruptedException {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        String email_id = "demouser"+ new FakerUtils().generateRandomNumber()+"@gmail.com";
        String password = "demouser"+ new FakerUtils().generateRandomNumber();
        LoginCredentials userRegister = new LoginCredentials()
                .setUsername(username)
                .setEmail_id(email_id)
                .setPassword(password);
        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(userRegister);

        CartAPI cartAPI = new CartAPI();
        Products  products = new Products(1215);
        cartAPI.addToCartAPI(products.getId(), 1);


        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(cartAPI.getCookies());
        checkoutPage.load();
//        Thread.sleep(5000);
        checkoutPage
                .loginFromCheckoutPage(userRegister);
//        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.getTextCheckoutOrderReviewProductName().contains(products.getName()));




    }
}

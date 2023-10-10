package org.selenium.pom.tests;

import objects.LoginCredentials;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.AccountPage;
import org.selenium.pom.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigLoaders;
import webAPI.actions.LoginAPI;

public class AccountTest extends BaseTest {



    @Test
    public void viewExistingOrders(){
        LoginAPI loginAPI = new LoginAPI();
        loginAPI.getAccount();
        String username = ConfigLoaders.getInstance().getUsername();
        String password = ConfigLoaders.getInstance().getPassword();
        LoginCredentials userLogin = new LoginCredentials()
                .setUsername(username)
                .setPassword(password);
       loginAPI.userLoginUsingAPI(userLogin);
        AccountPage accountPage = new AccountPage(getDriver()).load();
        injectCookiesToBrowser(loginAPI.getCookies());
        accountPage.load("/account/orders");
        accountPage.clickUserOrders();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("orders"));
    }
}

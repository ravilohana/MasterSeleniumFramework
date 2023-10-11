package org.selenium.pom.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import objects.Products;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.ProductPage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Navigation Tests")
public class NavigationTest extends BaseTest {
    @Story("Home page > Store Page")
    @Description("Test navigation of from home page to store page using main menu.")
    @Test(description = "Navigate from home page to store page.")
    public void NavigateFromHomeToStoreUsingMainMenu(){
        StorePage storePage = new HomePage(getDriver())
                .load().getAppHeader().clickStoreMenuLink();
        Assert.assertEquals(storePage.getTitle(),"Store");
    }

    @Story("Store page > Product Page")
    @Description("Test navigation of from store page to product page using main menu.")
    @Test(description = "Navigate from store page to product page.")
    public void NavigateFromStoreToProductPage() throws IOException {

        Products product = new Products(1215);
        ProductPage productPage = new StorePage(getDriver()).
                load().
                navigateToTheProduct(product.getId());
        Assert.assertEquals(productPage.getProductTitle(), product.getName());

    }

    @Story("Home page > Feature Product Page")
    @Description("Test navigation of from home page to feature product page page using main menu.")
    @Test(description = "Navigate from home to feature product page")
    public void NavigateFromHomeToFeatureProductPage() throws IOException {

        Products product = new Products(1215);
        ProductPage productPage = new HomePage(getDriver()).
                load().navigateToTheProduct(product.getId());
        Assert.assertEquals(productPage.getProductTitle(), product.getName());

    }



}

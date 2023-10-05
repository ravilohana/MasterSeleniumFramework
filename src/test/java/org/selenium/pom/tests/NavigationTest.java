package org.selenium.pom.tests;

import objects.Products;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.ProductPage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NavigationTest extends BaseTest {
    @Test
    public void NavigateFromHomeToStoreUsingMainMenu(){
        StorePage storePage = new HomePage(getDriver())
                .load().clickStoreMenuLink();
        Assert.assertEquals(storePage.getTitle(),"Store");
    }


    @Test
    public void NavigateFromStoreToProductPage() throws IOException {

        Products product = new Products(1215);
        ProductPage productPage = new StorePage(getDriver()).
                load().
                navigateToTheProduct(product.getId());
        Assert.assertEquals(productPage.getProductTitle(), product.getName());

    }

    @Test
    public void NavigateFromHomeToFeatureProductPage() throws IOException {

        Products product = new Products(1215);
        ProductPage productPage = new HomePage(getDriver()).
                load().navigateToTheProduct(product.getId());
        Assert.assertEquals(productPage.getProductTitle(), product.getName());

    }



}

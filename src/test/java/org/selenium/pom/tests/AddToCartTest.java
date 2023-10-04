package org.selenium.pom.tests;

import objects.Products;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage() throws IOException {
        Products products = new Products(1215);
        CartPage cartPage = new StorePage(getDriver())
                .load()
                .clickAddToCartBtn(products.getName())
                .clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), products.getName());
    }
}

package org.selenium.pom.tests;

import jdk.jfr.Description;
import objects.Products;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.ProductPage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FakerUtils;

import java.io.IOException;

public class SearchTest extends BaseTest {

    @Description("Test product search functionality with partial match ")
    @Test (description = "Search product with partial match")
    public void searchWithPartialMatch(){
        String searchFor = "Blue";
        StorePage storePage = new StorePage(getDriver())
                .load().search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+ searchFor + "”");
    }

    @Description("Test product search functionality with exact match ")
    @Test (description = "Search product with exact match")
    public void searchWithExactMatch() throws IOException {
        Products product = new Products(1215);
        ProductPage productPage = new StorePage(getDriver()).
                load().
                searchExactMatch(product.getName());
        Assert.assertEquals(productPage.getProductTitle(),product.getName());
    }

    @Description("Test product search functionality for non existing product ")
    @Test (description = "Search non existing product")
    public void searchNonExistingProduct(){
        StorePage storePage = new StorePage(getDriver()).
                load().
                search(new FakerUtils().generateRandomName());
        Assert.assertEquals(storePage.getInfo(),"No products were found matching your selection.");
    }
}

package org.selenium.pom.tests;

import objects.Products;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.ProductPage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FakerUtils;

import java.io.IOException;

public class SearchTest extends BaseTest {

    @Test
    public void searchWithPartialMatch(){
        String searchFor = "Blue";
        StorePage storePage = new StorePage(getDriver())
                .load().search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+ searchFor + "”");
    }

    @Test
    public void searchWithExactMatch() throws IOException {
        Products product = new Products(1215);
        ProductPage productPage = new StorePage(getDriver()).
                load().
                searchExactMatch(product.getName());
        Assert.assertEquals(productPage.getProductTitle(),product.getName());
    }

    @Test
    public void searchNonExistingProduct(){
        StorePage storePage = new StorePage(getDriver()).
                load().
                search(new FakerUtils().generateRandomName());
        Assert.assertEquals(storePage.getInfo(),"No products were found matching your selection.");
    }
}

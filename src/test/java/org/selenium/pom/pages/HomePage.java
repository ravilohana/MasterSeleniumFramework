package org.selenium.pom.pages;

import com.github.javafaker.App;
import objects.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.components.AppHeader;
import org.selenium.pom.pages.components.ProductThumbnail;

import java.io.IOException;

public class HomePage extends BasePage {


    private AppHeader appHeader;
    private ProductThumbnail productThumbnail;


    // Getter and setter


    public AppHeader getAppHeader() {
        return appHeader;
    }

    public void setAppHeader(AppHeader appHeader) {
        this.appHeader = appHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(ProductThumbnail productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        appHeader = new AppHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }



    public HomePage load(){
        load("/");
        return this;
    }

    public ProductPage navigateToTheProduct(Integer id) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[normalize-space()='"+ new Products(id).getName() + "']"))).click();
        return new ProductPage(driver);
    }


}

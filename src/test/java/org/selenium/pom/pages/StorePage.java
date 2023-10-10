package org.selenium.pom.pages;

import objects.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.components.ProductThumbnail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorePage extends BasePage {

    private final By searchFld = By.cssSelector("input.search-field");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector("header > h1");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    private final By infoTxt = By.cssSelector(".woocommerce-info");

    private ProductThumbnail productThumbnail;

//    private final  By storePageProductName = By.className(".astra-shop-summary-wrap > a > h2");

//    private  List<WebElement> storePageProductNameList;


//    private List<WebElement> getStorePageProductNameList(){
//
//        return driver.findElements(By.cssSelector(".astra-shop-summary-wrap > a > h2"));
//
//    }


    public StorePage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    // getter


    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    public StorePage load() {
        load("/store");
        return this;
    }

    private StorePage enterTextSearchFld(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(text);
        return this;
    }

    private StorePage clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }

    public StorePage search(String text){
        enterTextSearchFld(text).clickSearchBtn();
        return this;
    }

    public String getTitle(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }


    public ProductPage navigateToTheProduct(Integer id) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[normalize-space()='"+ new Products(id).getName() + "']"))).click();
        return new ProductPage(driver);
    }

    public ProductPage searchExactMatch(String txt){
        enterTextSearchFld(txt).clickSearchBtn();
        return new ProductPage(driver);
    }

    public String getInfo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(infoTxt)).getText();
    }

    public List<String> getStorePageProductNameList(){
        List<String> productNameList = new ArrayList<>();
        List<WebElement> storePageProductNameList = driver.findElements(By.cssSelector(".astra-shop-summary-wrap > a > h2"));
        for (WebElement element: storePageProductNameList){
//            System.out.println("Product Name text: ------>>>>>>>>>> " + element.getText());
            productNameList.add(element.getText());
        }
        return productNameList;
    }

}

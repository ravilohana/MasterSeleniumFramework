package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {


    private final By storeMenuLink = By.cssSelector("#primary-site-navigation > div  > ul > li:nth-child(2)  > a");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public StorePage clickStoreMenuLink(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }
}

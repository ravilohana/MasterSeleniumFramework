package org.selenium.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.StorePage;

public class AppHeader extends BasePage {
    private final By storeMenuLink = By.cssSelector("#primary-site-navigation > div  > ul > li:nth-child(2)  > a");
    public AppHeader(WebDriver driver) {
        super(driver);
    }

    public StorePage clickStoreMenuLink(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
}

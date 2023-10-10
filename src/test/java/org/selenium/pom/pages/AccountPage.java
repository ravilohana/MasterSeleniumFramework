package org.selenium.pom.pages;

import objects.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.components.AppHeader;
import org.selenium.pom.pages.components.ProductThumbnail;

import java.io.IOException;

public class AccountPage extends BasePage {


    private final By loginUserOrders = By.xpath("//li//a[text()='Orders']");


    // Getter and setter




    public AccountPage(WebDriver driver) {
        super(driver);
    }



    public AccountPage load(){
        load("/account");
        return this;
    }

    public void clickUserOrders(){
        wait.until(ExpectedConditions.elementToBeClickable(loginUserOrders)).click();
    }



}

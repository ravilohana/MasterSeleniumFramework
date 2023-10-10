package org.selenium.pom.factory.abstactFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDriverManagerAbstract extends DriverManagerAbstract {


    @Override
    protected void startDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
}

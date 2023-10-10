package org.selenium.pom.factory.abstactFactory;


import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverManagerAbstract extends DriverManagerAbstract {

    @Override
    protected void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}

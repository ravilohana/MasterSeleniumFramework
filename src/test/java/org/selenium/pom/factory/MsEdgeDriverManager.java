package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MsEdgeDriverManager implements DriverManager{
    @Override
    public WebDriver createDriver() {
         WebDriver driver = new EdgeDriver();
         driver.manage().window().maximize();
         return driver;
    }
}

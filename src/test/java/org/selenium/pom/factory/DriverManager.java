package org.selenium.pom.factory;

import constants.BrowserTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverManager {

    public WebDriver initializeDriver(String browser){


        WebDriver driver = switch (BrowserTypes.valueOf(browser)) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case MICROSOFTEDGE -> new EdgeDriver();
            default -> throw new IllegalStateException("Invalid Browser: " + browser);
        };
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
}

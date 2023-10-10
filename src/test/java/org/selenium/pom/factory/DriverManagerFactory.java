package org.selenium.pom.factory;

import constants.BrowserTypes;

public class DriverManagerFactory {

    public static DriverManager getManager(BrowserTypes browserTypes){
        switch (browserTypes){
            case CHROME ->{
                return new ChromeDriverManager();
            }
            case FIREFOX ->{
                return new FirefoxDriverManager();
            }
            case MICROSOFTEDGE ->{
                return new MsEdgeDriverManager();
            }
            default -> throw new IllegalStateException("Unexpected Value: " + browserTypes);
        }
    }
}

package org.selenium.pom.factory.abstactFactory;

import constants.BrowserTypes;


public class DriverManagerFactoryAbstract {

    public static DriverManagerAbstract getManager(BrowserTypes browserTypes){
        switch (browserTypes){
            case CHROME ->{
                return new ChromeDriverManagerAbstract();
            }
            case FIREFOX ->{
                return new FirefoxDriverManagerAbstract();
            }
            case MICROSOFTEDGE ->{
                return new MsEdgeDriverManagerAbstract();
            }
            default -> throw new IllegalStateException("Unexpected Value: " + browserTypes);
        }
    }
}

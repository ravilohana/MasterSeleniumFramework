package org.selenium.pom.factory.abstactFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class MsEdgeDriverManagerAbstract extends DriverManagerAbstract {


    @Override
    protected void startDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
}

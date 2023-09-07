import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Collections;

public class LambdaDragDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");

        WebElement source_1 = driver.findElement(By.cssSelector("#todrag > span:nth-child(2)"));
        WebElement source_2 = driver.findElement(By.cssSelector("#todrag > span:nth-child(3)"));
        WebElement target = driver.findElement(By.cssSelector("#mydropzone"));


//        new Actions(driver).dragAndDrop(source_1,target);

//        Rectangle start = source_1.getRect();
//        Rectangle finish = target.getRect();
//
//        new Actions(driver)
//                .dragAndDropBy(source_1,finish.getX() - finish.getY(), finish.getY() - start.getY())
//                        .perform();

        int x = target.getLocation().x;
        int y = target.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(source_1)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(source_1)
                .pause(Duration.ofSeconds(1))
                .moveToElement(target)
                .pause(Duration.ofSeconds(1))
                .release().perform();

//        Actions actions = new Actions(driver);
//        actions.moveToElement(source_1)
//                .pause(Duration.ofSeconds(1))
//                .clickAndHold(source_1)
//                .pause(Duration.ofSeconds(1))
//                .moveToElement(target,50,50)
//                .moveToElement(target,50,50)
//                .pause(Duration.ofSeconds(1))
//                .release().build().perform();

            Thread.sleep(5000);
            driver.quit();
//        Point location_source = source_1.getLocation();
//        Point location = source_1.getLocation();





    }




}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CartPage {

    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://askomdch.com/cart/");
//        String shipPrice = driver.findElement(By.cssSelector("#shipping_method > li > label > span > bdi")).getText();
//        String totalPrice = driver.findElement(By.cssSelector("tr.order-total  > td > strong > span > bdi")).getText();
//        System.out.println(shipPrice);
//        System.out.println(totalPrice);

        String s = "$48.51";
        float f = Float.parseFloat(s.substring(1));
        System.out.println(f);
        System.out.println(Math.round(f));


    }
}

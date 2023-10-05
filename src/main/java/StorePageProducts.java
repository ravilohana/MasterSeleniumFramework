import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class StorePageProducts {
    public static void main(String[] args) {

        List<String> storeProductList = new ArrayList<>();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://askomdch.com/store/");
        List<WebElement> productList = driver.findElements(By.cssSelector(".astra-shop-summary-wrap > a > h2"));

        for (WebElement ele:productList){
            System.out.println(ele.getText());
            storeProductList.add(ele.getText());
        }
        System.out.println(storeProductList);
    }
}

package org.selenium.pom.base;

import constants.BrowserTypes;
import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.selenium.pom.factory.abstactFactory.DriverManagerAbstract;
import org.selenium.pom.factory.abstactFactory.DriverManagerFactoryAbstract;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utils.CookieUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {

    private final ThreadLocal<DriverManagerAbstract> driverManager = new ThreadLocal<>();

    private void setDriverManager(DriverManagerAbstract driverManager){
        this.driverManager.set(driverManager);
    }

    protected DriverManagerAbstract getDriverManager(){
        return  this.driverManager.get();
    }


    private final ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public  void startDriver(String browser){
 //       browser = System.getProperty("browser",browser);
        if(browser == null) browser = "CHROME";
     //   setDriver(new DriverManagerOriginal().initializeDriver(browser));
     //   setDriver(DriverManagerFactory.getManager(BrowserTypes.valueOf(browser)).createDriver());
   //     setDriver(DriverManagerFactoryAbstract.getManager(BrowserTypes.valueOf(browser)).getDriver());
        setDriverManager(DriverManagerFactoryAbstract.
                getManager(BrowserTypes.valueOf(browser)));
        setDriver(getDriverManager().getDriver());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId()
                + "DRIVER: " + getDriver());
    }

    @Parameters("browser")
    @AfterMethod
    public  void quitDriver(String browser, ITestResult result) throws IOException {
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId()
                + "DRIVER: " + getDriver());
       // getDriver().quit();



        if (result.getStatus() == ITestResult.FAILURE){

            File destFile = new File("screenshots" + File.separator
                    + browser + File.separator + result.getTestClass().
                    getRealClass().getSimpleName() + "_" + result.getMethod().getMethodName()
                    + ".png");
            if (!destFile.exists()){
                destFile.mkdirs();
            }
            //takeScreenShots(destFile);
            takeScreenshotUsingAshot(destFile);
        }

        getDriverManager().getDriver().quit();
    }


    public void injectCookiesToBrowser(Cookies cookies){
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie: seleniumCookies){
            getDriver().manage().addCookie(cookie);
        }
    }

    private void takeScreenShots(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,destFile);

    }

    private void takeScreenshotUsingAshot(File destFile){
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getDriver());
        try {
            ImageIO.write(screenshot.getImage(),"PNG",destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}

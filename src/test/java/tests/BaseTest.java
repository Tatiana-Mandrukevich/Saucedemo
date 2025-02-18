package tests;

import constants.IConstants;
import constants.ITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    HeaderPage headerPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//неявное ожидание
        initPages();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}

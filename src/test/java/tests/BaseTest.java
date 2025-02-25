package tests;

import constants.IConstants;
import constants.ITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    HeaderPage headerPage;
    ProductsPage productsPage;
    CartPage cartPage;
    LoginPageFactory loginPageFactory;

    /**
     * This is the initialization of the test.
     * It is setting up the WebDriver, maximizing the window, setting the implicit wait.
     */
    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//неявное ожидание
        initPages();
    }

    /**
     * This is the initialization of pages.
     */
    public void initPages() {
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
    }

    /**
     * It is quitting the WebDriver.
     */
    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}

package tests;

import constants.IConstants;
import constants.ITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.CartSteps;
import steps.HeaderSteps;
import steps.LoginSteps;
import steps.ProductsSteps;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    HeaderPage headerPage;
    ProductsPage productsPage;
    CartPage cartPage;
    LoginPageFactory loginPageFactory;
    CartSteps cartSteps;
    HeaderSteps headerSteps;
    LoginSteps loginSteps;
    ProductsSteps productsSteps;

    /**
     * This is the initialization of the test.
     * It is setting up the WebDriver, maximizing the window, setting the implicit wait.
     */
    @BeforeMethod
    public void initTest(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
//        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//неявное ожидание
        initPages();
        iTestContext.setAttribute("driver", driver);
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
        cartSteps = new CartSteps(driver);
        headerSteps = new HeaderSteps(driver);
        loginSteps = new LoginSteps(driver);
        productsSteps = new ProductsSteps(driver);
    }

    /**
     * It is quitting the WebDriver.
     */
    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}

package steps;

import constants.IConstants;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductsSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductsSteps loginAndAddProductToCart(String username, String password, String productName) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(username, password)
                .waitForProductsPageOpened();
        productsPage.addProductToCart(productName);
        return this;
    }

    @Step("Login and add product to cart")
    public ProductsSteps loginAndAddProductToCart(User user, String productName) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(user)
                .waitForProductsPageOpened();
        productsPage.addProductToCart(productName);
        return this;
    }

    @Step("Login and add products to cart")
    public ProductsSteps loginAndAddProductsToCart(String username, String password, String... productNames) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(username, password)
                .waitForProductsPageOpened();
        productsPage.addProductsToCart(productNames);
        return this;
    }

    @Step("Login and add products to cart")
    public ProductsSteps loginAndAddProductsToCart(User user, String... productNames) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(user)
                .waitForProductsPageOpened();
        productsPage.addProductsToCart(productNames);
        return this;
    }
}

package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductsSteps {
    private ProductsPage productsPage;

    public ProductsSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
    }

    @Step("Wait for Products page open and add product to cart")
    public ProductsSteps addProductToCart(String productName) {
        productsPage
                .waitForProductsPageOpened()
                .addProductToCart(productName);
        return this;
    }

    @Step("Wait for Products page open and add products to cart")
    public ProductsSteps addProductsToCart(String... productNames) {
        productsPage
                .waitForProductsPageOpened()
                .addProductsToCart(productNames);
        return this;
    }
}

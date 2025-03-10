package pages;

import org.openqa.selenium.By;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

@Log4j2
public class CartPage extends HeaderPage {
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"cart_item\"]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class=\"cart_quantity\"]";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";
    private static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";
    private static final By PAGE_TITLE = By.xpath("//*[@class=\"title\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This is the opening page by URL.
     * @param url - the URL of the page.
     * @return - the CartPage.
     */
    public CartPage openCartPage(String url) {
        log.info("Open Cart page by URL: {}", url);
        driver.get(url);
        return this;
    }

    /**
     * This is getting the price of the product depending on the input parameter.
     * @param productName - the name of the product.
     * @return - the price of the product.
     */
    public String getProductPrice(String productName) {
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Get price for product: {}. Price is: {}", productName, productPrice);
        return productPrice;
    }

    /**
     * This is getting the quantity of products added to the cart.
     * @return - the quantity of the product.
     */

    public Integer getProductQuantity() {
        int productQuantity = driver.findElements(By.xpath(CART_ITEM_CONTAINER)).size();
        log.info("Get product quantity: {}", productQuantity);
        return productQuantity;
    }

    /**
     * This is removing a product from the cart depending on the input parameter.
     * @param productName - the name of the product.
     * @return - the CartPage.
     */
    public CartPage removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        log.info("Remove product: {} from cart", productName);
        return this;
    }

    /**
     * This checks the display of the product in the cart.
     * @param productName - the name of the product.
     * @return true if the product is displayed in the cart.
     */
    public boolean isProductDisplayed(String productName) {
        log.info("Check if product: {} is displayed in the cart", productName);
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }

    /**
     * This is waiting for the cart page to be opened.
     * @return CartPage.
     */
    public CartPage waitForCartPageOpened() {
        Waiter.waitForPageOpened(driver, PAGE_TITLE, 15);
        log.info("Wait for Cart page to be opened");
        return this;
    }
}

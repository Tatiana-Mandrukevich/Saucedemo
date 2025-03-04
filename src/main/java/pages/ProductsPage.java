package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waiters.Waiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
public class ProductsPage extends HeaderPage {
    public static final By PAGE_TITLE = By.xpath("//*[@class=\"title\"]");
    public static final By PRODUCTS = By.xpath("//*[@class=\"inventory_item\"]");
    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"inventory_item\"]";
    public static final String PRODUCT_NAME = "(//*[@class=\"inventory_item_name \"])[%s]";
    public static final String PRODUCT_DESCRIPTION = PRODUCT_ITEM + "//*[@class=\"inventory_item_desc\"]";
    public static final By ADD_TO_CART_BUTTONS = By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory \" and contains(text(), \"Add to cart\")]");
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    public static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    public static final By PRODUCT_PICTURE = By.xpath("//*[@class=\"inventory_item\"]//div[@class=\"inventory_item_img\"]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This is getting the page title text.
     * @return the page title text.
     */
    public String getPageTitleText() {
        String pageTitle = driver.findElement(PAGE_TITLE).getText();
        log.info("Get page title: {}", pageTitle);
        return pageTitle;
    }

    /**
     * This is getting the count of products on the page.
     * @return the count of products on the page.
     */
    public int getProductsCount() {
        int productsCount = driver.findElements(PRODUCTS).size();
        log.info("Get products count on Products page: {}", productsCount);
        return productsCount;
    }

    /**
     * This is getting the names of the products on the page.
     * @return the names of the products on the page.
     */
    public List<String> getActualProductsNames() {
        List<String> actualProductsNames = new ArrayList<>();
        for (int i = 1; i < getProductsCount() + 1; i++) {
            String element = driver.findElement(By.xpath(String.format(PRODUCT_NAME, i))).getText();
            actualProductsNames.add(element);
        }
        Collections.sort(actualProductsNames);
        log.info("Get products names on Products page: {}", actualProductsNames);
        return actualProductsNames;
    }

    /**
     * This is getting the description of a product.
     * @param productName - the name of the product.
     * @return the description of the product.
     */
    public String getProductDescription(String productName) {
        String productDescription = driver.findElement(By.xpath(String.format(PRODUCT_DESCRIPTION, productName))).getText();
        log.info("Get description for product: {}. Description is: {}", productName, productDescription);
        return productDescription;
    }

    /**
     * This is getting the price of a product.
     * @param productName - the name of the product.
     * @return the price of the product.
     */
    public String getProductPrice(String productName) {
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Get price for product: {}. Price is: {}", productName, productPrice);
        return productPrice;
    }

    /**
     * This is getting the count of product pictures on the page.
     * @return the count of product pictures on the page.
     */
    public int getProductPicturesCount() {
        int productPicturesCount = driver.findElements(PRODUCT_PICTURE).size();
        log.info("Get product pictures count on Products page: {}", productPicturesCount);
        return productPicturesCount;
    }

    /**
     * This is getting the count of Add to cart buttons on the page.
     * @return the count of Add to cart buttons on the page.
     */
    public int getAddToCartButtonsCount() {
        int addToCartButtonsCount = driver.findElements(ADD_TO_CART_BUTTONS).size();
        log.info("Get Add to cart buttons count on Products page: {}", addToCartButtonsCount);
        return addToCartButtonsCount;
    }

    /**
     * This is adding a product to the cart.
     * @param productName - the name of the product.
     * @return the ProductsPage.
     */
    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        log.info("Add product: {} to cart", productName);
        return this;
    }

    /**
     * This checks if Add to cart button is displayed for the product.
     * @param productName - the name of the product.
     * @return true if the Add to cart button is displayed for the product.
     */
    public boolean isAddToCartButtonDisplayedForProduct(String productName) {
        List<WebElement> addToCartButtons = driver.findElements(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        log.info("Check if Add to cart button is displayed for product: {}", productName);
        return !addToCartButtons.isEmpty();
    }

    /**
     * This checks if Remove button is displayed for the product.
     * @param productName - the name of the product.
     * @return true if the Remove button is displayed for the product.
     */
    public boolean isRemoveButtonDisplayedForProduct(String productName) {
        List<WebElement> removeButtons = driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName)));
        log.info("Check if Remove button is displayed for product: {}", productName);
        return !removeButtons.isEmpty();
    }

    /**
     * This is adding products to the cart.
     * @param productNames - names of the products.
     * @return the ProductsPage.
     */
    public ProductsPage addProductsToCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
            log.info("Add product: {} to cart", productName);
        }
        return this;
    }

    /**
     * This is waiting for the products page to be opened.
     * @return ProductsPage.
     */
    public ProductsPage waitForProductsPageOpened() {
        Waiter.waitForPageOpened(driver, PRODUCT_PICTURE, 15);
        log.info("Wait for Products page to be opened");
        return this;
    }
}
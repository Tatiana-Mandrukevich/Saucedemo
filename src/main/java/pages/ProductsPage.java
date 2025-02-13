package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public String getPageTitleText() { return driver.findElement(PAGE_TITLE).getText(); }

    public int getProductsSize() {
        return driver.findElements(PRODUCTS).size();
    }

    public List<String> getActualProductsNames() {
        List<String> actualProductsNames = new ArrayList<>();
        for (int i = 1; i < getProductsSize() + 1; i++) {
            String element = driver.findElement(By.xpath(String.format(PRODUCT_NAME, i))).getText();
            actualProductsNames.add(element);
        }
        Collections.sort(actualProductsNames);
        return actualProductsNames;
    }

    public String getProductDescription(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_DESCRIPTION, productName))).getText();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public List<WebElement> getProductPictures() {
        return driver.findElements(PRODUCT_PICTURE);
    }

    public List<WebElement> getAddToCartButtons() {
        return driver.findElements(ADD_TO_CART_BUTTONS);
    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public boolean isAddToCartButtonDisplayedForProduct(String productName) {
        List<WebElement> addToCartButtons = driver.findElements(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        return !addToCartButtons.isEmpty();
    }

    public boolean isRemoveButtonDisplayedForProduct(String productName) {
        List<WebElement> removeButtons = driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName)));
        return !removeButtons.isEmpty();
    }

    public void addProductsToCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends HeaderPage {
    public static final By PAGE_TITLE = By.xpath("//*[@class=\"title\"]");
    public static final By PRODUCT = By.xpath("//*[@class=\"inventory_item\"]");
    public static final String PRODUCT_NAME = "//*[@class=\"inventory_item_name \"]";
    public static final By PRODUCT_PICTURE = By.xpath("//*[@class=\"inventory_item\"]//div[@class=\"inventory_item_img\"]");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory \" and contains(text(), \"Add to cart\")]");
    public static final By REMOVE_BUTTON = By.xpath("//*[@class=\"btn btn_secondary btn_small btn_inventory \" and contains(text(), \"Remove\")]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public String getPageTitleText() { return driver.findElement(PAGE_TITLE).getText(); }

    public List<WebElement> getProducts() {
        return driver.findElements(PRODUCT);
    }

    public List<String> getActualProductNames() {
        List<String> actualProductNames = new ArrayList<>();
        for (int i = 1; i < getProducts().size() + 1; i++) {
            String element = driver.findElement(By.xpath("(" + PRODUCT_NAME + ")[" + i + "]")).getText();
            actualProductNames.add(element);
        }
        Collections.sort(actualProductNames);
        return actualProductNames;
    }

    public String getProductDescription(String productName) {
        return driver.findElement(By
                .xpath("//div[text()=\"" + productName + "\"]//parent::a/following-sibling::div[@class=\"inventory_item_desc\"]"))
                .getText();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By
                        .xpath("//div[text()=\"" + productName + "\"]//parent::a//parent::div/following-sibling::div[@class='pricebar']//div[@class='inventory_item_price']"))
                .getText();
    }

    public List<WebElement> getProductPictures() {
        return driver.findElements(PRODUCT_PICTURE);
    }

    public List<WebElement> getAddToCartButtons() {
        return driver.findElements(ADD_TO_CART_BUTTON);
    }

    public List<WebElement> getRemoveButtons() {
        return driver.findElements(REMOVE_BUTTON);
    }

    public void clickAddToCartButtonForProduct(String productName) {
        driver.findElement(By
                        .xpath("//div[text()=\"" + productName + "\"]//parent::a//parent::div/following-sibling::div[@class='pricebar']//button[contains(text(), \"Add to cart\")]"))
                .click();
    }

    public boolean isAddToCartButtonDisplayedForProduct(String productName) {
        List<WebElement> addToCartButtons = driver.findElements(By
                .xpath("//div[text()=\"" + productName + "\"]//parent::a//parent::div/following-sibling::div[@class='pricebar']//button[contains(text(), \"Add to cart\")]"));
        if (addToCartButtons.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isRemoveButtonDisplayedForProduct(String productName) {
        List<WebElement> removeButtons = driver.findElements(By
                .xpath("//div[text()=\"" + productName + "\"]//parent::a//parent::div/following-sibling::div[@class='pricebar']//button[contains(text(), \"Remove\")]"));
        if (removeButtons.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
}
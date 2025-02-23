package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public static final By APP_TITLE = By.xpath("//*[@class=\"app_logo\"]");
    public static final By OPEN_MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By INDICATION_THAT_MENU_IS_OPEN = By.xpath("//*[@aria-hidden=\"false\"]");
    public static final By CROSS_ON_MENU = By.id("react-burger-cross-btn");
    public static final By CART_BUTTON = By.xpath("//*[@data-test=\"shopping-cart-link\"]");
    public static final By COUNT_OF_ADDED_PRODUCTS_ON_CART_BUTTON = By.xpath("//*[@class=\"shopping_cart_badge\"]");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This is getting text of the app title.
     * @return text of the app title.
     */
    public String getAppTitleText() { return driver.findElement(APP_TITLE).getText(); }

    /**
     * This is clicking on the open menu button.
     * @return HeaderPage.
     */
    public HeaderPage clickOnOpenMenuButton() {
        driver.findElement(OPEN_MENU_BUTTON).click();
        return this;
    }

    /**
     * This is checking if the menu is open.
     * @return true if the menu is open.
     */
    public boolean isMenuOpen() {
        return !driver.findElements(INDICATION_THAT_MENU_IS_OPEN).isEmpty();
    }

    /**
     * This is clicking on the cross on the menu.
     * @return HeaderPage.
     */
    public HeaderPage clickOnCrossOnMenu() {
        driver.findElement(CROSS_ON_MENU).click();
        return this;
    }

    /**
     * This is clicking on the cart button.
     * @return CartPage.
     */
    public CartPage clickOnCartButton() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    /**
     * This is getting count of added products.
     * @return count of added products.
     */
    public Integer getCountOfAddedProducts() {
        String countOfAddedProductsStr = driver.findElement(COUNT_OF_ADDED_PRODUCTS_ON_CART_BUTTON).getText();
        return Integer.valueOf(countOfAddedProductsStr);
    }
}

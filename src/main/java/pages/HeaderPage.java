package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public String getAppTitleText() { return driver.findElement(APP_TITLE).getText(); }

    public void clickOnOpenMenuButton() {
        driver.findElement(OPEN_MENU_BUTTON).click();
    }

    public boolean isMenuOpen() {
        List<WebElement> indicatorsThatMenuIsOpen = driver.findElements(INDICATION_THAT_MENU_IS_OPEN);
        if (indicatorsThatMenuIsOpen.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

    public void clickOnCrossOnMenu() {
        driver.findElement(CROSS_ON_MENU).click();
    }

    public void clickOnCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    public Integer getCountOfAddedProducts() {
        String countOfAddedProductsStr = driver.findElement(COUNT_OF_ADDED_PRODUCTS_ON_CART_BUTTON).getText();
        Integer countOfAddedProducts = Integer.valueOf(countOfAddedProductsStr);
        return countOfAddedProducts;
    }
}

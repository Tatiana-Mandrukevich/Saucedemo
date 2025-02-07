package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SauceDemo {
    //1. Open browser, site https://www.saucedemo.com/
    //2. login: standard_user, password: secret_sauce
    //3. Add product to cart
    //4. Go to cart
    //5. Check (assertEquals) the price of the product and its name in the cart

    public void checkPriceAndNameOfProduct() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        final WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        final WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        final WebElement loginButton = driver.findElement(By.className("submit-button"));
        loginButton.click();
        final WebElement addToCartButton = driver.findElement(By.xpath("//*[@data-test=\"add-to-cart-sauce-labs-backpack\"]"));
        addToCartButton.click();
        final WebElement cartButton = driver.findElement(By.xpath("//*[@class=\"shopping_cart_link\"]"));
        cartButton.click();
        final WebElement price = driver.findElement(By.className("inventory_item_price"));
        final WebElement productName = driver.findElement(By.xpath("//*[text()=\"Sauce Labs Backpack\"]"));

        Assert.assertEquals(price.getText(), "$29.99");
        Assert.assertEquals(productName.getText(), "Sauce Labs Backpack");

        driver.quit();
    }
}

package lesson18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {

    WebDriver driver = new ChromeDriver();

    private final WebElement userName = driver.findElement(By.id("user-name"));
    private final WebElement password = driver.findElement(By.name("password"));
    private final WebElement loginButton = driver.findElement(By.className("submit-button"));
    private final WebElement listOfUserName = driver.findElement(By.tagName("h4"));
    private final WebElement linkText = driver.findElement(By.linkText("Sauce Labs Backpack"));
    private final WebElement partialLinkText = driver.findElement(By.partialLinkText("Labs Backpack"));
    private final WebElement addToCartButton = driver.findElement(By.xpath("//*[@data-test=\"add-to-cart-sauce-labs-backpack\"]"));
    private final WebElement productName = driver.findElement(By.xpath("//*[text()=\"Sauce Labs Backpack\"]"));
    private final WebElement productNamePart = driver.findElement(By.xpath("//*[contains(text(), \"Backpack\")]"));
    private final WebElement priceList = driver.findElement(By.xpath("//*[contains(@data-test, \"price\")]"));
    private final WebElement cssByTag = driver.findElement(By.cssSelector("input"));
    private final WebElement cssByTagAndClass = driver.findElement(By.cssSelector("input.class"));

    //*[text()='Accepted usernames are:']//ancestor::div/..
    //*[@class='login_wrapper-inner']//descendant::div
    //*[@class='login_wrapper-inner']//parent::div
    //input[@id='password']/preceding-sibling::input[1]
    //*[@class='login_wrapper-inner']/following-sibling::div
    //*[@data-test='password' and contains(@id, 'password')]
    //*[@data-test='password' and contains(@id, 'password') and contains(@name, 'password')]
    //h4/text()
    //link/@href
    //img[class="inventory_item_img"]/@src
    //div[@class=("inventory", "item", "label")] (не отработал на лекции)

    //CSS:
    //поиск по классу: .inventory_item_label
    //поиск класса внутри класса (поиск в разных классах): .inventory_item .inventory_item_img
    //поиск в одном классе: .inventory_item.inventory_item_img
    //поиск по полному совпадению значения атрибута: [data-test="inventory-list"]
    //поиск по частичному совпадению значения атрибута: [data-test~=item_4]
    //поиск по значению атрибута, а именно значение равно или совпадает начало: [data-test|=item-4-title-link]
    //поиск по значению атрибута, а именно значение равно или совпадает конец: [data-test$=item-4-title-link]
    //поиск по частичному совпадению: [href*=link]

}

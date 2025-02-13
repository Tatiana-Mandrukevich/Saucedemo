package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By LOGIN_BUTTON = By.className("submit-button");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");
    public static final By ERROR_BUTTON = By.className("error-button");
    public static final By CROSS_BUTTON_IN_USERNAME_FIELD = By.xpath("(//*[@fill=\"currentColor\"])[1]");
    public static final By CROSS_BUTTON_IN_PASSWORD_FIELD = By.xpath("(//*[@fill=\"currentColor\"])[2]");
    public static final By LOGIN_TITLE = By.xpath("//*[@class=\"login_logo\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMassageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void clickOnCrossInErrorMessage() {
        driver.findElement(ERROR_BUTTON).click();
    }

    public List<WebElement> getErrorMessages() {
        return driver.findElements(ERROR_MESSAGE);
    }

    public void clickOnCrossInUsernameField() {
        driver.findElement(CROSS_BUTTON_IN_USERNAME_FIELD).click();
    }

    public void clickOnCrossInPasswordField() {
        driver.findElement(CROSS_BUTTON_IN_PASSWORD_FIELD).click();
    }

    public String getUsernameText() {
        return driver.findElement(USERNAME_INPUT).getAttribute("value");
    }

    public String getPasswordText() {
        return driver.findElement(PASSWORD_INPUT).getAttribute("value");
    }

    public String getLoginTitleText() { return driver.findElement(LOGIN_TITLE).getText(); }

}

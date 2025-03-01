package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waiters.Waiter;

import java.util.List;

@Log4j2
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

    /**
     * Method for login.
     * @param user - user with username and password.
     * @return ProductsPage.
     */
    public ProductsPage login(User user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Login with data: username is {}", user.getUsername());
        return new ProductsPage(driver);
    }

    /**
     * Method for login.
     * @param username - username.
     * @param password - password.
     * @return ProductsPage.
     */
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Login with data: username is {}", username);
        return new ProductsPage(driver);
    }

    /**
     * This is getting an error text when logging in.
     * @return error text.
     */
    public String getErrorMassageText() {
        String errorMessage = driver.findElement(ERROR_MESSAGE).getText();
        log.info("Text of error message: {}", errorMessage);
        return errorMessage;
    }

    /**
     * This is clicking on the cross in the error message.
     * @return LoginPage.
     */
    public LoginPage clickOnCrossInErrorMessage() {
        driver.findElement(ERROR_BUTTON).click();
        return this;
    }

    /**
     * This is checking if the error message is displayed.
     * @return true if the error message is displayed.
     */
    public boolean isErrorMessagesDisplayed() {
        List<WebElement> errorMessages = driver.findElements(ERROR_MESSAGE);
        return !errorMessages.isEmpty();
    }

    /**
     * This is clicking on the cross in the username field.
     * @return LoginPage.
     */
    public LoginPage clickOnCrossInUsernameField() {
        driver.findElement(CROSS_BUTTON_IN_USERNAME_FIELD).click();
        return this;
    }

    /**
     * This is clicking on the cross in the password field.
     * @return LoginPage.
     */
    public LoginPage clickOnCrossInPasswordField() {
        driver.findElement(CROSS_BUTTON_IN_PASSWORD_FIELD).click();
        return this;
    }

    /**
     * This is getting the text from the username field.
     * @return text from the username field.
     */
    public String getUsernameText() {
        String usernameText = driver.findElement(USERNAME_INPUT).getAttribute("value");
        log.info("Get username from the username field: {}", usernameText);
        return usernameText;
    }

    /**
     * This is getting the text from the password field.
     * @return text from the password field.
     */
    public String getPasswordText() {
        return driver.findElement(PASSWORD_INPUT).getDomAttribute("value");
    }

    /**
     * This is getting the text from the login title.
     * @return text from the login title.
     */
    public String getLoginTitleText() {
        String loginTitle = driver.findElement(LOGIN_TITLE).getText();
        log.info("Get login title: {}", loginTitle);
        return loginTitle;
    }

    /**
     * This is waiting for the login page to be opened.
     * @return LoginPage.
     */
    public LoginPage waitForLoginPageOpened() {
        Waiter.waitForPageOpened(driver, LOGIN_BUTTON, 15);
        log.info("Wait for Login page to be opened");
        return this;
    }
}

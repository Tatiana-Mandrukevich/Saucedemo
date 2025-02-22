package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPageFactory extends BasePage {

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(className = "submit-button")
    WebElement loginButton;

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;

    public static final By ERROR_BUTTON = By.className("error-button");
    public static final By CROSS_BUTTON_IN_USERNAME_FIELD = By.xpath("(//*[@fill=\"currentColor\"])[1]");
    public static final By CROSS_BUTTON_IN_PASSWORD_FIELD = By.xpath("(//*[@fill=\"currentColor\"])[2]");
    public static final By LOGIN_TITLE = By.xpath("//*[@class=\"login_logo\"]");

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMassageText() {
        return errorMessage.getText();
    }

    public void clickOnCrossInErrorMessage() {
        driver.findElement(ERROR_BUTTON).click();
    }

/*    public List<WebElement> getErrorMessages() {
        return driver.findElements(ERROR_MESSAGE);
    }*/

    public void clickOnCrossInUsernameField() {
        driver.findElement(CROSS_BUTTON_IN_USERNAME_FIELD).click();
    }

    public void clickOnCrossInPasswordField() {
        driver.findElement(CROSS_BUTTON_IN_PASSWORD_FIELD).click();
    }

    public String getUsernameText() {
        return usernameInput.getAttribute("value");
    }

    public String getPasswordText() {
        return passwordInput.getAttribute("value");
    }

    public String getLoginTitleText() { return driver.findElement(LOGIN_TITLE).getText(); }

    public void waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}

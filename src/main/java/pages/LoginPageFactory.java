package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;

    @FindBys({
            @FindBy(xpath = "//*[@data-test='error']")
    })
    List<WebElement> errorMessages;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;

    @FindBy(className = "error-button")
    WebElement errorButton;

    @FindBy(xpath = "(//*[@fill=\"currentColor\"])[1]")
    WebElement crossButtonInUsernameField;

    @FindBy(xpath = "(//*[@fill=\"currentColor\"])[2]")
    WebElement crossButtonInPasswordField;

    @FindBy(xpath = "//*[@class=\"login_logo\"]")
    WebElement loginTitle;

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

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
        errorButton.click();
    }

    public List<WebElement> getErrorMessages() {
        return errorMessages;
    }

    public void clickOnCrossInUsernameField() {
        crossButtonInUsernameField.click();
    }

    public void clickOnCrossInPasswordField() {
        crossButtonInPasswordField.click();
    }

    public String getUsernameText() {
        return usernameInput.getDomAttribute("value");
    }

    public String getPasswordText() {
        return passwordInput.getDomAttribute("value");
    }

    public String getLoginTitleText() { return loginTitle.getText(); }

    public void waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}

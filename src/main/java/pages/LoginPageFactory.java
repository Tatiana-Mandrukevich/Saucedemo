package pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Getter
@Log4j2
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

/*    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }*/

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public LoginPageFactory login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        log.info("Login with data: username is {}", username);
        return this;
    }

    public String getErrorMassageText() {
        String errorMessageText = errorMessage.getText();
        log.info("Text of error message: {}", errorMessageText);
        return errorMessageText;
    }

    public LoginPageFactory clickOnCrossInErrorMessage() {
        errorButton.click();
        return this;
    }

    public boolean isErrorMessagesDisplayed() {
        return !errorMessages.isEmpty();
    }

    public LoginPageFactory clickOnCrossInUsernameField() {
        crossButtonInUsernameField.click();
        return this;
    }

    public LoginPageFactory clickOnCrossInPasswordField() {
        crossButtonInPasswordField.click();
        return this;
    }

    public String getUsernameText() {
        String usernameText = usernameInput.getAttribute("value");
        log.info("Get username from the username field: {}", usernameText);
        return usernameText;
    }

    public String getPasswordText() {
        return passwordInput.getDomAttribute("value");
    }

    public String getLoginTitleText() {
        String loginTitleText = loginTitle.getText();
        log.info("Get login title: {}", loginTitleText);
        return loginTitleText;
    }

    public LoginPageFactory waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        log.info("Wait for Login page to be opened");
        return this;
    }
}

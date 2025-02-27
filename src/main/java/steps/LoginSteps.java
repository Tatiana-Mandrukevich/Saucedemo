package steps;

import constants.IConstants;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Wait for Login page open and login with invalid data")
    public LoginSteps loginWithInvalidData(String username, String password) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Wait for Login page open and login with invalid data")
    public LoginSteps loginWithInvalidData(User user) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(user);
        return this;
    }

    @Step("Wait for Login page open, login with valid data and wait for Products page open")
    public LoginSteps loginWithValidData(String username, String password) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(username, password)
                .waitForProductsPageOpened();
        return this;
    }

    @Step("Wait for Login page open, login with valid data and wait for Products page open")
    public LoginSteps loginWithValidData(User user) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(user)
                .waitForProductsPageOpened();
        return this;
    }

    @Step("Wait for Login page open")
    public LoginSteps openLoginPage() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.waitForLoginPageOpened();
        return this;
    }
}
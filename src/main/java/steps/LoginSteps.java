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

    @Step("Wait for Login page open and login")
    public LoginSteps login(String username, String password) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Wait for Login page open and login")
    public LoginSteps login(User user) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(user);
        return this;
    }

    @Step("Wait for Login page open")
    public LoginSteps openLoginPage() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.waitForLoginPageOpened();
        return this;
    }
}
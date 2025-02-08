package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test(description = "This test login on site with empty username")
    public void loginWithEmptyUsernameTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "This test login on site with empty password")
    public void loginWithEmptyPasswordTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test(description = "This test login on site with empty username and password")
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "This test login on site with incorrect data in fields")
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("efwefwe", "efwfwe");
        Assert.assertEquals(loginPage.getErrorMassageText(), INCORRECT_DATA_IN_FIELDS);
    }
}

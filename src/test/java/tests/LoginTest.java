package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends Preconditions {
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test(description = "This test login on site with empty username")
    public void loginWithEmptyUsernameTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "This test login on site with empty password")
    public void loginWithEmptyPasswordTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test(description = "This test login on site with empty username and password")
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyFields);
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "This test login on site with incorrect data in fields")
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMassageText(), INCORRECT_DATA_IN_FIELDS);
    }

/*    @Test(description = "Login on site with correct data in fields")
    public void successLoginTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(
                System.getProperty("username"),
                System.getProperty("password"));
        Assert.assertEquals(loginPage.getCurrentUrl(), PRODUCT_PAGE_URL);
    }*/

    @Parameters({"username", "password"})
    @Test(description = "Login on site with correct data in fields")
    public void successLoginTest(@Optional("standard_user") String user,
                                 @Optional("secret_sauce") String pass) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user, pass);
        Assert.assertEquals(loginPage.getCurrentUrl(), PRODUCT_PAGE_URL);
    }

    @Test(description = "Close error message by clicking on the cross")
    public void closeErrorMessage() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("efwefwe", "efwfwe");
        loginPage.clickOnCrossInErrorMessage();
        Assert.assertTrue(loginPage.getErrorMessages().isEmpty());
    }

/*    @Test(description = "Clearing the field username by clicking on the cross")
    public void clearUsernameFieldByCross() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("efwefwe", "efwfwe");
        loginPage.clickOnCrossInUsernameField();
        Assert.assertEquals(loginPage.getUsernameText(), "");
    }

    @Test(description = "Clearing the field password by clicking on the cross")
    public void clearPasswordFieldByCross() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("efwefwe", "efwfwe");
        loginPage.clickOnCrossInPasswordField();
        Assert.assertEquals(loginPage.getPasswordText(), "");
    }*/

    @Test(description = "Check login title")
    public void checkLoginTitle() {
        loginPage.openPage(LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getLoginTitleText(), "Swag Labs");
    }

    @Test
    public void loginWithoutPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }

    @Test
    public void loginWithPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = loginPageFactory.getAddButton();
        addButton.click();
        WebElement deleteButton = loginPageFactory.getDeleteButton();
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }
}
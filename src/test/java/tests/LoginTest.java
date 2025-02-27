package tests;

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
        loginSteps.loginWithInvalidData(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "This test login on site with empty password")
    public void loginWithEmptyPasswordTest() {
        loginSteps.loginWithInvalidData(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test(description = "This test login on site with empty username and password")
    public void loginWithEmptyFieldsTest() {
        loginSteps.loginWithInvalidData(userWithEmptyFields);
        Assert.assertEquals(loginPage.getErrorMassageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "This test login on site with incorrect data in fields")
    public void loginWithIncorrectFieldsTest() {
        loginSteps.loginWithInvalidData(userWithIncorrectFields);
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
    public void successLoginTest(@Optional("standard_user") String username,
                                 @Optional("secret_sauce") String password) {
        loginSteps.loginWithInvalidData(username, password);
        Assert.assertEquals(loginPage.getCurrentUrl(), PRODUCT_PAGE_URL);
    }

    @Test(description = "Close error message by clicking on the cross")
    public void closeErrorMessage() {
        loginSteps.loginWithInvalidData(userWithIncorrectFields);
        loginPage.clickOnCrossInErrorMessage();
        Assert.assertFalse(loginPage.isErrorMessagesDisplayed());
    }

/*    @Test(description = "Clearing the field username by clicking on the cross")
    public void clearUsernameFieldByCross() {
        loginSteps.loginWithInvalidData(userWithIncorrectFields);
        loginPage.clickOnCrossInUsernameField();
        Assert.assertEquals(loginPage.getUsernameText(), "");
    }

    @Test(description = "Clearing the field password by clicking on the cross")
    public void clearPasswordFieldByCross() {
       loginSteps.loginWithInvalidData(userWithIncorrectFields);
        loginPage.clickOnCrossInPasswordField();
        Assert.assertEquals(loginPage.getPasswordText(), "");
    }*/

    @Test(description = "Check login title")
    public void checkLoginTitle() {
        loginSteps.openLoginPage();
        Assert.assertEquals(loginPage.getLoginTitleText(), "Swag Labs");
    }

/*    @Test(description = "Not for Saucedemo")
    public void loginWithoutPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }*/

    @Test(description = "Not for Saucedemo")
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
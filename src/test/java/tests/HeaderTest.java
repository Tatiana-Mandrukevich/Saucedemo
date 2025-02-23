package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test(description = "Check app title")
    public void checkAppTitle() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        Assert.assertEquals(headerPage.getAppTitleText(), "Swag Labs");
    }

    @Test(description = "Open menu")
    public void openMenu() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        headerPage
                .clickOnOpenMenuButton();
        Assert.assertTrue(headerPage.isMenuOpen());
    }

    @Test(description = "Close menu")
    public void closeMenu() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        headerPage
                .clickOnOpenMenuButton()
                .clickOnCrossOnMenu();
        Assert.assertFalse(headerPage.isMenuOpen());
    }

    @Test(description = "Open cart")
    public void openCart() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        headerPage
                .clickOnCartButton()
                .waitForCartPageOpened();
        Assert.assertEquals(headerPage.getCurrentUrl(), CART_PAGE_URL);
    }

    @Test(description = "Adding a product to the cart: check that the cart icon displays the count of added products")
    public void checkCountOfAddedProductsOnCart() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        productsPage
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.getCountOfAddedProducts(), 1);
    }
}

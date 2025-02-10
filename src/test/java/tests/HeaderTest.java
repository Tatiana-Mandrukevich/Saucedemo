package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test(description = "Check app title")
    public void checkAppTitle() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertEquals(headerPage.getAppTitleText(), "Swag Labs");
    }

    @Test(description = "Open menu")
    public void openMenu() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        headerPage.clickOnOpenMenuButton();
        Assert.assertTrue(headerPage.isMenuOpen());
    }

    @Test(description = "Close menu")
    public void closeMenu() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        headerPage.clickOnOpenMenuButton();
        headerPage.clickOnCrossOnMenu();
        Assert.assertFalse(headerPage.isMenuOpen());
    }

    @Test(description = "Open cart")
    public void openCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        headerPage.clickOnCartButton();
        Assert.assertEquals(headerPage.getCurrentUrl(), CART_PAGE_URL);
    }

    @Test(description = "Adding a product to the cart: check that the cart icon displays the count of added products")
    public void checkCountOfAddedProductsOnCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButtonForProduct(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.getCountOfAddedProducts(), productsPage.getRemoveButtons().size());
    }
}

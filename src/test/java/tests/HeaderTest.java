package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test(description = "Check app title")
    public void checkAppTitle() {
        loginSteps.loginWithValidData(USERNAME, PASSWORD);
        Assert.assertEquals(headerPage.getAppTitleText(), "Swag Labs");
    }

    @Test(description = "Open menu")
    public void openMenu() {
        loginSteps.loginWithValidData(USERNAME, PASSWORD);
        headerPage.clickOnOpenMenuButton();
        Assert.assertTrue(headerPage.isMenuOpen());
    }

    @Test(description = "Close menu")
    public void closeMenu() {
        loginSteps.loginWithValidData(USERNAME, PASSWORD);
        headerSteps.openAndCloseMenu();
        Assert.assertFalse(headerPage.isMenuOpen());
    }

    @Test(description = "Open cart")
    public void openCart() {
        loginSteps.loginWithValidData(USERNAME, PASSWORD);
        headerSteps.openCart();
        Assert.assertEquals(headerPage.getCurrentUrl(), CART_PAGE_URL);
    }

    @Test(description = "Adding a product to the cart: check that the cart icon displays the count of added products")
    public void checkCountOfAddedProductsOnCart() {
        loginSteps.loginWithValidData(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.getCountOfAddedProducts(), 1);
    }
}
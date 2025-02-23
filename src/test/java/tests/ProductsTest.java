package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsTest extends BaseTest {

    @Test(description = "Check page title")
    public void checkPageTitle() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        Assert.assertEquals(productsPage.getPageTitleText(), "Products");
    }

    @Test(description = "Check that there are 6 products displayed on the page")
    public void checkProductsCount() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        Assert.assertEquals(productsPage.getProductsCount(), 6);
    }

    @Test(description = "Check a product name for each product")
    public void checkProductsNames() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        List<String> expectedProductNames = new ArrayList<>();
        expectedProductNames.add(SAUCE_LABS_BACKPACK);
        expectedProductNames.add(SAUCE_LABS_BIKE_LIGHT);
        expectedProductNames.add(SAUCE_LABS_BOLT_T_SHIRT);
        expectedProductNames.add(SAUCE_LABS_FLEECE_JACKET);
        expectedProductNames.add(SAUCE_LABS_ONESIE);
        expectedProductNames.add(TEST_ALL_THE_THINGS_T_SHIRT_RED);
        Collections.sort(expectedProductNames);
        Assert.assertEquals(productsPage.getActualProductsNames(), expectedProductNames);
    }

    @Test(description = "Check a product description for each product")
    public void checkProductDescription() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        Assert.assertEquals(productsPage.getProductDescription(SAUCE_LABS_BACKPACK), SAUCE_LABS_BACKPACK_DESCRIPTION);
        Assert.assertEquals(productsPage.getProductDescription(SAUCE_LABS_BIKE_LIGHT), SAUCE_LABS_BIKE_LIGHT_DESCRIPTION);
        Assert.assertEquals(productsPage.getProductDescription(SAUCE_LABS_BOLT_T_SHIRT), SAUCE_LABS_BOLT_T_SHIRT_DESCRIPTION);
        Assert.assertEquals(productsPage.getProductDescription(SAUCE_LABS_FLEECE_JACKET), SAUCE_LABS_FLEECE_JACKET_DESCRIPTION);
        Assert.assertEquals(productsPage.getProductDescription(SAUCE_LABS_ONESIE), SAUCE_LABS_ONESIE_DESCRIPTION);
        Assert.assertEquals(productsPage.getProductDescription(TEST_ALL_THE_THINGS_T_SHIRT_RED), TEST_ALL_THE_THINGS_T_SHIRT_RED_DESCRIPTION);
    }

    @Test(description = "Check a product price for each product")
    public void checkProductPrice() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        Assert.assertEquals(productsPage.getProductPrice(SAUCE_LABS_BACKPACK), SAUCE_LABS_BACKPACK_PRICE);
        Assert.assertEquals(productsPage.getProductPrice(SAUCE_LABS_BIKE_LIGHT), SAUCE_LABS_BIKE_LIGHT_PRICE);
        Assert.assertEquals(productsPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT), SAUCE_LABS_BOLT_T_SHIRT_PRICE);
        Assert.assertEquals(productsPage.getProductPrice(SAUCE_LABS_FLEECE_JACKET), SAUCE_LABS_FLEECE_JACKET_PRICE);
        Assert.assertEquals(productsPage.getProductPrice(SAUCE_LABS_ONESIE), SAUCE_LABS_ONESIE_PRICE);
        Assert.assertEquals(productsPage.getProductPrice(TEST_ALL_THE_THINGS_T_SHIRT_RED), TEST_ALL_THE_THINGS_T_SHIRT_RED_PRICE);
    }

    @Test(description = "Check that a product picture is displayed for each product")
    public void checkProductPicturesCount() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        Assert.assertEquals(productsPage.getProductsCount(), productsPage.getProductPicturesCount());
    }

    @Test(description = "Check that \"Add to cart\" button is displayed for each product")
    public void checkAddToCartButtonsCount() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        Assert.assertEquals(productsPage.getProductsCount(), productsPage.getAddToCartButtonsCount());
    }

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened();
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayedForProduct(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test(description = "Adding a product to the cart: check that the \"Add to cart\" button is not displayed for the added product")
    public void checkAddToCartButtonIsNotDisplayedForAddedProduct() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened()
                .addProductToCart(SAUCE_LABS_BIKE_LIGHT);
        Assert.assertFalse(productsPage.isAddToCartButtonDisplayedForProduct(SAUCE_LABS_BIKE_LIGHT));
    }

    @Test(description = "Adding a product to the cart: check that the \"Remove\" button is displayed for the added product")
    public void checkRemoveButtonIsDisplayedForAddedProduct() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForProductsPageOpened()
                .addProductToCart(SAUCE_LABS_BIKE_LIGHT);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayedForProduct(SAUCE_LABS_BIKE_LIGHT));
    }
}

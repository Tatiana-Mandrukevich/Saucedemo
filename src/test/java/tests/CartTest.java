package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @DataProvider(name = "products")
    public Object[][] productsAndPrices() {
        return new Object[][] {
                {SAUCE_LABS_BACKPACK, SAUCE_LABS_BACKPACK_PRICE},
                {SAUCE_LABS_BOLT_T_SHIRT, SAUCE_LABS_BOLT_T_SHIRT_PRICE},
                {SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BIKE_LIGHT_PRICE},
                {SAUCE_LABS_FLEECE_JACKET, SAUCE_LABS_FLEECE_JACKET_PRICE},
                {SAUCE_LABS_ONESIE, SAUCE_LABS_ONESIE_PRICE},
                {TEST_ALL_THE_THINGS_T_SHIRT_RED, TEST_ALL_THE_THINGS_T_SHIRT_RED_PRICE},
        };
    }

    @Test(dataProvider = "products")
    public void checkProductPriceInCartTest(String productName, String price) {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductToCart(productName);
        cartPage.openCartPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(productName), price);
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkQuantityTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductsToCart(SAUCE_LABS_BOLT_T_SHIRT, SAUCE_LABS_BACKPACK);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductQuantity(), 2);
    }

    @Test(dataProvider = "products")
    public void addProductToCartTest(String productName, String price){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductToCart(productName);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(productName), price);
    }
}

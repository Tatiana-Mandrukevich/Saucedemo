package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;

public class HeaderSteps {
    private HeaderPage headerPage;

    public HeaderSteps(WebDriver driver) {
        headerPage = new HeaderPage(driver);
    }

    @Step("Wat for Header page open, open menu on header and close menu")
    public HeaderSteps openAndCloseMenu() {
        headerPage
                .waitForHeaderPageOpened()
                .clickOnOpenMenuButton()
                .clickOnCrossOnMenu();
        return this;
    }

    @Step("Wat for Header page open, open cart on header and wait for Cart page open")
    public HeaderSteps openCart() {
        headerPage
                .waitForHeaderPageOpened()
                .clickOnCartButton()
                .waitForCartPageOpened();
        return this;
    }
}

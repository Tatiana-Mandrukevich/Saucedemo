package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;

public class HeaderSteps {
    private HeaderPage headerPage;

    public HeaderSteps(WebDriver driver) {
        headerPage = new HeaderPage(driver);
    }

    @Step("Open menu on header and close menu")
    public HeaderSteps openAndCloseMenu() {
        headerPage
                .clickOnOpenMenuButton()
                .clickOnCrossOnMenu();
        return this;
    }

    @Step("Open cart on header and wait for Cart page open")
    public HeaderSteps openCart() {
        headerPage
                .clickOnCartButton()
                .waitForCartPageOpened();
        return this;
    }
}

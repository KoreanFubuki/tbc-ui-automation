package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import ge.tbc.testautomation.pages.HomePage;

public class NavigationSteps {
    private final HomePage homePage;

    public NavigationSteps(SelenideDriver driver) {
        this.homePage = new HomePage(driver);
    }

    public void openLocations(boolean mobile) {
        homePage.open();
        if (mobile) {
            homePage.openMobileMenu();
        }
        homePage.locationsLink().shouldBe(Condition.visible).click();
    }
}

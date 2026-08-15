package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.HomePage;
import org.testng.annotations.Test;

public class HomepageNavigationTest extends BaseTest {
    @Test(description = "Main navigation works differently but correctly on desktop and mobile")
    public void mainNavigationIsUsable() {
        HomePage home = new HomePage(driver).open();

        if (isMobile()) {
            home.burgerMenu().shouldBe(Condition.visible);
            home.openMobileMenu();
            home.personalNav().shouldBe(Condition.visible);
        } else {
            home.personalNav().shouldBe(Condition.visible);
            home.businessNav().shouldBe(Condition.visible);
            home.aboutNav().shouldBe(Condition.visible);
        }
    }
}

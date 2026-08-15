package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.constants.UrlConstants;
import org.openqa.selenium.By;

import java.time.Duration;

public class HomePage extends BasePage {
    private static final String PERSONAL = "ჩემთვის";
    private static final String BUSINESS = "ჩემი ბიზნესისთვის";
    private static final String ABOUT = "თიბისი";

    public HomePage(SelenideDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.open(UrlConstants.HOME);
        pageReady().shouldBe(Condition.visible, Duration.ofSeconds(15));
        return this;
    }

    public SelenideElement pageReady() {
        return el(By.cssSelector("body"));
    }

    public SelenideElement logo() {
        return el(By.cssSelector("img[alt='tbcge-logo'], img[alt*='tbc']"));
    }

    public SelenideElement burgerMenu() {
        return el(By.cssSelector(
                "button[aria-label*='მენიუ'], button[aria-label*='Menu'], " +
                "button[class*='burger'], button[class*='Burger'], " +
                "[role='button'][class*='burger'], [class*='burger-menu']"));
    }

    public SelenideElement navLink(String text) {
        return driver.$(By.xpath("//a[contains(normalize-space(.), '" + text + "')]") );
    }

    public SelenideElement personalNav() { return navLink(PERSONAL); }
    public SelenideElement businessNav() { return navLink(BUSINESS); }
    public SelenideElement aboutNav() { return navLink(ABOUT); }

    public SelenideElement locationsLink() {
        return driver.$(By.cssSelector("a[href*='atms'], a[href*='branches']"));
    }

    public void openMobileMenu() {
        burgerMenu().shouldBe(Condition.visible).click();
    }
}

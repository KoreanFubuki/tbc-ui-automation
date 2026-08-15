package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.constants.UrlConstants;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.match;

public class LocationsPage extends BasePage {
    public LocationsPage(SelenideDriver driver) {
        super(driver);
    }

    public LocationsPage open() {
        driver.open(UrlConstants.LOCATIONS);
        pageContent().shouldBe(Condition.visible, Duration.ofSeconds(15));
        return this;
    }

    public SelenideElement pageContent() {
        return el(By.cssSelector("main, [role='main'], body"));
    }

    private SelenideElement filter(String text) {
        return driver.$(By.xpath(
                "//button[contains(normalize-space(.), '" + text + "')]" +
                " | //*[@role='button' and contains(normalize-space(.), '" + text + "')]"));
    }

    public SelenideElement branchFilter() {
        return filter("ფილიალ");
    }

    public SelenideElement atmFilter() {
        return filter("ბანკომატ");
    }

    public void selectBranchFilter() {
        branchFilter().shouldBe(Condition.visible).click();
    }

    public void selectAtmFilter() {
        atmFilter().shouldBe(Condition.visible).click();
    }

    public void waitForFilterState(SelenideElement filter) {
        filter.should(match("filter is active", element -> {
            String ariaPressed = element.getAttribute("aria-pressed");
            String ariaChecked = element.getAttribute("aria-checked");
            String classes = element.getAttribute("class");

            return "true".equalsIgnoreCase(ariaPressed)
                    || "true".equalsIgnoreCase(ariaChecked)
                    || (classes != null && (
                    classes.contains("active")
                            || classes.contains("selected")
                            || classes.contains("checked")
            ));
        }));
    }
}

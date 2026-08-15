package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

public abstract class BasePage {
    protected final SelenideDriver driver;

    protected BasePage(SelenideDriver driver) {
        this.driver = driver;
    }

    protected SelenideElement el(By locator) {
        return driver.$(locator);
    }

    protected void waitForUrlContains(String value) {
        driver.Wait().withTimeout(Duration.ofSeconds(15))
                .until(d -> d.getCurrentUrl() != null && d.getCurrentUrl().contains(value));
    }
}

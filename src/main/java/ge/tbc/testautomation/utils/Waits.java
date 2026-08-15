package ge.tbc.testautomation.utils;

import com.codeborne.selenide.SelenideDriver;

import java.time.Duration;
import java.util.function.Function;

public final class Waits {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(12);

    private Waits() {}

    public static <T> T until(SelenideDriver driver, Function<org.openqa.selenium.WebDriver, T> condition) {
        return driver.Wait().withTimeout(DEFAULT_TIMEOUT).until(condition);
    }
}

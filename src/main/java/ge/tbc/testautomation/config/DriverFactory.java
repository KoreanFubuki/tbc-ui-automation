package ge.tbc.testautomation.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import ge.tbc.testautomation.constants.Resolution;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {
    private DriverFactory() {}

    public static SelenideDriver create(Resolution resolution) {
        SelenideConfig config = new SelenideConfig()
                .baseUrl(TestConfig.baseUrl())
                .browser(TestConfig.browser())
                .headless(TestConfig.headless())
                .timeout(10000);

        if (resolution.isMobile()) {
            config.browserCapabilities(mobileOptions(resolution));
        } else {
            config.browserSize(resolution.asBrowserSize());
        }

        return new SelenideDriver(config);
    }

    private static ChromeOptions mobileOptions(Resolution resolution) {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("width", resolution.width());
        metrics.put("height", resolution.height());
        metrics.put("pixelRatio", 1.0);
        metrics.put("mobile", true);

        Map<String, Object> emulation = new HashMap<>();
        emulation.put("deviceMetrics", metrics);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", emulation);
        return options;
    }

    public static void configureGlobalDefaults() {
        Configuration.reportsFolder = "target/test-results";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
    }
}

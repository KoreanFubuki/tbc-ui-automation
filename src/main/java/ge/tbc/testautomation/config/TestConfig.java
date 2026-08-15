package ge.tbc.testautomation.config;

import ge.tbc.testautomation.constants.Resolution;

public final class TestConfig {
    private TestConfig() {}

    public static Resolution resolution(String profile) {
        return Resolution.fromProfile(profile);
    }

    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", "true"));
    }

    public static String baseUrl() {
        return System.getProperty("base.url", "https://www.tbcbank.ge");
    }
}

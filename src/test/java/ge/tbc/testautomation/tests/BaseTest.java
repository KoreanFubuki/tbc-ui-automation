package ge.tbc.testautomation.tests;

import com.codeborne.selenide.SelenideDriver;
import ge.tbc.testautomation.config.DriverFactory;
import ge.tbc.testautomation.constants.Resolution;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    protected SelenideDriver driver;
    protected Resolution resolution;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        DriverFactory.configureGlobalDefaults();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("profile")
    public void setUp(@Optional("desktop") String profile) {
        resolution = Resolution.fromProfile(profile);
        driver = DriverFactory.create(resolution);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver != null) {
            driver.close();
        }
    }

    protected boolean isMobile() {
        return resolution.isMobile();
    }
}

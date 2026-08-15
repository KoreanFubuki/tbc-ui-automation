package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.constants.UrlConstants;
import org.openqa.selenium.By;

import java.time.Duration;

public class MoneyTransferPage extends BasePage {
    public MoneyTransferPage(SelenideDriver driver) {
        super(driver);
    }

    public MoneyTransferPage open() {
        driver.open(UrlConstants.MONEY_TRANSFERS);
        heading().shouldBe(Condition.visible, Duration.ofSeconds(15));
        return this;
    }

    public SelenideElement heading() {
        return el(By.cssSelector("h1"));
    }

    public SelenideElement mainContent() {
        return el(By.cssSelector("main, [role='main']"));
    }
}

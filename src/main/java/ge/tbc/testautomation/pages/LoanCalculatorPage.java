package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.constants.UrlConstants;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoanCalculatorPage extends BasePage {
    public LoanCalculatorPage(SelenideDriver driver) {
        super(driver);
    }

    public LoanCalculatorPage open() {
        driver.open(UrlConstants.CONSUMER_LOAN);
        calculatorInput().shouldBe(Condition.visible, Duration.ofSeconds(15));
        return this;
    }

    public SelenideElement calculatorInput() {
        return el(By.cssSelector(
                "input[type='number'], input[inputmode='numeric'], input[name*='amount'], input[name*='Amount']"));
    }

    public SelenideElement monthlyPayment() {
        return el(By.cssSelector(
                "[data-testid*='monthly'], [class*='monthly-payment'], [class*='monthlyPayment'], " +
                "[class*='calculator-result']"));
    }

    public String monthlyPaymentText() {
        return monthlyPayment().shouldBe(Condition.visible).getText().trim();
    }

    public void enterAmount(String amount) {
        calculatorInput().shouldBe(Condition.enabled).setValue(amount).pressEnter();
    }
}

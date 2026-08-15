package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.LoanCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoanCalculatorTest extends BaseTest {
    @Test(description = "Changing the loan amount updates the monthly payment estimate")
    public void loanAmountUpdatesMonthlyPayment() {
        LoanCalculatorPage page = new LoanCalculatorPage(driver).open();
        String before = page.monthlyPaymentText();

        page.enterAmount("5000");
        page.monthlyPayment().shouldBe(Condition.visible);
        driver.Wait().withTimeout(java.time.Duration.ofSeconds(10))
                .until(d -> !page.monthlyPaymentText().equals(before));

        String after = page.monthlyPaymentText();
        Assert.assertFalse(after.isBlank(), "Monthly payment should not be empty");
        Assert.assertNotEquals(after, before, "Monthly payment should change after changing the amount");
    }
}

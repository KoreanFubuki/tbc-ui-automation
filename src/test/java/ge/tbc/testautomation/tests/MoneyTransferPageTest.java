package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.MoneyTransferPage;
import org.testng.annotations.Test;

public class MoneyTransferPageTest extends BaseTest {
    @Test(description = "Money transfer page displays its main content")
    public void moneyTransferPageLoads() {
        MoneyTransferPage page = new MoneyTransferPage(driver).open();
        page.heading().shouldBe(Condition.visible);
        page.mainContent().shouldBe(Condition.visible);
    }
}
